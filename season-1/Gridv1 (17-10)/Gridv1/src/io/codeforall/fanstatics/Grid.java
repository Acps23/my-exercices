package io.codeforall.fanstatics;

public class Grid {
    private int cols;
    private int rows;

    private Cell[][] cells;

    public Grid(int cols, int rows){
        this.cols = cols;
        this.rows = rows;
        showGrid();
    }

    public void showGrid(){
        cells = new Cell[cols][rows];

        for(int col = 0; col < cols; cols++){
            for(int row=0; row< rows; rows++){
                cells[cols][rows] = new Cell(col, row);
            }
        }
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }
}
