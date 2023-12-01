package com.github.yelqo17.shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class TriangleEqualsShapesTest {
    private static final List<Point> points = new ArrayList<>();
    private static final Triangle triangle = new Triangle(points);

    @Test
    @DisplayName("check triangle validation")
    public void checkTriangleValidation() {

        addPointsForValidTest();
        boolean isValid = triangle.validate();

        then(isValid).isEqualTo(true);

        addPointsForInvalidTest();
        isValid = triangle.validate();

        then(isValid).isEqualTo(false);
    }

    @Test
    @DisplayName("check triangle area equality")
    public void checkTriangleAreaEquality() {

        addPointsForValidTest();
        double actualArea = triangle.calculateArea();

        then(actualArea).isEqualTo(12);

        addPointsForInvalidTest();
        actualArea = triangle.calculateArea();

        then(actualArea).isEqualTo(0);
    }

    @Test
    @DisplayName("check triangle perimeter equality")
    public void checkTrianglePerimeterEquality() {

        addPointsForValidTest();
        double actualPerimeter = triangle.calculatePerimeter();

        then(actualPerimeter).isEqualTo(18.31);

        addPointsForInvalidTest();
        actualPerimeter = triangle.calculatePerimeter();

        then(actualPerimeter).isEqualTo(6);
    }

    private void addPointsForValidTest() {
        points.clear();
        points.add(new Point(1, 6));
        points.add(new Point(9, 6));
        points.add(new Point(7, 9));

    }

    private void addPointsForInvalidTest() {
        points.clear();
        points.add(new Point(0, 0));
        points.add(new Point(1, 0));
        points.add(new Point(3, 0));
    }
}
