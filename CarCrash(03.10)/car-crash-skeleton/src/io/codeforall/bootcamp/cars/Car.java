package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.field.Position;

abstract  public class Car {

    /** The position of the car on the grid */
    private Position pos;
    private int velocity;

    private String brand;

    public car(String brand, int velocity, Position pos){
        this.brand = brand,
        this.velocity = velocity,
        this.pos = pos;
    }
    public Position getPos() {
        return pos;
    }

    public boolean isCrashed() {
        return false;
    }


}
