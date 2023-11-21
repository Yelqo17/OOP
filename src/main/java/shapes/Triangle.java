package shapes;

import java.util.List;

public class Triangle extends Figure {
    static final int MAX_SIZE = 3;
    static final double DIVIDER = 2.0;
    public Triangle(List<Point> points) {
        super(points);
    }

    @Override
    public boolean validate() {
        if (points.size() == MAX_SIZE) {
            double side1 = calculateDistance(points.get(0), points.get(1));
            double side2 = calculateDistance(points.get(1), points.get(2));
            double side3 = calculateDistance(points.get(2), points.get(0));

            boolean firstSide = (side1 + side2 > side3);
            boolean secondSide = (side2 + side3 > side1);
            boolean thirdSide = (side3 + side1 > side2);

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
    public void calculateArea() {
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        Point p3 = points.get(2);

        double area = Math.abs((p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y)) / DIVIDER);
        printArea(area);
    }

    @Override
    public void calculatePerimeter() {
        double side1 = calculateDistance(points.get(0), points.get(1));
        double side2 = calculateDistance(points.get(1), points.get(2));
        double side3 = calculateDistance(points.get(2), points.get(0));

        double perimeter = side1 + side2 + side3;
        printPerimeter(perimeter);
    }
}
