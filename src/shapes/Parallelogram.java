package shapes;

import java.util.ArrayList;
import java.util.List;

public class Parallelogram extends Figure {
    static final int MAX_SIZE = 4;
    static final int DEGREE_BY_FORMULA = 2;
    static final int A = 0;
    static final int B = 1;
    static final int C = 2;
    static final int D = 3;
    List<Point> vectors = new ArrayList<>();

    public Parallelogram(List<Point> points) {
        super(points);
    }

    @Override
    public boolean validate() {
        createVector(points.get(A), points.get(B));
        createVector(points.get(A), points.get(D));
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
    public void calculateArea() {
        double AB = calculateDistance(points.get(A), points.get(B));
        double AD = calculateDistance(points.get(A), points.get(D));
        double product = AB * AD;
        double cos = calculateCos(vectors.get(A), vectors.get(B), product);
        double sin = calculateSin(cos);
        double area = product * sin;
        printArea(area);
    }

    @Override
    public void calculatePerimeter() {
        double[] distances = new double[MAX_SIZE];

        for (int i = 0; i < MAX_SIZE; i++) {
            distances[i] = calculateDistance(points.get(i), points.get((i + 1) % MAX_SIZE));
        }

        double perimeter = DEGREE_BY_FORMULA * (distances[A] + distances[B]);
        printPerimeter(perimeter);
    }

    private void createVector(Point p1, Point p2) {
        int deltaX = p2.x - p1.x;
        int deltaY = p2.y - p1.y;
        int deltaZ = p2.z - p1.z;
        vectors.add(new Point(deltaX, deltaY, deltaZ));
    }

    private double calculateScalarProduct(Point p1, Point p2) {
        return (p1.x * p2.x + p1.y * p2.y + p1.z * p2.z);
    }

    private boolean areOppositeSidesParallel() {
        Point p1 = points.get(A);
        Point p2 = points.get(B);
        Point p3 = points.get(C);
        Point p4 = points.get(D);

        int dx1 = p2.x - p1.x;
        int dy1 = p2.y - p1.y;
        int dx2 = p4.x - p3.x;
        int dy2 = p4.y - p3.y;

        return dx1 * dy2 == dy1 * dx2;
    }

    private double calculateCos(Point p1, Point p2, double product) {
        return calculateScalarProduct(p1, p2) / product;
    }

    private double calculateSin(double cos) {
        return Math.sqrt(1 - Math.pow(cos, 2));
    }
}
