package com.hackathon.kitty.gamification.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import com.hackathon.kitty.gamification.model.Food;
import com.hackathon.kitty.gamification.repository.FoodRepository;
import com.hackathon.kitty.gamification.util.HungerHygieneCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hackathon.kitty.gamification.model.Kitty;
import com.hackathon.kitty.gamification.repository.KittyRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KittyService {
	@Autowired
	KittyRepository kittyRepository;
	@Autowired
	FoodRepository foodRepository;

	public List<Kitty> getAllKitties() {
		return kittyRepository.findAll();
	}

	public Page<Kitty> getAllKitties(Pageable pageable) {
		return kittyRepository.findAll(pageable);
	}

	public List<Kitty> findKittiesWithSpec(Specification<Kitty> spec) {
		return kittyRepository.findAll(spec);
	}

	public Page<Kitty> findKittiesWithSpec(Specification<Kitty> spec, Pageable pageable) {
		return kittyRepository.findAll(spec, pageable);
	}

	public Kitty updateKitty(Kitty kitty) {
		// TODO: add checks for updating
		return kittyRepository.save(kitty);
	}
	@Transactional(rollbackFor={Exception.class})
	public Kitty createKitty(Kitty kitty) {
		// TODO: add checks for inserting
		return kittyRepository.save(kitty);
	}

	public Kitty findKittyById(Integer id) {
		Optional<Kitty> optionalKitty = kittyRepository.findById(id);
		if (optionalKitty.isPresent()) {
			Kitty kitty = optionalKitty.get();
			kitty = HungerHygieneCalculator.recalculateHungerAndHygiene(kitty);

			return kitty;
		}

		return null;
	}

	public void deleteKitty(Kitty kitty) {
		kittyRepository.delete(kitty);
	}

	public List<Kitty> findByUserId(int userId){
		List<Kitty> kitties = kittyRepository.findByUserId(userId);
		return kitties;
	}

	public Kitty feedKitty(String kittyId, String foodId) {
		Optional<Kitty> optionalKitty = kittyRepository.findById(Integer.parseInt(kittyId));
		if (optionalKitty.isPresent()) {
			Kitty kitty = optionalKitty.get();
			kitty = HungerHygieneCalculator.recalculateHungerAndHygiene(kitty);

			Optional<Food> optionalFood = foodRepository.findById(Integer.parseInt(foodId));
			if (optionalFood.isPresent()) {
				int energy = optionalFood.get().getEnergy();
				int currentHunger = kitty.getHunger() + energy;
				if (currentHunger >= 100) currentHunger = 100;
				kitty.setHunger(currentHunger);
				kitty.setLastFeedDate(new Timestamp(System.currentTimeMillis() + 25200000));
			}

			return kittyRepository.save(kitty);
		}

		return null;
	}

	public Kitty bathKitty(String kittyId) {
		Optional<Kitty> optionalKitty = kittyRepository.findById(Integer.parseInt(kittyId));
		if (optionalKitty.isPresent()) {
			Kitty kitty = optionalKitty.get();
			kitty.setHygiene(100);
			kitty.setLastBathDate(new Timestamp(System.currentTimeMillis() + 25200000));
			return kittyRepository.save(kitty);
		}

		return null;
	}
}
