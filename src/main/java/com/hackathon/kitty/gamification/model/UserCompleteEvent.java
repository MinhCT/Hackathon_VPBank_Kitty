package com.hackathon.kitty.gamification.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user_complete_event", schema = "kitty_bank", catalog = "")
public class UserCompleteEvent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3708649928352398326L;
	
	private int userId;
	private int eventId;
	private byte isCompleted;

	@Id
	@Column(name = "userId", nullable = false)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Id
	@Column(name = "eventId", nullable = false)
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	@Basic
	@Column(name = "isCompleted", nullable = false)
	public byte getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(byte isCompleted) {
		this.isCompleted = isCompleted;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserCompleteEvent that = (UserCompleteEvent) o;
		return userId == that.userId && eventId == that.eventId && isCompleted == that.isCompleted;
	}

	@Override
	public int hashCode() {

		return Objects.hash(userId, eventId, isCompleted);
	}
}
