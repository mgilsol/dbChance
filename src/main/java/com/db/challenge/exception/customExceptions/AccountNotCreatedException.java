package com.db.challenge.exception.customExceptions;

public class AccountNotCreatedException extends Exception {

	private static final long serialVersionUID = 8785852399192221333L;

	public AccountNotCreatedException(String message) {
		super(message);
	}

}
