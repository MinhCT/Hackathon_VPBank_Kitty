package com.hackathon.kitty.gamification.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hackathon.kitty.gamification.model.*;
import com.hackathon.kitty.gamification.service.*;
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

import com.hackathon.kitty.gamification.util.specification.BaseSpecificationsBuilder;

@RestController
@RequestMapping("/api/food")
public class FoodController {

	@Autowired
	FoodService foodService;

	@Autowired
	KittyTypeService kittyTypeService;

	@Autowired
	UserService userService;

	@Autowired
	RankService rankService;

	@Autowired
	KittyService kittyService;

	@Autowired
	UserBuyFoodService userBuyFoodService;

	@GetMapping("/store")
	public ResponseEntity<ItemStore> getAllItemStore(){
		List<Food> foods = foodService.getAllFood();
		BaseSpecificationsBuilder<KittyType> builder = new BaseSpecificationsBuilder<>();
		builder.with("name","=","egg");
		List<KittyType> eggs = kittyTypeService.findKittyTypeBySpec(builder.build());
		ItemStore itemStore = new ItemStore(eggs, foods);
		return new ResponseEntity<ItemStore>(itemStore, HttpStatus.OK);
	}

	@PostMapping("/buy")
	public ResponseEntity<?> postBuyItemById(@RequestParam(value = "id") String id, @RequestParam(value = "name") String name, @RequestParam(value = "accountNumber") String accountNumber){
		User buyer =  userService.findUserByAccountNumber(accountNumber);
		if(name.equalsIgnoreCase("egg")){
			KittyType egg = kittyTypeService.findKittyTypeById(Integer.parseInt(id));
			if(buyer.getCreditPoint()<egg.getPrice()){
				//TODO: return error message due to not enough CP
				return new ResponseEntity<>("not enough money", HttpStatus.OK);
			} else{
				//pay CP
				buyer.setCreditPoint(buyer.getCreditPoint() - egg.getPrice());
				//add new record to kitty
				Kitty kitty = new Kitty();
				kitty.setExperience(0);
				byte[] b = new byte[1];
				new Random().nextBytes(b);
				kitty.setGender(b[0]);
				kitty.setHunger(80);	//default hunger for new egg = 80
				kitty.setHygiene(80);	//default hygiene for new egg = 80
				kitty.setKittyTypeId(egg.getId());
				kitty.setLastBathDate(new Timestamp(System.currentTimeMillis()));
				kitty.setLastFeedDate(new Timestamp(System.currentTimeMillis()));
				kitty.setLevel(0);
				kitty.setExperience(0);
				kitty.setPrice(egg.getPrice());
				kitty.setRank(rankService.getAllRank().size()+1);
				kitty.setUserId(buyer.getId());
				kitty.setName("Hello");
				kitty.setImage("egg");
				try {
					kittyService.createKitty(kitty);
					userService.updateUser(buyer);
				} catch (Exception e){
					return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
				}
				return new ResponseEntity<>("successfully buy", HttpStatus.OK);
			}
		} else {
			Food food = foodService.findFoodById(Integer.parseInt(id));
			if(buyer.getCreditPoint() < food.getPrice()){
				return new ResponseEntity<>("not enough money", HttpStatus.OK);
			} else {
				//pay CP
				buyer.setCreditPoint(buyer.getCreditPoint()-food.getPrice());
				//user own food
				try{
					UserBuyFood userBuyFood = userBuyFoodService.findByUserIdAndFoodId(buyer.getId(), Integer.parseInt(id));
					if(userBuyFood == null){
						userBuyFood = new UserBuyFood();
						userBuyFood.setQuantity(1);
						userBuyFood.setUserId(buyer.getId());
						userBuyFood.setFoodId(Integer.parseInt(id));
						userBuyFoodService.createUserBuyFood(userBuyFood);
					} else {
						userBuyFood.setQuantity(userBuyFood.getQuantity()+1);
						userBuyFoodService.updateUserBuyFood(userBuyFood);
					}

				} catch (Exception e ){
					return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
				}
				//update entity
				userService.updateUser(buyer);
				return new ResponseEntity<>("buy successfully", HttpStatus.OK);
			}
		}
	}

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
