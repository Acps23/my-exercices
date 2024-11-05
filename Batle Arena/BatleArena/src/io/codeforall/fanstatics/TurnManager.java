package io.codeforall.fanstatics;

import io.codeforall.fanstatics.Hero.Cleric;
import io.codeforall.fanstatics.Hero.Hero;
import io.codeforall.fanstatics.Hero.Warrior;

import java.util.List;

public class TurnManager {
    private List<Hero> heroes;
    private int shieldBlockDuration = 0;

    public TurnManager(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public void nextTurn() {
        for (Hero currentHero : heroes) {
            if (currentHero.isAlive()) {
                currentHero.decrementCooldown(); // Decrement the cooldown for abilities
                Hero target = getRandomTarget(currentHero); // Get a random target for the hero
                if (target != null) {
                    boolean useAbility = Math.random() < 0.3; // 30% chance to use an ability

                    if (currentHero instanceof Warrior) {
                        Warrior warrior = (Warrior) currentHero;
                        if (shieldBlockDuration > 0) {
                            System.out.println("Warrior's ShieldBlock remains active for " + shieldBlockDuration + " more turns.");
                            shieldBlockDuration--;
                            if (shieldBlockDuration == 0) {
                                warrior.desactivateShieldBlock(); // Desactivate ShieldBlock when duration ends
                            }
                        } else if (useAbility && warrior.canUseAbility()) {
                            warrior.useAbility(target);
                            shieldBlockDuration = 2; // Set ShieldBlock duration
                        } else {
                            warrior.attackHero(target);
                        }
                    } else if (currentHero instanceof Cleric) {
                        Cleric cleric = (Cleric) currentHero;
                        if (useAbility && cleric.canUseAbility()) {
                            cleric.useAbility(cleric); // Cleric uses healing ability on itself
                            Hero attackTarget = getRandomTarget(currentHero); // Cleric also attacks a random target
                            if (attackTarget != null) {
                                System.out.println(cleric.getClass().getSimpleName() + " attacks " + attackTarget.getClass().getSimpleName() + " for " + cleric.getAttack() + " damage!");
                                attackTarget.receiveDamage(cleric.getAttack());
                            }
                        } else {
                            cleric.attackHero(target);
                        }
                    } else {
                        if (useAbility && currentHero.canUseAbility()) {
                            currentHero.useAbility(target);
                        } else {
                            currentHero.attackHero(target);
                        }
                    }

                    if (isOnlyOneHeroAlive()) { // Check if only one hero is left alive
                        announceWinner();
                        return;
                    }
                } else {
                    System.out.println(currentHero.getClass().getSimpleName() + " has no valid targets.");
                }
            }
        }
    }

    private void announceWinner() {
            Hero winner = null;
            for (Hero hero : heroes) {
                if (hero.isAlive()) {
                    winner = hero;
                    break;
                }
            }
            if (winner != null) {
                System.out.println(winner.getClass().getSimpleName() + " is the winner!" + "\n");
            }
        }

    private Hero getRandomTarget(Hero attacker) {
        int numHeroes = heroes.size();

        int startIndex = (int) (Math.random() * numHeroes);

        for (int i = 0; i < numHeroes; i++) {
            int targetIndex = (startIndex + i) % numHeroes;
            Hero potentialTarget = heroes.get(targetIndex);

            if (potentialTarget != attacker && potentialTarget.isAlive()) {
                return potentialTarget; // Return a valid target that is not the attacker and is alive
            }
        }
        return null;
    }

    public boolean isOnlyOneHeroAlive() {
        int aliveCount = 0;
        for (Hero hero : heroes) {
            if (hero.isAlive()) {
                aliveCount++;
            }
        }
        return aliveCount == 1;
    }
}