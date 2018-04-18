package com.hackathon.kitty.gamification.repository;

import com.hackathon.kitty.gamification.models.Kitty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KittyRepository extends JpaRepository<Kitty, Integer> {
}
