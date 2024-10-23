package io.codeforall.fanSTATICs;

abstract public class Enemy extends GameObject {

    private int health;
    private boolean isDead;

    private boolean isDead() {

        return false;
    }

    private void hit(int shoot) {

    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}

