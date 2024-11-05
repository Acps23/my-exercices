package io.codeforall.fanstatics.Hero;

import io.codeforall.fanstatics.Abilitys.Heal;

public class Cleric extends Hero {

    public Cleric(int health, int mana, int attack, int defense) {
        super(health, mana, attack, defense, new Heal());
    }

    public void receiveHealing(int healing) {
        if (getHealth() > 0) {
            setHealth(healing + getHealth()); // Increase health by the healing amount
        }
    }

    @Override
    public void useAbility(Hero target) {
        if (this.getMana() >= Heal.getManaCost()) { // Check if the Cleric has enough mana
            getAbility().execute(this); // Execute the Heal ability on itself
            reduceMana(Heal.getManaCost()); // Reduce mana by the cost of the Heal ability
        }
    }
}

