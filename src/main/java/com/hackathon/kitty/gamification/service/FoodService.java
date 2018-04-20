package com.hackathon.kitty.gamification.service;

import com.hackathon.kitty.gamification.model.Food;
import com.hackathon.kitty.gamification.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    FoodRepository foodRepository;

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    public Page<Food> getAllFoods(Pageable pageable) {
        return foodRepository.findAll(pageable);
    }

    public List<Food> findFoodBySpec(Specification<Food> spec) {
        return foodRepository.findAll(spec);
    }

    public Page<Food> findFoodBySpec(Specification<Food> spec, Pageable pageable) {
        return foodRepository.findAll(spec, pageable);
    }
}
