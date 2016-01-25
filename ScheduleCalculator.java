import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 23-01-16.
 */
public class ScheduleCalculator {

    private static final int MINUTES_BETWEEN_9_17 = 480;
    private static final String STARTTIME = "09:00";
    private static final String ENDTIME = "17:00";

    private String m_napStartTime;
    private int m_napDuration;
    private int m_totalBusyTime;

    public void calculateSchedule(String totalSchedule) {
        if(totalSchedule == null || "".equals(totalSchedule)) {
            setNapDuration(STARTTIME, MINUTES_BETWEEN_9_17);
            addToTotalBusyTime(0);
            return;
        }
        List<String> times = createTimeList(totalSchedule);

        if(!times.contains(STARTTIME)) {
            int minutes = DurationCalculator.calculateDuration(STARTTIME, times.get(0));
            setNapDuration(STARTTIME, minutes);
        }

        boolean appointment = true; // The first two items in the list are an appointment, then the 2nd and 3rd items are the possible nap time between two appointments
        for (int i = 0; i < times.size() - 1; i++) {
            String start = times.get(i);
            String end = times.get(i + 1);
            int minutesDuration = DurationCalculator.calculateDuration(start, end);
            if(appointment) {
                addToTotalBusyTime(minutesDuration);
            } else {
                setNapDuration(start, minutesDuration);
            }
            appointment = !appointment;
        }

        if(!times.contains(ENDTIME)) {
            String lastEndTime = times.get(times.size() - 1);
            int minutes = DurationCalculator.calculateDuration(lastEndTime, ENDTIME);
            setNapDuration(lastEndTime, minutes);
        }
    }

    private List<String> createTimeList(String totalSchedule) {
        List<String> timeList = new ArrayList<>();

        String[] appointments = totalSchedule.split("'");
        for (int i = 0; i < appointments.length; i += 2) {
            String[] times = appointments[i].trim().split(" ");
            timeList.add(times[0]);
            timeList.add(times[1]);
        }

        return timeList;
    }

    private void addToTotalBusyTime(int minutes) {
        m_totalBusyTime += minutes;
    }

    public String getNapStartTime() {
        return m_napStartTime == null ? "none" : m_napStartTime;
    }

    private void setNapDuration(String startTime, int duration) {
        if(duration > m_napDuration) {
            m_napDuration = duration;
            m_napStartTime = startTime;
        }
    }

    public int getNapDuration() {
        return m_napDuration;
    }

    public int getTotalFreeTime() {
        return MINUTES_BETWEEN_9_17 - m_totalBusyTime;
    }

}
