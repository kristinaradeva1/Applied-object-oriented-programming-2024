package geometry;

import javafx.scene.layout.Pane;

public class Rectangle extends Point {
    private Point lPoint; //lower right corner

    public Rectangle(int[] coords, Point lPoint) {
        super(coords);
        this.lPoint = lPoint;
    }

    public Rectangle() {
        this(new int[] {0,0}, new Point(new int[] {5,5}));
    }

    public Rectangle(Rectangle r) {
        this(r.getCoords(), r.getlPoint());
    }

    public Point getlPoint() {
        return new Point(lPoint);
    }

    public void setlPoint(Point lPoint) {
        if(lPoint != null) {
            this.lPoint = new Point(lPoint);
        } else {
            this.lPoint = new Point();
        }
    }

    public double measure() {
        int[] uCoords = this.getCoords();
        int[] lCoords = lPoint.getCoords();

        int width = Math.abs(uCoords[0] - lCoords[0]);
        int height = Math.abs(uCoords[1] - lCoords[1]);

        return 2*(width + height);
    }

    public void draw(Pane pane) {
        int[] uCoords = this.getCoords();
        int[] lCoords = lPoint.getCoords();

        int width = lCoords[0] - uCoords[0];
        int height = lCoords[1] - lCoords[1];
        javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle(uCoords[0],uCoords[1], width, height);
        
    }
}
