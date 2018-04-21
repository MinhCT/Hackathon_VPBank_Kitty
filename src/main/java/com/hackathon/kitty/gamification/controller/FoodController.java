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

import com.hackathon.kitty.gamification.model.Food;
import com.hackathon.kitty.gamification.service.FoodService;
import com.hackathon.kitty.gamification.util.specification.BaseSpecificationsBuilder;

@RestController
@RequestMapping("/api/food")
public class FoodController {

	@Autowired
	FoodService foodService;

	@GetMapping("")
	public ResponseEntity<List<Food>> getAllFood() {
		return new ResponseEntity<>(foodService.getAllFood(), HttpStatus.OK);
	}

	@GetMapping("/paging")
	public ResponseEntity<Page<Food>> getAllFood(Pageable pageable) {
		return new ResponseEntity<>(foodService.getAllFood(pageable), HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Food>> searchFood(@RequestParam(value = "query") String query) {
		BaseSpecificationsBuilder<Food> builder = new BaseSpecificationsBuilder<>();

		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(.*?),");
		Matcher matcher = pattern.matcher(query + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		Specification<Food> spec = builder.build();

		return new ResponseEntity<>(foodService.findFoodBySpec(spec), HttpStatus.OK);
	}

	@GetMapping("/search/paging")
	public ResponseEntity<Page<Food>> searchFood(@RequestParam(value = "query") String query, Pageable pageable) {
		BaseSpecificationsBuilder<Food> builder = new BaseSpecificationsBuilder<>();

		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(.*?),");
		Matcher matcher = pattern.matcher(query + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		Specification<Food> spec = builder.build();

		return new ResponseEntity<>(foodService.findFoodBySpec(spec, pageable), HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<?> createFood(@RequestBody Food food) {
		// TODO: add checks (for duplicate id for example -> return error message)
		// return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(foodService.createFood(food), HttpStatus.OK);
	}

	@PutMapping("")
	public ResponseEntity<?> updateFood(@RequestBody Food food) {
		// TODO: add checks (for duplicate id for example -> return error message)
		// return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(foodService.updateFood(food), HttpStatus.OK);
	}

	@DeleteMapping("")
	public ResponseEntity<?> deleteFood(@RequestBody Food food) {
		// TODO: add checks (for duplicate id for example -> return error message)
		// return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

		foodService.deleteFood(food);

		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
}