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
	//@formatter:off
	
	public void receivedJsonResponse(JsonResponse jsonResponse);
	
	//START OF MAP
	public void newMap(Map map);
	public void receivedMap(Map map);
	public void mapReset();
	public void mapNameChange(String mapName);
	public void modeChange(String mode);
	public void roundChange(int round);
	public void teamNameChange(String ct, String t);
	public void scoreChange(int ct, int t);
	public void phaseChange(String phase);
	//END OF MAP
	
	//START OF ROUND
	public void newRound(Round round);
	public void roundReset();
	public void roundBombChange(String bomb);
	public void roundBombReset();
	public void roundWinningTeamChange(String team);
	public void roundPhaseChange(String phase);
	
	//END OF ROUND
	
	//START OF PLAYER
	public void newPlayer(Player player);
	public void receivedPlayer(Player player);
	public void playerReset();
	public void playerNameChange(String name);
	public void playerSteamIDChange(String steamID);
	public void playerTeamChange(String team);
	public void playerActivityChange(String activity);
	public void playerStateChange(State state);
	
		//START OF PlayerState
		public void playerHealthChange(int health);
		public void playerArmorChange(int armor);
		public void playerHelmetChange(boolean helmet);
		public void playerFlashedChange(int flashed);
		public void playerSmokeChange(int smoked);
		public void playerBurningChange(int burning);
		public void playerMoneyChange(int money);
		public void playerRoundKillsChange(int kills);
		public void playerRoundKillsHSChange(int killsHS);
		//END OF PlayerState
		
		//Start of PlayerWeapons
		//TODO: Rework Weapons. They suck. Hard. //TODONE. Kinda.
		public void newWeapons(Weapon[] weapons);
		public void weaponsChange(Weapon[] weapons);
		public void weaponActiveChange(Weapon weapon);
		public void weaponShoot(Weapon weapon);
		public void weaponReload(Weapon weapon);
		//End of PlayerWeapons
		
		//Start of PlayerMatchStats
		public void playerMatchStatsChange(MatchStats ms);
		public void playerMatchKillsChange(int kills);
		public void playerMatchAssistsChange(int assists);
		public void playerMatchDeathsChange(int deaths);
		public void playerMatchMVPSChange(int mvps);
		public void playerMatchScoreChange(int score);
		//End of PlayerMatchStats	
	//END OF PLAYER
	//@formatter:on
}
