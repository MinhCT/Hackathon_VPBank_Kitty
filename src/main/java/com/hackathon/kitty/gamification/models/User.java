package com.hackathon.kitty.gamification.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class User {
    private int id;
    private String accountNumber;
    private String password;
    private String email;
    private String phone;
    private String fullName;
    private byte gender;
    private int age;
    private Date dob;
    private double balance;
    private int creditPoint;
    private Double savingBalance;
    private int rank;
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
    @Column(name = "accountNumber", nullable = false, length = 50)
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 128)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 12)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "fullName", nullable = false, length = 50)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
    @Column(name = "age", nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Basic
    @Column(name = "dob", nullable = false)
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Basic
    @Column(name = "balance", nullable = false, precision = 0)
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "creditPoint", nullable = false)
    public int getCreditPoint() {
        return creditPoint;
    }

    public void setCreditPoint(int creditPoint) {
        this.creditPoint = creditPoint;
    }

    @Basic
    @Column(name = "savingBalance", nullable = true, precision = 0)
    public Double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(Double savingBalance) {
        this.savingBalance = savingBalance;
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
        User user = (User) o;
        return id == user.id &&
                gender == user.gender &&
                age == user.age &&
                Double.compare(user.balance, balance) == 0 &&
                creditPoint == user.creditPoint &&
                rank == user.rank &&
                isDeleted == user.isDeleted &&
                Objects.equals(accountNumber, user.accountNumber) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(fullName, user.fullName) &&
                Objects.equals(dob, user.dob) &&
                Objects.equals(savingBalance, user.savingBalance);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, accountNumber, password, email, phone, fullName, gender, age, dob, balance, creditPoint, savingBalance, rank, isDeleted);
    }
}
