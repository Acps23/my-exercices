package io.codeforall.fanstatics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Pointer {
    private Rectangle rectangle;

    public Pointer() {
        rectangle = new Rectangle(0, 0, 20, 20);
        rectangle.fill();
        rectangle.setColor(Color.PINK);
    }
}
