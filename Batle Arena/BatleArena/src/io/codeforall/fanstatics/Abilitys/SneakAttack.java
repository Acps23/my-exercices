package io.codeforall.fanstatics.Abilitys;

import io.codeforall.fanstatics.Hero.Hero;

public class SneakAttack extends AbstractAbility {
    private int critDamage = 45; // Critical damage dealt by the Sneak Attack ability

    public SneakAttack() {
        super(0);
    }// Initialize the Sneak Attack ability with a mana cost of 0

    @Override
    public void execute(Hero target) {
            target.receiveDamage(critDamage);
            System.out.println("Rogue performs a Sneak Attack dealing " + critDamage + " damage!");

    }
}

