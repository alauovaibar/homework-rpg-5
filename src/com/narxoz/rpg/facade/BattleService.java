package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;
import java.util.Random;

public class BattleService {
    private Random random = new Random();

    public BattleService setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public AdventureResult battle(HeroProfile hero, BossEnemy boss, AttackAction action) {
        AdventureResult result = new AdventureResult();

        result.addLine("Начало боя с " + boss.getName());

        int damage = action.getDamage();
        boss.takeDamage(damage);
        result.addLine(hero.getName() + " применил " + action.getActionName() + " и нанес " + damage + " урона.");

        if (!boss.isAlive()) {
            result.setWinner(hero.getName());
            result.addLine("Босс повержен!");
        } else {

            hero.takeDamage(boss.getAttackPower());
            result.addLine(boss.getName() + " ударил в ответ на " + boss.getAttackPower());
            result.setWinner(hero.isAlive() ? "Ничья" : boss.getName());
        }

        return result;
    }
}