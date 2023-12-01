package com.github.yelqo17.shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class PolygonEqualsShapesTest {
    private static final int FIRST_VALID_COORDINATE_X = 1;
    private static final int SECOND_VALID_COORDINATE_X = 9;
    private static final int THIRD_VALID_COORDINATE_X = 7;
    private static final int FIRST_VALID_COORDINATE_Y = 6;
    private static final int SECOND_VALID_COORDINATE_Y = 6;
    private static final int THIRD_VALID_COORDINATE_Y = 9;
    private static final int FIRST_INVALID_COORDINATE_X = 0;
    private static final int SECOND_INVALID_COORDINATE_X = 1;
    private static final int THIRD_INVALID_COORDINATE_X = 2;
    private static final int FIRST_INVALID_COORDINATE_Y = 0;
    private static final int SECOND_INVALID_COORDINATE_Y = 1;
    private static final int THIRD_INVALID_COORDINATE_Y = 2;
    private static final double VALID_AREA = 12;
    private static final double INVALID_AREA = 0;
    private static final double VALID_PERIMETER = 18.31;
    private static final double INVALID_PERIMETER = 5.66;

    private static final List<Point> points = new ArrayList<>();
    private static final Polygon polygon = new Polygon(points);

    @Test
    @DisplayName("check polygon validation")
    public void checkPolygonValidation() {

        addPointsForValidTest();
        boolean isValid = polygon.validate();

        then(isValid).isEqualTo(true);

        addPointsForInvalidTest();
        isValid = polygon.validate();

        then(isValid).isEqualTo(false);
    }

    @Test
    @DisplayName("check polygon area equality")
    public void checkPolygonAreaEquality() {

        addPointsForValidTest();
        double actualArea = polygon.calculateArea();

        then(actualArea).isEqualTo(VALID_AREA);

        addPointsForInvalidTest();
        actualArea = polygon.calculateArea();

        then(actualArea).isEqualTo(INVALID_AREA);
    }

    @Test
    @DisplayName("check polygon perimeter equality")
    public void checkPolygonPerimeterEquality() {

        addPointsForValidTest();
        double actualPerimeter = polygon.calculatePerimeter();

        then(actualPerimeter).isEqualTo(VALID_PERIMETER);

        addPointsForInvalidTest();
        actualPerimeter = polygon.calculatePerimeter();

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
