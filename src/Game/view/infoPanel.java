package Game.view;

import Game.item.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class infoPanel extends JPanel implements ActionListener {
    public final static int Height = 448;
    public final static int Width = 125;

    private int score;
    private int length;
    private int delay;

    public void initPanel() {
        this.setBackground(Color.LIGHT_GRAY);
        this.setDoubleBuffered(true);
        this.setBounds(830, 30, Width, Height);
        this.setVisible(true);
    }

    public void getInfo(Snake snake, mainPanel mPanel) {
        this.length = snake.getLen();
        this.score = snake.getScore();
        this.delay = mPanel.getDelay();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.pink);
        g.setFont(new Font("微软雅黑", Font.BOLD, 16));
        g.drawString("Score: " + this.score, 16, 30);
        g.drawString("Length: " + this.length, 16, 60);
        g.drawString("Speed: " + (30 - this.delay / 10), 16, 90);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
    }
}
