package com.hackathon.kitty.gamification.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hackathon.kitty.gamification.model.Event;
import com.hackathon.kitty.gamification.repository.EventRepository;

@Service
public class EventService {
	@Autowired
	EventRepository eventRepository;

	public List<Event> getAllEvent() {
		return eventRepository.findAll();
	}

	public Page<Event> getAllEvent(Pageable pageable) {
		return eventRepository.findAll(pageable);
	}

	public List<Event> findEventBySpec(Specification<Event> spec) {
		return eventRepository.findAll(spec);
	}

	public Page<Event> findEventBySpec(Specification<Event> spec, Pageable pageable) {
		return eventRepository.findAll(spec, pageable);
	}

	public Event updateEvent(Event event) {
		// TODO: add checks for updating
		return eventRepository.save(event);
	}

	public Event createEvent(Event event) {
		// TODO: add checks for inserting
		return eventRepository.save(event);
	}

	public Event findEventById(Integer id) {
		Optional<Event> event = eventRepository.findById(id);

		return event.isPresent() ? event.get() : null;
	}

	public void deleteEvent(Event event) {
		eventRepository.delete(event);
	}
}
