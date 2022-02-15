package Game.tool;

import Game.view.mainPanel;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 2);
        System.out.println(p1.equals(p2));
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void update(int x, int y) {
        setX(x);
        setY(y);
    }

    public boolean equals(Object obj) {
        Point point = (Point) obj;
        return Math.floorMod(this.x, mainPanel.Width) == Math.floorMod(point.x, mainPanel.Width) && Math.floorMod(this.y, mainPanel.Height) == Math.floorMod(point.y, mainPanel.Height);
    }
}
