package com.hackathon.kitty.gamification.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hackathon.kitty.gamification.model.TransactionType;
import com.hackathon.kitty.gamification.repository.TransactionTypeRepository;

@Service
public class TransactionTypeService {
	@Autowired
	TransactionTypeRepository transactionTypeRepository;

	public List<TransactionType> getAllTransactionType() {
		return transactionTypeRepository.findAll();
	}

	public Page<TransactionType> getAllTransactionType(Pageable pageable) {
		return transactionTypeRepository.findAll(pageable);
	}

	public List<TransactionType> findTransactionTypeBySpec(Specification<TransactionType> spec) {
		return transactionTypeRepository.findAll(spec);
	}

	public Page<TransactionType> findTransactionTypeBySpec(Specification<TransactionType> spec, Pageable pageable) {
		return transactionTypeRepository.findAll(spec, pageable);
	}

	public TransactionType updateTransactionType(TransactionType transactionType) {
		// TODO: add checks for updating
		return transactionTypeRepository.save(transactionType);
	}

	public TransactionType createTransactionType(TransactionType transactionType) {
		// TODO: add checks for inserting
		return transactionTypeRepository.save(transactionType);
	}

	public TransactionType findTransactionTypeById(Integer id) {
		Optional<TransactionType> transactionType = transactionTypeRepository.findById(id);

		return transactionType.isPresent() ? transactionType.get() : null;
	}

	public void deleteTransactionType(TransactionType transactionType) {
		transactionTypeRepository.delete(transactionType);
	}
}
