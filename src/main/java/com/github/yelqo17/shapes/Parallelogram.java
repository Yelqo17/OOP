package com.github.yelqo17.shapes;

import java.util.ArrayList;
import java.util.List;

public class Parallelogram extends Figure {
    private static final int MAX_SIZE = 4;
    private static final int DEGREE_BY_FORMULA = 2;
    private static final int A = 0;
    private static final int B = 1;
    private static final int C = 2;
    private static final int D = 3;
    private final List<Point> vectors = new ArrayList<>();
    public Parallelogram(List<Point> points) {
        super(points);
        createVector(points.get(A), points.get(B));
        createVector(points.get(A), points.get(D));
    }

    @Override
    public boolean validate() {
        if (points.size() == MAX_SIZE) {
            boolean isValid = calculateScalarProduct(vectors.get(A), vectors.get(B)) != 0;

            if (isValid) {
                if (areOppositeSidesParallel()) {
                    printValid();
                    return true;
                } else {
                    printInvalid();
                }
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
        double AB = calculateDistance(points.get(A), points.get(B));
        double AD = calculateDistance(points.get(A), points.get(D));
        double product = AB * AD;
        double cos = calculateCos(vectors.get(A), vectors.get(B), product);
        double sin = calculateSin(cos);
        return product * sin;
    }

    @Override
    public double calculatePerimeter() {
        double[] distances = new double[MAX_SIZE];

        for (int i = 0; i < MAX_SIZE; i++) {
            distances[i] = calculateDistance(points.get(i), points.get((i + 1) % MAX_SIZE));
        }

        return DEGREE_BY_FORMULA * (distances[A] + distances[B]);
    }

    private void createVector(Point p1, Point p2) {
        int deltaX = p2.getX() - p1.getX();
        int deltaY = p2.getY() - p1.getY();
        int deltaZ = p2.getZ() - p1.getZ();
        vectors.add(new Point(deltaX, deltaY, deltaZ));
    }

    private double calculateScalarProduct(Point p1, Point p2) {
        return (p1.getX() * p2.getX() + p1.getY() * p2.getY() + p1.getZ() * p2.getZ());
    }

    private boolean areOppositeSidesParallel() {
        Point p1 = points.get(A);
        Point p2 = points.get(B);
        Point p3 = points.get(C);
        Point p4 = points.get(D);

        int dx1 = p2.getX() - p1.getX();
        int dy1 = p2.getY() - p1.getY();
        int dx2 = p4.getX() - p3.getX();
        int dy2 = p4.getY() - p3.getY();

        return dx1 * dy2 == dy1 * dx2;
    }

    private double calculateCos(Point p1, Point p2, double product) {
        return calculateScalarProduct(p1, p2) / product;
    }

    private double calculateSin(double cos) {
        return Math.sin(Math.acos(cos));
    }
}
