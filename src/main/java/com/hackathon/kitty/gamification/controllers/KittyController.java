package com.hackathon.kitty.gamification.controllers;

import com.hackathon.kitty.gamification.models.Kitty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hackathon.kitty.gamification.repository.KittyRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class KittyController {

    @Autowired
    KittyRepository kittyRepository;

    @GetMapping("/kitties")
    public List<Kitty> getAllKitties() {
        return kittyRepository.findAll();
    }

    @GetMapping("/kitties/{id}")
    public Optional<Kitty> getKittyById(@PathVariable(value = "id") Integer kittyId) {
        return kittyRepository.findById(kittyId);
    }
}
