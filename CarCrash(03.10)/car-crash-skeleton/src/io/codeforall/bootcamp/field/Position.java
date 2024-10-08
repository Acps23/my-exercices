package io.codeforall.bootcamp.field;

import io.codeforall.bootcamp.cars.CarFactory;

public class Position {

    private int col;
    private int row;
    private CarFactory carFactory;

    private int random;

    public void firstposition() {
        this.col = carFactory.getFirstCol();
        this.row = carFactory.getFirstRow();
    }

    public int getCol() {
        return this.col;
    }

    public int getRow() {
        return this.row;
    }

    public void moveCar (){
        this.random = (int) Math.round(Math.random()*3);
        switch (random){
            case 0:
                if(row==0){
                    moveCar();
                }
                row++;
                //Para cima
            case 1:
                if(row==Field.getWidth()-1){
                    moveCar();
                }
                row--;
                //Para baixo
            case 2:
                if(col==0){
                    moveCar();
                }
                col++;
                //Para o lado direito
            case 3:
                if(col==Field.getHeight()-1){
                    moveCar();
                }
                col--;
                //Para o lado esquerdo
        }
    }

}
