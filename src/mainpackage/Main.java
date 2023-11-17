package mainpackage;

import shapes.Circle;
import shapes.Cone;
import shapes.Cylinder;
import shapes.Parallelogram;
import shapes.Polygon;
import shapes.Rectangle;
import shapes.Sphere;
import shapes.Square;
import shapes.Triangle;
import shapes.TruncatedSphere;
import shapes.Point;
import shapes.Figure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final int MIN_LENGTH = 2;
    static final int MAX_LENGTH = 3;
    static final int X_INDEX = 0;
    static final int Y_INDEX = 1;
    static final int Z_INDEX = 2;
    private enum FigureType {
        CIRCLE,
        SQUARE,
        RECTANGLE,
        PARALLELOGRAM,
        TRIANGLE,
        POLYGON,
        SPHERE,
        TRUNCATED_SPHERE,
        CYLINDER,
        CONE
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Point> points = new ArrayList<>();

        while (true) {
            String command = scanner.nextLine();

            if (command.equals("END")) {
                break;
            }

            if (!commandIsValid(command)) {
                System.out.println("Please, retype");
                continue;
            }

            while (true) {
                String input = scanner.nextLine();
                if (input.equals("STOP_INPUT")) {
                    break;
                }

                String[] coordinates = input.split(" ");
                if (coordinates.length < MIN_LENGTH || coordinates.length > MAX_LENGTH) {
                    System.out.println("Invalid input. Please enter coordinates in the format 'x y' or 'x y z'.");
                    continue;
                }

                int x = Integer.parseInt(coordinates[X_INDEX]);
                int y = Integer.parseInt(coordinates[Y_INDEX]);
                int z = coordinates.length == MAX_LENGTH ? Integer.parseInt(coordinates[Z_INDEX]) : 0;

                points.add(new Point(x, y, z));
            }

            Figure figure = createFigure(command, points);

            if (figure.validate()) {
                figure.calculateArea();
                figure.calculatePerimeter();
            }
            points.clear();
        }
    }

    private static boolean commandIsValid(String command) {
        return List.of("FIGURE", "CIRCLE", "SQUARE", "RECTANGLE", "PARALLELOGRAM", "TRIANGLE", "POLYGON",
                "SPHERE", "TRUNCATED_SPHERE", "CYLINDER", "CONE", "END").contains(command);
    }

    private static Figure createFigure(String command, List<Point> points) {
        FigureType figureType = FigureType.valueOf(command);
        switch (figureType) {
            case CIRCLE:
                return new Circle(points);
            case SQUARE:
                return new Square(points);
            case RECTANGLE:
                return new Rectangle(points);
            case PARALLELOGRAM:
                return new Parallelogram(points);
            case TRIANGLE:
                return new Triangle(points);
            case POLYGON:
                return new Polygon(points);
            case SPHERE:
                return new Sphere(points);
            case TRUNCATED_SPHERE:
                return new TruncatedSphere(points);
            case CYLINDER:
                return new Cylinder(points);
            case CONE:
                return new Cone(points);
            default:
                return new Figure(points);
        }
    }
}
