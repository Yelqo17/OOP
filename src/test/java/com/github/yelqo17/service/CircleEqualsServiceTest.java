package com.github.yelqo17.service;

import com.github.yelqo17.shapes.Circle;
import com.github.yelqo17.shapes.Point;

import java.util.ArrayList;
import java.util.List;

public class CircleEqualsServiceTest {
    private static final List<Point> points = new ArrayList<>();
    private static final Circle circle = new Circle(points);

    public static void main(String[] args) {
        points.add(new Point(0, 0));
        points.add(new Point(0, 1));
        Point A = points.get(0);
        Point B = points.get(1);

        testEqualsArea(A, B,3.14);
        testEqualsPerimeter(A, B, 6.28);

        points.clear();
        points.add(new Point(-1, 2));
        points.add(new Point(4, 5));
        A = points.get(0);
        B = points.get(1);

        testEqualsArea(A, B,106.81);
        testEqualsPerimeter(A, B, 36.64);
    }

    private static void testEqualsArea(Point A, Point B, double expected) {
        double actual = (double) Math.round(circle.calculateArea() * 100) / 100;
        if (actual != expected) {
            throw new RuntimeException(
                    String.format(
                            "Invalid result. Actual: %s but expected: %s for %nx1 = %s, y1 = %s,%n" +
                                    "x2 = %s, y2 = %s",
                            actual,
                            expected,
                            A.getX(),
                            A.getY(),
                            B.getX(),
                            B.getY()
                    )
            );
        }
    }

    private static void testEqualsPerimeter(Point A, Point B, double expected) {
        double actual = (double) Math.round(circle.calculatePerimeter() * 100) / 100;
        if (actual != expected) {
            throw new RuntimeException(
                    String.format(
                            "Invalid result. Actual: %s but expected: %s for x1 = %s, y1 = %s, x2 = %s, y2 = %s",
                            actual,
                            expected,
                            A.getX(),
                            A.getY(),
                            B.getX(),
                            B.getY()
                    )
            );
        }
    }
}
