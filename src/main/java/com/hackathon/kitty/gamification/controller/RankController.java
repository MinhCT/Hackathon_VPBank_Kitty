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

import com.hackathon.kitty.gamification.model.Rank;
import com.hackathon.kitty.gamification.service.RankService;
import com.hackathon.kitty.gamification.util.specification.BaseSpecificationsBuilder;

@RestController
@RequestMapping("/api/rank")
public class RankController {

	@Autowired
	RankService rankService;

	@GetMapping("")
	public ResponseEntity<List<Rank>> getAllRank() {
		return new ResponseEntity<>(rankService.getAllRank(), HttpStatus.OK);
	}

	@GetMapping("/paging")
	public ResponseEntity<Page<Rank>> getAllRank(Pageable pageable) {
		return new ResponseEntity<>(rankService.getAllRank(pageable), HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Rank>> searchRank(@RequestParam(value = "query") String query) {
		BaseSpecificationsBuilder<Rank> builder = new BaseSpecificationsBuilder<>();

		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(.*?),");
		Matcher matcher = pattern.matcher(query + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		Specification<Rank> spec = builder.build();

		return new ResponseEntity<>(rankService.findRankBySpec(spec), HttpStatus.OK);
	}

	@GetMapping("/search/paging")
	public ResponseEntity<Page<Rank>> searchRank(@RequestParam(value = "query") String query, Pageable pageable) {
		BaseSpecificationsBuilder<Rank> builder = new BaseSpecificationsBuilder<>();

		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(.*?),");
		Matcher matcher = pattern.matcher(query + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		Specification<Rank> spec = builder.build();

		return new ResponseEntity<>(rankService.findRankBySpec(spec, pageable), HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<?> createRank(@RequestBody Rank rank) {
		// TODO: add checks (for duplicate id for example -> return error message)
		// return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(rankService.createRank(rank), HttpStatus.OK);
	}

	@PutMapping("")
	public ResponseEntity<?> updateRank(@RequestBody Rank rank) {
		// TODO: add checks (for duplicate id for example -> return error message)
		// return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(rankService.updateRank(rank), HttpStatus.OK);
	}

	@DeleteMapping("")
	public ResponseEntity<?> deleteRank(@RequestBody Rank rank) {
		// TODO: add checks (for duplicate id for example -> return error message)
		// return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

		rankService.deleteRank(rank);

		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
}
