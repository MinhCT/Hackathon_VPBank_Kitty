package com.hackathon.kitty.gamification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.hackathon.kitty.gamification.model.Kitty;

import java.util.List;

@Repository
public interface KittyRepository extends JpaRepository<Kitty, Integer>, JpaSpecificationExecutor<Kitty> {
    List<Kitty> findByUserId(int userId);
}
