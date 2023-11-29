package com.github.yelqo17.service;

import com.github.yelqo17.shapes.Point;
import com.github.yelqo17.shapes.TruncatedSphere;

import java.util.ArrayList;
import java.util.List;

public class TruncatedSphereEqualsService {
    private static final List<Point> points = new ArrayList<>();
    private static final TruncatedSphere truncatedSphere = new TruncatedSphere(points);

    public static void main(String[] args) {
        points.add(new Point(0, 0, 0));
        points.add(new Point(10, 0, 0));
        points.add(new Point(0, 0, 10));
        Point A = points.get(0);
        Point B = points.get(1);
        Point C = points.get(2);

        testEqualsArea(A, B, C, 942.48);

        points.clear();
        points.add(new Point(0, 0, 0));
        points.add(new Point(0, 2, 0));
        points.add(new Point(0, 0, -4));
        A = points.get(0);
        B = points.get(1);
        C = points.get(2);

        testEqualsArea(A, B, C, 50.27);
    }

    private static void testEqualsArea(Point A, Point B, Point C, double expected) {
        double actual = (double) Math.round(truncatedSphere.calculateArea() * 100) / 100;
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
