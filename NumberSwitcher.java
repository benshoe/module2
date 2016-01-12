import javax.swing.*;

/**
 * This object shows a greeting and then asks the user to input two numbers. These will then be swapped,
 * altered and shown back to the user.
 *
 * @author Ben Schoen<ben.schoen@online.liverpool.ac.uk>
 * @since 8 January 2016
 *
 */
public final class NumberSwitcher {

    private int m_first;
    private int m_second;

    /**
     * Because it doesn't make a lot of sense to run the dialogs in a different order I chose
     * to make the methods private and have them run in a fixed order by the run() method.
     * <ol>
     *     <li>The user is greeted</li>
     *     <li>A first number is asked</li>
     *     <li>A second number is asked</li>
     *     <li>The numbers are swapped and 100 resp. 50 is added to the numbers and displayed</li>
     * </ol>
     */
    public void run() {
        greeting();
        getFirstNumber();
        getSecondNumber();
        swapNumber();
    }

    private void greeting() {
        String message = "Welcome to my program!";
        JOptionPane.showMessageDialog(null, message, "Welcome!", JOptionPane.PLAIN_MESSAGE);
    }

    private void getFirstNumber() {
        m_first = askForNumber("Please, input a first whole number.", "First number?");
    }

    private void getSecondNumber() {
        m_second = askForNumber("Please, input a second whole number.", "Second number?");
    }

    private int askForNumber(String message, String title) {
        String answer = JOptionPane.showInputDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
        try {
            return Integer.parseInt(answer);
        } catch (NumberFormatException e) {
            if(answer == null) {
                message = "You clicked on Cancel.\nWould you like to quit?";
                int confirmDialog = JOptionPane.showConfirmDialog(null, message, "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if(confirmDialog == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                message = "Please, try again entering a valid whole number.";
            } else {
                message = "The number you entered is not valid.\nPlease, try again entering a valid whole number.";
            }
            return askForNumber(message, title);
        }
    }

    private void swapNumber() {
        int temp = m_first;
        m_first = m_second;
        m_second = temp;

        m_first += 100;
        m_second += 50;
        String message = "The new value of first number is: " + m_first;
        JOptionPane.showMessageDialog(null, message, "Summary", JOptionPane.INFORMATION_MESSAGE);
        message = "The new value of the second number is: " + m_second;
        JOptionPane.showMessageDialog(null, message, "Summary", JOptionPane.INFORMATION_MESSAGE);
    }
}
