package src.shapes;

import java.util.List;

public class Figure {
    List<Point> points;

    public Figure(List<Point> points) {
        this.points = points;
    }

    public boolean validate() {
        System.out.println("The figure is figyre");
        return true;
    }

    public void calculateArea() {
        System.out.println("The figure has no area");
    }

    public void calculatePerimeter() {
        System.out.println("The figure has no perimeter");
    }

    public void printArea(double area) {
        System.out.printf("The figure area %.2f%n", area);
    }

    public void printPerimeter(double perimeter) {
        System.out.printf("The figure perimeter %.2f%n", perimeter);
    }


    public void printValid() {
        System.out.println("The figure is valid");
    }

    public void printInvalid() {
        System.out.println("The figyre is invalid");
    }

    public double calculateDistance(Point p1, Point p2) {
        int deltaX = p2.x - p1.x;
        int deltaY = p2.y - p1.y;
        int deltaZ = p2.z - p1.z;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
    }

}