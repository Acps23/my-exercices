package io.codeforall.bootcamp.gameobject.decor;

public enum BarrelType {
    PLASTIC (4),
    WOOD (6),
    METAL (10);

    private int maxDamage = 1;

    private int damage;

    BarrelType(int maxDamage){
        this.maxDamage = maxDamage;
    }
    public int getMaxDamage() {
        return maxDamage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
