package com.github.yelqo17.service;

import com.github.yelqo17.shapes.Polygon;
import com.github.yelqo17.shapes.Point;

import java.util.ArrayList;
import java.util.List;

public class PolygonEqualsServiceTest {
    private static final List<Point> points = new ArrayList<>();
    private static final Polygon polygon = new Polygon(points);

    public static void main(String[] args) {
        points.add(new Point(5, 7));
        points.add(new Point(9, 7));
        points.add(new Point(10, 2));
        points.add(new Point(6, 1));
        points.add(new Point(2, 2));

        Point A = points.get(0);
        Point B = points.get(1);
        Point C = points.get(2);
        Point D = points.get(3);
        Point E = points.get(4);


        testEqualsArea(A, B, C, D, E, 34);
        testEqualsPerimeter(A, B, C, D, E, 23.18);

        points.clear();
        points.add(new Point(5, 7));
        points.add(new Point(1, 1));
        points.add(new Point(-4, 2));
        points.add(new Point(-1, -4));
        points.add(new Point(4, -3));

        A = points.get(0);
        B = points.get(1);
        C = points.get(2);
        D = points.get(3);
        E = points.get(4);


        testEqualsArea(A, B, C, D, E, 42);
        testEqualsPerimeter(A, B, C, D, E, 34.17);
    }

    private static void testEqualsArea(Point A, Point B, Point C, Point D, Point E, double expected) {
        double actual = (double) Math.round(polygon.calculateArea() * 100) / 100;
        if (actual != expected) {
            throw new RuntimeException(
                    String.format(
                            "Invalid result. Actual: %s but expected: %s for %nx1 = %s, y1 = %s,%n" +
                                    "x2 = %s, y2 = %s,%n" +
                                    "x3 = %s, y3 = %s,%n" +
                                    "x4 = %s, y4 = %s,%n" +
                                    "x5 = %s, y5 = %s.",
                            actual,
                            expected,
                            A.getX(),
                            A.getY(),
                            B.getX(),
                            B.getY(),
                            C.getX(),
                            C.getY(),
                            D.getX(),
                            D.getY(),
                            E.getX(),
                            E.getY()
                    )
            );
        }
    }

    private static void testEqualsPerimeter(Point A, Point B, Point C, Point D, Point E, double expected) {
        double actual = (double) Math.round(polygon.calculatePerimeter() * 100) / 100;
        if (actual != expected) {
            throw new RuntimeException(
                    String.format(
                            "Invalid result. Actual: %s but expected: %s for %nx1 = %s, y1 = %s,%n" +
                                    "x2 = %s, y2 = %s,%n" +
                                    "x3 = %s, y3 = %s,%n" +
                                    "x4 = %s, y4 = %s,%n" +
                                    "x5 = %s, y5 = %s.",
                            actual,
                            expected,
                            A.getX(),
                            A.getY(),
                            B.getX(),
                            B.getY(),
                            C.getX(),
                            C.getY(),
                            D.getX(),
                            D.getY(),
                            E.getX(),
                            E.getY()
                    )
            );
        }
    }
}
