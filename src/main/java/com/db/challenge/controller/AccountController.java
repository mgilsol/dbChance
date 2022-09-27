package com.db.challenge.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.db.challenge.bean.Account;
import com.db.challenge.bean.dtos.AccountDto;
import com.db.challenge.exception.customExceptions.AccountAlreadyPresentException;
import com.db.challenge.exception.customExceptions.AccountNotCreatedException;
import com.db.challenge.exception.customExceptions.AccountNotFoundException;
import com.db.challenge.exception.customExceptions.IllegalTransferRequestForAmount;
import com.db.challenge.service.IAccountService;

@RestController
public class AccountController {

	@Autowired
	private IAccountService iAccountService;

	@RequestMapping(value = "/createAccount", method = RequestMethod.PUT)
	public ResponseEntity<AccountDto> createAccount(@RequestBody Account account)
			throws AccountAlreadyPresentException, AccountNotCreatedException {
		AccountDto act = iAccountService.createAccount(account).get();

		return new ResponseEntity<AccountDto>(act, HttpStatus.CREATED);
	}

	@GetMapping("/account/{accountId}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable(name = "accountId") long accountId)
			throws AccountNotFoundException {

		Optional<AccountDto> account = iAccountService.getAccountById(accountId);
		if (!account.isPresent()) {
			throw new AccountNotFoundException("Account not found for id : " + accountId);
		}

		return new ResponseEntity<AccountDto>(account.get(), HttpStatus.FOUND);

	}

	@RequestMapping(value = "/transferMoney/{from}/{amount}/{to}", method = RequestMethod.PUT)
	public ResponseEntity<AccountDto> transferMoney(@PathVariable(name = "from") long fromAccountId,
			@PathVariable(name = "amount") double amount, @PathVariable(name = "to") long toAccountId)
			throws AccountNotFoundException, IllegalTransferRequestForAmount {
		Optional<AccountDto> account = iAccountService.transferMoney(fromAccountId, amount, toAccountId);

		return new ResponseEntity<AccountDto>(account.get(), HttpStatus.ACCEPTED);
	}

}
