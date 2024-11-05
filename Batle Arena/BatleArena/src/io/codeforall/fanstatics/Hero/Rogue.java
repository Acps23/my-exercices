package io.codeforall.fanstatics.Hero;

import io.codeforall.fanstatics.Abilitys.SneakAttack;

public class Rogue extends Hero {

    public Rogue(int health, int mana, int attack, int defense) {
        super(health, mana, attack, defense, new SneakAttack());
    }

    @Override
    public void useAbility(Hero target) {
        if (this.getMana() >= SneakAttack.getManaCost()) { // Check if the Rogue has enough mana
            getAbility().execute(target); // Execute the SneakAttack ability on the target
            reduceMana(SneakAttack.getManaCost()); // Reduce mana by the cost of the SneakAttack ability
        }
    }
}
