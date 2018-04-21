package com.hackathon.kitty.gamification.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class TransactionType {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "type_name")
	@NotNull
	private String typeName;

	@Column(name = "reward_rate")
	@NotNull
	private double rewardRate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public double getRewardRate() {
		return rewardRate;
	}

	public void setRewardRate(double rewardRate) {
		this.rewardRate = rewardRate;
	}
}
