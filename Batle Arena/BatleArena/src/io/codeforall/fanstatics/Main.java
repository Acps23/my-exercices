package io.codeforall.fanstatics;

import io.codeforall.fanstatics.Hero.*;

import java.util.LinkedList;


public class Main {
    // Create a LinkedList to hold the heroes;
    private static LinkedList<Hero> heroes = new LinkedList<>();

    public static void main(String[] args) {
        // Create instances of different heroes
        Hero rogue = new Rogue(100, 0, 25, 15);
        Hero mage = new Mage(100, 100, 25, 10);
        Hero warrior = new Warrior(100, 100, 30, 10);
        Hero cleric = new Cleric(100, 100, 20, 15);

        // Add the heroes to the LinkedList
        heroes.add(rogue);
        heroes.add(mage);
        heroes.add(warrior);
        heroes.add(cleric);

        // Create an instance of Arena with the list of heroes
        Arena arena = new Arena(heroes);

        // Start the battle in the arena
        arena.start();
    }
}
