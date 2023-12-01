package com.github.yelqo17.shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class CylinderEqualsShapesTest {
    private static final List<Point> points = new ArrayList<>();
    private static final Cylinder cylinder = new Cylinder(points);

    @Test
    @DisplayName("when cylinder validation equals to expected then return true")
    public void whenCylinderValidationEqualsToExpectedThenReturnTrue() {

        addPointsForValidTest();
        boolean isValid = cylinder.validate();

        then(isValid).isEqualTo(true);

        addPointsForInvalidTest();
        isValid = cylinder.validate();

        then(isValid).isEqualTo(false);
    }

    @Test
    @DisplayName("when cylinder area equals to expected then return true")
    public void whenCylinderAreaEqualsToExpectedThenReturnTrue() {

        addPointsForValidTest();
        double actualArea = cylinder.calculateArea();

        then(actualArea).isEqualTo(57);

        addPointsForInvalidTest();
        actualArea = cylinder.calculateArea();

        then(actualArea).isEqualTo(73.26);
    }

    private void addPointsForValidTest() {
        points.clear();
        points.add(new Point(0, 0, 0));
        points.add(new Point(0, 0, 5));
        points.add(new Point(1, 1, 0));
    }

    private void addPointsForInvalidTest() {
        points.clear();
        points.add(new Point(0, 0, 0));
        points.add(new Point(0, 0, 5));
        points.add(new Point(1, 1, -1));
    }
}
