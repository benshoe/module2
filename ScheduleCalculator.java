/**
 * Created by ben on 23-01-16.
 */
public class ScheduleCalculator {

    private String longestNapStartTimeMessage;
    private String longestNapDuration;
    private String totalFreeTimeMessage;

    private static final String STARTTIME = "09:00";
    private static final String ENDTIME = "17:00";

    public void calculateSchedule(String totalSchedule) {
        if(totalSchedule.length() == 0) {
            setLongestNapStartTimeMessage(STARTTIME, "8 hours and 0 minutes.");
            setTotalFreeTimeMessage("8 hours and 0 minutes.");
            return;
        }
        String[] appointments = totalSchedule.split("'");
        /* Now we have an array with every even number containing the start and end time
        and every odd number containing the appointment description
         */

        String[] times = appointments[0].split(" ");

        DurationCalculator durationCalculator = new DurationCalculator(STARTTIME, times[0]);
        int hours = durationCalculator.getHoursDuration();
        int minutes = durationCalculator.getMinutesDuration();

        longestNapDuration = hours > 0 ? hours + " hours and " + minutes + " minutes" : minutes + " minutes";
        longestNapStartTimeMessage = STARTTIME;

        for(int i = 0; i < appointments.length; i += 3) {
            durationCalculator = new DurationCalculator(appointments[i], appointments[i + 1]);
            durationCalculator.getHoursDuration();
            durationCalculator.getMinutesDuration();
        }
    }

    private void setLongestNapStartTimeMessage(String napStartTime, String napDuration) {
        longestNapStartTimeMessage = "Schedule of the day:\n\nYou can take a longest nap at " + napStartTime + " and it will last for " + napDuration;
    }

    public String getLongestNapStartTimeMessage() {
        return longestNapStartTimeMessage;
    }

    private void setTotalFreeTimeMessage(String totalFreeTime) {
        totalFreeTimeMessage = "Total free time during whole day is " + totalFreeTime;
    }

    public String getTotalFreeTimeMessage() {
        return totalFreeTimeMessage;
    }

}
