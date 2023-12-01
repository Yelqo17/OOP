package com.github.yelqo17.shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class TriangleEqualsShapesTest {
    private static final int FIRST_VALID_COORDINATE_X = 1;
    private static final int SECOND_VALID_COORDINATE_X = 9;
    private static final int THIRD_VALID_COORDINATE_X = 7;
    private static final int FIRST_VALID_COORDINATE_Y = 6;
    private static final int SECOND_VALID_COORDINATE_Y = 6;
    private static final int THIRD_VALID_COORDINATE_Y = 9;
    private static final int FIRST_INVALID_COORDINATE_X = 0;
    private static final int SECOND_INVALID_COORDINATE_X = 1;
    private static final int THIRD_INVALID_COORDINATE_X = 3;
    private static final int FIRST_INVALID_COORDINATE_Y = 0;
    private static final int SECOND_INVALID_COORDINATE_Y = 0;
    private static final int THIRD_INVALID_COORDINATE_Y = 0;
    private static final double VALID_AREA = 12;
    private static final double INVALID_AREA = 0;
    private static final double VALID_PERIMETER = 18.31;
    private static final double INVALID_PERIMETER = 6;

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

        then(actualArea).isEqualTo(VALID_AREA);

        addPointsForInvalidTest();
        actualArea = triangle.calculateArea();

        then(actualArea).isEqualTo(INVALID_AREA);
    }

    @Test
    @DisplayName("check triangle perimeter equality")
    public void checkTrianglePerimeterEquality() {

        addPointsForValidTest();
        double actualPerimeter = triangle.calculatePerimeter();

        then(actualPerimeter).isEqualTo(VALID_PERIMETER);

        addPointsForInvalidTest();
        actualPerimeter = triangle.calculatePerimeter();

        then(actualPerimeter).isEqualTo(INVALID_PERIMETER);
    }

    private void addPointsForValidTest() {
        points.clear();
        points.add(new Point(FIRST_VALID_COORDINATE_X, FIRST_VALID_COORDINATE_Y));
        points.add(new Point(SECOND_VALID_COORDINATE_X, SECOND_VALID_COORDINATE_Y));
        points.add(new Point(THIRD_VALID_COORDINATE_X, THIRD_VALID_COORDINATE_Y));

    }

    private void addPointsForInvalidTest() {
        points.clear();
        points.add(new Point(FIRST_INVALID_COORDINATE_X, FIRST_INVALID_COORDINATE_Y));
        points.add(new Point(SECOND_INVALID_COORDINATE_X, SECOND_INVALID_COORDINATE_Y));
        points.add(new Point(THIRD_INVALID_COORDINATE_X, THIRD_INVALID_COORDINATE_Y));
    }
}
