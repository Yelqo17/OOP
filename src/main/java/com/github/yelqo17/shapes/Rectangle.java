package com.github.yelqo17.shapes;

import java.util.List;

public class Rectangle extends Figure {
    private static final int MAX_SIZE = 4;
    private static final int DEGREE_BY_FORMULA = 2;
    private static final int A = 0;
    private static final int B = 1;
    private static final int C = 2;
    public Rectangle(List<Point> points) {
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
            for (int i = 0; i < MAX_SIZE; i++) {
                if (distances[i] != distances[(i + 2) % MAX_SIZE] || distances[i] == distances[(i + 1) % MAX_SIZE] ) {
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
        double length = calculateDistance(points.get(A), points.get(B));
        double width = calculateDistance(points.get(B), points.get(C));
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        double[] distances = new double[MAX_SIZE];

        for (int i = 0; i < MAX_SIZE; i++) {
            distances[i] = calculateDistance(points.get(i), points.get((i + 1) % MAX_SIZE));
        }

        return DEGREE_BY_FORMULA * (distances[A] + distances[B]);
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
