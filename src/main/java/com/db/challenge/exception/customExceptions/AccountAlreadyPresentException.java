package com.db.challenge.exception.customExceptions;

public class AccountAlreadyPresentException extends Exception {

	private static final long serialVersionUID = 2691962703830213627L;

	public AccountAlreadyPresentException(String message) {
		super(message);
	}

}
