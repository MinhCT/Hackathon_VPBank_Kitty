package com.hackathon.kitty.gamification.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.kitty.gamification.model.Transaction;
import com.hackathon.kitty.gamification.service.TransactionService;
import com.hackathon.kitty.gamification.util.specification.BaseSpecificationsBuilder;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@GetMapping("")
	public ResponseEntity<List<Transaction>> getAllTransaction() {
		return new ResponseEntity<>(transactionService.getAllTransaction(), HttpStatus.OK);
	}

	@GetMapping("/paging")
	public ResponseEntity<Page<Transaction>> getAllTransaction(Pageable pageable) {
		return new ResponseEntity<>(transactionService.getAllTransaction(pageable), HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Transaction>> searchTransaction(@RequestParam(value = "query") String query) {
		BaseSpecificationsBuilder<Transaction> builder = new BaseSpecificationsBuilder<>();

		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(.*?),");
		Matcher matcher = pattern.matcher(query + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		Specification<Transaction> spec = builder.build();

		return new ResponseEntity<>(transactionService.findTransactionBySpec(spec), HttpStatus.OK);
	}

	@GetMapping("/search/paging")
	public ResponseEntity<Page<Transaction>> searchTransaction(@RequestParam(value = "query") String query,
			Pageable pageable) {
		BaseSpecificationsBuilder<Transaction> builder = new BaseSpecificationsBuilder<>();

		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(.*?),");
		Matcher matcher = pattern.matcher(query + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		Specification<Transaction> spec = builder.build();

		return new ResponseEntity<>(transactionService.findTransactionBySpec(spec, pageable), HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<?> createTransaction(@RequestBody Transaction transaction) {
		// TODO: add checks (for duplicate id for example -> return error message)
		// return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(transactionService.createTransaction(transaction), HttpStatus.OK);
	}

	@PutMapping("")
	public ResponseEntity<?> updateTransaction(@RequestBody Transaction transaction) {
		// TODO: add checks (for duplicate id for example -> return error message)
		// return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(transactionService.updateTransaction(transaction), HttpStatus.OK);
	}

	@DeleteMapping("")
	public ResponseEntity<?> deleteTransaction(@RequestBody Transaction transaction) {
		// TODO: add checks (for duplicate id for example -> return error message)
		// return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

		transactionService.deleteTransaction(transaction);

		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
}
