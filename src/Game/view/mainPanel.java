package Game.view;

import javax.swing.*;

import Game.item.Food;
import Game.item.Snake;
import Game.tool.Point;
import Game.imgSrc.Img;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class mainPanel extends JPanel implements ActionListener, KeyListener {
    public final static int Width = 800;
    public final static int Height = 448;
    public final static int Start = 5;
    public final static int Pause = 6;
    public final static int Over = 7;
    public Snake snake;
    public Food food;
    private int state = Start;

    public void initPanel() {
        this.snake = new Snake();
        this.snake.init(400, 224, Snake.RIGHT);
        this.food = new Food(this.snake);
        this.setBackground(new Color(122, 115, 116));
        this.setDoubleBuffered(true);
        this.setBounds(30, 30, Width, Height);
        this.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (snake.getTowards()) {
            case Snake.UP: {
                g.drawImage(Img.head_u, Math.floorMod(snake.getHead().getX(), Width), Math.floorMod(snake.getHead().getY(), Height), Img.SIZE, Img.SIZE, this);
                break;
            }
            case Snake.DOWN: {
                g.drawImage(Img.head_d, Math.floorMod(snake.getHead().getX(), Width), Math.floorMod(snake.getHead().getY(), Height), Img.SIZE, Img.SIZE, this);
                break;
            }
            case Snake.RIGHT: {
                g.drawImage(Img.head_r, Math.floorMod(snake.getHead().getX(), Width), Math.floorMod(snake.getHead().getY(), Height), Img.SIZE, Img.SIZE, this);
                break;
            }
            case Snake.LEFT: {
                g.drawImage(Img.head_l, Math.floorMod(snake.getHead().getX(), Width), Math.floorMod(snake.getHead().getY(), Height), Img.SIZE, Img.SIZE, this);
                break;
            }
            default:
                throw new IllegalArgumentException("Unexpected value: " + snake.getTowards());
        }

        for (Point point : snake.getBodyPoints()) {
            g.drawImage(Img.body, Math.floorMod(point.getX(), Width), Math.floorMod(point.getY(), Height), Img.SIZE, Img.SIZE, this);
        }
        switch (snake.isHasMoved() ? snake.getTailDirect() : snake.getTowards()) {
            case Snake.UP: {
                g.drawImage(Img.tail_u, Math.floorMod(snake.getTail().getX(), Width), Math.floorMod(snake.getTail().getY(), Height), Img.SIZE, Img.SIZE, this);
                break;
            }
            case Snake.DOWN: {
                g.drawImage(Img.tail_d, Math.floorMod(snake.getTail().getX(), Width), Math.floorMod(snake.getTail().getY(), Height), Img.SIZE, Img.SIZE, this);
                break;
            }
            case Snake.RIGHT: {
                g.drawImage(Img.tail_r, Math.floorMod(snake.getTail().getX(), Width), Math.floorMod(snake.getTail().getY(), Height), Img.SIZE, Img.SIZE, this);
                break;
            }
            case Snake.LEFT: {
                g.drawImage(Img.tail_l, Math.floorMod(snake.getTail().getX(), Width), Math.floorMod(snake.getTail().getY(), Height), Img.SIZE, Img.SIZE, this);
                break;
            }
            default:
                throw new IllegalArgumentException("Unexpected value: " + snake.getTailDirect());
        }
        g.drawImage(Img.food, food.getLocation().getX(), food.getLocation().getY(), Img.SIZE, Img.SIZE, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (this.state) {
            case Start: {
                this.snake.move();
                if (this.snake.getHead().equals(this.food.getLocation())) {
                    this.snake.lengthen();
                    this.food = new Food(this.snake);
                } else if (this.snake.getTail().equals(this.snake.getHead()) || this.snake.getBodyPoints().contains(this.snake.getHead())) {
                    this.state = Over;
                }
                this.repaint();
                break;
            }
            case Pause: {
                ;
            }
            case Over: {
                ;
            }
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W: {
                snake.setTowards(Snake.UP);
                break;
            }
            case KeyEvent.VK_S: {
                snake.setTowards(Snake.DOWN);
                break;
            }
            case KeyEvent.VK_A: {
                snake.setTowards(Snake.LEFT);
                break;
            }
            case KeyEvent.VK_D: {
                snake.setTowards(Snake.RIGHT);
                break;
            }
            case KeyEvent.VK_SPACE: {
                if (this.state == Start) {
                    this.state = Pause;
                } else if (this.state == Pause) {
                    this.state = Start;
                }
                break;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        ;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        ;
    }
}
