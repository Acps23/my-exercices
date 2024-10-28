package io.codeforall.fanSTATICs;

public class SniperRifle {

    private int bulletDamage = 50;

    private void shoot(Enemy enemy){
        int accuracy = (int) Math.ceil(Math.random()*5);
        if(accuracy < 5) {
            enemy.setHealth(enemy.getHealth() - bulletDamage);
            System.out.println("Pum, hhhhhhhh splash!");
        }
        else {
            System.out.println("Pum, hhhhhhhh pheeeeewwwwwwwww");
        }
    }

}
