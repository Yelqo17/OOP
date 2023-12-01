package com.github.yelqo17.shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class ParallelogramEqualsShapesTest {
    private static final List<Point> points = new ArrayList<>();
    private static Parallelogram parallelogram;

    @Test
    @DisplayName("when parallelogram validation equals to expected then return true")
    public void whenParallelogramValidationEqualsToExpectedThenReturnTrue() {

        addPointsForValidTest();
        boolean isValid = parallelogram.validate();

        then(isValid).isEqualTo(true);

        addPointsForInvalidTest();
        isValid = parallelogram.validate();

        then(isValid).isEqualTo(false);
    }

    @Test
    @DisplayName("when parallelogram area equals to expected then return true")
    public void whenParallelogramAreaEqualsToExpectedThenReturnTrue() {

        addPointsForValidTest();
        double actualArea = parallelogram.calculateArea();

        then(actualArea).isEqualTo(4);

        addPointsForInvalidTest();
        actualArea = parallelogram.calculateArea();

        then(actualArea).isEqualTo(25);
    }

    @Test
    @DisplayName("when parallelogram perimeter equals to expected then return true")
    public void whenParallelogramPerimeterEqualsToExpectedThenReturnTrue() {

        addPointsForValidTest();
        double actualPerimeter = parallelogram.calculatePerimeter();

        then(actualPerimeter).isEqualTo(8.47);

        addPointsForInvalidTest();
        actualPerimeter = parallelogram.calculatePerimeter();

        then(actualPerimeter).isEqualTo(20);
    }

    private void addPointsForValidTest() {
        points.clear();
        points.add(new Point(0, 0));
        points.add(new Point(2, 0));
        points.add(new Point(3, 2));
        points.add(new Point(1, 2));
        parallelogram = new Parallelogram(points);
    }

    private void addPointsForInvalidTest() {
        points.clear();
        points.add(new Point(0, 0));
        points.add(new Point(0, 5));
        points.add(new Point(5, 5));
        points.add(new Point(5, 0));
        parallelogram = new Parallelogram(points);
    }
}
