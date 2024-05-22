package Exercise23;

import java.awt.*;

public abstract class Shape {
     protected int x,y,width,height;
    protected Color color;
    protected boolean isFilled;
    public Shape(int x, int y, Color color, boolean isFilled, int width, int height) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.isFilled = isFilled;
        this.width = width;
        this.height = height;

    }
    public abstract void draw(Graphics g);
}
