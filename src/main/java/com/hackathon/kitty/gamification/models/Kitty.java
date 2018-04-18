package com.hackathon.kitty.gamification.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

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
    @Column(name = "userId", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "kittyTypeId", nullable = false)
    public int getKittyTypeId() {
        return kittyTypeId;
    }

    public void setKittyTypeId(int kittyTypeId) {
        this.kittyTypeId = kittyTypeId;
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
    @Column(name = "gender", nullable = false)
    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "image", nullable = false, length = 128)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "level", nullable = false)
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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
    @Column(name = "rank", nullable = false)
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Basic
    @Column(name = "energy", nullable = false)
    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
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
                energy == kitty.energy &&
                isDeleted == kitty.isDeleted &&
                Objects.equals(name, kitty.name) &&
                Objects.equals(image, kitty.image);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, kittyTypeId, name, gender, image, price, level, experience, rank, energy, isDeleted);
    }
}
