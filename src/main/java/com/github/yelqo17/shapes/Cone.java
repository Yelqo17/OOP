package com.github.yelqo17.shapes;

import java.util.List;

public class Cone extends Figure {
    private static final int MAX_SIZE = 3;
    private static final int DEGREE_BY_FORMULA = 2;
    private static final int A = 0;
    private static final int B = 1;
    private static final int C = 2;
    public Cone(List<Point> points) {
        super(points);
    }

    @Override
    public boolean validate() {
        if (points.size() == MAX_SIZE) {
            Point p1 = points.get(A);
            Point p2 = points.get(B);
            Point p3 = points.get(C);

            if (p1.getX() == p2.getX() && p1.getY() == p2.getY() && p1.getZ() == p2.getZ()
                    || p1.getX() == p3.getX() && p1.getY() == p3.getY() && p1.getZ() == p3.getZ()
                    || p2.getX() == p3.getX() && p2.getY() == p3.getY() && p2.getZ() == p3.getZ()) {
                printInvalid();
                return false;
            }

            if (p1.getZ() != 0 || p2.getZ() != 0 || p3.getZ() != 0) {
                printValid();
                return true;
            } else {
                printInvalid();
            }
        } else {
            printInvalid();
        }
        return false;
    }

    @Override
    public double calculateArea() {
        double radius = calculateDistance(points.get(A), points.get(B));
        double slantHeight = calculateDistance(points.get(A), points.get(C));
        double lateralSurfaceArea = Math.PI * radius * (radius + slantHeight);
        double baseArea = Math.PI * Math.pow(radius, DEGREE_BY_FORMULA);
        return round(lateralSurfaceArea + baseArea);
    }
}