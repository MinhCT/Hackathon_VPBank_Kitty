package com.hackathon.kitty.gamification.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hackathon.kitty.gamification.model.KittyType;
import com.hackathon.kitty.gamification.repository.KittyTypeRepository;

@Service
public class KittyTypeService {
	@Autowired
	KittyTypeRepository kittyTypeRepository;

	public List<KittyType> getAllKittyType() {
		return kittyTypeRepository.findAll();
	}

	public Page<KittyType> getAllKittyType(Pageable pageable) {
		return kittyTypeRepository.findAll(pageable);
	}

	public List<KittyType> findKittyTypeBySpec(Specification<KittyType> spec) {
		return kittyTypeRepository.findAll(spec);
	}

	public Page<KittyType> findKittyTypeBySpec(Specification<KittyType> spec, Pageable pageable) {
		return kittyTypeRepository.findAll(spec, pageable);
	}

	public KittyType updateKittyType(KittyType kittyType) {
		// TODO: add checks for updating
		return kittyTypeRepository.save(kittyType);
	}

	public KittyType createKittyType(KittyType kittyType) {
		// TODO: add checks for inserting
		return kittyTypeRepository.save(kittyType);
	}

	public KittyType findKittyTypeById(Integer id) {
		Optional<KittyType> kittyType = kittyTypeRepository.findById(id);

		return kittyType.isPresent() ? kittyType.get() : null;
	}

	public void deleteKittyType(KittyType kittyType) {
		kittyTypeRepository.delete(kittyType);
	}
}
