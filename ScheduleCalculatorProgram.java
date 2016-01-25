import javax.swing.*;

/**
 * Created by ben on 23-01-16.
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
        String message = "This program lets you enter a schedule starting at 9:00 and finishing at 17:00.";
        message += "\nYou will get a response with the time at which you can take your longest nap and";
        message += "\nthe total free time you will have available during this day.";
        JOptionPane.showMessageDialog(null, message, "Schedule calculator", JOptionPane.INFORMATION_MESSAGE);

        String answer = JOptionPane.showInputDialog(null, "Enter the schedule", "Schedule calculator", JOptionPane.QUESTION_MESSAGE);

        ScheduleCalculator scheduleCalculator = new ScheduleCalculator();
        scheduleCalculator.calculateSchedule(answer);

        String napMessage = scheduleCalculator.getNapStartTime();
        int totalFreeTime = scheduleCalculator.getTotalFreeTime();
        String freeTimeMessage = getHoursAndMinutes(totalFreeTime);
        message = napMessage + "\n\n" + freeTimeMessage;
        JOptionPane.showMessageDialog(null, message, "Your schedule for the day", JOptionPane.INFORMATION_MESSAGE);
    }

    private String getHoursAndMinutes(int totalFreeTime) {
        int hours = totalFreeTime / 60;
        int minutes = totalFreeTime % 60;
        return hours == 0 ? minutes + " minutes" : hours + " hours and " + minutes + " minutes";
    }
}
