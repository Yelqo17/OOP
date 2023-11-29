package com.github.yelqo17.shapes;

import java.util.List;

public class Cylinder extends Figure {
    private static final int MAX_SIZE = 3;
    private static final int DEGREE_BY_FORMULA = 2;
    private static final int A = 0;
    private static final int B = 1;
    private static final int C = 2;
    public Cylinder(List<Point> points) {
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

            int dx1 = p2.getX() - p1.getX();
            int dy1 = p2.getY() - p1.getY();
            int dz1 = p2.getZ() - p1.getZ();
            int dx2 = p3.getX() - p1.getX();
            int dy2 = p3.getY() - p1.getY();
            int dz2 = p3.getZ() - p1.getZ();

            if (dx1 * dx2 + dy1 * dy2 + dz1 * dz2 == 0) {
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
        double radius = calculateDistance(points.get(A), points.get(C));
        double height = calculateDistance(points.get(A), points.get(B));

        double baseArea = DEGREE_BY_FORMULA * Math.PI * Math.pow(radius, DEGREE_BY_FORMULA);
        double lateralSurfaceArea = 2 * Math.PI * radius * height;

        return baseArea + lateralSurfaceArea;
    }
}