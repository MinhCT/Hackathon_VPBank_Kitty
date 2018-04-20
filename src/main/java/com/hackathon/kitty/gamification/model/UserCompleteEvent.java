package com.hackathon.kitty.gamification.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_complete_event", schema = "kitty_bank", catalog = "")
public class UserCompleteEvent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3708649928352398326L;

	private int userId;
	private int eventId;
	private boolean completed;

	@Id
	@Column(name = "user_id")
	@NotNull
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Id
	@Column(name = "event_id")
	@NotNull
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	@Column(name = "completed")
	@NotNull
	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserCompleteEvent that = (UserCompleteEvent) o;
		return userId == that.userId && eventId == that.eventId && completed == that.completed;
	}

	@Override
	public int hashCode() {

		return Objects.hash(userId, eventId, completed);
	}
}
