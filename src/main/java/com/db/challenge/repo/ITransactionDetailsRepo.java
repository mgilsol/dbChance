package com.db.challenge.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.challenge.bean.TransactionDetails;

@Repository
public interface ITransactionDetailsRepo extends JpaRepository<TransactionDetails, Long> {

}
