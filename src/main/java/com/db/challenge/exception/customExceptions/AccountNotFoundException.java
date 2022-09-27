package com.db.challenge.exception.customExceptions;

public class AccountNotFoundException extends Exception {

	private static final long serialVersionUID = 7593824500635048111L;

	public AccountNotFoundException(String message) {
		super(message);
	}

}
