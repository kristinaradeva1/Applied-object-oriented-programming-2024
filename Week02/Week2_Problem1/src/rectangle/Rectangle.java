package rectangle;

public class Rectangle {
    private double height;
    private double width;
    private static String color;

    //alt+insert

    public void setHeight(double height) {
        if(height > 0) {
            this.height = height;
        } else {
            this.height = 1;
        }
    }

    public void setWidth(double width) {
        if(width > 0) {
             this.width = width;
         } else {
            this.width = 1;
    }

    }
    public Rectangle() {
        this(1, 1);
    }
    public static void setColor(String color) {
        if(color!= null) {
            Rectangle.color = color;
        } else {
            Rectangle.color = "yellow";
        }
    }

    public Rectangle(double height, double width) {
        setHeight(height);
        setWidth(width);
        this.height = height;
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public static String getColor() {
        return color;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }
}
