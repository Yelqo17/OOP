package com.github.yelqo17.shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class CylinderEqualsShapesTest {
    private static final int FIRST_VALID_COORDINATE_X = 0;
    private static final int SECOND_VALID_COORDINATE_X = 0;
    private static final int THIRD_VALID_COORDINATE_X = 1;
    private static final int FIRST_VALID_COORDINATE_Y = 0;
    private static final int SECOND_VALID_COORDINATE_Y = 0;
    private static final int THIRD_VALID_COORDINATE_Y = 1;
    private static final int FIRST_VALID_COORDINATE_Z = 0;
    private static final int SECOND_VALID_COORDINATE_Z = 5;
    private static final int THIRD_VALID_COORDINATE_Z = 0;
    private static final int FIRST_INVALID_COORDINATE_X = 0;
    private static final int SECOND_INVALID_COORDINATE_X = 0;
    private static final int THIRD_INVALID_COORDINATE_X = 1;
    private static final int FIRST_INVALID_COORDINATE_Y = 0;
    private static final int SECOND_INVALID_COORDINATE_Y = 0;
    private static final int THIRD_INVALID_COORDINATE_Y = 1;
    private static final int FIRST_INVALID_COORDINATE_Z = 0;
    private static final int SECOND_INVALID_COORDINATE_Z = 5;
    private static final int THIRD_INVALID_COORDINATE_Z = -1;
    private static final double VALID_AREA = 57;
    private static final double INVALID_AREA = 73.26;

    private static final List<Point> points = new ArrayList<>();
    private static final Cylinder cylinder = new Cylinder(points);

    @Test
    @DisplayName("check cylinder validation")
    public void checkCylinderValidation() {

        addPointsForValidTest();
        boolean isValid = cylinder.validate();

        then(isValid).isEqualTo(true);

        addPointsForInvalidTest();
        isValid = cylinder.validate();

        then(isValid).isEqualTo(false);
    }

    @Test
    @DisplayName("check cylinder area equality")
    public void checkCylinderAreaEquality() {

        addPointsForValidTest();
        double actualArea = cylinder.calculateArea();

        then(actualArea).isEqualTo(VALID_AREA);

        addPointsForInvalidTest();
        actualArea = cylinder.calculateArea();

        then(actualArea).isEqualTo(INVALID_AREA);
    }

    private void addPointsForValidTest() {
        points.clear();
        points.add(new Point(FIRST_VALID_COORDINATE_X, FIRST_VALID_COORDINATE_Y, FIRST_VALID_COORDINATE_Z));
        points.add(new Point(SECOND_VALID_COORDINATE_X, SECOND_VALID_COORDINATE_Y, SECOND_VALID_COORDINATE_Z));
        points.add(new Point(THIRD_VALID_COORDINATE_X, THIRD_VALID_COORDINATE_Y, THIRD_VALID_COORDINATE_Z));
    }

    private void addPointsForInvalidTest() {
        points.clear();
        points.add(new Point(FIRST_INVALID_COORDINATE_X, FIRST_INVALID_COORDINATE_Y, FIRST_INVALID_COORDINATE_Z));
        points.add(new Point(SECOND_INVALID_COORDINATE_X, SECOND_INVALID_COORDINATE_Y, SECOND_INVALID_COORDINATE_Z));
        points.add(new Point(THIRD_INVALID_COORDINATE_X, THIRD_INVALID_COORDINATE_Y, THIRD_INVALID_COORDINATE_Z));
    }
}
