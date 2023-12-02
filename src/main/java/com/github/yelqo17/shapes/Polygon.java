package com.github.yelqo17.shapes;

import java.util.List;

public class Polygon extends Figure {
    private static final int MIN_SIZE = 3;
    private static final double DIVIDER = 2.0;
    public Polygon(List<Point> points) {
        super(points);
    }

    @Override
    public boolean validate() {
        if (points.size() < MIN_SIZE) {
            printInvalid();
            return false;
        }

        if (arePointsCollinear()) {
            printInvalid();
            return false;
        }

        printValid();
        return true;
    }

    @Override
    public double calculateArea() {
        int n = points.size();
        double area = 0;

        for (int i = 0; i < n; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % n);
            area += (p1.getX() * p2.getY() - p1.getY() * p2.getX());
        }

        area = Math.abs(area) / DIVIDER;

        return round(area);
    }

    @Override
    public double calculatePerimeter() {
        int n = points.size();
        double perimeter = 0;

        for (int i = 0; i < n; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % n);
            perimeter += calculateDistance(p1, p2);
        }

        return round(perimeter);
    }

    private boolean arePointsCollinear() {
        int n = points.size();

        for (int i = 0; i < n; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % n);
            Point p3 = points.get((i + 2) % n);

            int crossProduct = (p2.getX() - p1.getX()) * (p3.getY() - p1.getY())
                    - (p2.getY() - p1.getY()) * (p3.getX() - p1.getX());

            if (crossProduct != 0) {
                return false;
            }
        }

        return true;
    }
}
