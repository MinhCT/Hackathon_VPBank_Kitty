package com.hackathon.kitty.gamification.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Kitty implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -5103087079214209396L;

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
    private boolean deleted;
    private int hunger;
    private int hygiene;
    private Timestamp lastFeedDate;
    private Timestamp lastBathDate;

    @Transient
    private long mili;

    public long getMili() {
        return System.currentTimeMillis();
    }

    public void setMili(long mili) {
        this.mili = mili;
    }

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

    @Column(name = "deleted")
    @NotNull
    public boolean getIsDeleted() {
        return deleted;
    }

    public void setIsDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Column(name = "hunger")
    @NotNull
    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    @Column(name = "hygiene")
    @NotNull
    public int getHygiene() {
        return hygiene;
    }

    public void setHygiene(int hygiene) {
        this.hygiene = hygiene;
    }

    @Column(name = "last_feed_date")
    @NotNull
    public Timestamp getLastFeedDate() {
        return lastFeedDate;
    }

    public void setLastFeedDate(Timestamp lastFeedDate) {
        this.lastFeedDate = lastFeedDate;
    }

    @Column(name = "last_bath_date")
    @NotNull
    public Timestamp getLastBathDate() {
        return lastBathDate;
    }

    public void setLastBathDate(Timestamp lastBathDate) {
        this.lastBathDate = lastBathDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kitty kitty = (Kitty) o;
        return id == kitty.id &&
                userId == kitty.userId &&
                kittyTypeId == kitty.kittyTypeId &&
                gender == kitty.gender &&
                price == kitty.price &&
                level == kitty.level &&
                experience == kitty.experience &&
                rank == kitty.rank &&
                deleted == kitty.deleted &&
                hunger == kitty.hunger &&
                hygiene == kitty.hygiene &&
                Objects.equals(name, kitty.name) &&
                Objects.equals(image, kitty.image) &&
                Objects.equals(lastFeedDate, kitty.lastFeedDate) &&
                Objects.equals(lastBathDate, kitty.lastBathDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, kittyTypeId, name, gender, image, price, level, experience, rank, deleted, hunger, hygiene, lastFeedDate, lastBathDate);
    }
}
