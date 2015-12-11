package com.brekcel.csgostate.post;

import com.brekcel.csgostate.JSON.JsonResponse;
import com.brekcel.csgostate.JSON.Player;
import com.brekcel.csgostate.JSON.Weapon0;
import com.brekcel.csgostate.JSON.Weapon1;
import com.brekcel.csgostate.JSON.Weapon2;

// Simple class that implements PostHandler.
// Use this when you only want to use specific methods from PostHandler.
// If using ALL methods of PostHandler, might as well just implement that
// instead of extending this.
public class PostHandlerAdapter implements PostHandler {
	@Override
	public void JsonResponseChange(JsonResponse jsonResponse) {}

	@Override
	public void mapNameChange(String mapName) {}

	@Override
	public void roundChange(int round) {}

	@Override
	public void scoreChange(int ct, int t) {}

	@Override
	public void phaseChange(String phase) {}

	@Override
	public void roundWinningTeamChange(String team) {}

	@Override
	public void roundBombChange(String bomb) {}

	@Override
	public void roundPhaseChange(String phase) {}

	@Override
	public void playerChange(Player player) {}

	@Override
	public void playerTeamChange(String team) {}

	@Override
	public void playerActivityChange(String activity) {}

	@Override
	public void playerHealthChange(int health) {}

	@Override
	public void playerArmorChange(int armor) {}

	@Override
	public void playerHelmetChange(boolean helmet) {}

	@Override
	public void playerFlashedChange(int flashed) {}

	@Override
	public void playerSmokeChange(int smoked) {}

	@Override
	public void playerBurningChange(int burning) {}

	@Override
	public void playerMoneyChange(int money) {}

	@Override
	public void playerRoundKillsChange(int kills) {}

	@Override
	public void playerRoundKillsHSChange(int killsHS) {}

	@Override
	public void weaponCountChange(int count) {}

	@Override
	public void weaponKnifeChange(Weapon0 knife) {}

	@Override
	public void weaponPrimaryChange(Weapon1 primary) {}

	@Override
	public void weaponSecondaryChange(Weapon2 secondary) {}

	@Override
	public void weaponActiveChange(int weapon) {}

	@Override
	public void playerMatchKillsChange(int kills) {}

	@Override
	public void playerMatchAssistsChange(int assists) {}

	@Override
	public void playerMatchDeathsChange(int deaths) {}

	@Override
	public void playerMatchMVPSChange(int mvps) {}

	@Override
	public void playerMatchScoreChange(int score) {}

	@Override
	public void modeChange(String mode) {}

	@Override
	public void teamNameChange(String ct, String t) {}
}
