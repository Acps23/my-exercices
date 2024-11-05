package io.codeforall.fanstatics.Hero;

import io.codeforall.fanstatics.Abilitys.ShieldBlock;

public class Warrior extends Hero {
    private ShieldBlock shieldBlock;
    private boolean shieldActive = false; // Tracks if the shield is currently active
    private static int initialDefense; // Store the initial defense value
    public Warrior(int health, int mana, int attack, int defense) {
        super(health, mana, attack, defense, new ShieldBlock());
        this.shieldBlock = new ShieldBlock();
        this.initialDefense = defense;
    }

    public void activateShieldBlock() {
        if (!shieldActive) { // Check if the shield is not already active
            shieldBlock.applyShield(this); // Apply the shield effect
            shieldActive = true; // Set shieldActive to true
        }
    }

    public void desactivateShieldBlock() {
        if (shieldActive) { // Check if the shield is currently active
            shieldBlock.removeShield(this); // Remove the shield effect
            shieldActive = false; // Set shieldActive to false

        }
    }

    public int getInitialDefense() {
        return initialDefense;
    }
    public void increaseDefense(int amount) {
        setDefense(initialDefense + amount);
    }

    public void decreaseDefense(int initialDefense) {
        setDefense(initialDefense);
    }

    @Override
    public void useAbility(Hero target) {
        if (this.getMana() >= ShieldBlock.getManaCost()) { // Check if the Warrior has enough mana
            activateShieldBlock(); // Activate the ShieldBlock ability
            reduceMana(ShieldBlock.getManaCost()); // Reduce mana by the cost of the ShieldBlock ability
        }
    }
}
