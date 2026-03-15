package com.narxoz.rpg.facade;

public class RewardService {
    public String determineReward(AdventureResult battleResult) {
        // TODO: Decide reward rules based on battle outcome.
        if (battleResult.getRounds() < 5) return "Легендарный сундук золота";
        return "Мешочек с монетами";
    }
}
