package com.github.yelqo17.service;

import com.github.yelqo17.shapes.Cone;
import com.github.yelqo17.shapes.Point;

import java.util.ArrayList;
import java.util.List;

public class ConeEqualsServiceTest {
    private static final List<Point> points = new ArrayList<>();
    private static final Cone cone = new Cone(points);

    public static void main(String[] args) {
        points.add(new Point(0, 0, 0));
        points.add(new Point(1, 0, 0));
        points.add(new Point(0, 0, 2));
        Point A = points.get(0);
        Point B = points.get(1);
        Point C = points.get(2);

        testEqualsArea(A, B, C, 12.57);

        points.clear();
        points.add(new Point(-1, -1, -1));
        points.add(new Point(-3, -1, -1));
        points.add(new Point(-2, -1, -5));
        A = points.get(0);
        B = points.get(1);
        C = points.get(2);

        testEqualsArea(A, B, C, 51.04);
    }

    private static void testEqualsArea(Point A, Point B, Point C, double expected) {
        double actual = (double) Math.round(cone.calculateArea() * 100) / 100;
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
