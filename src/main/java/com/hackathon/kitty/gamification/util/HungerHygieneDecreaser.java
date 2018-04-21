package com.hackathon.kitty.gamification.util;

import com.hackathon.kitty.gamification.models.Kitty;
import com.hackathon.kitty.gamification.repository.KittyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HungerHygieneDecreaser {
    @Autowired
    private KittyRepository kittyRepository;

    @Scheduled(fixedRate = 1000)
    public void decreaseHungerAndHygiene() {
        for (Kitty kitty : kittyRepository.findAll()) {

        }
    }
}
