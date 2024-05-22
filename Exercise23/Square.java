package Exercise23;

import java.awt.*;

public class Square extends Shape {
    public Square(int x, int y, Color color, boolean isFilled, int width, int height) {
        super(x, y, color, isFilled, width, height);
    }
@Override
    public void draw(Graphics g) {
        g.setColor(color);
        if(this.isFilled==true){
            g.fillRect(x, y, width, height);
        }else{
            g.drawRect(x, y, width, height);
        }
    }

}
