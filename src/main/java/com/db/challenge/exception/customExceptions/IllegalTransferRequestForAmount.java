package com.db.challenge.exception.customExceptions;

public class IllegalTransferRequestForAmount extends Exception {

	private static final long serialVersionUID = 160128958182173030L;

	public IllegalTransferRequestForAmount(String message) {
		super(message);
	}

}
