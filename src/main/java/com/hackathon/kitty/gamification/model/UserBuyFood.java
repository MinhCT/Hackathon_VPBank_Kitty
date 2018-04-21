package com.hackathon.kitty.gamification.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity(name = "user_buy_food")
public class UserBuyFood {
    private int id;
    private int userId;
    private int foodId;
    private int quantity;

    public UserBuyFood(int id, int userId, int foodId, int quantity) {
        this.id = id;
        this.userId = userId;
        this.foodId = foodId;
        this.quantity = quantity;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "food_id")
    @NotNull
    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    @Column(name = "quantity")
    @NotNull
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
