package com.hackathon.kitty.gamification.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Event {
	private int id;
	private String name;
	private Date startDate;
	private Date endDate;
	private String xmlPath;
	private int experience;
	private byte isDeleted;

	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "startDate", nullable = false)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Basic
	@Column(name = "endDate", nullable = false)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Basic
	@Column(name = "xmlPath", nullable = true, length = 128)
	public String getXmlPath() {
		return xmlPath;
	}

	public void setXmlPath(String xmlPath) {
		this.xmlPath = xmlPath;
	}

	@Basic
	@Column(name = "experience", nullable = false)
	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Basic
	@Column(name = "isDeleted", nullable = false)
	public byte getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(byte isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Event event = (Event) o;
		return id == event.id && experience == event.experience && isDeleted == event.isDeleted
				&& Objects.equals(name, event.name) && Objects.equals(startDate, event.startDate)
				&& Objects.equals(endDate, event.endDate) && Objects.equals(xmlPath, event.xmlPath);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, name, startDate, endDate, xmlPath, experience, isDeleted);
	}
}
