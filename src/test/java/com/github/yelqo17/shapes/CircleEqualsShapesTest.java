package com.github.yelqo17.shapes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.ArrayList;
import java.util.List;

public class CircleEqualsShapesTest {
    private static final int FIRST_VALID_COORDINATE_X = 0;
    private static final int SECOND_VALID_COORDINATE_X = 0;
    private static final int FIRST_VALID_COORDINATE_Y = 0;
    private static final int SECOND_VALID_COORDINATE_Y = 1;
    private static final int FIRST_INVALID_COORDINATE_X = 2;
    private static final int SECOND_INVALID_COORDINATE_X = 2;
    private static final int FIRST_INVALID_COORDINATE_Y = 0;
    private static final int SECOND_INVALID_COORDINATE_Y = 0;
    private static final double VALID_AREA = 3.14;
    private static final double INVALID_AREA = 0;
    private static final double VALID_PERIMETER = 6.28;
    private static final double INVALID_PERIMETER = 0;

    private static final List<Point> points = new ArrayList<>();
    private static final Circle circle = new Circle(points);

    @Test
    @DisplayName("check circle validation")
    public void checkCircleValidation() {

        addPointsForValidTest();
        boolean isValid = circle.validate();

        then(isValid).isEqualTo(true);

        addPointsForInvalidTest();
        isValid = circle.validate();

        then(isValid).isEqualTo(false);
    }

    @Test
    @DisplayName("check circle area equality")
    public void checkCircleAreaEquality() {

        addPointsForValidTest();
        double actualArea = circle.calculateArea();

        then(actualArea).isEqualTo(VALID_AREA);

        addPointsForInvalidTest();
        actualArea = circle.calculateArea();

        then(actualArea).isEqualTo(INVALID_AREA);
    }

    @Test
    @DisplayName("check circle perimeter equality")
    public void checkCirclePerimeterEquality() {

        addPointsForValidTest();
        double actualPerimeter = circle.calculatePerimeter();

        then(actualPerimeter).isEqualTo(VALID_PERIMETER);

        addPointsForInvalidTest();
        actualPerimeter = circle.calculatePerimeter();

        then(actualPerimeter).isEqualTo(INVALID_PERIMETER);
    }

    private void addPointsForValidTest() {
        points.clear();
        points.add(new Point(FIRST_VALID_COORDINATE_X, FIRST_VALID_COORDINATE_Y));
        points.add(new Point(SECOND_VALID_COORDINATE_X, SECOND_VALID_COORDINATE_Y));
    }

    private void addPointsForInvalidTest() {
        points.clear();
        points.add(new Point(FIRST_INVALID_COORDINATE_X, FIRST_INVALID_COORDINATE_Y));
        points.add(new Point(SECOND_INVALID_COORDINATE_X, SECOND_INVALID_COORDINATE_Y));
    }
}
