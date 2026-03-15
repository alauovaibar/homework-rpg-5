package com.narxoz.rpg;

import com.narxoz.rpg.decorator.*;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.facade.AdventureResult;
import com.narxoz.rpg.facade.DungeonFacade;
import com.narxoz.rpg.hero.HeroProfile;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 5 Demo: Decorator + Facade ===\n");

        HeroProfile hero = new HeroProfile("Ведьмак Геральт", 120);
        BossEnemy boss = new BossEnemy("Ледяной Гигант", 200, 18);

        AttackAction basic = new BasicAttack("Удар мечом", 15);

        AttackAction fireSword = new FireRuneDecorator(basic);

        AttackAction ultimateAttack = new CriticalFocusDecorator(
                new PoisonCoatingDecorator(
                        new FireRuneDecorator(basic)
                )
        );

        System.out.println("--- Проверка работы паттерна Decorator ---");
        printAttackInfo(basic);
        printAttackInfo(fireSword);
        printAttackInfo(ultimateAttack);

        System.out.println("\n--- Проверка работы паттерна Facade (Dungeon Run) ---");
        DungeonFacade facade = new DungeonFacade().setRandomSeed(12345L);

        AdventureResult result = facade.runAdventure(hero, boss, ultimateAttack);

        System.out.println("========================================");
        System.out.println("ИТОГИ ПРИКЛЮЧЕНИЯ:");
        System.out.println("========================================");
        System.out.println("Победитель: " + result.getWinner());
        System.out.println("Длительность: " + result.getRounds() + " раундов");
        System.out.println("Полученная награда: " + result.getReward());
        System.out.println("\nДетальный лог сражения:");

        for (String line : result.getLog()) {
            System.out.println(" > " + line);
        }

        System.out.println("\n=== Demo Complete ===");
    }

    private static void printAttackInfo(AttackAction action) {
        System.out.println("Действие: [" + action.getActionName() + "]");
        System.out.println("   - Урон: " + action.getDamage());
        System.out.println("   - Эффекты: " + action.getEffectSummary());
        System.out.println("----------------------------------------");
    }
}