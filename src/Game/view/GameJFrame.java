package Game.view;

import javax.swing.*;
import java.awt.*;

public class GameJFrame extends JFrame {
    public final static int Width = 1000;
    public final static int Height = 545;
    public static mainPanel mPanel;
    public static infoPanel iPanel;
    public GameJFrame(String title) {
        super(title);
        mPanel = new mainPanel();
        mPanel.initPanel();
        iPanel = new infoPanel();
        iPanel.initPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(0, 0, Width, Height);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addKeyListener(mPanel);
        this.getContentPane().add(mPanel);
        this.getContentPane().add(iPanel);
        this.getContentPane().setBackground(Color.ORANGE);
    }

    public static void main(String[] args) {
        GameJFrame gJFrame = new GameJFrame("SnakeGame");
        Timer mainTimer = new Timer(mPanel.getDelay(), mPanel);
        Timer infoTimer = new Timer(mPanel.getDelay(), iPanel);
        mainTimer.setRepeats(false);
        infoTimer.setRepeats(false);
        while (true) {
            mainTimer.setDelay(mPanel.getDelay());
            iPanel.getInfo(mPanel.snake, mPanel);
            infoTimer.setDelay(mPanel.getDelay());
            mainTimer.start();
            infoTimer.start();
            while (mainTimer.isRunning() || infoTimer.isRunning()) {
                ;
            }
            mainTimer.stop();
            infoTimer.stop();
        }
    }
}
