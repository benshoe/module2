import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for DurationCalculator
 *
 * @author Ben Schoen<ben.schoen@online.liverpool.ac.uk>
 * @since 24 January 2016
 */
public class DurationCalculatorTest {

    @Test
    public void testCalculateDuration() throws Exception {
        Assert.assertEquals(DurationCalculator.calculateDuration("09:00", "10:00"), 60);
        Assert.assertEquals(DurationCalculator.calculateDuration("09:15", "09:45"), 30);
        Assert.assertEquals(DurationCalculator.calculateDuration("09:25", "09:45"), 20);
        Assert.assertEquals(DurationCalculator.calculateDuration("09:30", "10:45"), 75);
        Assert.assertEquals(DurationCalculator.calculateDuration("09:00", "17:00"), 480);
        Assert.assertEquals(DurationCalculator.calculateDuration("09:13", "11:11"), 118);
        Assert.assertEquals(DurationCalculator.calculateDuration("09:15", "10:14"), 59);
        Assert.assertEquals(DurationCalculator.calculateDuration("09:59", "10:01"), 2);
        Assert.assertEquals(DurationCalculator.calculateDuration("09:59", "09:59"), 0);
        Assert.assertEquals(DurationCalculator.calculateDuration("9:59", "9:59"), 0);
    }
}