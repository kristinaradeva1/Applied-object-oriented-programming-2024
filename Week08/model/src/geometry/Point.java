package geometry;

import java.util.Arrays;

public class Point {
    private int[] coords;

    public Point(int[] coords) {
        setCoords(coords);
    }

    public Point() {
        this(new int[2]);
    }

    public Point(Point p) {
        this(p.getCoords());
    }

    public int[] getCoords() {
        int[] copy = new int[coords.length];
        for(int i = 0; i < copy.length; i++){
            copy[i] = coords[i];
        }
        return coords;
    }

    public void setCoords(int[] coords) {
        if(coords != null && coords.length == 2) {
            this.coords = new int[coords.length];
            for(int i = 0; i < coords.length; i++) {
                if(coords[i] < 0) {
                    this.coords[i] = -coords[i];
                } else {
                    this.coords[i] = coords[i];
                }
            }
        } else {
            this.coords = new int[2];
        }
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", coords[0], coords[1]);
    }
}
