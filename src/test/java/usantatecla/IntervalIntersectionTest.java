package usantatecla;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(Parameterized.class)
public class IntervalIntersectionTest {

    private String name;
    private Point left;
    private Point right;
    private Point leftToCompare;
    private Point rightToCompare;
    private boolean expectedIsIntersected;

    public IntervalIntersectionTest(String name, Point left, Point right, Point leftToCompare, Point rightToCompare, boolean expectedIsIntersected) {
        this.name = name;
        this.left = left;
        this.right = right;
        this.leftToCompare = leftToCompare;
        this.rightToCompare = rightToCompare;
        this.expectedIsIntersected = expectedIsIntersected;
    }

    @Parameterized.Parameters(name = "(Test {0}: Interval({1}, {2}) | IntervalToCompare({3}, {4}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"This Interval contains MIN parameter", point(1), point(5), point(2), point(8), true}
        });
    }

    @Test
    public void givenIntervalOpenOpenTestIsIntersected() {
        Interval interval = new IntervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
        Interval intervalToCompare = new IntervalBuilder().open(leftToCompare.getEquals()).open(rightToCompare.getEquals()).build();
        assertThat(interval.isIntersected(intervalToCompare), is(expectedIsIntersected));
    }

    private static Point point(double value) {
        return new Point(value);
    }
}
