package com.hackathon.kitty.gamification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.hackathon.kitty.gamification.model.KittyType;

@Repository
public interface KittyTypeRepository extends JpaRepository<KittyType, Integer>, JpaSpecificationExecutor<KittyType> {
}
