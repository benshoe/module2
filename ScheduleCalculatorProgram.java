// start of the ScheduleCalculatorProgram
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the class to run and test the ScheduleCalculator
 *
 * The run method handles the input and output with the user.
 * I have chosen to create the final messages in this class and have
 * the ScheduleCalculator return the time in minutes.
 *
 * The entire application uses only minutes.
 *
 * @author Ben Schoen<ben.schoen@online.liverpool.ac.uk>
 * @since 20 January 2016
 */
public class ScheduleCalculatorProgram {

    public static void main(String[] args) {
        setLookAndFeel();
        ScheduleCalculatorProgram program = new ScheduleCalculatorProgram();
        program.run();
    }

    /**
     * This method forces the Nimbus Look and Feel to be loaded
     */
    private static void setLookAndFeel() {
        final UIManager.LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
        for(int i = installedLookAndFeels.length - 1; i >=0; i--) {
            if(installedLookAndFeels[i].getName().equals("Nimbus")) {
                try {
                    UIManager.setLookAndFeel(installedLookAndFeels[i].getClassName());
                } catch(Exception e) {
                    e.printStackTrace();
                    System.out.println("Too bad, it is not possible to set the LookAndFeel to Nimbus. We'll use the default then.");
                }
            }
        }
    }

    private void run() {
        StringBuilder message = createWelcomeMessage();
        JOptionPane.showMessageDialog(null, message, "Schedule calculator", JOptionPane.INFORMATION_MESSAGE);

        String answer = JOptionPane.showInputDialog(null, "Enter the schedule", "Schedule calculator", JOptionPane.QUESTION_MESSAGE);

        ScheduleCalculator scheduleCalculator = new ScheduleCalculator();
        scheduleCalculator.calculateSchedule(answer);

        message = new StringBuilder("Based on the schedule you provided: ");
        message.append("\n");
        message.append(answer == null || "".equals(answer) ? "You didn't enter anything. So I'll assume your schedule is empty." : answer);
        message.append("\n\n");
        message.append(getNapMessage(scheduleCalculator));
        message.append("\n\n");
        message.append(getFreeTimeMessage(scheduleCalculator));

        JOptionPane.showMessageDialog(null, message, "Your schedule for the day", JOptionPane.INFORMATION_MESSAGE);
    }

    private StringBuilder createWelcomeMessage() {
        StringBuilder message = new StringBuilder("This program lets you enter a schedule starting at 9:00 and finishing at 17:00.");
        message.append("\nPlease, enter the schedule in format: hh:mm hh:mm 'appointment' etc.");
        message.append("\nE.g., 9:00 9:45 'Ward inspection' 10:00 11:30 'Patients' 12:00 13:00 'Lunch' 13:00 15:00 'Meeting' 16:30 17:00 'Reading'");
        message.append("\n\nYou will get a response with the time at which you can take your longest nap and");
        message.append("\nthe total free time you will have available during this day.");
        message.append("\n\nHave a nice day and I hope you'll enjoy your nap!");
        return message;
    }

    private String getFreeTimeMessage(ScheduleCalculator scheduleCalculator) {
        return "Your total free time during the day is " + getHoursAndMinutes(scheduleCalculator.getTotalFreeTime()) + ".";
    }

    private String getNapMessage(ScheduleCalculator scheduleCalculator) {
        String napStartTime = scheduleCalculator.getNapStartTime();
        if(napStartTime == null) {
            return "You're busy all day and will have no time for a nap.\nAll the best for today, better luck tomorrow!";
        }
        return "You can take the longest nap at " + napStartTime + " and it will last for " + getHoursAndMinutes(scheduleCalculator.getNapDuration()) + ".";
    }

    private String getHoursAndMinutes(int totalFreeTime) {
        int hours = totalFreeTime / 60;
        int minutes = totalFreeTime % 60;
        return hours == 0 ? minutes + " minutes" : hours + " hours and " + minutes + " minutes";
    }
}
// end of ScheduleCalculatorProgram