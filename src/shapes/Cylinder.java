package src.shapes;

import java.util.List;

public class Cylinder extends Figure {
    static final int MAX_SIZE = 3;
    static final int DEGREE_BY_FORMULA = 2;
    public Cylinder(List<Point> points) {
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

            int dx1 = p2.x - p1.x;
            int dy1 = p2.y - p1.y;
            int dz1 = p2.z - p1.z;
            int dx2 = p3.x - p1.x;
            int dy2 = p3.y - p1.y;
            int dz2 = p3.z - p1.z;

            if (dx1 * dx2 + dy1 * dy2 + dz1 * dz2 == 0) {
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
        double radius = calculateDistance(points.get(0), points.get(2));
        double height = calculateDistance(points.get(0), points.get(1));
        double lateralSurfaceArea = DEGREE_BY_FORMULA * Math.PI * radius * height;
        double baseArea = Math.PI * Math.pow(radius, DEGREE_BY_FORMULA);
        double totalSurfaceArea = DEGREE_BY_FORMULA * baseArea + lateralSurfaceArea;
        printArea(totalSurfaceArea);
    }
}