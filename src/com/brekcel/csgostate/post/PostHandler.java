package com.brekcel.csgostate.post;

import com.brekcel.csgostate.JSON.JsonResponse;
import com.brekcel.csgostate.JSON.Map;
import com.brekcel.csgostate.JSON.MatchStats;
import com.brekcel.csgostate.JSON.Player;
import com.brekcel.csgostate.JSON.Round;
import com.brekcel.csgostate.JSON.State;
import com.brekcel.csgostate.JSON.Weapon;

// TODO: Change Strings to enums?
public interface PostHandler {
	/**
	 * Called when a new JsonResponse is received.
	 * 
	 * @param jsonResponse
	 *            The jsonResponse that was just received.
	 */
	public void receivedJsonResponse(JsonResponse jsonResponse);

	// START OF MAP
	/**
	 * Called when Map is received, and a previous Map value did not exist.
	 * Should only be called when a player joins a game from a menu.
	 * 
	 * @param map
	 *            The Map object that was just received.
	 */
	public void newMap(Map map);

	/**
	 * Called when a Map object is received.
	 * 
	 * @param map
	 *            The Map object that was just received.
	 */
	public void receivedMap(Map map);

	/**
	 * Called when a Map previously existed, but no longer does.
	 * I.E. going from a Game to the main menu.
	 */
	public void mapReset();

	/**
	 * Called when the name of the map is changed.
	 * 
	 * @param mapName
	 *            The name of the new map.
	 */
	public void mapNameChange(String mapName);

	/**
	 * Called when the gamemode changes
	 * 
	 * @param mode
	 *            The name of the new mode.
	 */
	public void modeChange(String mode);

	/**
	 * Called when the round changes.
	 * 
	 * @param round
	 *            The new round.
	 */
	public void roundChange(int round);

	/**
	 * Called when a Team changes it's name.
	 * 
	 * @param team
	 *            Which team changed it's name. Either: "ct" or "t".
	 * @param name
	 *            The new name of the team.
	 */
	public void teamNameChange(String team, String name);

	/**
	 * Called when the score changes.
	 * 
	 * @param ct
	 *            The CT's Score.
	 * @param t
	 *            The T's Score.
	 */
	public void scoreChange(int ct, int t);

	/**
	 * Called when the Map's Phase Changes.
	 * 
	 * @param phase
	 *            The Map's new phase.
	 */
	public void phaseChange(String phase);
	// END OF MAP

	// START OF ROUND
	/**
	 * Called when a Round is received, and no previous round existed.
	 * 
	 * @param round
	 *            The Round received.
	 */
	public void newRound(Round round);

	/**
	 * Called when a Round is received.
	 * 
	 * @param round
	 *            The Round received.
	 */
	public void receivedRound(Round round);

	/**
	 * Called when a round previously existed, but no longer does.
	 */
	public void roundReset();

	/**
	 * Called when the bomb's state changes.
	 * <br>
	 * <b>As of <a href=
	 * "https://www.reddit.com/r/GlobalOffensive/comments/3xah5n/counterstrike_global_offensive_update_for_121715/">
	 * 12.17.15's 1.35.1.6 Update</a>, the bomb's state is randomly delayed when
	 * user is not a spectator.</b>
	 * 
	 * @param bomb
	 *            The new state of the bomb.
	 */
	public void roundBombChange(String bomb);

	/**
	 * Called when the bomb's state previously existed, but not longer does.
	 */
	public void roundBombReset();

	/**
	 * Called when a team wins a round.
	 * 
	 * @param team
	 *            The team that won the round. Either: "CT" or "T"
	 */
	public void roundWinningTeamChange(String team);

	/**
	 * Called when the rounds phase changes.
	 * 
	 * @param phase
	 *            The new Round phase.
	 */
	public void roundPhaseChange(String phase);
	// END OF ROUND

	// START OF PLAYER
	/**
	 * Called when a new Player is received and Player did not previously exist.
	 * 
	 * @param player
	 *            The Player received.
	 */
	public void newPlayer(Player player);

	/**
	 * Called when a Player is received.
	 * 
	 * @param player
	 *            The Player received.
	 */
	public void receivedPlayer(Player player);

	/**
	 * Called when a Player no longer exists, but did previously exist.
	 */
	public void playerReset();

	/**
	 * Called when a Players name changes.
	 * 
	 * @param name
	 *            The new name.
	 */
	public void playerNameChange(String name);

	/**
	 * Called when the players SteamID changes.
	 * 
	 * @param steamID
	 *            The new SteamID.
	 */
	public void playerSteamIDChange(String steamID);

	/**
	 * Called when the Players team changes.
	 * 
	 * @param team
	 *            The new team.
	 */
	public void playerTeamChange(String team);

	/**
	 * Called when the Players activity changes.
	 * 
	 * @param activity
	 *            The new activity.
	 */
	public void playerActivityChange(String activity);

	/**
	 * Called when the Players state changes.
	 * 
	 * @param state
	 *            The new state.
	 */
	public void playerStateChange(State state);

	// START OF PlayerState
	/**
	 * Called when the Players health changes.
	 * 
	 * @param health
	 *            The players current hp. Value is 0-100
	 */
	public void playerHealthChange(int health);

	/**
	 * Called when the Players armor value changes.
	 * 
	 * @param armor
	 *            The players current armor. Value is 0-100
	 */
	public void playerArmorChange(int armor);

	/**
	 * Called when a player either buys a helmet, or loses it.
	 * 
	 * @param helmet
	 *            If the player has a helmet or not.
	 */
	public void playerHelmetChange(boolean helmet);

	/**
	 * Called when the player is flashed.
	 * 
	 * @param flashed
	 *            The value of how flashed the player is. Value is 0-255
	 */
	public void playerFlashedChange(int flashed);

	/**
	 * Called when the player walks into smoke.
	 * 
	 * @param smoked
	 *            The value of how smoked they are. Value is 0-255
	 */
	public void playerSmokeChange(int smoked);

	/**
	 * Called when a player gets burned. By fire.
	 * 
	 * @param burning
	 *            Not really sure... Value is 0-255. Full burn is 255, Not
	 *            burning is 0. Only seems possible to receive other values when
	 *            fire is dissipating.
	 */
	public void playerBurningChange(int burning);

	/**
	 * Called when the players money changes.
	 * 
	 * @param money
	 *            How much money they have. Value is 0-mp_maxmoney [Set on
	 *            Server]
	 */
	public void playerMoneyChange(int money);

	/**
	 * Called when the players Round Kills changes.
	 * 
	 * @param kills
	 *            How many kills they got this round.
	 */
	public void playerRoundKillsChange(int kills);

	/**
	 * Called when the players Round Kills Headshot changes.
	 * 
	 * @param killsHS
	 *            How many headshots they got this round.
	 */
	public void playerRoundKillsHSChange(int killsHS);
	// END OF PlayerState

	// Start of PlayerWeapons
	// TODO: Rework Weapons. They suck. Hard. //TODONE. Kinda.
	public void newWeapons(Weapon[] weapons);

	public void weaponsChange(Weapon[] weapons);

	public void weaponActiveChange(Weapon weapon);

	public void weaponShoot(Weapon weapon);

	public void weaponReload(Weapon weapon);
	// End of PlayerWeapons

	// Start of PlayerMatchStats
	/**
	 * Called when the players MatchStats changes.
	 * 
	 * @param ms
	 *            The received MatchStats
	 */
	public void playerMatchStatsChange(MatchStats ms);

	/**
	 * Called when MatchStats are received.
	 * 
	 * @param ms
	 *            The MatchStats received.
	 */
	public void playerMatchStatsReceived(MatchStats ms);

	/**
	 * Called when the Players kill count change.
	 * 
	 * @param kills
	 *            How many kills the player has.
	 */
	public void playerMatchKillsChange(int kills);

	/**
	 * Called when the Players Assist count changes.
	 * 
	 * @param assists
	 *            How many assists the player has.
	 */
	public void playerMatchAssistsChange(int assists);

	/**
	 * Called when the Players death count changes.
	 * 
	 * @param deaths
	 *            How many deaths the player has.
	 */
	public void playerMatchDeathsChange(int deaths);

	/**
	 * Called when the Players MVP count changes.
	 * 
	 * @param mvps
	 *            How many MVP's the player has.
	 */
	public void playerMatchMVPSChange(int mvps);

	/**
	 * Called when the players score changes.
	 * 
	 * @param score
	 *            The players score.
	 */
	public void playerMatchScoreChange(int score);
	// End of PlayerMatchStats
	// END OF PLAYER
}
