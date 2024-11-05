package io.codeforall.fanstatics.Abilitys;

import io.codeforall.fanstatics.Hero.Hero;
import io.codeforall.fanstatics.Hero.Warrior;

public class ShieldBlock extends AbstractAbility {

    private int shieldProtect = 15; // Amount of defense increase provided by ShieldBlock

    public ShieldBlock() {
        super(60);
    }// Initialize the ShieldBlock ability with a mana cost

    public void applyShield(Warrior warrior) {
        warrior.increaseDefense(shieldProtect);
        System.out.println("ShieldBlock applied! Defense increased by " + shieldProtect + ".");
    }

    public void removeShield(Warrior warrior) {
        warrior.decreaseDefense(shieldProtect);
        System.out.println("ShieldBlock effect has worn off!");
    }

    @Override
    public void execute(Hero target) {
        if (target instanceof Warrior) {
            applyShield((Warrior) target);
        }
    }
}
