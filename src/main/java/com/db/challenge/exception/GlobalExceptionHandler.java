package com.db.challenge.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.db.challenge.exception.customExceptions.AccountAlreadyPresentException;
import com.db.challenge.exception.customExceptions.AccountNotCreatedException;
import com.db.challenge.exception.customExceptions.AccountNotFoundException;
import com.db.challenge.exception.customExceptions.IllegalTransferRequestForAmount;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = AccountNotFoundException.class)
	public ResponseEntity<Object> handleAccountNotFoundException(AccountNotFoundException acex, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", acex.getMessage());
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = AccountNotCreatedException.class)
	public ResponseEntity<Object> handleAccountNotCreatedException(AccountNotCreatedException acex,
			WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", acex.getMessage());
		return new ResponseEntity<>(body, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(value = AccountAlreadyPresentException.class)
	public ResponseEntity<Object> handleAccountAlreadyPresentException(AccountAlreadyPresentException acex,
			WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", acex.getMessage());
		return new ResponseEntity<>(body, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(value = IllegalTransferRequestForAmount.class)
	public ResponseEntity<Object> handleIllegalTransferForAmountException(IllegalTransferRequestForAmount acex,
			WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", acex.getMessage());
		return new ResponseEntity<>(body, HttpStatus.NOT_ACCEPTABLE);
	}

}
