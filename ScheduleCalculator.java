// start of the ScheduleCalculator
import java.util.ArrayList;
import java.util.List;

/**
 * This is the class that will parse the string and calculate the nap start time, nap duration and total free time
 *
 * The input must be in the following format separated by spaces and the appointment surrounded by a single quote (')
 * the format may be repeated as many times as wanted.
 * The first time may not be earlier than 09:00
 * The latest time may not exceed 17:00
 *
 * hh:mm hh:mm 'appointment 1'
 *
 * @author Ben Schoen<ben.schoen@online.liverpool.ac.uk>
 * @since 20 January 2016
 */
class ScheduleCalculator {

    private static final int MINUTES_BETWEEN_9_17 = 480;
    private static final String STARTTIME = "09:00";
    private static final String ENDTIME = "17:00";

    private String m_napStartTime;
    private int m_napDuration;
    private int m_totalBusyTime;

    public void calculateSchedule(String totalSchedule) {
        // If the string is empty, we assume that the whole day will be available to nap
        if(totalSchedule == null || "".equals(totalSchedule)) {
            setNapDuration(STARTTIME, MINUTES_BETWEEN_9_17);
            addToTotalBusyTime(0);
            return;
        }

        // Create a list with all the times from the totalSchedule
        List<String> times = createTimeList(totalSchedule);

        // If the schedule does not contain 09:00
        // then we calculate the time from 09:00 until the first time in the list.
        // This will be the first nap time of the day.
        if(!times.contains(STARTTIME)) {
            int minutes = DurationCalculator.calculateDuration(STARTTIME, times.get(0));
            setNapDuration(STARTTIME, minutes);
        }

        // The first two items in the list are an appointment, then the 2nd and 3rd items are the possible nap time between two appointments
        // Or in other words, every odd item in the list is the start of an appointment and every even item is the end time
        // We go through the whole list one item at a time and use the following item to calculate the duration.
        // The following boolean appointment is used to determine whether the duration calculated is nap time or busy time (appointment)
        boolean appointment = true;
        for (int i = 0; i < times.size() - 1; i++) {
            String start = times.get(i);
            String end = times.get(i + 1);
            int minutesDuration = DurationCalculator.calculateDuration(start, end);
            if(appointment) {
                addToTotalBusyTime(minutesDuration); // This is an appointment so the minutes are added to the busy time
            } else {
                setNapDuration(start, minutesDuration); // This is a pause between appointments so added to the napduration
            }
            appointment = !appointment; // We toggle the boolean here
        }

        // If the schedule does not contain 17:00
        // then we calculate the time from the last item in the list until 17:00.
        // This will then be the possible latest nap time of the day.
        if(!times.contains(ENDTIME)) {
            String lastEndTime = times.get(times.size() - 1);
            int minutes = DurationCalculator.calculateDuration(lastEndTime, ENDTIME);
            setNapDuration(lastEndTime, minutes);
        }
    }

    /**
     * This method splits the totalSchedule string into parts and returns the time segments ordered as per the input
     *
     * We expext the string to be
     *
     * @param totalSchedule
     * @return A list containing all the times
     */
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
        return m_napStartTime;
    }

    /*
    This method will be called every time a possible nap time is found.
    In this method the decision is made if the offered nap time is larger than
    the one present currently.
    If the duration of a second nap time is equal to the one currently stored, the
    first one will be kept and the second one discarded.
     */
    private void setNapDuration(String startTime, int duration) {
        if(duration > m_napDuration) {
            m_napDuration = duration;
            m_napStartTime = startTime;
        }
    }

    public int getNapDuration() {
        return m_napDuration;
    }

    // for the total free time I did not create a field, because it is calculated by the following formula
    public int getTotalFreeTime() {
        return MINUTES_BETWEEN_9_17 - m_totalBusyTime;
    }

}
// end of the ScheduleCalculator