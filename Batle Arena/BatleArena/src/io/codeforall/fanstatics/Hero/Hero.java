package io.codeforall.fanstatics.Hero;

import io.codeforall.fanstatics.Abilitys.Ability;
import io.codeforall.fanstatics.Abilitys.AbstractAbility;

public abstract class Hero {
    private int health;
    private int mana;
    private int attack;
    private int defense;
    private Ability ability;
    private int cooldown = 0;

    public Hero(int health, int mana, int attack, int defense, Ability ability) {
        this.health = health;
        this.mana = mana;
        this.attack = attack;
        this.defense = defense;
        this.ability = ability;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void receiveDamage(int damage) {
        if (health <= 0) return; // If hero is already dead, do nothing

        int effectiveDamage = Math.max(damage - defense, 0); // Calculate effective damage after defense
        health -= effectiveDamage; // Reduce health by effective damage
        System.out.println(this.getClass().getSimpleName() + " receives " + effectiveDamage + " damage because he have " + getDefense() + " of defense");
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public void decrementCooldown() {
        if (cooldown > 0) {
            cooldown--;
        }
    }

    public boolean canUseAbility() {
        return cooldown == 0;
    }

    public int getHealth() {
        return Math.max(health, 0);
    }// Return the hero's health, ensuring it's not negative

    public int getMana() {
        return Math.max(mana, 0);
    }// Return the hero's mana, ensuring it's not negative

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getAttack() {
        return attack;
    }

    public void reduceMana(int amount) {
        mana = Math.max(mana - amount, 0);
    } // Reduce mana by the specified amount, ensuring it doesn't go negative

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Ability getAbility() {
        return ability;
    }

    public void useAbility(Hero target) {
        if (mana >= AbstractAbility.getManaCost()) {
            System.out.println(this.getClass().getSimpleName() + " uses " + ability.getClass().getSimpleName() + " on " + target.getClass().getSimpleName() + "!");
            ability.execute(target); // Execute the ability on the target
            reduceMana(AbstractAbility.getManaCost()); // Reduce mana by the ability's cost
            setCooldown(3); // Set the cooldown period for the ability
        } else if (!canUseAbility()) {
            System.out.println(this.getClass().getSimpleName() + " cannot use ability for " + cooldown + " more turns.");
        } else {
            System.out.println(this.getClass().getSimpleName() + " does not have enough mana to use ability.");
        }
    }

    public void attackHero(Hero target) {
        System.out.println(this.getClass().getSimpleName() + " attacks " + target.getClass().getSimpleName() + " for " + attack + " damage!");
        target.receiveDamage(attack);
    }

    public void incrementMana(int increment) {
        setMana(mana + increment);
    }
}