package com.github.yelqo17.shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class RectangleEqualsShapesTest {
    private static final List<Point> points = new ArrayList<>();
    private static final Rectangle rectangle = new Rectangle(points);

    @Test
    @DisplayName("check rectangle validation")
    public void checkRectangleValidation() {

        addPointsForValidTest();
        boolean isValid = rectangle.validate();

        then(isValid).isEqualTo(true);

        addPointsForInvalidTest();
        isValid = rectangle.validate();

        then(isValid).isEqualTo(false);
    }

    @Test
    @DisplayName("check rectangle area equality")
    public void checkRectangleAreaEquality() {

        addPointsForValidTest();
        double actualArea = rectangle.calculateArea();

        then(actualArea).isEqualTo(21);

        addPointsForInvalidTest();
        actualArea = rectangle.calculateArea();

        then(actualArea).isEqualTo(25);
    }

    @Test
    @DisplayName("check rectangle perimeter equality")
    public void checkRectanglePerimeterEquality() {

        addPointsForValidTest();
        double actualPerimeter = rectangle.calculatePerimeter();

        then(actualPerimeter).isEqualTo(20);

        addPointsForInvalidTest();
        actualPerimeter = rectangle.calculatePerimeter();

        then(actualPerimeter).isEqualTo(20);
    }

    private void addPointsForValidTest() {
        points.clear();
        points.add(new Point(0, 0));
        points.add(new Point(0, 7));
        points.add(new Point(3, 7));
        points.add(new Point(3, 0));
    }

    private void addPointsForInvalidTest() {
        points.clear();
        points.add(new Point(0, 0));
        points.add(new Point(0, 5));
        points.add(new Point(5, 5));
        points.add(new Point(5, 0));
    }
}
