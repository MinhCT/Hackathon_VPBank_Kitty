package com.hackathon.kitty.gamification.repository;

import com.hackathon.kitty.gamification.model.UserBuyFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserBuyFoodRepository extends JpaRepository<UserBuyFood, Integer>, JpaSpecificationExecutor<UserBuyFood> {
    UserBuyFood findByUserIdAndFoodId(int userId, int foodId);
}
