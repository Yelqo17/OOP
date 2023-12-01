package com.github.yelqo17.shapes;

import java.util.List;

public class Square extends Figure {
    private static final int MAX_SIZE = 4;
    private static final int DEGREE_BY_FORMULA = 2;
    private static final int CONST_BY_FORMULA = 4;
    private static final int A = 0;
    private static final int B = 1;
    public Square(List<Point> points) {
        super(points);
    }

    @Override
    public boolean validate() {
        if (points.size() == MAX_SIZE) {
            double[] distances = new double[MAX_SIZE];

            for (int i = 0; i < MAX_SIZE; i++) {
                distances[i] = calculateDistance(points.get(i), points.get((i + 1) % MAX_SIZE));
            }

            boolean isValid = true;
            for (int i = 1; i < MAX_SIZE; i++) {
                if (distances[i] != distances[0]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid && areAllAngles90Degrees()) {
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
        double sideLength = calculateDistance(points.get(A), points.get(B));
        return round(Math.pow(sideLength, DEGREE_BY_FORMULA));
    }

    @Override
    public double calculatePerimeter() {
        double sideLength = calculateDistance(points.get(A), points.get(B));
        return round(CONST_BY_FORMULA * sideLength);
    }

    private boolean areAllAngles90Degrees() {
        for (int i = 0; i < MAX_SIZE; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % MAX_SIZE);
            Point p3 = points.get((i + 2) % MAX_SIZE);

            int dx1 = p2.getX() - p1.getX();
            int dy1 = p2.getY() - p1.getY();
            int dx2 = p3.getX() - p2.getX();
            int dy2 = p3.getY() - p2.getY();

            if (dx1 * dx2 + dy1 * dy2 != 0) {
                return false;
            }
        }
        return true;
    }
}