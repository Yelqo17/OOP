package com.github.yelqo17.shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class RectangleEqualsShapesTest {
    private static final int FIRST_VALID_COORDINATE_X = 0;
    private static final int SECOND_VALID_COORDINATE_X = 0;
    private static final int THIRD_VALID_COORDINATE_X = 3;
    private static final int FOURTH_VALID_COORDINATE_X = 3;
    private static final int FIRST_VALID_COORDINATE_Y = 0;
    private static final int SECOND_VALID_COORDINATE_Y = 7;
    private static final int THIRD_VALID_COORDINATE_Y = 7;
    private static final int FOURTH_VALID_COORDINATE_Y = 0;
    private static final int FIRST_INVALID_COORDINATE_X = 0;
    private static final int SECOND_INVALID_COORDINATE_X = 0;
    private static final int THIRD_INVALID_COORDINATE_X = 5;
    private static final int FOURTH_INVALID_COORDINATE_X = 5;
    private static final int FIRST_INVALID_COORDINATE_Y = 0;
    private static final int SECOND_INVALID_COORDINATE_Y = 5;
    private static final int THIRD_INVALID_COORDINATE_Y = 5;
    private static final int FOURTH_INVALID_COORDINATE_Y = 0;
    private static final double VALID_AREA = 21;
    private static final double INVALID_AREA = 25;
    private static final double VALID_PERIMETER = 20;
    private static final double INVALID_PERIMETER = 20;

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

        then(actualArea).isEqualTo(VALID_AREA);

        addPointsForInvalidTest();
        actualArea = rectangle.calculateArea();

        then(actualArea).isEqualTo(INVALID_AREA);
    }

    @Test
    @DisplayName("check rectangle perimeter equality")
    public void checkRectanglePerimeterEquality() {

        addPointsForValidTest();
        double actualPerimeter = rectangle.calculatePerimeter();

        then(actualPerimeter).isEqualTo(VALID_PERIMETER);

        addPointsForInvalidTest();
        actualPerimeter = rectangle.calculatePerimeter();

        then(actualPerimeter).isEqualTo(INVALID_PERIMETER);
    }

    private void addPointsForValidTest() {
        points.clear();
        points.add(new Point(FIRST_VALID_COORDINATE_X, FIRST_VALID_COORDINATE_Y));
        points.add(new Point(SECOND_VALID_COORDINATE_X, SECOND_VALID_COORDINATE_Y));
        points.add(new Point(THIRD_VALID_COORDINATE_X, THIRD_VALID_COORDINATE_Y));
        points.add(new Point(FOURTH_VALID_COORDINATE_X, FOURTH_VALID_COORDINATE_Y));
    }

    private void addPointsForInvalidTest() {
        points.clear();
        points.add(new Point(FIRST_INVALID_COORDINATE_X, FIRST_INVALID_COORDINATE_Y));
        points.add(new Point(SECOND_INVALID_COORDINATE_X, SECOND_INVALID_COORDINATE_Y));
        points.add(new Point(THIRD_INVALID_COORDINATE_X, THIRD_INVALID_COORDINATE_Y));
        points.add(new Point(FOURTH_INVALID_COORDINATE_X, FOURTH_INVALID_COORDINATE_Y));
    }
}
