package com.github.yelqo17.shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class SphereEqualsShapesTest {
    private static final int FIRST_VALID_COORDINATE_X = 0;
    private static final int SECOND_VALID_COORDINATE_X = 0;
    private static final int FIRST_VALID_COORDINATE_Y = 0;
    private static final int SECOND_VALID_COORDINATE_Y = 0;
    private static final int FIRST_VALID_COORDINATE_Z = 0;
    private static final int SECOND_VALID_COORDINATE_Z = 1;
    private static final int FIRST_INVALID_COORDINATE_X = 0;
    private static final int SECOND_INVALID_COORDINATE_X = 0;
    private static final int FIRST_INVALID_COORDINATE_Y = 0;
    private static final int SECOND_INVALID_COORDINATE_Y = 0;
    private static final int FIRST_INVALID_COORDINATE_Z = 1;
    private static final int SECOND_INVALID_COORDINATE_Z = 1;
    private static final double VALID_AREA = 12.57;
    private static final double INVALID_AREA = 0;

    private static final List<Point> points = new ArrayList<>();
    private static final Sphere sphere = new Sphere(points);

    @Test
    @DisplayName("check sphere validation")
    public void checkSphereValidation() {

        addPointsForValidTest();
        boolean isValid = sphere.validate();

        then(isValid).isEqualTo(true);

        addPointsForInvalidTest();
        isValid = sphere.validate();

        then(isValid).isEqualTo(false);
    }

    @Test
    @DisplayName("check sphere area equality")
    public void checkSphereAreaEquality() {

        addPointsForValidTest();
        double actualArea = sphere.calculateArea();

        then(actualArea).isEqualTo(VALID_AREA);

        addPointsForInvalidTest();
        actualArea = sphere.calculateArea();

        then(actualArea).isEqualTo(INVALID_AREA);
    }

    private void addPointsForValidTest() {
        points.clear();
        points.add(new Point(FIRST_VALID_COORDINATE_X, FIRST_VALID_COORDINATE_Y, FIRST_VALID_COORDINATE_Z));
        points.add(new Point(SECOND_VALID_COORDINATE_X, SECOND_VALID_COORDINATE_Y, SECOND_VALID_COORDINATE_Z));
    }

    private void addPointsForInvalidTest() {
        points.clear();
        points.add(new Point(FIRST_INVALID_COORDINATE_X, FIRST_INVALID_COORDINATE_Y, FIRST_INVALID_COORDINATE_Z));
        points.add(new Point(SECOND_INVALID_COORDINATE_X, SECOND_INVALID_COORDINATE_Y, SECOND_INVALID_COORDINATE_Z));
    }
}
