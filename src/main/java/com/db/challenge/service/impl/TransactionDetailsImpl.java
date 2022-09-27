package com.db.challenge.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.db.challenge.bean.Account;
import com.db.challenge.bean.TransactionDetails;
import com.db.challenge.repo.ITransactionDetailsRepo;
import com.db.challenge.service.ITransactionDetailsService;

@Service
public class TransactionDetailsImpl implements ITransactionDetailsService {

	@Autowired
	private ITransactionDetailsRepo iTransactionDetailsRepo;

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Optional<TransactionDetails> saveTransaction(Account from, Account to, double amount) {

		TransactionDetails trDetails = new TransactionDetails(from, to, amount);

		iTransactionDetailsRepo.saveAndFlush(trDetails);

		return Optional.of(trDetails);
	}

	@Override
	@Transactional
	public List<TransactionDetails> getAllTransactions() {
		return iTransactionDetailsRepo.findAll();
	}

}
