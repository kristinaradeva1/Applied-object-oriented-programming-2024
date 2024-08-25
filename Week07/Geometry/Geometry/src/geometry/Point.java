package geometry;

public class Point {
    private double[] coords;

    public Point(double[] coords) {
        this.coords = coords;
    }

    public Point() {
        this(new double[2]); //new double[]{0, 0}
    }

    public double[] getCoords() {
        double[] copy = new double[coords.length];
        for(int i = 0; i < copy.length; i++) {
            copy[i] = coords[i];
        }
        return copy;
    }

    public void setCoords(double[] coords) {
        if(coords != null && coords.length == 2) {
            this.coords = new double[coords.length];
            for(int i = 0; i < coords.length; i++) {
                this.coords[i] = coords[i];
                //validation coords[i]
            }
        }
        else {
            this.coords = new double[2]; //0,0
        }
    }

    public Point(Point point) {
        this(point.getCoords());
    }

    @java.lang.Override
    public java.lang.String toString() {
       return String.format("(%.2f; %.2f)", coords[0], coords[1]);
    }
}
