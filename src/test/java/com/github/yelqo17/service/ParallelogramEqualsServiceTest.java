package com.github.yelqo17.service;

import com.github.yelqo17.shapes.Parallelogram;
import com.github.yelqo17.shapes.Point;

import java.util.ArrayList;
import java.util.List;

public class ParallelogramEqualsServiceTest {
    private static final List<Point> points = new ArrayList<>();
    private static Parallelogram parallelogram;

    public static void main(String[] args) {
        points.add(new Point(0, 0));
        points.add(new Point(2, 0));
        points.add(new Point(3, 2));
        points.add(new Point(1, 2));
        parallelogram = new Parallelogram(points);

        Point A = points.get(0);
        Point B = points.get(1);
        Point C = points.get(2);
        Point D = points.get(3);


        testEqualsArea(A, B, C, D, 4);
        testEqualsPerimeter(A, B, C, D, 8.47);

        points.clear();
        points.add(new Point(1, 1));
        points.add(new Point(4, 1));
        points.add(new Point(5, 4));
        points.add(new Point(2, 4));
        parallelogram = new Parallelogram(points);

        A = points.get(0);
        B = points.get(1);
        C = points.get(2);
        D = points.get(3);

        testEqualsArea(A, B, C, D, 9);
        testEqualsPerimeter(A, B, C, D, 12.32);
    }

    private static void testEqualsArea(Point A, Point B, Point C, Point D, double expected) {
        double actual = (double) Math.round(parallelogram.calculateArea() * 100) / 100;
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
        double actual = (double) Math.round(parallelogram.calculatePerimeter() * 100) / 100;
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
