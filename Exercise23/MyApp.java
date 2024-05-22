package Exercise23;

import javax.swing.*;

public class MyApp extends JFrame {
    public MyApp() {
        setTitle("UsingMousePaint");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel panel = new MyPanel();
        getContentPane().add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyApp();
    }
}
