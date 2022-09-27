package com.db.challenge.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.db.challenge.bean.Account;
import com.db.challenge.bean.dtos.AccountDto;
import com.db.challenge.exception.customExceptions.AccountAlreadyPresentException;
import com.db.challenge.exception.customExceptions.AccountNotCreatedException;
import com.db.challenge.exception.customExceptions.AccountNotFoundException;
import com.db.challenge.exception.customExceptions.IllegalTransferRequestForAmount;
import com.db.challenge.repo.IAccountRepo;
import com.db.challenge.service.IAccountService;
import com.db.challenge.service.ITransactionDetailsService;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private IAccountRepo iAccountRepo;

	@Autowired
	private ITransactionDetailsService iTransactionDetailsService;

	@Override
	@Transactional
	public Optional<AccountDto> createAccount(Account account)
			throws AccountNotCreatedException, AccountAlreadyPresentException {
		AccountDto dto = null;
		if (account == null) {
			throw new AccountNotCreatedException("Account cannot be created for being null");
		}

		if (iAccountRepo.existsById(account.getAccountId())) {
			throw new AccountAlreadyPresentException("Account is already present for id : " + account.getAccountId());
		}

		account = iAccountRepo.saveAndFlush(account);
		dto = new AccountDto(account.getAccountId(), account.getBalance());

		return Optional.of(dto);
	}

	@Override
	@Transactional
	public Optional<AccountDto> getAccountById(long accountId) throws AccountNotFoundException {
		AccountDto dto = null;
		Optional<Account> account = null;

		if (accountId == 0) {
			throw new AccountNotFoundException("Account not found for : " + accountId);
		}
		account = iAccountRepo.findById(accountId);

		if (account.isPresent()) {
			dto = new AccountDto(account.get().getAccountId(), account.get().getBalance());
		} else {
			throw new AccountNotFoundException("Account not found for id : " + accountId);
		}

		return Optional.of(dto);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Optional<AccountDto> transferMoney(long fromAccountId, double amount, long toAccountId)
			throws AccountNotFoundException, IllegalTransferRequestForAmount {

		AccountDto dto = null;

		if (fromAccountId == 0) {
			throw new AccountNotFoundException("Account not found for : " + fromAccountId);
		}

		if (toAccountId == 0) {
			throw new AccountNotFoundException("Account not found for : " + toAccountId);
		}

		if (amount < 0) {
			throw new IllegalTransferRequestForAmount("Transfer cannot be initiated for amount : " + amount);
		}

		Account from = null;
		if (getAccountById(fromAccountId).isPresent()) {
			from = iAccountRepo.getReferenceById(fromAccountId);
		} else {
			throw new AccountNotFoundException("Account not found for id : " + fromAccountId);
		}

		Account to = null;
		if (getAccountById(toAccountId).isPresent()) {
			to = iAccountRepo.getReferenceById(toAccountId);
		} else {
			throw new AccountNotFoundException("Account not found for id :" + toAccountId);
		}

		if (from.getAccountId() == to.getAccountId()) {
			throw new IllegalTransferRequestForAmount("Accounts cannot be same");
		}

		if (from.getBalance() < 0) {
			throw new IllegalTransferRequestForAmount("Balance in the senders account is less");
		}

		double balCheck = from.getBalance() - amount;

		if (balCheck <= 0) {
			throw new IllegalTransferRequestForAmount("Balance in the senders account cannot go below zero");
		} else {
			from.setBalance(balCheck);
			to.setBalance(to.getBalance() + amount);
		}

		iAccountRepo.saveAndFlush(from);
		iAccountRepo.saveAndFlush(to);

		iTransactionDetailsService.saveTransaction(from, to, amount);

		dto = new AccountDto(from.getAccountId(), from.getBalance());

		return Optional.of(dto);
	}

}
