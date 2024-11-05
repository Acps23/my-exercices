package io.codeforall.fanstatics;

import io.codeforall.fanstatics.Hero.Hero;

import java.util.LinkedList;

public class Arena {
    private LinkedList<Hero> heroes;
    private TurnManager turnManager;

    public Arena(LinkedList<Hero> heroes) {
        this.heroes = heroes;
        this.turnManager = new TurnManager(heroes); // Initialize TurnManager with the list of heroes
    }

    public void start() {
        int round = 1;
        while (isAnyHeroAlive()) { // Continue the battle while any hero is alive
            System.out.println("-- Round " + round + " --");
            turnManager.nextTurn(); // Execute the next turn for all heroes
            getStatus(); // Display the status of all heroes

            if (turnManager.isOnlyOneHeroAlive()) { // Check if only one hero is left alive
                System.out.println("The battle has ended!");
                return;
            }

            round++;
        }
    }

    private boolean isAnyHeroAlive() {
        for (Hero hero : heroes) {
            if (hero.isAlive()) {
                return true;
            }
        }
        return false;
    }

    public void getStatus() {
        System.out.println("-- Hero Status --");
        for (Hero h : heroes) {
            System.out.println(h.getClass().getSimpleName() + ": Health = " + h.getHealth() + ", Mana = " + h.getMana());
        }
        System.out.println("\n");
    }
}

