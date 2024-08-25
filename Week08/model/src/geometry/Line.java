package geometry;

import javafx.scene.layout.Pane;

public class Line extends Point{
    private Point ePoint;

    public Line(int[] coords, Point ePoint) {
        super(coords);
        setePoint(ePoint);
    }

    public Line(Point p, Point ePoint) {
        super(p);
        this.ePoint = ePoint;
    }

    public Line() {
        this(new int[2], new Point(new int[] {1, 1}));
    }

    public Line(Line l) {
        this(l.getCoords(), l.getePoint());
    }

    public Point getePoint() {
        return new Point(ePoint);
    }

    public void setePoint(Point ePoint) {
       if(ePoint != null) {
           this.ePoint = new Point(ePoint);
       } else {
           this.ePoint = new Point();
       }
    }

    public double measure() {
        int[] sCoords = this.getCoords();
        int[] eCoords = ePoint.getCoords();

        int dx = eCoords[0] - sCoords[0];
        int dy = eCoords[1] - sCoords[1];
        double length = Math.sqrt(dx*dx + dy*dy);
        return length;
    }

    public void draw(Pane pane) {
        int[] sCoords = this.getCoords();
        int[] eCoords = ePoint.getCoords();

        javafx.scene.shape.Line line = new javafx.scene.shape.Line(sCoords[0], sCoords[1], eCoords[0], eCoords[1]);
        pane.getChildren().add(line);
    }

    @Override
    public String toString() {
        return String.format("Line sPoint coords %s, " + "ePoint coords %s", super.toString(), ePoint.toString());
    }
}
