package com.github.yelqo17.service;

import com.github.yelqo17.shapes.Point;
import com.github.yelqo17.shapes.Triangle;

import java.util.ArrayList;
import java.util.List;

public class TriangleEqualsServiceTest {
    private static final List<Point> points = new ArrayList<>();
    private static final Triangle triangle = new Triangle(points);

    public static void main(String[] args) {
        points.add(new Point(1, 6));
        points.add(new Point(9, 6));
        points.add(new Point(7, 9));


        Point A = points.get(0);
        Point B = points.get(1);
        Point C = points.get(2);


        testEqualsArea(A, B, C, 12);
        testEqualsPerimeter(A, B, C, 18.31);

        points.clear();
        points.add(new Point(4, 0));
        points.add(new Point(12, -2));
        points.add(new Point(5, -9));

        A = points.get(0);
        B = points.get(1);
        C = points.get(2);

        testEqualsArea(A, B, C, 35);
        testEqualsPerimeter(A, B, C, 27.2);
    }

    private static void testEqualsArea(Point A, Point B, Point C, double expected) {
        double actual = (double) Math.round(triangle.calculateArea() * 100) / 100;
        if (actual != expected) {
            throw new RuntimeException(
                    String.format(
                            "Invalid result. Actual: %s but expected: %s for %nx1 = %s, y1 = %s,%n" +
                                    "x2 = %s, y2 = %s,%n" +
                                    "x3 = %s, y3 = %s.",
                            actual,
                            expected,
                            A.getX(),
                            A.getY(),
                            B.getX(),
                            B.getY(),
                            C.getX(),
                            C.getY()
                    )
            );
        }
    }

    private static void testEqualsPerimeter(Point A, Point B, Point C, double expected) {
        double actual = (double) Math.round(triangle.calculatePerimeter() * 100) / 100;
        if (actual != expected) {
            throw new RuntimeException(
                    String.format(
                            "Invalid result. Actual: %s but expected: %s for %nx1 = %s, y1 = %s,%n" +
                                    "x2 = %s, y2 = %s,%n" +
                                    "x3 = %s, y3 = %s.",
                            actual,
                            expected,
                            A.getX(),
                            A.getY(),
                            B.getX(),
                            B.getY(),
                            C.getX(),
                            C.getY()
                    )
            );
        }
    }
}
