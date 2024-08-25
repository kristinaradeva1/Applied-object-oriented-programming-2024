package com.geometry.types;

public class Point implements Comparable{
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0,0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%d; %d)", x, y);
    }

    @Override
    public int compareTo(Object o) {
        if(o == null) return 1;
        if(!(o instanceof Point)) return 1;
        Point p = (Point) o;
        int dx = this.x - p.x;
        if(dx != 0) return dx;
        return this.y - p.y;
    }
}