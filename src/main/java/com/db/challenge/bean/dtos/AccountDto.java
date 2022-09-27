package com.db.challenge.bean.dtos;

public class AccountDto {

	public AccountDto() {
	}

	public AccountDto(long accountId, double balance) {
		this.accountId = accountId;
		this.balance = balance;
	}

	private long accountId;
	private double balance;

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountDto [accountId=" + accountId + ", balance=" + balance + "]";
	}

}
