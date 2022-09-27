package com.db.challenge.service;

import java.util.Optional;

import com.db.challenge.bean.Account;
import com.db.challenge.bean.dtos.AccountDto;
import com.db.challenge.exception.customExceptions.AccountAlreadyPresentException;
import com.db.challenge.exception.customExceptions.AccountNotCreatedException;
import com.db.challenge.exception.customExceptions.AccountNotFoundException;
import com.db.challenge.exception.customExceptions.IllegalTransferRequestForAmount;

public interface IAccountService {

	public Optional<AccountDto> createAccount(Account account)
			throws AccountNotCreatedException, AccountAlreadyPresentException;

	public Optional<AccountDto> getAccountById(long accountId) throws AccountNotFoundException;

	public Optional<AccountDto> transferMoney(long fromAccountId, double amount, long toAccountId)
			throws AccountNotFoundException, IllegalTransferRequestForAmount;

}
