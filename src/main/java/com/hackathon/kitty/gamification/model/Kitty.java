package com.hackathon.kitty.gamification.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Kitty {
	private int id;
	private int userId;
	private int kittyTypeId;
	private String name;
	private byte gender;
	private String image;
	private int price;
	private int level;
	private int experience;
	private int rank;
	private int energy;
	private boolean deleted;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "user_id")
	@NotNull
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "kitty_type_id")
	@NotNull
	public int getKittyTypeId() {
		return kittyTypeId;
	}

	public void setKittyTypeId(int kittyTypeId) {
		this.kittyTypeId = kittyTypeId;
	}

	@Column(name = "name", length = 50)
	@NotNull
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "gender")
	@NotNull
	public byte getGender() {
		return gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	@Column(name = "image", length = 128)
	@NotNull
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "price")
	@NotNull
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Column(name = "level")
	@NotNull
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Column(name = "experience")
	@NotNull
	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Column(name = "rank")
	@NotNull
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Column(name = "energy")
	@NotNull
	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	@Column(name = "deleted")
	@NotNull
	public boolean getIsDeleted() {
		return deleted;
	}

	public void setIsDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Kitty kitty = (Kitty) o;
		return id == kitty.id && userId == kitty.userId && kittyTypeId == kitty.kittyTypeId && gender == kitty.gender
				&& price == kitty.price && level == kitty.level && experience == kitty.experience && rank == kitty.rank
				&& energy == kitty.energy && deleted == kitty.deleted && Objects.equals(name, kitty.name)
				&& Objects.equals(image, kitty.image);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, userId, kittyTypeId, name, gender, image, price, level, experience, rank, energy,
				deleted);
	}
}
