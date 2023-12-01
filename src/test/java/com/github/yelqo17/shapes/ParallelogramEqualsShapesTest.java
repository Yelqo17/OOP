package com.github.yelqo17.shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class ParallelogramEqualsShapesTest {
    private static final int FIRST_VALID_COORDINATE_X = 0;
    private static final int SECOND_VALID_COORDINATE_X = 2;
    private static final int THIRD_VALID_COORDINATE_X = 3;
    private static final int FOURTH_VALID_COORDINATE_X = 1;
    private static final int FIRST_VALID_COORDINATE_Y = 0;
    private static final int SECOND_VALID_COORDINATE_Y = 0;
    private static final int THIRD_VALID_COORDINATE_Y = 2;
    private static final int FOURTH_VALID_COORDINATE_Y = 2;
    private static final int FIRST_INVALID_COORDINATE_X = 0;
    private static final int SECOND_INVALID_COORDINATE_X = 0;
    private static final int THIRD_INVALID_COORDINATE_X = 5;
    private static final int FOURTH_INVALID_COORDINATE_X = 5;
    private static final int FIRST_INVALID_COORDINATE_Y = 0;
    private static final int SECOND_INVALID_COORDINATE_Y = 5;
    private static final int THIRD_INVALID_COORDINATE_Y = 5;
    private static final int FOURTH_INVALID_COORDINATE_Y = 0;
    private static final double VALID_AREA = 4;
    private static final double INVALID_AREA = 25;
    private static final double VALID_PERIMETER = 8.47;
    private static final double INVALID_PERIMETER = 20;

    private static final List<Point> points = new ArrayList<>();
    private static Parallelogram parallelogram;

    @Test
    @DisplayName("check parallelogram validation")
    public void checkParallelogramValidation() {

        addPointsForValidTest();
        boolean isValid = parallelogram.validate();

        then(isValid).isEqualTo(true);

        addPointsForInvalidTest();
        isValid = parallelogram.validate();

        then(isValid).isEqualTo(false);
    }

    @Test
    @DisplayName("check parallelogram area equality")
    public void checkParallelogramAreaEquality() {

        addPointsForValidTest();
        double actualArea = parallelogram.calculateArea();

        then(actualArea).isEqualTo(VALID_AREA);

        addPointsForInvalidTest();
        actualArea = parallelogram.calculateArea();

        then(actualArea).isEqualTo(INVALID_AREA);
    }

    @Test
    @DisplayName("check parallelogram perimeter equality")
    public void checkParallelogramPerimeterEquality() {

        addPointsForValidTest();
        double actualPerimeter = parallelogram.calculatePerimeter();

        then(actualPerimeter).isEqualTo(VALID_PERIMETER);

        addPointsForInvalidTest();
        actualPerimeter = parallelogram.calculatePerimeter();

        then(actualPerimeter).isEqualTo(INVALID_PERIMETER);
    }

    private void addPointsForValidTest() {
        points.clear();
        points.add(new Point(FIRST_VALID_COORDINATE_X, FIRST_VALID_COORDINATE_Y));
        points.add(new Point(SECOND_VALID_COORDINATE_X, SECOND_VALID_COORDINATE_Y));
        points.add(new Point(THIRD_VALID_COORDINATE_X, THIRD_VALID_COORDINATE_Y));
        points.add(new Point(FOURTH_VALID_COORDINATE_X, FOURTH_VALID_COORDINATE_Y));
        parallelogram = new Parallelogram(points);
    }

    private void addPointsForInvalidTest() {
        points.clear();
        points.add(new Point(FIRST_INVALID_COORDINATE_X, FIRST_INVALID_COORDINATE_Y));
        points.add(new Point(SECOND_INVALID_COORDINATE_X, SECOND_INVALID_COORDINATE_Y));
        points.add(new Point(THIRD_INVALID_COORDINATE_X, THIRD_INVALID_COORDINATE_Y));
        points.add(new Point(FOURTH_INVALID_COORDINATE_X, FOURTH_INVALID_COORDINATE_Y));
        parallelogram = new Parallelogram(points);
    }
}
