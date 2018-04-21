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

import com.hackathon.kitty.gamification.model.Event;
import com.hackathon.kitty.gamification.service.EventService;
import com.hackathon.kitty.gamification.util.specification.BaseSpecificationsBuilder;

@RestController
@RequestMapping("/api/event")
public class EventController {

	@Autowired
	EventService eventService;

	@GetMapping("")
	public ResponseEntity<List<Event>> getAllEvent() {
		return new ResponseEntity<>(eventService.getAllEvent(), HttpStatus.OK);
	}

	@GetMapping("/paging")
	public ResponseEntity<Page<Event>> getAllEvent(Pageable pageable) {
		return new ResponseEntity<>(eventService.getAllEvent(pageable), HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Event>> searchEvent(@RequestParam(value = "query") String query) {
		BaseSpecificationsBuilder<Event> builder = new BaseSpecificationsBuilder<>();

		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(.*?),");
		Matcher matcher = pattern.matcher(query + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		Specification<Event> spec = builder.build();

		return new ResponseEntity<>(eventService.findEventBySpec(spec), HttpStatus.OK);
	}

	@GetMapping("/search/paging")
	public ResponseEntity<Page<Event>> searchEvent(@RequestParam(value = "query") String query, Pageable pageable) {
		BaseSpecificationsBuilder<Event> builder = new BaseSpecificationsBuilder<>();

		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(.*?),");
		Matcher matcher = pattern.matcher(query + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		Specification<Event> spec = builder.build();

		return new ResponseEntity<>(eventService.findEventBySpec(spec, pageable), HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<?> createEvent(@RequestBody Event event) {
		// TODO: add checks (for duplicate id for example -> return error message)
		// return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(eventService.createEvent(event), HttpStatus.OK);
	}

	@PutMapping("")
	public ResponseEntity<?> updateEvent(@RequestBody Event event) {
		// TODO: add checks (for duplicate id for example -> return error message)
		// return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(eventService.updateEvent(event), HttpStatus.OK);
	}

	@DeleteMapping("")
	public ResponseEntity<?> deleteEvent(@RequestBody Event event) {
		// TODO: add checks (for duplicate id for example -> return error message)
		// return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

		eventService.deleteEvent(event);

		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
}
