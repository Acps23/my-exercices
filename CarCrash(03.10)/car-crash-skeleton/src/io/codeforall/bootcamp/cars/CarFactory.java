package io.codeforall.bootcamp.cars;

import io.codeforall.bootcamp.field.Field;

public class CarFactory {

    private int firstCol;
    private int firstRow;

    public static Car getNewCar() {
        if ((int) Math.round(Math.random()) == 0) {
            return new Fiat();
            Position carPos = new Position();
        }
        return new Mustang();
    }

    public void firstRow() {
        firstRow = (int) Math.round(Math.random() * Field.getWidth());
    }

    public void firstCol() {
        firstCol = (int) Math.round(Math.random() * Field.getHeight());
    }

    public int getFirstCol() {
        return firstCol;
    }

    public int getFirstRow() {
        return firstRow;
    }
}
