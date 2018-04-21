package com.hackathon.kitty.gamification.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hackathon.kitty.gamification.model.Food;
import com.hackathon.kitty.gamification.repository.FoodRepository;

@Service
public class FoodService {
	@Autowired
	FoodRepository foodRepository;

	public List<Food> getAllFood() {
		return foodRepository.findAll();
	}

	public Page<Food> getAllFood(Pageable pageable) {
		return foodRepository.findAll(pageable);
	}

	public List<Food> findFoodBySpec(Specification<Food> spec) {
		return foodRepository.findAll(spec);
	}

	public Page<Food> findFoodBySpec(Specification<Food> spec, Pageable pageable) {
		return foodRepository.findAll(spec, pageable);
	}

	public Food updateFood(Food food) {
		// TODO: add checks for updating
		return foodRepository.save(food);
	}

	public Food createFood(Food food) {
		// TODO: add checks for inserting
		return foodRepository.save(food);
	}

	public Food findFoodById(Integer id) {
		Optional<Food> food = foodRepository.findById(id);

		return food.isPresent() ? food.get() : null;
	}

	public void deleteFood(Food food) {
		foodRepository.delete(food);
	}
}
