package com.github.yelqo17.shapes;

import java.util.List;

public class Sphere extends Figure {
    static final int MAX_SIZE = 2;
    static final int DEGREE_BY_FORMULA = 2;
    static final int CONST_BY_FORMULA = 4;
    private static final int A = 0;
    private static final int B = 1;
    public Sphere(List<Point> points) {
        super(points);
    }

    @Override
    public boolean validate() {
        if (points.size() == MAX_SIZE) {
            Point p1 = points.get(A);
            Point p2 = points.get(B);

            if (p1.equals(p2)) {
                printInvalid();
                return false;
            }

            printValid();
            return true;
        } else {
            printInvalid();
            return false;
        }
    }

    @Override
    public double calculateArea() {
        double radius = calculateDistance(points.get(A), points.get(B));
        return CONST_BY_FORMULA * Math.PI * Math.pow(radius, DEGREE_BY_FORMULA);
    }
}
