package io.codeforall.bootcamp;

import io.codeforall.bootcamp.gameobject.GameObject;
import io.codeforall.bootcamp.gameobject.GameObjectFactory;
import io.codeforall.bootcamp.gameobject.decor.Barrel;
import io.codeforall.bootcamp.gameobject.decor.BarrelType;
import io.codeforall.bootcamp.gameobject.decor.Tree;
import io.codeforall.bootcamp.gameobject.enemy.Enemy;
import io.codeforall.bootcamp.gameobject.weapons.SniperRifle;

/**
 * Sniper Elite
 */
public class Game {

    public static final double ENEMY_PROBABILITY = 0.5;
    public static final double TREE_PROBABILITY = 0.3;

    public static final double BARREL_PROBABILITY = 0.2;
    public static final int BULLET_DAMAGE = 1;

    private GameObject[] gameObjects;
    private SniperRifle sniperRifle;

    /**
     * Construct the game
     *
     * @param numberObjects the number of game objects to create
     */
    public Game(int numberObjects) {

        this.gameObjects = createGameObjects(numberObjects);
        this.sniperRifle = new SniperRifle(BULLET_DAMAGE);

    }

    /**
     * Start shooting
     */
    public void start() {

        for (GameObject gameObject : gameObjects) {

            System.out.println(gameObject.getMessage());

            if (gameObject instanceof Enemy) {

                Enemy target = (Enemy) gameObject;
                while (!target.isDead()) {

                    System.out.println("Making the shot...");
                    sniperRifle.shoot(target);

                }

                System.out.println("Target is neutralized. I repeat, Target is neutralized!");

            }

            if (gameObject instanceof Barrel){
                Barrel target = (Barrel) gameObject;
                while(!target.isDestroyed()) {
                    System.out.println("This is gonna be fun...");
                    sniperRifle.shoot(target);
                }
                System.out.println("BOOOOOOM");
            }


        }

        System.out.println("All targets are down. I repeat all targets are down. " + sniperRifle.getShotsFired() + " shots.");

    }

    private GameObject[] createGameObjects(int numberObjects) {

        GameObject[] gameObjects = new GameObject[numberObjects];

        for (int i = 0; i < gameObjects.length; i++) {
            double random = Math.random();

            if (random < ENEMY_PROBABILITY) {
                gameObjects[i] = GameObjectFactory.createEnemy();

                //gameObjects[i] = Math.random() < ENEMY_PROBABILITY ? GameObjectFactory.createEnemy() : new Tree();
            } else if (random > ENEMY_PROBABILITY && random < (ENEMY_PROBABILITY + TREE_PROBABILITY)) {
                gameObjects[i] = new Tree();

            } else {
                gameObjects[i] = new Barrel(BarrelType.PLASTIC);

            }

        }

        return gameObjects;

    }

}
