package io.codeforall.fanstatics.Abilitys;

import io.codeforall.fanstatics.Hero.Hero;

public class Fireball extends AbstractAbility {
    private int fireballDamage = 35;// Damage dealt by the Fireball ability

    public Fireball() {
        super(30);
    } // Initialize the Fireball ability with a mana cost of 20

    @Override
    public void execute(Hero target) {
        System.out.println("Mage use fireball: makes " + fireballDamage + " of damage!");
        target.receiveDamage(fireballDamage);
    }
}

