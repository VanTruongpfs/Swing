package Exercise23;

import com.sun.source.tree.NewArrayTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MyPanel extends JPanel {
    JButton btnRed, btnBlue, btnClear;
    JRadioButton rBSquare, rBOval, rBFill, rBLine;
    ButtonGroup grShape, grStyle;
    boolean isStart =  false;
   static  ArrayList<Shape> shapes;
    Color color;
        TopPanel pnTop = new TopPanel();
        LeftPanel pnLeft = new LeftPanel();
        DrawPanel pnDraw = new DrawPanel();
    public MyPanel() {
        setLayout(new BorderLayout());
        add(pnTop, BorderLayout.NORTH);
        add(pnLeft, BorderLayout.WEST);
        add(pnDraw, BorderLayout.CENTER);


    }


    class TopPanel extends JPanel{
        public TopPanel(){
            btnRed = new JButton("Red");
            btnBlue = new JButton("Blue");
            rBSquare = new JRadioButton("Square");
            rBOval = new JRadioButton("Oval");
            rBFill = new JRadioButton("Fill");
            rBLine = new JRadioButton("OutLine");
            grShape = new ButtonGroup();
            grStyle = new ButtonGroup();
            //Button
            btnRed.setBackground(Color.RED);
            btnBlue.setBackground(Color.BLUE);
            //RadioButton
            grShape.add(rBSquare);
            grShape.add(rBOval);
            grStyle.add(rBFill);
            grStyle.add(rBLine);
            setLayout(new FlowLayout());
            setBackground(Color.pink);
            //Event Red
            btnRed.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    System.out.println("Red");
                    color = Color.RED;
                }
            });
            add(btnRed);
            // Event Button blue
            btnBlue.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    System.out.println("Blue");
                    color = Color.BLUE;
                }});
            add(btnBlue);
            // Event RadioButton Square
            rBSquare.setSelected(true);
            rBSquare.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    System.out.println("Square");
                }
            });
            add(rBSquare);
            // Event RadioButton Square
            rBOval.setSelected(true);
            rBOval.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Oval");
                }
            });
            add(rBOval);
            // Style
            rBFill.setSelected(true);
            rBFill.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e) {
                    System.out.println("Fill");
                }
            });
            add(rBFill);
            rBLine.setSelected(true);
            rBLine.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e) {
                    System.out.println("OutLine");
                }
            });
            add(rBLine);
        }
    }
    class LeftPanel extends JPanel{
        public LeftPanel(){
            setLayout(new FlowLayout());
            setBackground(Color.pink);
            btnClear = new JButton("Clear All");
            btnClear.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    System.out.println("Clear All");
                    shapes = new ArrayList<>();
                    pnDraw.repaint();
                }
            });

            add(btnClear);
        }
    }
    class DrawPanel extends JPanel{
        public DrawPanel(){
            shapes = new ArrayList<>();
            setBackground(Color.yellow);
            // process event mouse left and right
            addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    super.mouseClicked(e);
                    if(e.getButton() == MouseEvent.BUTTON1){
                        isStart = true;
                        System.out.println("draw");
                    }else if(e.getButton() == MouseEvent.BUTTON3){
                        isStart = false;
                        System.out.println("Stop draw");
                    }
                }
            });
            // process choice;
            addMouseMotionListener(new MouseAdapter(){
                public void mouseMoved(MouseEvent e){
                    if(isStart){
                        if(rBSquare.isSelected()){
                            if(rBFill.isSelected()) {
                                shapes.add(new Square(e.getX(), e.getY(), color, true, 20, 20));
                            }else{
                                shapes.add(new Square(e.getX(), e.getY(), color, false, 20, 20));
                        }
                        }
                        if(rBOval.isSelected()){
                            if(rBFill.isSelected()) {
                                shapes.add(new Oval(e.getX(), e.getY(), color, true, 20, 20));
                            }else{
                                shapes.add(new Oval(e.getX(), e.getY(), color, false, 20, 20));
                        }
                        }
                        repaint(); // display shape
                    }
                }
            });
        }
        // draw list shape
    @Override
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            System.out.println(shapes.size());
                for(Shape s : shapes){
                    s.draw(g);
            }
    }

    }

}
