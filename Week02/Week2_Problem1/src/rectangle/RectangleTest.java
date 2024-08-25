package rectangle;

import java.util.Scanner;

public class RectangleTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double width;
        double height;
        String color;
        System.out.print("Enter width: ");
        width = input.nextDouble();
        System.out.print("Enter height: ");
        height = input.nextDouble();
        System.out.print("Enter color: ");
        color = input.next();

        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(height, width);
        r2.setColor(color);

        System.out.println("r2 area: " + r2.getArea());
        System.out.println("r1 perimeter" + r1.getPerimeter());
        System.out.println("color: " + r1.getColor());

    }
}
