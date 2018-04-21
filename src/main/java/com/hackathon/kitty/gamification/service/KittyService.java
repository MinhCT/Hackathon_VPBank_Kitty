package com.hackathon.kitty.gamification.service;

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

	public Kitty feedKitty(String kittyId, String foodId) {
		Optional<Kitty> optionalKitty = kittyRepository.findById(Integer.parseInt(kittyId));
		if (optionalKitty.isPresent()) {
			Kitty kitty = optionalKitty.get();
			kitty = HungerHygieneCalculator.recalculateHungerAndHygiene(kitty);

			Optional<Food> optionalFood = foodRepository.findById(Integer.parseInt(foodId));
			if (optionalFood.isPresent()) {
				int energy = optionalFood.get().getEnergy();
				kitty.setHunger(kitty.getHunger() + energy);
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
			return kittyRepository.save(kitty);
		}

		return null;
	}
}
