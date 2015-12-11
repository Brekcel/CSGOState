package com.brekcel.csgostate.post;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import com.brekcel.csgostate.Server;
import com.brekcel.csgostate.JSON.JsonResponse;
import com.brekcel.csgostate.JSON.Map;
import com.brekcel.csgostate.JSON.Round;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class PostReceiver implements HttpHandler {
	private PostHandler handle;
	private Server serv;
	private Gson gson;
	private BufferedWriter writer;
	private JsonResponse currentJSR;

	public PostReceiver(Server serv, PostHandler handle) {
		this.serv = serv;
		this.handle = handle;
		gson = new Gson();
		try {
			new File("A:/csgoLog.txt").createNewFile();
			writer = new BufferedWriter(new FileWriter(new File("A:/csgoLog.txt"), true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void handle(HttpExchange exc) throws IOException {
		StringBuffer response = new StringBuffer();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(exc.getRequestBody()));
			String inl;
			while ((inl = in.readLine()) != null)
				response.append(inl);
			in.close();
			writer.write(response.toString());
			writer.newLine();
			writer.flush();
			JsonResponse jsr = gson.fromJson(response.toString(), JsonResponse.class);
			if ((serv.getAuthToken() == null && jsr.getAuth() != null) || !jsr.getAuth().getToken().equals(serv.getAuthToken())) {
				System.out.println("Invalid connection attempt from: " + exc.getLocalAddress());
				return;
			}
			exc.sendResponseHeaders(200, -1);
			callMethods(jsr);
		} catch (Exception e) {
			System.out.println(response.toString());
			e.printStackTrace();
		}
	}

	// TODO: Finish it.
	private void callMethods(JsonResponse jsr) {
		try {
			handle.JsonResponseChange(jsr);
			if (currentJSR == null)
				currentJSR = new JsonResponse();
			currentJSR.setProvider(jsr.getProvider());
			if (jsr.getMap() != null) {
				if (currentJSR.getMap() == null || !currentJSR.getMap().equals(jsr.getMap())) {
					Map nm = jsr.getMap();
					Map cm = currentJSR.getMap();
					if (currentJSR.getMap() == null) {
						currentJSR.setMap(nm);
						if (nm.getMode() != null)
							handle.modeChange(nm.getMode());
						if (nm.getName() != null)
							handle.mapNameChange(nm.getName());
						if (nm.getRound() != null)
							handle.roundChange(nm.getRound());
						if (nm.getTeamCt().getName() != null || nm.getTeamT().getName() != null)
							handle.teamNameChange(nm.getTeamCt().getName(), nm.getTeamT().getName());
						if (nm.getTeamCt().getScore() != null && nm.getTeamT() != null)
							handle.scoreChange(nm.getTeamCt().getScore(), nm.getTeamT().getScore());
						if (nm.getPhase() != null)
							handle.phaseChange(nm.getPhase());
					} else {
						if (nm.getMode() != null && (cm.getMode() == null || !cm.getMode().equals(nm.getMode()))) {
							handle.modeChange(nm.getMode());
							cm.setMode(nm.getMode());
						}
						if (nm.getName() != null && (cm.getName() == null || !cm.getName().equals(nm.getName()))) {
							handle.mapNameChange(nm.getName());
							cm.setName(nm.getName());
						}
						if (nm.getPhase() != null && (cm.getPhase() == null || !cm.getPhase().equals(nm.getPhase()))) {
							handle.phaseChange(nm.getPhase());
							cm.setPhase(nm.getPhase());
						}
						if (nm.getPhase() != null && (cm.getRound() == null || cm.getRound() != nm.getRound())) {
							handle.roundChange(nm.getRound());
							cm.setRound(nm.getRound());
						}
						if ((nm.getTeamCt().getScore() != null && nm.getTeamT().getScore() != null) && (cm.getTeamCt().getScore() == null || cm.getTeamT().getScore() == null || cm.getTeamCt().getScore() != nm.getTeamCt().getScore() || cm.getTeamT().getScore() != nm.getTeamT().getScore())) {
							handle.scoreChange(nm.getTeamCt().getScore(), nm.getTeamT().getScore());
							cm.getTeamCt().setScore(nm.getTeamCt().getScore());
							cm.getTeamT().setScore(nm.getTeamT().getScore());
						}
						if ((nm.getTeamCt().getName() != null && (cm.getTeamCt().getName() == null || !cm.getTeamCt().getName().equals(nm.getTeamCt().getName()))) || (nm.getTeamT().getName() != null && (cm.getTeamT().getName() == null || !cm.getTeamT().getName().equals(cm.getTeamT().getName())))) {
							handle.teamNameChange(nm.getTeamCt().getName(), nm.getTeamT().getName());
							cm.getTeamCt().setName(nm.getTeamCt().getName());
							cm.getTeamT().setName(nm.getTeamT().getName());
						}
						if ((nm.getTeamCt().getName() == null && cm.getTeamCt().getName() != null) || (nm.getTeamT().getName() == null && cm.getTeamT().getName() != null)) {
							handle.teamNameChange(nm.getTeamCt().getName(), nm.getTeamT().getName());
							cm.getTeamCt().setName(nm.getTeamCt().getName());
							cm.getTeamT().setName(nm.getTeamT().getName());
						}
					}
				}
			}
			if (jsr.getRound() != null) {
				if (currentJSR.getRound() == null || !currentJSR.getMap().equals(jsr.getMap())) {
					Round nr = jsr.getRound();
					Round cr = currentJSR.getRound();
					if (currentJSR.getRound() == null) {
						currentJSR.setRound(nr);
						if (nr.getPhase() != null)
							handle.roundPhaseChange(nr.getPhase());
						if (nr.getBomb() != null)
							handle.roundBombChange(nr.getBomb());
						if (nr.getWinTeam() != null)
							handle.roundWinningTeamChange(nr.getWinTeam());
					} else {
						if (nr.getBomb() != null && (cr.getBomb() == null || !cr.getBomb().equals(nr.getBomb()))) {
							handle.roundBombChange(nr.getBomb());
							cr.setBomb(nr.getBomb());
						}
						// Needs to be tested.
						// Tested for 5 minutes. Worked.
						if (nr.getWinTeam() != null && (cr.getPhase() != null && !cr.getPhase().equals(nr.getPhase()))) {
							handle.roundWinningTeamChange(nr.getWinTeam());
							cr.setWinTeam(nr.getWinTeam());
						}
						if (nr.getPhase() != null && (cr.getPhase() == null || !cr.getPhase().equals(nr.getPhase()))) {
							handle.roundPhaseChange(nr.getPhase());
							cr.setPhase(nr.getPhase());
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JsonResponse getCurrentJSR() {
		return currentJSR;
	}
}
