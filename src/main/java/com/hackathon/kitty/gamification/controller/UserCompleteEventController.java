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

import com.hackathon.kitty.gamification.model.UserCompleteEvent;
import com.hackathon.kitty.gamification.service.UserCompleteEventService;
import com.hackathon.kitty.gamification.util.specification.BaseSpecificationsBuilder;

@RestController
@RequestMapping("/api/userCompleteUserCompleteEvent")
public class UserCompleteEventController {

	@Autowired
	UserCompleteEventService userCompleteUserCompleteEventService;

	@GetMapping("")
	public ResponseEntity<List<UserCompleteEvent>> getAllUserCompleteEvent() {
		return new ResponseEntity<>(userCompleteUserCompleteEventService.getAllUserCompleteEvent(), HttpStatus.OK);
	}

	@GetMapping("/paging")
	public ResponseEntity<Page<UserCompleteEvent>> getAllUserCompleteEvent(Pageable pageable) {
		return new ResponseEntity<>(userCompleteUserCompleteEventService.getAllUserCompleteEvent(pageable),
				HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<List<UserCompleteEvent>> searchUserCompleteEvent(
			@RequestParam(value = "query") String query) {
		BaseSpecificationsBuilder<UserCompleteEvent> builder = new BaseSpecificationsBuilder<>();

		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(.*?),");
		Matcher matcher = pattern.matcher(query + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		Specification<UserCompleteEvent> spec = builder.build();

		return new ResponseEntity<>(userCompleteUserCompleteEventService.findUserCompleteEventBySpec(spec),
				HttpStatus.OK);
	}

	@GetMapping("/search/paging")
	public ResponseEntity<Page<UserCompleteEvent>> searchUserCompleteEvent(@RequestParam(value = "query") String query,
			Pageable pageable) {
		BaseSpecificationsBuilder<UserCompleteEvent> builder = new BaseSpecificationsBuilder<>();

		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(.*?),");
		Matcher matcher = pattern.matcher(query + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		Specification<UserCompleteEvent> spec = builder.build();

		return new ResponseEntity<>(userCompleteUserCompleteEventService.findUserCompleteEventBySpec(spec, pageable),
				HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<?> createUserCompleteEvent(@RequestBody UserCompleteEvent userCompleteUserCompleteEvent) {
		// TODO: add checks (for duplicate id for example -> return error message)
		// return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(
				userCompleteUserCompleteEventService.createUserCompleteEvent(userCompleteUserCompleteEvent),
				HttpStatus.OK);
	}

	@PutMapping("")
	public ResponseEntity<?> updateUserCompleteEvent(@RequestBody UserCompleteEvent userCompleteUserCompleteEvent) {
		// TODO: add checks (for duplicate id for example -> return error message)
		// return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(
				userCompleteUserCompleteEventService.updateUserCompleteEvent(userCompleteUserCompleteEvent),
				HttpStatus.OK);
	}

	@DeleteMapping("")
	public ResponseEntity<?> deleteUserCompleteEvent(@RequestBody UserCompleteEvent userCompleteUserCompleteEvent) {
		// TODO: add checks (for duplicate id for example -> return error message)
		// return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

		userCompleteUserCompleteEventService.deleteUserCompleteEvent(userCompleteUserCompleteEvent);

		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
}
