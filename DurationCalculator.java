// start of the DurationCalculator
/**
 * This is the class that calculates the duration in minutes
 *
 * It is a final class with a private constructor, because the user should not
 * instantiate this class, but only use the calculateDuration method
 *
 * @author Ben Schoen<ben.schoen@online.liverpool.ac.uk>
 * @since 24 January 2016
 */
final class DurationCalculator {

    /** private constructor so we know that users cannot create an instance of this class */
    private DurationCalculator() {}

    /**
     * Provide this method with two string parameters and the difference in minutes will be returned
     * @param startTime format hh:mm
     * @param endTime format hh:mm
     * @return minutes in int
     */
    public static int calculateDuration(String startTime, String endTime) {
        String[] startHoursMinutes = startTime.split(":"); // Since the format is hh:mm, we can use String.split(":")
        checkTimeFormat(startHoursMinutes, "The start time is not in the format hh:mm");
        int startHours = Integer.valueOf(startHoursMinutes[0]);
        int startMinutes = Integer.valueOf(startHoursMinutes[1]);

        String[] endHoursMinutes = endTime.split(":");
        checkTimeFormat(endHoursMinutes, "The end time is not in the format hh:mm");
        int endHours = Integer.valueOf(endHoursMinutes[0]);
        int endMinutes = Integer.valueOf(endHoursMinutes[1]);

        int totalMinutes = endMinutes - startMinutes;
        int totalHours = endHours - startHours;
        return totalHours * 60 + totalMinutes;
    }

    private static void checkTimeFormat(String[] hoursMinutes, String s) {
        if (hoursMinutes.length != 2) {
            throw new IllegalArgumentException(s);
        }
    }

}
// end of the DurationCalculator