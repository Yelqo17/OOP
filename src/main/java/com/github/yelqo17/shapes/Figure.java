package com.github.yelqo17.shapes;

import java.util.List;

public class Figure {
    protected List<Point> points;
    public Figure(List<Point> points) {
        this.points = points;
    }

    public boolean validate() {
        System.out.println("The figure is figure");
        return true;
    }

    public void printArea() {
        double area = calculateArea();
        if (area == 0) {
            return;
        }
        System.out.println("The figure area " + area);
    }

    public void printPerimeter() {
        double perimeter = calculatePerimeter();
        if (perimeter == 0) {
            return;
        }
        System.out.println("The figure perimeter " + perimeter);
    }

    public double round(double number) {
        return Math.round(number * 100.0) / 100.0;
    }

    protected double calculateArea() {
        System.out.println("The figure has no area");
        return 0;
    }

    protected double calculatePerimeter() {
        System.out.println("The figure has no perimeter");
        return 0;
    }

    protected void printValid() {
        System.out.println("The figure is valid");
    }

    protected void printInvalid() {
        System.out.println("The figure is invalid");
    }

    protected double calculateDistance(Point p1, Point p2) {
        int deltaX = p2.getX() - p1.getX();
        int deltaY = p2.getY() - p1.getY();
        int deltaZ = p2.getZ() - p1.getZ();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
    }

}