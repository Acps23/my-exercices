package io.codeforall.fanstatics.Abilitys;

import io.codeforall.fanstatics.Hero.Hero;

public abstract class AbstractAbility implements Ability {
    private static int manaCost; // Cost in mana to use the ability

    AbstractAbility(int manaCost) {
        this.manaCost = manaCost;
    }

    public static int getManaCost() {
        return manaCost;
    }

    public abstract void execute(Hero target);
}
