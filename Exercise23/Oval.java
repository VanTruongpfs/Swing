package Exercise23;

import java.awt.*;

public class Oval extends Shape {
    public Oval(int x, int y, Color color, boolean isFilled, int width, int height) {
        super(x, y, color, isFilled, width, height);
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        if(this.isFilled==true){
            g.fillOval(x, y, width, height);
        }else{
            g.drawOval(x, y, width, height);
        }
    }
}
