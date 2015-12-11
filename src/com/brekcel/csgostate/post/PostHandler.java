package com.brekcel.csgostate.post;

import com.brekcel.csgostate.JSON.JsonResponse;
import com.brekcel.csgostate.JSON.Player;
import com.brekcel.csgostate.JSON.Weapon0;
import com.brekcel.csgostate.JSON.Weapon1;
import com.brekcel.csgostate.JSON.Weapon2;

public interface PostHandler {
	//@formatter:off
	
	public void JsonResponseChange(JsonResponse jsonResponse);
	
	//START OF MAP
	public void mapNameChange(String mapName);
	public void modeChange(String mode);
	public void roundChange(int round);
	public void teamNameChange(String ct, String t);
	public void scoreChange(int ct, int t);
	public void phaseChange(String phase);
	//END OF MAP
	
	//START OF ROUND
	public void roundWinningTeamChange(String team);
	public void roundBombChange(String bomb);
	public void roundPhaseChange(String phase);
	//END OF ROUND
	
	//START OF PLAYER
	public void playerChange(Player player);
	public void playerTeamChange(String team);
	public void playerActivityChange(String activity); //TODO: Change to enum??
	
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
		public void weaponCountChange(int count);
		public void weaponKnifeChange(Weapon0 knife);
		public void weaponPrimaryChange(Weapon1 primary);
		public void weaponSecondaryChange(Weapon2 secondary);
		public void weaponActiveChange(int weapon);
		//End of PlayerWeapons
		
		//Start of PlayerMatchStats
		public void playerMatchKillsChange(int kills);
		public void playerMatchAssistsChange(int assists);
		public void playerMatchDeathsChange(int deaths);
		public void playerMatchMVPSChange(int mvps);
		public void playerMatchScoreChange(int score);
		//End of PlayerMatchStats	
	//END OF PLAYER
	//@formatter:on
}
