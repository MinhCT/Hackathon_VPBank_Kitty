package com.hackathon.kitty.gamification.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity(name = "provider")
public class Provider {
    private int id;
    private String name;
    private String accountNumber;
    private double rewardRate;

    public Provider(int id, String name, String accountNumber, double rewardRate) {
        this.id = id;
        this.name = name;
        this.accountNumber = accountNumber;
        this.rewardRate = rewardRate;
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

    @Column(name = "name")
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "account_number")
    @NotNull
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Column(name = "reward_rate")
    @NotNull
    public double getRewardRate() {
        return rewardRate;
    }

    public void setRewardRate(double rewardRate) {
        this.rewardRate = rewardRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provider provider = (Provider) o;
        return id == provider.id &&
                Double.compare(provider.rewardRate, rewardRate) == 0 &&
                Objects.equals(name, provider.name) &&
                Objects.equals(accountNumber, provider.accountNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, accountNumber, rewardRate);
    }
}
