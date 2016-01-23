import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ben on 23-01-16.
 */
public class ScheduleCalculatorTest {

    @Test
    public void testEmptyScheduleCalculator() {
        ScheduleCalculator calculator = new ScheduleCalculator();
        calculator.calculateSchedule("");

        Assert.assertEquals("09:00", calculator.getLongestNapStartTimeMessage());
        Assert.assertEquals("8 hours", calculator.getTotalFreeTimeMessage());

        calculator.calculateSchedule("09:00 17:00 'Very busy'");
        Assert.assertEquals("no", calculator.getLongestNapStartTimeMessage());
        Assert.assertEquals("0 hours", calculator.getTotalFreeTimeMessage());
    }


    @Test
    public void testCalculateSchedule() throws Exception {
        ScheduleCalculator calculator = new ScheduleCalculator();
        calculator.calculateSchedule("09:00 10:00 'Rounds' 10:15 11:00 'Ward inspection' 11:30 12:00 'Patients' 13:00 15:00 'Patients' 15:30 16:30 'Reading'");
    }
}