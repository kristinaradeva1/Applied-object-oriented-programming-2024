package com.geometry.utils;

import com.geometry.types.Circle;
import com.geometry.types.Cylinder;
import com.geometry.types.Point;
import com.geometry.types.*;
import java.util.Arrays;
import java.util.Random;

public class SelectionSortTest {
    private static Comparable[] arrComparable =
            new Comparable[9];

    public static void main(String[] args) {
        Random rand = new Random();
        for(int i = 0; i < 3; i++) {
            arrComparable[i] = new Point(rand.nextInt(10, 51),
                    rand.nextInt(10, 51));
        }

        for(int i = 3; i < 6; i++) {
            Point p = (Point) arrComparable[i - 3];
            arrComparable[i] = new Circle(
                    p.getX(), p.getY(),
                    rand.nextInt(10, 31)
            );
        }

        for(int i = 6; i < 9; i++) {
            Circle c = (Circle) arrComparable[i - 3];
            arrComparable[i] = new Cylinder(c.getX(), c.getY(),
                    c.getRadius(),
                    rand.nextInt(10, 61)); // ?
        }

        System.out.println("Unsorted Array: ");
        System.out.println(Arrays.toString(arrComparable));

        SelectionSort.sortArray(arrComparable);
        System.out.println("Sorted Array: ");
        System.out.println(Arrays.toString(arrComparable));
//        for(var el : arrComparable) {
//            System.out.println(el);
//        }
    }
}
