package com.hackathon.kitty.gamification.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hackathon.kitty.gamification.model.Transaction;
import com.hackathon.kitty.gamification.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	TransactionRepository transactionRepository;

	public List<Transaction> getAllTransaction() {
		return transactionRepository.findAll();
	}

	public Page<Transaction> getAllTransaction(Pageable pageable) {
		return transactionRepository.findAll(pageable);
	}

	public List<Transaction> findTransactionBySpec(Specification<Transaction> spec) {
		return transactionRepository.findAll(spec);
	}

	public Page<Transaction> findTransactionBySpec(Specification<Transaction> spec, Pageable pageable) {
		return transactionRepository.findAll(spec, pageable);
	}

	public Transaction updateTransaction(Transaction transaction) {
		// TODO: add checks for updating
		return transactionRepository.save(transaction);
	}

	public Transaction createTransaction(Transaction transaction) {
		// TODO: add checks for inserting
		return transactionRepository.save(transaction);
	}

	public Transaction findTransactionById(Integer id) {
		Optional<Transaction> transaction = transactionRepository.findById(id);

		return transaction.isPresent() ? transaction.get() : null;
	}

	public void deleteTransaction(Transaction transaction) {
		transactionRepository.delete(transaction);
	}
}
