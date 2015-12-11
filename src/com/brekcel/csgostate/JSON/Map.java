package com.brekcel.csgostate.JSON;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Map {
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("mode")
	@Expose
	private String mode;
	@SerializedName("phase")
	@Expose
	private String phase;
	@SerializedName("round")
	@Expose
	private Integer round;
	@SerializedName("team_ct")
	@Expose
	private TeamCt teamCt;
	@SerializedName("team_t")
	@Expose
	private TeamT teamT;

	/**
	 * 
	 * @return
	 * 		The mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 
	 * @param mode
	 *            The mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * 
	 * @return
	 * 		The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 * 		The phase
	 */
	public String getPhase() {
		return phase;
	}

	/**
	 * 
	 * @param phase
	 *            The phase
	 */
	public void setPhase(String phase) {
		this.phase = phase;
	}

	/**
	 * 
	 * @return
	 * 		The round
	 */
	public Integer getRound() {
		return round;
	}

	/**
	 * 
	 * @param round
	 *            The round
	 */
	public void setRound(Integer round) {
		this.round = round;
	}

	/**
	 * 
	 * @return
	 * 		The teamCt
	 */
	public TeamCt getTeamCt() {
		return teamCt;
	}

	/**
	 * 
	 * @param teamCt
	 *            The team_ct
	 */
	public void setTeamCt(TeamCt teamCt) {
		this.teamCt = teamCt;
	}

	/**
	 * 
	 * @return
	 * 		The teamT
	 */
	public TeamT getTeamT() {
		return teamT;
	}

	/**
	 * 
	 * @param teamT
	 *            The team_t
	 */
	public void setTeamT(TeamT teamT) {
		this.teamT = teamT;
	}
}
