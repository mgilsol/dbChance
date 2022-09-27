package com.db.challenge.service;

import java.util.List;
import java.util.Optional;

import com.db.challenge.bean.Account;
import com.db.challenge.bean.TransactionDetails;

public interface ITransactionDetailsService {

	List<TransactionDetails> getAllTransactions();
	
	Optional<TransactionDetails> saveTransaction(Account from, Account to, double amount);

}
