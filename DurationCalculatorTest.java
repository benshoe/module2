import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ben on 23-01-16.
 */
public class DurationCalculatorTest {

    @Test
    public void testCalculateDuration() throws Exception {
        DurationCalculator durationCalculator = new DurationCalculator("09:00", "10:00");
        Assert.assertEquals(durationCalculator.getHoursDuration(), 1);
        Assert.assertEquals(durationCalculator.getMinutesDuration(), 0);

        durationCalculator = new DurationCalculator("09:15", "09:45");
        assertEquals(durationCalculator.getHoursDuration(), 0);
        assertEquals(durationCalculator.getMinutesDuration(), 30);

        durationCalculator = new DurationCalculator("09:25", "09:45");
        assertEquals(durationCalculator.getHoursDuration(), 0);
        assertEquals(durationCalculator.getMinutesDuration(), 20);

        durationCalculator = new DurationCalculator("09:30", "10:45");
        assertEquals(durationCalculator.getHoursDuration(), 1);
        assertEquals(durationCalculator.getMinutesDuration(), 15);

        durationCalculator = new DurationCalculator("09:00", "17:00");
        assertEquals(durationCalculator.getHoursDuration(), 8);
        assertEquals(durationCalculator.getMinutesDuration(), 0);

        durationCalculator = new DurationCalculator("09:13", "11:11");
        assertEquals(durationCalculator.getHoursDuration(), 1);
        assertEquals(durationCalculator.getMinutesDuration(), 58);

        durationCalculator = new DurationCalculator("09:15", "10:14");
        assertEquals(durationCalculator.getHoursDuration(), 0);
        assertEquals(durationCalculator.getMinutesDuration(), 59);

    }
}