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

        Assert.assertEquals("09:00", calculator.getNapStartTime());
        Assert.assertEquals(480, calculator.getTotalFreeTime());
        Assert.assertEquals(480, calculator.getNapDuration());

        calculator = new ScheduleCalculator();
        calculator.calculateSchedule("09:00 17:00 'Very busy'");
        Assert.assertEquals("none", calculator.getNapStartTime());
        Assert.assertEquals(0, calculator.getTotalFreeTime());
        Assert.assertEquals(0, calculator.getNapDuration());
    }


    @Test
    public void testCalculateSchedule() throws Exception {
        ScheduleCalculator calculator = new ScheduleCalculator();
        calculator.calculateSchedule("09:00 10:00 'Rounds' 10:15 11:00 'Ward inspection' 11:30 12:00 'Patients' 13:00 15:00 'Patients' 15:30 16:30 'Reading'");
        // 10:00 - 10:15 + 11:00 - 11:30 + 12:00 - 13:00 + 15:00 - 15:30 + 16:30 - 17:00
        //      15       +       30      +       60      +       30      +       30      = 165 minutes
        Assert.assertEquals("12:00", calculator.getNapStartTime());
        Assert.assertEquals(60, calculator.getNapDuration());
        Assert.assertEquals(165, calculator.getTotalFreeTime());
    }

    @Test
    public void testExample1() throws Exception {
        ScheduleCalculator calculator = new ScheduleCalculator();
        calculator.calculateSchedule("9:00 9:45 'Ward inspection' 10:00 11:30 'Patients' 12:00 13:00 'Lunch' 13:00 15:00 'Meeting' 16:30 17:00 'Reading'");
        Assert.assertEquals("15:00", calculator.getNapStartTime());
        Assert.assertEquals(90, calculator.getNapDuration());
        Assert.assertEquals(135, calculator.getTotalFreeTime());
    }

    @Test
    public void testExample2() throws Exception {
        ScheduleCalculator calculator = new ScheduleCalculator();
        calculator.calculateSchedule("12:00 13:00 'Lunch invitation'");
        Assert.assertEquals("13:00", calculator.getNapStartTime());
        Assert.assertEquals(240, calculator.getNapDuration());
        Assert.assertEquals(420, calculator.getTotalFreeTime());
    }

    @Test
    public void testExample3() throws Exception {
        ScheduleCalculator calculator = new ScheduleCalculator();
        calculator.calculateSchedule("9:00 12:00 'Patients' 12:00 13:00 'Lunch' 13:00 16:00 'Operation theatre' 16:30 17:00 'Discussion'");
        Assert.assertEquals("16:00", calculator.getNapStartTime());
        Assert.assertEquals(30, calculator.getNapDuration());
        Assert.assertEquals(30, calculator.getTotalFreeTime());
    }
}