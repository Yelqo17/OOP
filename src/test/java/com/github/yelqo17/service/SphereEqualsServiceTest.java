package com.github.yelqo17.service;

import com.github.yelqo17.shapes.Point;
import com.github.yelqo17.shapes.Sphere;

import java.util.ArrayList;
import java.util.List;

public class SphereEqualsServiceTest {
    private static final List<Point> points = new ArrayList<>();
    private static final Sphere sphere = new Sphere(points);

    public static void main(String[] args) {
        points.add(new Point(0, 0, 0));
        points.add(new Point(0, 0, 1));
        Point A = points.get(0);
        Point B = points.get(1);

        testEqualsArea(A, B, 12.57);

        points.clear();
        points.add(new Point(2, 3, 4));
        points.add(new Point(5, 3, 4));
        A = points.get(0);
        B = points.get(1);

        testEqualsArea(A, B, 113.1);
    }

    private static void testEqualsArea(Point A, Point B, double expected) {
        double actual = (double) Math.round(sphere.calculateArea() * 100) / 100;
        if (actual != expected) {
            throw new RuntimeException(
                    String.format(
                            "Invalid result. Actual: %s but expected: %s for %nx1 = %s, y1 = %s, z1 = %s,%n" +
                                    "x2 = %s, y2 = %s, z2 = %s.",
                            actual,
                            expected,
                            A.getX(),
                            A.getY(),
                            A.getZ(),
                            B.getX(),
                            B.getY(),
                            B.getZ()
                    )
            );
        }
    }
}
