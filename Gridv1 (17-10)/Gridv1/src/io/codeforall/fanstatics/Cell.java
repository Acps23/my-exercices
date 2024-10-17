package io.codeforall.fanstatics;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {
    private Rectangle rect;
    private int col;
    private int row;

    private int cellSize = 30;

    public static final int PADDING = 10;

    public Cell(int col, int row){
        this.col = col;
        this.row = row;
        this.rect = new Rectangle(PADDING,PADDING,col*cellSize,row * cellSize);
        this.rect.draw();
    }
}
