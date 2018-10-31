package io.transaction.details.entity;

import java.util.Date;

public class Transaction {

	private int transactionId;
	private int user;
	private Date transactionDate;
	private double salesAmount;
	private Date joinDate;

	public Transaction(int id, int user, Date transactionDate, double salesAmount, Date joinDate) {
		this.transactionId = id;
		this.user = user;
		this.transactionDate = transactionDate;
		this.salesAmount = salesAmount;
		this.joinDate = joinDate;
	}

	public Transaction() {
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(double salesAmount) {
		this.salesAmount = salesAmount;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

}
