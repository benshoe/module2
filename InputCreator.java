import javax.swing.*;
import java.math.BigDecimal;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/20/16.
 */
public class InputCreator {

    /**
     * An input dialog is shown which asks for a whole number
     * @param message
     * @param title
     * @return
     */
    public static int askForPositiveInteger(String message, String title) {
        String answer = JOptionPane.showInputDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
        try {
            int i = Integer.parseInt(answer);
            if(i < 0) {
                throw new NumberFormatException();
            }
            return i;
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
                message = "The number you entered is not valid.\nPlease, try again entering a positive valid whole number.";
            }
            return askForPositiveInteger(message, title); // I recursively call this same method until a valid number is entered or the user quits the program
        }
    }

    public static BigDecimal askForPositiveDecimalNumber(String message, String title) {
        String answer = JOptionPane.showInputDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
        if(answer == null) { // This is true when no answer is entered. If Ok is clicked without entering anything then answer is not null but an empty String ("")
            String quitMessage = "You clicked on Cancel.\nWould you like to quit?";
            int confirmDialog = JOptionPane.showConfirmDialog(null, quitMessage, "Are you sure?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if(confirmDialog == JOptionPane.YES_OPTION) {
                    /* If the user clicks on 'Yes' when asked if the user wants to quit
                        we stop the execution of the program. 0 means that execution was without problems */
                System.exit(0);
            }
            return askForPositiveDecimalNumber(message, title);
        }
        try {
            BigDecimal bigDecimal = new BigDecimal(answer);
            if(bigDecimal.signum() == -1) { //If the number is negative we throw an exception
                throw new NumberFormatException();
            }
            return bigDecimal;

        } catch (NumberFormatException e) {
            message = "The number you entered is not valid.\nPlease, try again entering a valid positive decimal number.";
        }
        return askForPositiveDecimalNumber(message, title); // I recursively call this same method until a valid number is entered or the user quits the program
    }

}
