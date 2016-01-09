import javax.swing.*;
import java.math.BigInteger;

/**
 * This object shows a greeting and then asks the user to input two numbers. These will then be swapped,
 * altered and shown back to the user.
 *
 * @author Ben Schoen<ben.schoen@online.liverpool.ac.uk>
 * @since 8 January 2016
 *
 */
public final class NumberSwitcher {

    private BigInteger m_first;
    private BigInteger m_second;

    /**
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

    private BigInteger askForNumber(String message, String title) {
        String answer = JOptionPane.showInputDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
        try {
            return new BigInteger(answer);
        } catch (NumberFormatException e) {
            message = "The number you entered is not valid.\nPlease, try again entering a valid whole number.";
            return askForNumber(message, title);
        } catch (Exception e) {
            return askForNumber(message, title);
        }
    }

    private void swapNumber() {
        BigInteger temp = m_first;
        m_first = m_second;
        m_second = temp;

        BigInteger first = m_first.add(new BigInteger("100")); // Because BigInteger is immutable it must be assigned to a new object
        BigInteger second = m_second.add(new BigInteger("50"));
        String message = "The new value of first number is: " + first;
        JOptionPane.showMessageDialog(null, message, "Summary", JOptionPane.INFORMATION_MESSAGE);
        message = "The new value of the second number is: " + second;
        JOptionPane.showMessageDialog(null, message, "Summary", JOptionPane.INFORMATION_MESSAGE);
    }
}
