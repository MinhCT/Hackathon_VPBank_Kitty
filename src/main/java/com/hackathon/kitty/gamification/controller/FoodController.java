package com.hackathon.kitty.gamification.controller;

import com.hackathon.kitty.gamification.model.Food;
import com.hackathon.kitty.gamification.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping("")
    public ResponseEntity<List<Food>> getAllFoods(){
        return new ResponseEntity<>(foodService.getAllFoods(), HttpStatus.OK);
    }
}
