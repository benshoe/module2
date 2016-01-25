/**
 * Created by ben on 23-01-16.
 */
public final class DurationCalculator {

//    private int minutes;

    private DurationCalculator() {
//        calculateDuration(startTime, endTime);
    }

//    public int getMinutesDuration() {
//        return minutes;
//    }

    public static int calculateDuration(String startTime, String endTime) {
        String[] startHoursMinutes = startTime.split(":");
        if(startHoursMinutes.length != 2) {
            throw new IllegalArgumentException("The start time is not in the format hh:mm");
        }
        int startHours = Integer.valueOf(startHoursMinutes[0]);
        int startMinutes = Integer.valueOf(startHoursMinutes[1]);

        String[] endHoursMinutes = endTime.split(":");
        if(endHoursMinutes.length != 2) {
            throw new IllegalArgumentException("The end time is not in the format hh:mm");
        }

        int endHours = Integer.valueOf(endHoursMinutes[0]);
        int endMinutes = Integer.valueOf(endHoursMinutes[1]);

        int totalMinutes = endMinutes - startMinutes;
        int totalHours = endHours - startHours;
        int hours = totalMinutes < 0 ? totalHours - 1 : totalHours;
        int minutes = hours * 60;
        minutes += totalMinutes < 0 ? 60 + totalMinutes : totalMinutes;
        return minutes;
    }

}
