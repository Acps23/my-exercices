package io.codeforall.fanstatics.gfx.simplegfx;

import io.codeforall.fanstatics.grid.Grid;
import io.codeforall.fanstatics.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class SimpleGfxGrid implements Grid {

    public static final int PADDING = 10;

    private int cellSize = 30;
    private int cols;
    private int rows;

    private Rectangle field;

    /**
     * Simple graphics grid constructor with a certain number of rows and columns
     *
     * @param cols number of the columns
     * @param rows number of rows
     */
    public SimpleGfxGrid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
    }

    /**
     * Initializes the field simple graphics rectangle and draws it
     */
    @Override
    public void init() {
        this.field = new Rectangle(PADDING,PADDING, cols * cellSize, rows * cellSize);
        this.field.draw();
        for (int col = 0; col <= cols; col++) {
            int x = columnToX(col);
            new Rectangle(x, PADDING, 1, rows * cellSize).draw(); // linha vertical
        }

        // Desenha as linhas horizontais
        for (int row = 0; row <= rows; row++) {
            int y = rowToY(row);
            new Rectangle(PADDING, y, cols * cellSize, 1).draw(); // linha horizontal
        }
    }

    public int getCellSize() {
        return cellSize;
    }

    @Override
    public int getCols() {
        return this.cols;
    }

    @Override
    public int getRows() {
        return this.rows;
    }

    public int getWidth() {
        return this.field.getWidth();
    }

    public int getHeight() {
        return this.field.getHeight();
    }

    public int getX() {
        return this.field.getX();
    }

    public int getY() {
        return this.field.getY();
    }

    /**
     * @see Grid#makeGridPosition()
     */
    @Override
    public GridPosition makeGridPosition() {
        return new SimpleGfxGridPosition(this);
    }

    /**
     * @see Grid#makeGridPosition(int, int)
     */
    @Override
    public GridPosition makeGridPosition(int col, int row) {
        return new SimpleGfxGridPosition(col, row, this);
    }

    /**
     * Auxiliary method to compute the y value that corresponds to a specific row
     * @param row index
     * @return y pixel value
     */
    public int rowToY(int row) {
        return PADDING + cellSize * row;
    }

    /**
     * Auxiliary method to compute the x value that corresponds to a specific column
     * @param column index
     * @return x pixel value
     */
    public int columnToX(int column) {
        return PADDING + cellSize * column;
    }

}
