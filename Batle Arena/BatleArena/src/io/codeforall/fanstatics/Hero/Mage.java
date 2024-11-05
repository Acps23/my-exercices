package io.codeforall.fanstatics.Hero;

import io.codeforall.fanstatics.Abilitys.Fireball;

public class Mage extends Hero {

    public Mage(int health, int mana, int attack, int defense) {
        super(health, mana, attack, defense, new Fireball());
    }

    @Override
    public void useAbility(Hero target) {
        if (this.getMana() >= Fireball.getManaCost()) { // Check if the Mage has enough mana
            getAbility().execute(target); // Execute the Fireball ability on the target
            reduceMana(Fireball.getManaCost()); // Reduce mana by the cost of the Fireball ability
        }
    }
}
