package Game.view;

import Game.item.Snake;

import javax.swing.*;
import java.awt.*;

public class GameJFrame extends JFrame {
    public final static int Width = 1000;
    public final static int Height = 545;
    public static mainPanel mPanel;

    public GameJFrame(String title) {
        super(title);
        mPanel = new mainPanel();
        mPanel.initPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(0, 0, Width, Height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addKeyListener(mPanel);
        this.getContentPane().add(mPanel);
        this.getContentPane().setBackground(Color.ORANGE);
    }

    public static void main(String[] args) {
        GameJFrame gJFrame = new GameJFrame("SnakeGame");
        Timer mainTimer = new Timer(200, mPanel);
        mainTimer.start();
    }
}
