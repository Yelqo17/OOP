package com.github.yelqo17.shapes;

import java.util.List;

public class Circle extends Figure {
    private static final int MAX_SIZE = 2;
    private static final int DEGREE_BY_FORMULA = 2;
    private static final int A = 0;
    private static final int B = 1;

    public Circle(List<Point> points) {
        super(points);
    }

    @Override
    public boolean validate() {
        if (points.size() == MAX_SIZE) {
            Point p1 = points.get(A);
            Point p2 = points.get(B);

            if (p1.getX() == p2.getX() && p1.getY() == p2.getY()) {
                printInvalid();
                return false;
            }

            printValid();
            return true;
        } else {
            printInvalid();
        }
        return false;
    }

    @Override
    public double calculateArea() {
        double radius = calculateDistance(points.get(A), points.get(B));
        return round(Math.PI * Math.pow(radius, DEGREE_BY_FORMULA));
    }

    @Override
    public double calculatePerimeter() {
        double radius = calculateDistance(points.get(A), points.get(B));
        return round(DEGREE_BY_FORMULA * Math.PI * radius);
    }
}
