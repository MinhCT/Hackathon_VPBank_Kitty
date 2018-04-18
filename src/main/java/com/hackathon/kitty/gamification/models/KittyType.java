package com.hackathon.kitty.gamification.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "kitty_type", schema = "kitty_bank", catalog = "")
public class KittyType {
    private int id;
    private String name;
    private byte gender;
    private String image;
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
        KittyType kittyType = (KittyType) o;
        return id == kittyType.id &&
                gender == kittyType.gender &&
                isDeleted == kittyType.isDeleted &&
                Objects.equals(name, kittyType.name) &&
                Objects.equals(image, kittyType.image);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, gender, image, isDeleted);
    }
}
