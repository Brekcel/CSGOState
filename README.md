# CSGOState
Java library for Counter-Strike: Global Offensive's Game State Integration.

Still in very early development.

Majority of development is streamed live on [Twitch](http://www.twitch.tv/sakki54)

## Dependencies
* [Google's Gson](https://github.com/google/gson)

## Progress
Finished: 
* All methods in PostHandler Interface EXCEPT for the Weapon methods.

In-Progress: 
* Weapon handling rework.
* Documentation writing.
* Inevitable Bug Fixes.

## Usage
To start the server:

```java
new Server(int port, PostHandler postHandle, boolean OnlyUserInfo, String authToken);
``` 

Or  

```java
new Server(int port, PostHandler postHandle, boolean OnlyUserInfo);
```

For Example:

```java
new Server(1338, PostHandler, true, "supersecretpassword");
```

The PostHandler class is a new class that either implements PostHandler to override all possible methods called, or extends PostHandlerAdapter in order to only override the necessary methods needed from the PostHandler class.

For Example:

```java
import com.brekcel.csgostate.post.PostHandlerAdapter;

public class PostOverride extends PostHandlerAdapter {

	@Override
	public void playerHealthChange(int health) { 
    	System.out.println("The players health is: " + health);
    }
}
```

```java
new Server(1338, new PostOverride(), true, "cloud9secretstrats");
```

You must also have a valid ```gamestate_integration_x.cfg``` file in your ```[Counter-Strike Global Offensive]\csgo\cfg\``` folder. A blank gamestate_integration file is provided here:
```
"CSGOState Test v0.1"
{
 "uri" "http://127.0.0.1:1338"
 "timeout" "5.0"
 "data"
 {
   "provider"            "1"
   "map"                 "1"
   "round"               "1"
   "player_id"           "1"
   "player_state"        "1"
   "player_weapons"      "1"
   "player_match_stats"  "1"
 }
}
```
