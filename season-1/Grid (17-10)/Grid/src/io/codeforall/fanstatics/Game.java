package io.codeforall.fanstatics;

import io.codeforall.fanstatics.gfx.simplegfx.SimpleGfxGrid;
import io.codeforall.fanstatics.grid.Grid;
import io.codeforall.fanstatics.grid.GridFactory;
import io.codeforall.fanstatics.grid.position.GridType;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class Game {

    private Grid grid;
    private int delay;

    public Point point;


    public Game(GridType gridType, int cols, int rows, int delay) {
        grid = GridFactory.makeGrid(gridType, cols, rows);
        this.delay = delay;
    }

    public void init() {

        boolean keyboardSupport = grid instanceof SimpleGfxGrid;

        grid.init();

        if (keyboardSupport) {
            Point point = new Point() {

            };
        }
    }




}

