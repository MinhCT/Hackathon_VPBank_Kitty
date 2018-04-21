package com.hackathon.kitty.gamification.util;

import com.hackathon.kitty.gamification.constant.Constants;
import com.hackathon.kitty.gamification.model.Kitty;

import static com.hackathon.kitty.gamification.constant.Constants.HUNGRY_RATE;
import static com.hackathon.kitty.gamification.constant.Constants.HYGIENE_RATE;

public class HungerHygieneCalculator {

    // Recalculate the hunger and hygiene value from the old value
    // retrieved from the database based on the rate and current time
    public static Kitty recalculateHungerAndHygiene(Kitty kitty) {
        final long CURRENT_MILLI_SEC = System.currentTimeMillis();
        long lastFeedMilliSec = kitty.getLastFeedDate().getTime();
        long lastBathMilliSec = kitty.getLastBathDate().getTime();

        long feedDiffer = CURRENT_MILLI_SEC - lastFeedMilliSec;
        long bathDiffer = CURRENT_MILLI_SEC - lastBathMilliSec;

        int hungerLossByRate = Math.round((feedDiffer * HUNGRY_RATE) / 60000);
        int hygieneLossByRate = Math.round((bathDiffer * HYGIENE_RATE) / 60000);

        int currentHunger = kitty.getHunger() - hungerLossByRate;
        int currentHygiene = kitty.getHygiene() - hygieneLossByRate;
        if (currentHunger <= 0) currentHunger = 0;
        if (currentHygiene <= 0) currentHygiene = 0;

        kitty.setHunger(currentHunger);
        kitty.setHygiene(currentHygiene);

        return kitty;
    }
}
