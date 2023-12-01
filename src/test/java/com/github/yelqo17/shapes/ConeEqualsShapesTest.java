package com.github.yelqo17.shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class ConeEqualsShapesTest {
    private static final List<Point> points = new ArrayList<>();
    private static final Cone cone = new Cone(points);

    @Test
    @DisplayName("check cone validation")
    public void checkConeValidation() {

        addPointsForValidTest();
        boolean isValid = cone.validate();

        then(isValid).isEqualTo(true);

        addPointsForInvalidTest();
        isValid = cone.validate();

        then(isValid).isEqualTo(false);
    }

    @Test
    @DisplayName("check cone area equality")
    public void checkConeAreaEquality() {

        addPointsForValidTest();
        double actualArea = cone.calculateArea();

        then(actualArea).isEqualTo(12.57);

        addPointsForInvalidTest();
        actualArea = cone.calculateArea();

        then(actualArea).isEqualTo(9.42);
    }

    private void addPointsForValidTest() {
        points.clear();
        points.add(new Point(0, 0, 0));
        points.add(new Point(1, 0, 0));
        points.add(new Point(0, 0, 2));
    }

    private void addPointsForInvalidTest() {
        points.clear();
        points.add(new Point(0, 0, 0));
        points.add(new Point(1, 0, 0));
        points.add(new Point(1, 0, 0));
    }
}
