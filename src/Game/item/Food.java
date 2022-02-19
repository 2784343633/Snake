package Game.item;

import Game.imgSrc.Img;
import Game.tool.Point;

import java.util.Date;
import java.util.Random;

public class Food {
    public final static int A = 50;
    public final static int B = 28;
    private Point location;

    public Food(Snake snake, Wall wall) {
        int a;
        int b;
        Point point;
        do {
            a = this.getRandomInt(A);
            b = this.getRandomInt(B);
            point = new Point(a * Img.SIZE, b * Img.SIZE);
        } while (snake.getHead().equals(point) || snake.getTail().equals(point) || snake.getBodyPoints().contains(point) || wall.getWallPoints().contains(point));
        location = point;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public int getRandomInt(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }
}
