package geometry;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Rectangle {
    private Point upoint; //upper left corner
    private double width;
    private double height;

    public Rectangle() {
        this(new Point(), 10, 10);
    }

    public Rectangle(Point upoint, double width, double height) {
       setUpoint(upoint);
       setHeight(height);
       setWidth(width);
    }

    public Rectangle(Rectangle rectangle) {
        this(rectangle.getUpoint(), rectangle.width, rectangle.height);
    }
    public void setUpoint(Point upoint) {
        if(upoint != null)
        {
            this.upoint = new Point(upoint);
        } else {
            this.upoint = new Point();
        }
    }

    public void setWidth(double width) {
        if(width > 0) {
            this.width = width;
        } else {
            this.width = 10;
        }
    }

    public void setHeight(double height) {
        if(height > 0) {
            this.height = height;
        } else {
            this.height = 10;
        }
    }

    public Point getUpoint() {
        return upoint;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void draw(Group pane){
        double[] coords = upoint.getCoords();
        javafx.scene.shape.Rectangle rectangleFX = new javafx.scene.shape.Rectangle(
                coords[0], coords[1], width, height
        );
        rectangleFX.setStroke(Color.BLACK);
        rectangleFX.setFill(null);

        pane.getChildren().add(rectangleFX);
    }
    @Override
    public String toString() {
        return String.format("Upper left corner %s, width: %.2f, height: %.2f", upoint.toString(),
        width, height);

    }
}
