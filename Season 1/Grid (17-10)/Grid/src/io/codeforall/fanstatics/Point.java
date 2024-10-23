package io.codeforall.fanstatics;

import io.codeforall.fanstatics.grid.Grid;
import io.codeforall.fanstatics.grid.GridColor;
import io.codeforall.fanstatics.grid.GridDirection;
import io.codeforall.fanstatics.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Point implements KeyboardHandler {
   private GridPosition pos;
    private Grid grid;
private Rectangle rectangle;
    protected GridDirection gridDirection;
    private Keyboard keyboard;

    public Point(GridPosition pos) {
        this.pos = pos;
        this.pos.setColor(GridColor.BLUE);
        gridDirection = GridDirection.values()[(int) (Math.random() * GridDirection.values().length)];
        //rectangle = new Rectangle(0,0,20,20);
        //rectangle.fill();
        initKeyboard();
    }

    private void initKeyboard() {
        this.keyboard = new Keyboard(this);

        KeyboardEvent moveRight = new KeyboardEvent();
        moveRight.setKey(KeyboardEvent.KEY_RIGHT);
        moveRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(moveRight);

        KeyboardEvent moveLeft = new KeyboardEvent();
        moveLeft.setKey(KeyboardEvent.KEY_LEFT);
        moveLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(moveLeft);

        KeyboardEvent moveUP = new KeyboardEvent();
        moveUP.setKey(KeyboardEvent.KEY_UP);
        moveUP.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(moveUP);

        KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKey(KeyboardEvent.KEY_DOWN);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(moveDown);

        KeyboardEvent clean = new KeyboardEvent();
        clean.setKey(KeyboardEvent.KEY_C);
        clean.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(clean);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(save);

        KeyboardEvent load = new KeyboardEvent();
        load.setKey(KeyboardEvent.KEY_L);
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(load);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                System.out.println("right");
                point.translate(1,0);
                break;
            case KeyboardEvent.KEY_LEFT:
                System.out.println("left");
                rectangle.translate(-1,0);
                break;
            case KeyboardEvent.KEY_DOWN:
                break;
           }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    /*public GridPosition getPos() {
    }*/


    /*public boolean isHitting() {

        switch (gridDirection) {
            case LEFT:
                if (getPos().getCol() == 0) {
                    return true;
                }
                break;
            case RIGHT:
                if (getPos().getCol() == grid.getCols() - 1) {
                    return true;
                }
                break;
            case UP:
                if (getPos().getRow() == 0) {
                    return true;
                }
                break;
            case DOWN:
                if (getPos().getRow() == grid.getRows() - 1) {
                    return true;
                }
        }

        return false;

    }*/


}
