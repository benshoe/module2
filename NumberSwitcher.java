import javax.swing.*;

/**
 * This object shows a greeting and then asks the user to input two numbers. These will then be swapped,
 * altered and shown back to the user.
 *
 * The class is final as I don't think it should be subclassed.
 * Also, there are no getters and setters for the two properties m_first and m_second
 *
 * @author Ben Schoen<ben.schoen@online.liverpool.ac.uk>
 * @since 8 January 2016
 *
 */
public final class NumberSwitcher {

    /* this naming convention (starting a member with m_) is so natural to me that I find it hard to change it. */
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
            if(answer == null) { // This is true when no answer is entered. If Ok is clicked without entering anything then answer is not null but an empty String ("")
                String quitMessage = "You clicked on Cancel.\nWould you like to quit?";
                int confirmDialog = JOptionPane.showConfirmDialog(null, quitMessage, "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if(confirmDialog == JOptionPane.YES_OPTION) {
                    /* If the user clicks on 'Yes' when asked if the user wants to quit
                        we stop the execution of the program. 0 means that execution was without problems */
                    System.exit(0);
                }
            } else {
                message = "The number you entered is not valid.\nPlease, try again entering a valid whole number.";
            }
            return askForNumber(message, title); // I recursively call this same method until a valid number is entered or the user quits the program
        }
    }

    private void swapNumber() {
        /*
        In words you might say "first value becomes second and second value becomes first", but in a programming language
        this is not done that way, because as soon as first value is assigned the second value, the initial first value is no longer
        accessible. In other words, when a = 5 and b = 10 and we code:
        a = b; // here a gets the value 10, but the value 5 is gone
        b = a; // here we assign the value 10 to b which it already had.
        Therefore we introduce a temporary variable that holds the value of the first value before assigning it to the second value.
         */
        int temp = m_first;
        m_first = m_second;
        m_second = temp;

        m_first += 100;
        m_second += 50;

        String message = "The new value of first number is: " + m_first;
        displaySummary(message);
        message = "The new value of second number is: " + m_second;
        displaySummary(message);
    }

    private void displaySummary(String message) {
        JOptionPane.showMessageDialog(null, message, "Summary", JOptionPane.INFORMATION_MESSAGE);
    }
}
