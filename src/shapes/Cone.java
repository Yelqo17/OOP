package src.shapes;

import java.util.List;

public class Cone extends Figure {
    static final int MAX_SIZE = 3;
    static final int DEGREE_BY_FORMULA = 2;
    public Cone(List<Point> points) {
        super(points);
    }

    @Override
    public boolean validate() {
        if (points.size() == MAX_SIZE) {
            Point p1 = points.get(0);
            Point p2 = points.get(1);
            Point p3 = points.get(2);

            if (p1.x == p2.x && p1.y == p2.y && p1.z == p2.z
                    || p1.x == p3.x && p1.y == p3.y && p1.z == p3.z
                    || p2.x == p3.x && p2.y == p3.y && p2.z == p3.z) {
                printInvalid();
                return false;
            }

            int a = p1.x * (p2.y * p3.z - p3.y * p2.z) - p2.x * (p1.y * p3.z - p3.y * p1.z)
                    + p3.x * (p1.y * p2.z - p2.y * p1.z);

            if (a == 0) {
                printInvalid();
                return false;
            }

            if (p1.z != 0 || p2.z != 0 || p3.z != 0) {
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
        double slantHeight = calculateDistance(points.get(0), points.get(2));
        double lateralSurfaceArea = Math.PI * radius * slantHeight;
        double baseArea = Math.PI * Math.pow(radius, DEGREE_BY_FORMULA);
        double totalSurfaceArea = lateralSurfaceArea + baseArea;
        printArea(totalSurfaceArea);
    }
}