package io.codeforall.bootcamp.gameobject.decor;

import io.codeforall.bootcamp.gameobject.Destroyable;
import io.codeforall.bootcamp.gameobject.GameObject;

public class Barrel extends GameObject implements Destroyable {

    private BarrelType barrelType;
    private int currentDamage;
    private boolean destroyed;

    public Barrel(BarrelType barrelType) {
        this.barrelType = BarrelType.values()[(int) (Math.random() * BarrelType.values().length)];
    }

    public BarrelType getBarrelType() {
        return barrelType;
    }


    public void hit(int damage) {
        switch (barrelType) {
            case METAL:
                BarrelType.METAL.setDamage(BarrelType.METAL.getMaxDamage() - damage);
                break;
            case WOOD:
                BarrelType.WOOD.setDamage(BarrelType.WOOD.getMaxDamage() - damage);
                break;
            case PLASTIC:
                BarrelType.PLASTIC.setDamage(BarrelType.PLASTIC.getMaxDamage() - damage);
                break;
        }

    }

    public boolean isDestroyed() {
        if (barrelType.METAL.getDamage()<=0){
            return true;
        } else if (barrelType.WOOD.getDamage()<=0) {
            return true;
        } else if (barrelType.PLASTIC.getDamage()<=0){
        return true;
        } return false;
    }

    @Override
    public String getMessage() {
        return "Interesting barrel, I wonder if it will explodes...";
    }
}
