package com.hackathon.kitty.gamification.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hackathon.kitty.gamification.model.Rank;
import com.hackathon.kitty.gamification.repository.RankRepository;

@Service
public class RankService {
	@Autowired
	RankRepository rankRepository;

	public List<Rank> getAllRank() {
		return rankRepository.findAll();
	}

	public Page<Rank> getAllRank(Pageable pageable) {
		return rankRepository.findAll(pageable);
	}

	public List<Rank> findRankBySpec(Specification<Rank> spec) {
		return rankRepository.findAll(spec);
	}

	public Page<Rank> findRankBySpec(Specification<Rank> spec, Pageable pageable) {
		return rankRepository.findAll(spec, pageable);
	}

	public Rank updateRank(Rank rank) {
		// TODO: add checks for updating
		return rankRepository.save(rank);
	}

	public Rank createRank(Rank rank) {
		// TODO: add checks for inserting
		return rankRepository.save(rank);
	}

	public Rank findRankById(Integer id) {
		Optional<Rank> rank = rankRepository.findById(id);

		return rank.isPresent() ? rank.get() : null;
	}

	public void deleteRank(Rank rank) {
		rankRepository.delete(rank);
	}
}
