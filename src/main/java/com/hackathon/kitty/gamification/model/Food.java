package com.hackathon.kitty.gamification.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Food implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 592382328131107677L;

    private int id;
    private String name;
    private int price;
    private int experience;
    private String image;
    private int energy;
    private boolean deleted;
    private String description;

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

    @Column(name = "price")
    @NotNull
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name = "experience")
    @NotNull
    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Column(name = "image", length = 128)
    @NotNull
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "energy")
    @NotNull
    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Column(name = "deleted", nullable = false)
    @NotNull
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return id == food.id &&
                price == food.price &&
                experience == food.experience &&
                energy == food.energy &&
                deleted == food.deleted &&
                Objects.equals(name, food.name) &&
                Objects.equals(image, food.image) &&
                Objects.equals(description, food.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, price, experience, image, energy, deleted, description);
    }
}
