package com.hackathon.kitty.gamification.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hackathon.kitty.gamification.model.Transaction;

@Repository
public interface TransactionRepository
		extends JpaRepository<Transaction, Integer>, JpaSpecificationExecutor<Transaction> {
	@Query("SELECT tran FROM Transaction tran WHERE tran.senderAccount = :accountNumber OR tran.receiverAccount = :accountNumber")
	public List<Transaction> getTransactionsByUserAndSender(@Param("accountNumber") String accountNumber);
}
