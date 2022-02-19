package Game.item;

import Game.imgSrc.Img;
import Game.tool.Point;

import java.util.ArrayList;

public class Wall {
    public final static int L1 = 11;
    private ArrayList<Point> wallPoints;

    public Wall(int level) {
        this.wallPoints = new ArrayList<>();
        switch (level) {
            case L1: {
                for (int i = 15; i < 35; i++) {
                    this.wallPoints.add(new Point(i * Img.SIZE, 9 * Img.SIZE));
                    this.wallPoints.add(new Point(i * Img.SIZE, 19 * Img.SIZE));
                }
                break;
            }
            default:
                throw new IllegalArgumentException("Unexpected value: " + level);
        }
    }

    public ArrayList<Point> getWallPoints() {
        return wallPoints;
    }
}
