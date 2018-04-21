package com.hackathon.kitty.gamification.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hackathon.kitty.gamification.model.UserCompleteEvent;
import com.hackathon.kitty.gamification.repository.UserCompleteEventRepository;

@Service
public class UserCompleteEventService {
	@Autowired
	UserCompleteEventRepository userCompleteEventRepository;

	public List<UserCompleteEvent> getAllUserCompleteEvent() {
		return userCompleteEventRepository.findAll();
	}

	public Page<UserCompleteEvent> getAllUserCompleteEvent(Pageable pageable) {
		return userCompleteEventRepository.findAll(pageable);
	}

	public List<UserCompleteEvent> findUserCompleteEventBySpec(Specification<UserCompleteEvent> spec) {
		return userCompleteEventRepository.findAll(spec);
	}

	public Page<UserCompleteEvent> findUserCompleteEventBySpec(Specification<UserCompleteEvent> spec,
			Pageable pageable) {
		return userCompleteEventRepository.findAll(spec, pageable);
	}

	public UserCompleteEvent updateUserCompleteEvent(UserCompleteEvent userCompleteEvent) {
		// TODO: add checks for updating
		return userCompleteEventRepository.save(userCompleteEvent);
	}

	public UserCompleteEvent createUserCompleteEvent(UserCompleteEvent userCompleteEvent) {
		// TODO: add checks for inserting
		return userCompleteEventRepository.save(userCompleteEvent);
	}

	public UserCompleteEvent findUserCompleteEventById(Integer id) {
		Optional<UserCompleteEvent> userCompleteEvent = userCompleteEventRepository.findById(id);

		return userCompleteEvent.isPresent() ? userCompleteEvent.get() : null;
	}

	public void deleteUserCompleteEvent(UserCompleteEvent userCompleteEvent) {
		userCompleteEventRepository.delete(userCompleteEvent);
	}
}
