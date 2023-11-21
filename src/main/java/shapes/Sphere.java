package shapes;

import java.util.List;

public class Sphere extends Figure {
    static final int MAX_SIZE = 2;
    static final int DEGREE_BY_FORMULA = 2;
    static final int CONST_BY_FORMULA = 4;
    public Sphere(List<Point> points) {
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

            if (p1.z != 0 || p2.z != 0) {
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
        double radius = calculateDistance(points.get(0), points.get(1));
        double area = CONST_BY_FORMULA * Math.PI * Math.pow(radius, DEGREE_BY_FORMULA);
        printArea(area);
    }
}
