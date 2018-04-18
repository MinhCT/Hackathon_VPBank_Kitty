package com.hackathon.kitty.gamification.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class UserCompleteEventPK implements Serializable {
    private int userId;
    private int eventId;

    @Column(name = "userId", nullable = false)
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "eventId", nullable = false)
    @Id
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCompleteEventPK that = (UserCompleteEventPK) o;
        return userId == that.userId &&
                eventId == that.eventId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, eventId);
    }
}
