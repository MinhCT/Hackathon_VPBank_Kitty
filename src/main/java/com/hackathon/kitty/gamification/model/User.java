package com.hackathon.kitty.gamification.model;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
	private int rankId;
	private boolean deleted;
	private boolean creditCard;
	private boolean internetBanking;
	private boolean useVpp;
	private boolean useDream;
	private Date joinDate;

	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "account_number", length = 50)
	@NotNull
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Column(name = "password", length = 128)
	@NotNull
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "email", length = 50)
	@NotNull
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", length = 12)
	@NotNull
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "full_name", length = 50)
	@NotNull
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "gender")
	@NotNull
	public byte getGender() {
		return gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	@Column(name = "age")
	@NotNull
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Column(name = "dob")
	@NotNull
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name = "balance", precision = 0)
	@NotNull
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Column(name = "credit_point")
	@NotNull
	public int getCreditPoint() {
		return creditPoint;
	}

	public void setCreditPoint(int creditPoint) {
		this.creditPoint = creditPoint;
	}

	@Column(name = "saving_balance", precision = 0)
	@NotNull
	public Double getSavingBalance() {
		return savingBalance;
	}

	public void setSavingBalance(Double savingBalance) {
		this.savingBalance = savingBalance;
	}

	@Column(name = "deleted")
	@NotNull
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Column(name = "rank_id")
	@NotNull
	public int getRankId() {
		return rankId;
	}

	public void setRankId(int rankId) {
		this.rankId = rankId;
	}

	@Column(name = "has_credit_card")
	@NotNull
	public boolean hasCreditCard() {
		return creditCard;
	}

	public void setCreditCard(boolean creditCard) {
		this.creditCard = creditCard;
	}

	@Column(name = "has_internet_banking")
	@NotNull
	public boolean hasInternetBanking() {
		return internetBanking;
	}

	public void setInternetBanking(boolean internetBanking) {
		this.internetBanking = internetBanking;
	}

	@Column(name = "user_vpp")
	@NotNull
	public boolean doUseVpp() {
		return useVpp;
	}

	public void setUseVpp(boolean useVpp) {
		this.useVpp = useVpp;
	}

	@Column(name = "use_dream")
	@NotNull
	public boolean doUseDream() {
		return useDream;
	}

	public void setUseDream(boolean useDream) {
		this.useDream = useDream;
	}

	@Column(name = "join_date")
	@NotNull
	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User) o;
		return id == user.id && gender == user.gender && age == user.age && Double.compare(user.balance, balance) == 0
				&& creditPoint == user.creditPoint && rankId == user.rankId && deleted == user.deleted
				&& Objects.equals(accountNumber, user.accountNumber) && Objects.equals(password, user.password)
				&& Objects.equals(email, user.email) && Objects.equals(phone, user.phone)
				&& Objects.equals(fullName, user.fullName) && Objects.equals(dob, user.dob)
				&& Objects.equals(savingBalance, user.savingBalance);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id, accountNumber, password, email, phone, fullName, gender, age, dob, balance, creditPoint,
				savingBalance, rankId, deleted);
	}
}
