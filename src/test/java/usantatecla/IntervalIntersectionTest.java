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
    private boolean expectedIsIntersectedOpen;
    private boolean expectedIsIntersectedClose;

    public IntervalIntersectionTest(String name, Point left, Point right, Point leftToCompare, Point rightToCompare,
                                    boolean expectedIsIntersectedOpen, boolean expectedIsIntersectedClose) {
        this.name = name;
        this.left = left;
        this.right = right;
        this.leftToCompare = leftToCompare;
        this.rightToCompare = rightToCompare;
        this.expectedIsIntersectedOpen = expectedIsIntersectedOpen;
        this.expectedIsIntersectedClose = expectedIsIntersectedClose;
    }

    @Parameterized.Parameters(name = "(Test {0}: Interval({1}, {2}) | IntervalToCompare({3}, {4}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "This Interval contains leftToCompare", point(1), point(5), point(2), point(8), true, true },
                { "This Interval contains rightToCompare", point(1), point(5), point(-1), point(3), true, true },
                { "This Interval is in IntervalToCompare", point(3), point(5), point(1), point(8), true, true },
                { "This Interval is in IntervalToCompare with same left", point(3), point(5), point(3), point(8), true, true },
                { "This Interval's left has same IntervalToCompare's right", point(5), point(8), point(3), point(5), false, true },
                { "This Interval's left and right has same IntervalToCompare's left and right", point(5), point(8), point(5), point(8), true, true }
        });
    }

    @Test
    public void givenIntervalOpenOpenTestIsIntersected() {
        Interval interval = new IntervalBuilder().open(left.getEquals()).open(right.getEquals()).build();
        Interval intervalToCompare = new IntervalBuilder().open(leftToCompare.getEquals()).open(rightToCompare.getEquals()).build();
        assertThat(interval.isIntersected(intervalToCompare), is(expectedIsIntersectedOpen));
    }

    @Test
    public void givenIntervalCloseCloseTestIsIntersected() {
        Interval interval = new IntervalBuilder().closed(left.getEquals()).closed(right.getEquals()).build();
        Interval intervalToCompare = new IntervalBuilder().open(leftToCompare.getEquals()).open(rightToCompare.getEquals()).build();
        assertThat(interval.isIntersected(intervalToCompare), is(expectedIsIntersectedClose));
    }

    private static Point point(double value) {
        return new Point(value);
    }
}
