package com.github.yelqo17.shapes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class TruncatedSphereEqualsShapesTest {
    private static final List<Point> points = new ArrayList<>();
    private static final TruncatedSphere truncatedSphere = new TruncatedSphere(points);

    @Test
    @DisplayName("check truncated sphere validation")
    public void checkTruncatedSphereValidation() {

        addPointsForValidTest();
        boolean isValid = truncatedSphere.validate();

        then(isValid).isEqualTo(true);

        addPointsForInvalidTest();
        isValid = truncatedSphere.validate();

        then(isValid).isEqualTo(false);
    }

    @Test
    @DisplayName("check truncated sphere area equality")
    public void checkTruncatedSphereAreaEquality() {

        addPointsForValidTest();
        double actualArea = truncatedSphere.calculateArea();

        then(actualArea).isEqualTo(9.42);

        addPointsForInvalidTest();
        actualArea = truncatedSphere.calculateArea();

        then(actualArea).isEqualTo(-3.14);
    }

    private void addPointsForValidTest() {
        points.clear();
        points.add(new Point(0, 0, 0));
        points.add(new Point(1, 0, 0));
        points.add(new Point(0, 0, 1));
    }

    private void addPointsForInvalidTest() {
        points.clear();
        points.add(new Point(0, 0, 0));
        points.add(new Point(0, 0, 0));
        points.add(new Point(0, 0, 1));
    }
}
