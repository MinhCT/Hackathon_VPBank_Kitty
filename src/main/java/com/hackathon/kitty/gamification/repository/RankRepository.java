package com.hackathon.kitty.gamification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.hackathon.kitty.gamification.model.Rank;

@Repository
public interface RankRepository extends JpaRepository<Rank, Integer>, JpaSpecificationExecutor<Rank> {
}
