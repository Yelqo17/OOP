package com.github.yelqo17.service;

import com.github.yelqo17.shapes.Point;
import com.github.yelqo17.shapes.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class RectangleEqualsServiceTest {
    private static final List<Point> points = new ArrayList<>();
    private static final Rectangle rectangle = new Rectangle(points);

    public static void main(String[] args) {
        points.add(new Point(0, 0));
        points.add(new Point(0, 7));
        points.add(new Point(3, 7));
        points.add(new Point(3, 0));

        Point A = points.get(0);
        Point B = points.get(1);
        Point C = points.get(2);
        Point D = points.get(3);


        testEqualsArea(A, B, C, D, 21);
        testEqualsPerimeter(A, B, C, D, 20);

        points.clear();
        points.add(new Point(5, 3));
        points.add(new Point(-2, 3));
        points.add(new Point(-2, -2));
        points.add(new Point(5, -2));

        A = points.get(0);
        B = points.get(1);
        C = points.get(2);
        D = points.get(3);

        testEqualsArea(A, B, C, D, 35);
        testEqualsPerimeter(A, B, C, D, 24);
    }

    private static void testEqualsArea(Point A, Point B, Point C, Point D, double expected) {
        double actual = (double) Math.round(rectangle.calculateArea() * 100) / 100;
        if (actual != expected) {
            throw new RuntimeException(
                    String.format(
                            "Invalid result. Actual: %s but expected: %s for %nx1 = %s, y1 = %s,%n" +
                                    "x2 = %s, y2 = %s,%n" +
                                    "x3 = %s, y3 = %s,%n" +
                                    "x4 = %s, y4 = %s.",
                            actual,
                            expected,
                            A.getX(),
                            A.getY(),
                            B.getX(),
                            B.getY(),
                            C.getX(),
                            C.getY(),
                            D.getX(),
                            D.getY()
                    )
            );
        }
    }

    private static void testEqualsPerimeter(Point A, Point B, Point C, Point D, double expected) {
        double actual = (double) Math.round(rectangle.calculatePerimeter() * 100) / 100;
        if (actual != expected) {
            throw new RuntimeException(
                    String.format(
                            "Invalid result. Actual: %s but expected: %s for %nx1 = %s, y1 = %s,%n" +
                                    "x2 = %s, y2 = %s,%n" +
                                    "x3 = %s, y3 = %s,%n" +
                                    "x4 = %s, y4 = %s.",
                            actual,
                            expected,
                            A.getX(),
                            A.getY(),
                            B.getX(),
                            B.getY(),
                            C.getX(),
                            C.getY(),
                            D.getX(),
                            D.getY()
                    )
            );
        }
    }
}
