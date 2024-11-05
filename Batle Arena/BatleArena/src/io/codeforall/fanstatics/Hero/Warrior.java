package io.codeforall.fanstatics.Hero;

import io.codeforall.fanstatics.Abilitys.ShieldBlock;

public class Warrior extends Hero {
    private ShieldBlock shieldBlock;
    private boolean shieldActive = false; // Tracks if the shield is currently active

    public Warrior(int health, int mana, int attack, int defense) {
        super(health, mana, attack, defense, new ShieldBlock());
        this.shieldBlock = new ShieldBlock();
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

    public void increaseDefense(int amount) {
        setDefense(getDefense() + amount);
    }

    public void decreaseDefense(int amount) {
        setDefense(getDefense() - amount);
    }

    @Override
    public void useAbility(Hero target) {
        if (this.getMana() >= ShieldBlock.getManaCost()) { // Check if the Warrior has enough mana
            activateShieldBlock(); // Activate the ShieldBlock ability
            reduceMana(ShieldBlock.getManaCost()); // Reduce mana by the cost of the ShieldBlock ability
        }
    }
}
