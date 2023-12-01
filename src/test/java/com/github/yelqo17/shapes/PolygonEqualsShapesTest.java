package com.github.yelqo17.shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class PolygonEqualsShapesTest {
    private static final List<Point> points = new ArrayList<>();
    private static final Polygon polygon = new Polygon(points);

    @Test
    @DisplayName("when polygon validation equals to expected then return true")
    public void whenPolygonValidationEqualsToExpectedThenReturnTrue() {

        addPointsForValidTest();
        boolean isValid = polygon.validate();

        then(isValid).isEqualTo(true);

        addPointsForInvalidTest();
        isValid = polygon.validate();

        then(isValid).isEqualTo(false);
    }

    @Test
    @DisplayName("when polygon area equals to expected then return true")
    public void whenPolygonAreaEqualsToExpectedThenReturnTrue() {

        addPointsForValidTest();
        double actualArea = polygon.calculateArea();

        then(actualArea).isEqualTo(34);

        addPointsForInvalidTest();
        actualArea = polygon.calculateArea();

        then(actualArea).isEqualTo(0);
    }

    @Test
    @DisplayName("when polygon perimeter equals to expected then return true")
    public void whenPolygonPerimeterEqualsToExpectedThenReturnTrue() {

        addPointsForValidTest();
        double actualPerimeter = polygon.calculatePerimeter();

        then(actualPerimeter).isEqualTo(23.18);

        addPointsForInvalidTest();
        actualPerimeter = polygon.calculatePerimeter();

        then(actualPerimeter).isEqualTo(11.31);
    }

    private void addPointsForValidTest() {
        points.clear();
        points.add(new Point(5, 7));
        points.add(new Point(9, 7));
        points.add(new Point(10, 2));
        points.add(new Point(6, 1));
        points.add(new Point(2, 2));
    }

    private void addPointsForInvalidTest() {
        points.clear();
        points.add(new Point(0, 0));
        points.add(new Point(1, 1));
        points.add(new Point(2, 2));
        points.add(new Point(3, 3));
        points.add(new Point(4, 4));
    }
}
