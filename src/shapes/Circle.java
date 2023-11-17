package src.shapes;

import java.util.List;

public class Circle extends Figure {
    static final int MAX_SIZE = 2;
    static final int DEGREE_BY_FORMULA = 2;
    public Circle(List<Point> points) {
        super(points);
    }

    @Override
    public boolean validate() {
        if (points.size() == MAX_SIZE) {
            Point p1 = points.get(0);
            Point p2 = points.get(1);

            if (p1.x == p2.x && p1.y == p2.y && p1.z == p2.z) {
                printInvalid();
                return false;
            }

            printValid();
            return true;
        } else {
            printInvalid();
        }
        return false;
    }

    @Override
    public void calculateArea() {
        double radius = calculateDistance(points.get(0), points.get(1));
        double area = Math.PI * Math.pow(radius, DEGREE_BY_FORMULA);
        printArea(area);
    }

    @Override
    public void calculatePerimeter() {
        double radius = calculateDistance(points.get(0), points.get(1));
        double perimeter = DEGREE_BY_FORMULA * Math.PI * radius;
        printPerimeter(perimeter);
    }
}
