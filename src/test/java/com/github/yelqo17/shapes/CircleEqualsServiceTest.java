package com.github.yelqo17.shapes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.ArrayList;
import java.util.List;

public class CircleEqualsServiceTest {
    private static final List<Point> points = new ArrayList<>();
    private static final Circle circle = new Circle(points);

    @Test
    @DisplayName("when circle validation equals to expected then return true")
    public void whenCircleValidationEqualsToExpectedThenReturnTrue() {

        addPointsForValidTest();
        boolean isValid = circle.validate();

        then(isValid).isEqualTo(true);

        addPointsForInvalidTest();
        isValid = circle.validate();

        then(isValid).isEqualTo(false);
    }

    @Test
    @DisplayName("when circle area equals to expected then return true")
    public void whenCircleAreaEqualsToExpectedThenReturnTrue() {

        addPointsForValidTest();
        double actualArea = circle.calculateArea();

        then(actualArea).isEqualTo(3.14);

        addPointsForInvalidTest();
        actualArea = circle.calculateArea();

        then(actualArea).isEqualTo(0);
    }

    @Test
    @DisplayName("when circle perimeter equals to expected then return true")
    public void whenCirclePerimeterEqualsToExpectedThenReturnTrue() {

        addPointsForValidTest();
        double actualPerimeter = circle.calculatePerimeter();

        then(actualPerimeter).isEqualTo(6.28);

        addPointsForInvalidTest();
        actualPerimeter = circle.calculatePerimeter();

        then(actualPerimeter).isEqualTo(0);
    }

    private void addPointsForValidTest() {
        points.clear();
        points.add(new Point(0, 0));
        points.add(new Point(0, 1));
    }

    private void addPointsForInvalidTest() {
        points.clear();
        points.add(new Point(2, 0));
        points.add(new Point(2, 0));
    }
}
