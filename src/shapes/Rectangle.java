package src.shapes;

import java.util.List;

public class Rectangle extends Figure {
    static final int MAX_SIZE = 4;
    static final int DEGREE_BY_FORMULA = 2;
    static final int A = 0;
    static final int B = 1;
    static final int C = 2;
    static final int D = 3;
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
                if (distances[i] != distances[(i + 2) % MAX_SIZE]) {
                    isValid = false;
                    break;
                }
            }

            if (isValid && areAllAngles90Degrees() && areOppositeSidesParallel()) {
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
    public void calculateArea() {
        double length = calculateDistance(points.get(A), points.get(B));
        double width = calculateDistance(points.get(B), points.get(C));
        double area = length * width;

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

    private boolean areAllAngles90Degrees() {
        for (int i = 0; i < MAX_SIZE; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get((i + 1) % MAX_SIZE);
            Point p3 = points.get((i + 2) % MAX_SIZE);

            int dx1 = p2.x - p1.x;
            int dy1 = p2.y - p1.y;
            int dx2 = p3.x - p2.x;
            int dy2 = p3.y - p2.y;

            if (dx1 * dx2 + dy1 * dy2 != 0) {
                return false;
            }
        }
        return true;
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
}
