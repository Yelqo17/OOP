package com.github.yelqo17.shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class SphereEqualsShapesTest {
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

        then(actualArea).isEqualTo(12.57);

        addPointsForInvalidTest();
        actualArea = sphere.calculateArea();

        then(actualArea).isEqualTo(0);
    }

    private void addPointsForValidTest() {
        points.clear();
        points.add(new Point(0, 0, 0));
        points.add(new Point(0, 0, 1));
    }

    private void addPointsForInvalidTest() {
        points.clear();
        points.add(new Point(0, 0, 1));
        points.add(new Point(0, 0, 1));
    }
}
