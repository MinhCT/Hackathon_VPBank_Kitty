package com.hackathon.kitty.gamification.service;

import com.hackathon.kitty.gamification.model.UserBuyFood;
import com.hackathon.kitty.gamification.repository.UserBuyFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserBuyFoodService {
    @Autowired
    UserBuyFoodRepository userBuyFoodRepository;

    public List<UserBuyFood> getAllUserBuyFood() {
        return userBuyFoodRepository.findAll();
    }

    public Page<UserBuyFood> getAllUserBuyFood(Pageable pageable) {
        return userBuyFoodRepository.findAll(pageable);
    }

    public List<UserBuyFood> findUserBuyFoodBySpec(Specification<UserBuyFood> spec) {
        return userBuyFoodRepository.findAll(spec);
    }

    public Page<UserBuyFood> findUserBuyFoodBySpec(Specification<UserBuyFood> spec,
                                                               Pageable pageable) {
        return userBuyFoodRepository.findAll(spec, pageable);
    }

    public UserBuyFood updateUserBuyFood(UserBuyFood userBuyFood) {
        // TODO: add checks for updating
        return userBuyFoodRepository.save(userBuyFood);
    }

    public UserBuyFood createUserBuyFood(UserBuyFood userBuyFood) {
        // TODO: add checks for inserting
        return userBuyFoodRepository.save(userBuyFood);
    }

    public UserBuyFood findUserBuyFoodById(Integer id) {
        Optional<UserBuyFood> userBuyFood = userBuyFoodRepository.findById(id);

        return userBuyFood.isPresent() ? userBuyFood.get() : null;
    }

    public UserBuyFood findByUserIdAndFoodId(int userId, int foodId){
        UserBuyFood userBuyFood = userBuyFoodRepository.findByUserIdAndFoodId(userId, foodId);
        return userBuyFood;
    }

    public void deleteUserBuyFood(UserBuyFood userBuyFood) {
        userBuyFoodRepository.delete(userBuyFood);
    }
}
