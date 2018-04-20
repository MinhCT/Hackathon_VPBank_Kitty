package com.hackathon.kitty.gamification.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Rank {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "rank_name")
	@NotNull
	private String rankName;

	@Column(name = "credit_point")
	@NotNull
	private int creditPoint;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	public int getCreditPoint() {
		return creditPoint;
	}

	public void setCreditPoint(int creditPoint) {
		this.creditPoint = creditPoint;
	}
}
