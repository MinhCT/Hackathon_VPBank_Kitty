package com.hackathon.kitty.gamification.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "kitty_type", schema = "kitty_bank", catalog = "")
public class KittyType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4535660095041334174L;

	private int id;
	private String name;
	private byte gender;
	private String image;
	private boolean deleted;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Column(name = "deleted")
	@NotNull
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		KittyType kittyType = (KittyType) o;
		return id == kittyType.id && gender == kittyType.gender && deleted == kittyType.deleted
				&& Objects.equals(name, kittyType.name) && Objects.equals(image, kittyType.image);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, name, gender, image, deleted);
	}
}
