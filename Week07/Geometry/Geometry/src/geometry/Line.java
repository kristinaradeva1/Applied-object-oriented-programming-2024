package geometry;

import javafx.scene.Group;

public class Line {
    private Point sPoint; //start point
    private Point ePoint; //end point

    public Line(Point sPoint, Point ePoint) {
        setePoint(ePoint);
        setsPoint(sPoint);
    }

    public Line() {
        this(new Point(), new Point(new double[]{10, 0}));

    }

    public Line(Line line) {
        this(line.getsPoint(), line.getePoint());
    }
    public Point getsPoint() {
        return new Point(sPoint);
    }

    public void setsPoint(Point sPoint) {
        if(sPoint != null) {
            this.sPoint = new Point(sPoint);
        } else {
            this.sPoint = new Point();
        }
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

    public void draw(Group pane) {
        double[] coordsS = sPoint.getCoords();
        double[] coordsE = ePoint.getCoords();
        javafx.scene.shape.Line lineFX = new javafx.scene.shape.Line(
                coordsS[0], coordsS[1],
                coordsE[0], coordsE[0]
        );
        pane.getChildren().add(lineFX);
    }

    @Override
    public String toString() {
        return String.format("Start point %s, End point %s", sPoint, ePoint);
    }
}
