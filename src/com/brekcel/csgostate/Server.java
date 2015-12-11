package com.brekcel.csgostate;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import com.brekcel.csgostate.JSON.JsonResponse;
import com.brekcel.csgostate.post.PostHandler;
import com.brekcel.csgostate.post.PostReceiver;
import com.sun.net.httpserver.HttpServer;

public class Server {
	private HttpServer serv;
	private String authToken;
	private int port;
	private PostReceiver receive;

	public Server(int port, PostHandler postHandle, String authToken) throws IOException {
		this.port = port;
		this.authToken = authToken;
		serv = HttpServer.create(new InetSocketAddress(port), 0);
		receive = new PostReceiver(this, postHandle);
		serv.createContext("/", receive);
		serv.setExecutor(Executors.newCachedThreadPool());
		serv.start();
		System.out.println("Server successfully started on port " + port + (authToken == null ? "." : " with Auth Token: " + authToken));
	}

	public Server(int port, PostHandler postHandle) throws IOException {
		new Server(port, postHandle, null);
	}

	public JsonResponse getCurrentJSR() {
		return receive.getCurrentJSR();
	}
	
	public String getAuthToken() {
		return authToken;
	}

	public void stop() {
		serv.stop(0);
	}

	public int getPort() {
		return port;
	}
}
