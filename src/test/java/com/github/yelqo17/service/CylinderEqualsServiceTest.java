package com.github.yelqo17.service;

import com.github.yelqo17.shapes.Cylinder;
import com.github.yelqo17.shapes.Point;

import java.util.ArrayList;
import java.util.List;

public class CylinderEqualsServiceTest {
    private static final List<Point> points = new ArrayList<>();
    private static final Cylinder cylinder = new Cylinder(points);

    public static void main(String[] args) {
        points.add(new Point(0, 0, 0));
        points.add(new Point(0, 0, 5));
        points.add(new Point(1, 1, 0));
        Point A = points.get(0);
        Point B = points.get(1);
        Point C = points.get(2);

        testEqualsArea(A, B, C, 57);

        points.clear();
        points.add(new Point(1, -2, 3));
        points.add(new Point(1, -2, 8));
        points.add(new Point(-2, 1, 3));
        A = points.get(0);
        B = points.get(1);
        C = points.get(2);

        testEqualsArea(A, B, C, 246.38);
    }

    private static void testEqualsArea(Point A, Point B, Point C, double expected) {
        double actual = (double) Math.round(cylinder.calculateArea() * 100) / 100;
        if (actual != expected) {
            throw new RuntimeException(
                    String.format(
                            "Invalid result. Actual: %s but expected: %s for %nx1 = %s, y1 = %s, z1 = %s,%n" +
                                    "x2 = %s, y2 = %s, z2 = %s,%n" +
                                    "x3 = %s, y3 = %s, z3 = %s.",
                            actual,
                            expected,
                            A.getX(),
                            A.getY(),
                            A.getZ(),
                            B.getX(),
                            B.getY(),
                            B.getZ(),
                            C.getX(),
                            C.getY(),
                            C.getZ()
                    )
            );
        }
    }
}
