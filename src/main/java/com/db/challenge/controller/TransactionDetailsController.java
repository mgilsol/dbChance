package com.db.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.db.challenge.bean.TransactionDetails;
import com.db.challenge.service.ITransactionDetailsService;

@RestController("/")
public class TransactionDetailsController {

	@Autowired
	private ITransactionDetailsService iTransactionDetailsService;

	@RequestMapping(value = "/getTransactions", method = RequestMethod.GET)
	public ResponseEntity<List<TransactionDetails>> getAllTransactionDetails() {
		return new ResponseEntity<List<TransactionDetails>>(iTransactionDetailsService.getAllTransactions(),
				HttpStatus.ACCEPTED);
	}

}
