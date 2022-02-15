package Game.item;

import Game.imgSrc.Img;
import Game.tool.Point;

import java.util.LinkedList;

public class Snake {
    public final static int initLen = 4;
    public final static int UP = 1;
    public final static int RIGHT = 2;
    public final static int DOWN = 3;
    public final static int LEFT = 4;
    private int towards;
    private Point head;
    private boolean hasMoved;
    private int tailDirect;
    private Point tail;
    private LinkedList<Point> bodyPoints = new LinkedList<>();

    public boolean isHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public int getTailDirect() {
        return tailDirect;
    }

    public void setTailDirect(int tailDirect) {
        this.tailDirect = tailDirect;
    }

    public int getTowards() {
        return towards;
    }

    public boolean setTowards(int towards) {
        if ((towards - this.towards) % 2 == 0) {
            return false;
        } else {
            this.towards = towards;
            return true;
        }
    }

    public Point getHead() {
        return head;
    }

    public void setHead(Point head) {
        this.head = head;
    }

    public Point getTail() {
        return tail;
    }

    public void setTail(Point tail) {
        this.tail = tail;
    }

    public LinkedList<Point> getBodyPoints() {
        return bodyPoints;
    }

    public void setBodyPoints(LinkedList<Point> bodyPoints) {
        this.bodyPoints = bodyPoints;
    }

    public void init(int x, int y, int toWard) {
        this.hasMoved = false;
        this.towards = toWard;
        this.head = new Point(x, y);

        for (int i = 0; i < initLen - 2; i++) {
            Point point;
            if (this.bodyPoints.isEmpty()) {
                point = addPoint(this.head);
            } else {
                point = addPoint(this.bodyPoints.getLast());
            }
            this.bodyPoints.add(point);
        }
        this.tail = addPoint(this.bodyPoints.getLast());
    }

    public Point addPoint(Point reference) {
        Point point;
        switch (this.towards) {
            case UP: {
                point = new Point(reference.getX(), reference.getY() + Img.SIZE);
                break;
            }
            case DOWN: {
                point = new Point(reference.getX(), reference.getY() - Img.SIZE);
                break;
            }
            case LEFT: {
                point = new Point(reference.getX() + Img.SIZE, reference.getY());
                break;
            }
            case RIGHT: {
                point = new Point(reference.getX() - Img.SIZE, reference.getY());
                break;
            }
            default:
                throw new IllegalArgumentException("Unexpected Value: " + this.getTowards());
        }
        return point;
    }

    public void lengthen() {
        int x = this.head.getX();
        int y = this.head.getY();
        switch (this.towards) {
            case UP: {
                this.head.setY(y - Img.SIZE);
                break;
            }
            case DOWN: {
                this.head.setY(y + Img.SIZE);
                break;
            }
            case LEFT: {
                this.head.setX(x - Img.SIZE);
                break;
            }
            case RIGHT: {
                this.head.setX(x + Img.SIZE);
                break;
            }
            default:
                throw new IllegalArgumentException("Unexpected value: " + this.towards);
        }
        this.bodyPoints.addFirst(new Point(x, y));
    }

    public void move() {
        int x1 = this.head.getX();
        int y1 = this.head.getY();
        switch (this.towards) {
            case UP: {
                this.head.setY(y1 - Img.SIZE);
                break;
            }
            case DOWN: {
                this.head.setY(y1 + Img.SIZE);
                break;
            }
            case LEFT: {
                this.head.setX(x1 - Img.SIZE);
                break;
            }
            case RIGHT: {
                this.head.setX(x1 + Img.SIZE);
                break;
            }
            default:
                throw new IllegalArgumentException("Unexpected value: " + this.towards);
        }
        Point last = this.bodyPoints.pollLast();
        this.bodyPoints.addFirst(new Point(x1, y1));
        assert last != null;
        x1 = last.getX();
        y1 = last.getY();
        this.tail.update(x1, y1);

        int x2 = this.bodyPoints.getLast().getX();
        int y2 = this.bodyPoints.getLast().getY();

        if (x1 == x2 && y1 > y2) {
            this.tailDirect = UP;
        } else if (x1 == x2 && y1 < y2) {
            this.tailDirect = DOWN;
        } else if (y1 == y2 && x1 > x2) {
            this.tailDirect = LEFT;
        } else if (y1 == y2 && x1 < x2) {
            this.tailDirect = RIGHT;
        }
        this.hasMoved = true;
    }
}
