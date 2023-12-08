package com.github.yelqo17.shapes;

import java.util.List;

public class Triangle extends Figure {

    private static final int MAX_SIZE = 3;

    private static final double DIVIDER = 2.0;

    private static final int A = 0;
    private static final int B = 1;
    private static final int C = 2;

    public Triangle(List<Point> points) {
        super(points);
    }

    @Override
    public boolean validate() {
        if (points.size() == MAX_SIZE) {
            double AB = calculateDistance(points.get(A), points.get(B));
            double BC = calculateDistance(points.get(B), points.get(C));
            double CA = calculateDistance(points.get(C), points.get(A));

            boolean firstSide = AB + BC > CA;
            boolean secondSide = BC + CA > AB;
            boolean thirdSide = CA + AB > BC;

            boolean isValid = firstSide && secondSide && thirdSide;

            if (isValid) {
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
        Point p1 = points.get(A);
        Point p2 = points.get(B);
        Point p3 = points.get(C);
        return round(
                Math.abs((p1.getX() * (p2.getY() - p3.getY())
                        + p2.getX() * (p3.getY() - p1.getY())
                        + p3.getX() * (p1.getY() - p2.getY())
                ) / DIVIDER
        ));
    }

    @Override
    public double calculatePerimeter() {
        double AB = calculateDistance(points.get(A), points.get(B));
        double BC = calculateDistance(points.get(B), points.get(C));
        double CA = calculateDistance(points.get(C), points.get(A));
        return round(AB + BC + CA);
    }
}