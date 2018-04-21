package com.hackathon.kitty.gamification.service;

import java.util.List;
import java.util.Optional;

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
}
