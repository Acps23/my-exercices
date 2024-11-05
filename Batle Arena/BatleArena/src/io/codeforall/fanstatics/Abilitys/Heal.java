package io.codeforall.fanstatics.Abilitys;

import io.codeforall.fanstatics.Hero.Cleric;
import io.codeforall.fanstatics.Hero.Hero;

public class Heal extends AbstractAbility {
    private int healAmount = 25;// Amount of health restored by the Heal ability

    public Heal() {
        super(50);
    }// Initialize the Heal ability with a mana cost of 20

    @Override
    public void execute(Hero target) {
        if (target instanceof Cleric) {
           ((Cleric) target).receiveHealing(healAmount); // Restore health to the Cleric
            System.out.println("Cleric heals for " + healAmount + " health!");
        }
    }
}
