package shapes;

import java.util.List;

public class Square extends Figure {
    static final int MAX_SIZE = 4;
    static final int DEGREE_BY_FORMULA = 2;
    static final int CONST_BY_FORMULA = 4;
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
    public void calculateArea() {
        double sideLength = calculateDistance(points.get(0), points.get(1));
        double area = Math.pow(sideLength, DEGREE_BY_FORMULA);
        printArea(area);
    }

    @Override
    public void calculatePerimeter() {
        double sideLength = calculateDistance(points.get(0), points.get(1));
        double perimeter = CONST_BY_FORMULA * sideLength;
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
}