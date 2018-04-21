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

import com.hackathon.kitty.gamification.model.KittyType;
import com.hackathon.kitty.gamification.service.KittyTypeService;
import com.hackathon.kitty.gamification.util.specification.BaseSpecificationsBuilder;

@RestController
@RequestMapping("/api/kitty_type")
public class KittyTypeController {

	@Autowired
	KittyTypeService kittyTypeService;

	@GetMapping("")
	public ResponseEntity<List<KittyType>> getAllKittyType() {
		return new ResponseEntity<>(kittyTypeService.getAllKittyType(), HttpStatus.OK);
	}

	@GetMapping("/paging")
	public ResponseEntity<Page<KittyType>> getAllKittyType(Pageable pageable) {
		return new ResponseEntity<>(kittyTypeService.getAllKittyType(pageable), HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<List<KittyType>> searchKittyType(@RequestParam(value = "query") String query) {
		BaseSpecificationsBuilder<KittyType> builder = new BaseSpecificationsBuilder<>();

		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(.*?),");
		Matcher matcher = pattern.matcher(query + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		Specification<KittyType> spec = builder.build();

		return new ResponseEntity<>(kittyTypeService.findKittyTypeBySpec(spec), HttpStatus.OK);
	}

	@GetMapping("/search/paging")
	public ResponseEntity<Page<KittyType>> searchKittyType(@RequestParam(value = "query") String query,
			Pageable pageable) {
		BaseSpecificationsBuilder<KittyType> builder = new BaseSpecificationsBuilder<>();

		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(.*?),");
		Matcher matcher = pattern.matcher(query + ",");

		while (matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}

		Specification<KittyType> spec = builder.build();

		return new ResponseEntity<>(kittyTypeService.findKittyTypeBySpec(spec, pageable), HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<?> createKittyType(@RequestBody KittyType kittyType) {
		// TODO: add checks (for duplicate id for example -> return error message)
		// return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(kittyTypeService.createKittyType(kittyType), HttpStatus.OK);
	}

	@PutMapping("")
	public ResponseEntity<?> updateKittyType(@RequestBody KittyType kittyType) {
		// TODO: add checks (for duplicate id for example -> return error message)
		// return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(kittyTypeService.updateKittyType(kittyType), HttpStatus.OK);
	}

	@DeleteMapping("")
	public ResponseEntity<?> deleteKittyType(@RequestBody KittyType kittyType) {
		// TODO: add checks (for duplicate id for example -> return error message)
		// return new ResponseEntity<>("Error message", HttpStatus.BAD_REQUEST);

		kittyTypeService.deleteKittyType(kittyType);

		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
}
