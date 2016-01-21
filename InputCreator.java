import javax.swing.*;
import java.math.BigDecimal;

/**
 * This class contains two methods to easily create dialog boxes with two different inputs
 *
 * One dialog box asks for a positive integer and the other for a positive decimal number where
 * the number of decimals can be set.
 *
 * When the need arises for more input dialogs or with different settings, the class may be altered
 * to support an easier use of the class with less parameters. Maybe the Builder Pattern will be used then.
 *
 * @author Ben Schoen<ben.schoen@online.liverpool.ac.uk>
 * @since 20 January 2016
 */
public class InputCreator {

    public static final String NEGATIVE_NUMBER_ENTERED = "You entered a negative number.";

    /**
     * An input dialog is shown which asks for a whole number
     * @param message which will be displayed to the user
     * @param title of the dialog window
     * @return the integer that the user entered
     */
    public static int askForPositiveInteger(String message, String title) {
        String answer = JOptionPane.showInputDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
        if(answer == null) { // This is true when no answer is entered. If Ok is clicked without entering anything then answer is not null but an empty String ("")
            confirmQuit();
            return askForPositiveInteger(message, title);
        }
        try {
            int i = Integer.parseInt(answer);
            if(i < 0) {
                throw new NumberFormatException(NEGATIVE_NUMBER_ENTERED);
            }
            return i;
        } catch (NumberFormatException e) {
            message = getExtraInfo(e) + "Please, try again entering a positive whole number.";
            return askForPositiveInteger(message, title); // I recursively call this same method until a valid number is entered or the user quits the program
        }
    }

    public static BigDecimal askForPositiveDecimalNumber(String message, String title, Integer numberOfDecimals) {
        String answer = JOptionPane.showInputDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
        if(answer == null) { // This is true when no answer is entered. If Ok is clicked without entering anything then answer is not null but an empty String ("")
            confirmQuit();
            return askForPositiveDecimalNumber(message, title, numberOfDecimals);
        }
        try {
            BigDecimal bigDecimal = new BigDecimal(answer);
            if(bigDecimal.signum() == -1) { // If the number is negative we throw an exception
                throw new NumberFormatException(NEGATIVE_NUMBER_ENTERED);
            }
            if(numberOfDecimals != null && bigDecimal.scale() > numberOfDecimals) {
                throw new NumberFormatException("You entered " + bigDecimal.scale() + " decimals while the maximum is " + numberOfDecimals + ".");
            }
            return bigDecimal;
        } catch (NumberFormatException e) {
            message = getExtraInfo(e) + "Please, try again entering a positive decimal number.";
            return askForPositiveDecimalNumber(message, title, numberOfDecimals);
        }
    }

    private static String getExtraInfo(NumberFormatException e) {
        if(e.getMessage() != null && !e.getMessage().contains("For input string")) { // I could have created a new Exception type, but didn't see the value of it now
            return e.getMessage() + "\n";
        }
        return "The number you entered is not valid.\n";
    }

    private static void confirmQuit() {
        String quitMessage = "You clicked on Cancel.\nWould you like to quit?";
        int confirmDialog = JOptionPane.showConfirmDialog(null, quitMessage, "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(confirmDialog == JOptionPane.YES_OPTION) {
                /* If the user clicks on 'Yes' when asked if the user wants to quit
                    we stop the execution of the program. 0 means that execution was without problems */
            System.exit(0);
        }
    }

}
