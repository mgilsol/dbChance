package com.db.challenge.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TransactionDetails {

	public TransactionDetails() {
	}

	public TransactionDetails(Account fromAccount, Account toAccount, double transferredAmount) {
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.transferredAmount = transferredAmount;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Transfer_Id")
	private long transferId;

	@OneToOne
	private Account fromAccount;

	@OneToOne
	private Account toAccount;

	private double transferredAmount;

	public double getBalance() {
		return transferredAmount;
	}

	public void setBalance(double balance) {
		this.transferredAmount = balance;
	}

	public long getTransferId() {
		return transferId;
	}

	public void setTransferId(long transferId) {
		this.transferId = transferId;
	}

	public Account getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Account getToAccount() {
		return toAccount;
	}

	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}

	@Override
	public String toString() {
		return "TransactionDetails [transferId=" + transferId + ", fromAccount=" + fromAccount + ", toAccount="
				+ toAccount + ", balance=" + transferredAmount + "]";
	}

}
