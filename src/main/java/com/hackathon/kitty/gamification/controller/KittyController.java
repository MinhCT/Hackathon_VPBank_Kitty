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

import com.hackathon.kitty.gamification.model.Kitty;
import com.hackathon.kitty.gamification.service.KittyService;
import com.hackathon.kitty.gamification.util.specification.BaseSpecificationsBuilder;

@RestController
@RequestMapping("/api/kitty")
public class KittyController {

	@Autowired
	KittyService kittyService;

	@GetMapping("")
	public ResponseEntity<List<Kitty>> getAllKitties() {
		return new ResponseEntity<>(kittyService.getAllKitties(), HttpStatus.OK);
	}

	// Paging example:
	// http://localhost:8081/api/kitty?page=0&size=10&sort=id,asc
	@GetMapping("/paging")
	public ResponseEntity<Page<Kitty>> getAllKitties(Pageable pageable) {
		return new ResponseEntity<>(kittyService.getAllKitties(pageable), HttpStatus.OK);
	}

	// Use this to search, for example:
	// http://localhost:8081/api/kitty/search?query=id:1 (other fields work too)
	@GetMapping("/search")
	public ResponseEntity<List<Kitty>> searchKittie(@RequestParam(value = "query") String query) {
		BaseSpecificationsBuilder<Kitty> builder = new BaseSpecificationsBuilder<>();

		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(.*?),");
		Matcher matcher = pattern.matcher(query + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		Specification<Kitty> spec = builder.build();

		return new ResponseEntity<>(kittyService.findKittiesWithSpec(spec), HttpStatus.OK);
	}

	@GetMapping("/search/paging")
	public ResponseEntity<Page<Kitty>> searchKittie(@RequestParam(value = "query") String query, Pageable pageable) {
		BaseSpecificationsBuilder<Kitty> builder = new BaseSpecificationsBuilder<>();

		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(.*?),");
		Matcher matcher = pattern.matcher(query + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		Specification<Kitty> spec = builder.build();

		return new ResponseEntity<>(kittyService.findKittiesWithSpec(spec, pageable), HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<?> createKitty(@RequestBody Kitty kitty) {
		// TODO: add checks (for duplicate id for example -> return error message)
		// return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(kittyService.createKitty(kitty), HttpStatus.OK);
	}

	@PutMapping("")
	public ResponseEntity<?> updateKitty(@RequestBody Kitty kitty) {
		// TODO: add checks (for duplicate id for example -> return error message)
		// return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(kittyService.updateKitty(kitty), HttpStatus.OK);
	}

	@DeleteMapping("")
	public ResponseEntity<?> deleteKitty(@RequestBody Kitty kitty) {
		// TODO: add checks (for duplicate id for example -> return error message)
		// return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

		kittyService.deleteKitty(kitty);

		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
}
