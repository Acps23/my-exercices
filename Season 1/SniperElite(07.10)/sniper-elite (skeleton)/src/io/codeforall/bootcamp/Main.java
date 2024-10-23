package io.codeforall.bootcamp;

import io.codeforall.bootcamp.gameobject.decor.BarrelType;

public class Main {

    public static void main(String[] args) {

        // create a new game with the specified number of objects
        Game game = new Game(10);

        // start the game
        game.start();

        //System.out.println(BarrelType.values()[2]);

    }

}
