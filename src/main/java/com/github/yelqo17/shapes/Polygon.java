package com.github.yelqo17.shapes;

import java.util.List;

public class Polygon extends Figure {
    static final int MIN_SIZE = 3;
    static final double DIVIDER = 2.0;
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
        double area;

        if (is3DPolygon()) {
            area = calculate3DArea();
        } else {
            area = calculate2DArea();
        }

        return area;
    }

    @Override
    public double calculatePerimeter() {
        double perimeter;

        if (is3DPolygon()) {
            perimeter = calculate3DPerimeter();
        } else {
            perimeter = calculate2DPerimeter();
        }

        return perimeter;
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

    private boolean is3DPolygon() {
        for (Point point : points) {
            if (point.getZ() != 0) {
                return true;
            }
        }
        return false;
    }

    private double calculate3DArea() {
        int n = points.size();
        double area = 0;

        Point centroid = calculateCentroid();

        for (int i = 0; i < n; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % n);
            area += calculateTriangleArea(p1, p2, centroid);
        }

        return area;
    }

    private Point calculateCentroid() {
        int n = points.size();
        int xSum = 0;
        int ySum = 0;
        int zSum = 0;

        for (Point point : points) {
            xSum += point.getX();
            ySum += point.getY();
            zSum += point.getZ();
        }

        int xCentroid = xSum / n;
        int yCentroid = ySum / n;
        int zCentroid = zSum / n;

        return new Point(xCentroid, yCentroid, zCentroid);
    }

    private double calculateTriangleArea(Point p1, Point p2, Point p3) {
        double[] vector1 = {p2.getX() - p1.getX(), p2.getY() - p1.getY(), p2.getZ() - p1.getZ()};
        double[] vector2 = {p3.getX() - p1.getX(), p3.getY() - p1.getY(), p3.getZ() - p1.getZ()};

        double vx = vector1[1] * vector2[2] - vector1[2] * vector2[1];
        double vy = vector1[2] * vector2[0] - vector1[0] * vector2[2];
        double vz = vector1[0] * vector2[1] - vector1[1] * vector2[0];

        double area = Math.sqrt(vx * vx + vy * vy + vz * vz);

        return area / DIVIDER;
    }

    private double calculate2DArea() {
        int n = points.size();
        double area = 0;

        for (int i = 0; i < n; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % n);
            area += (p1.getX() * p2.getY() - p1.getY() * p2.getX());
        }

        area = Math.abs(area) / DIVIDER;
        return area;
    }

    private double calculate3DPerimeter() {
        int n = points.size();
        double perimeter = 0;

        for (int i = 0; i < n; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % n);
            perimeter += calculateDistance(p1, p2);
        }

        return perimeter;
    }

    private double calculate2DPerimeter() {
        int n = points.size();
        double perimeter = 0;

        for (int i = 0; i < n; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % n);
            perimeter += calculateDistance(p1, p2);
        }

        return perimeter;
    }
}
