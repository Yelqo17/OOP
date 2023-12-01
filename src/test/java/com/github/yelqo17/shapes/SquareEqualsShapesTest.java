package com.github.yelqo17.shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class SquareEqualsShapesTest {
    private static final List<Point> points = new ArrayList<>();
    private static final Square square = new Square(points);

    @Test
    @DisplayName("when square validation equals to expected then return true")
    public void whenSquareValidationEqualsToExpectedThenReturnTrue() {

        addPointsForValidTest();
        boolean isValid = square.validate();

        then(isValid).isEqualTo(true);

        addPointsForInvalidTest();
        isValid = square.validate();

        then(isValid).isEqualTo(false);
    }

    @Test
    @DisplayName("when square area equals to expected then return true")
    public void whenSquareAreaEqualsToExpectedThenReturnTrue() {

        addPointsForValidTest();
        double actualArea = square.calculateArea();

        then(actualArea).isEqualTo(25);

        addPointsForInvalidTest();
        actualArea = square.calculateArea();

        then(actualArea).isEqualTo(49);
    }

    @Test
    @DisplayName("when square perimeter equals to expected then return true")
    public void whenSquarePerimeterEqualsToExpectedThenReturnTrue() {

        addPointsForValidTest();
        double actualPerimeter = square.calculatePerimeter();

        then(actualPerimeter).isEqualTo(20);

        addPointsForInvalidTest();
        actualPerimeter = square.calculatePerimeter();

        then(actualPerimeter).isEqualTo(28);
    }

    private void addPointsForValidTest() {
        points.clear();
        points.add(new Point(0, 0));
        points.add(new Point(0, 5));
        points.add(new Point(5, 5));
        points.add(new Point(5, 0));

    }

    private void addPointsForInvalidTest() {
        points.clear();
        points.add(new Point(0, 0));
        points.add(new Point(0, 7));
        points.add(new Point(3, 7));
        points.add(new Point(3, 0));
    }
}
