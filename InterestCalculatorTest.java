// start of InterestCalculatorTest.java
import javax.swing.*;
import javax.swing.UIManager.*;
import java.math.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * This is the class to run and test the InterestCalculator
 *
 * @author Ben Schoen<ben.schoen@online.liverpool.ac.uk>
 * @since 20 January 2016
 */
public class InterestCalculatorTest {

    private BigDecimal m_startAmount;
    private BigDecimal m_interest;
    private int m_periods;

    public static void main(String[] args) {
		setLookAndFeel();

		InterestCalculatorTest interestCalculatorTest = new InterestCalculatorTest();
		interestCalculatorTest.run();
	}

    /**
     * This method forces the Nimbus Look and Feel to be loaded
     */
	private static void setLookAndFeel() {
		final LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
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

    /**
     * This method handles all input and output
     */
	private void run() {
        // Let's start with a welcome message, so the user knows what is happening
        StringBuilder welcomeMessage = new StringBuilder();
        welcomeMessage.append("This program will calculate the total accrued amount you will save, based on some questions.\n\n");
        welcomeMessage.append("You will be asked to input the initial amount, \n");
        welcomeMessage.append("then the rate of interest, \n");
        welcomeMessage.append("and finally the number of periods you wish to save your money.\n\n");
        welcomeMessage.append("You will then be presented with the result.\n\n");
        welcomeMessage.append("Should you wish to leave the program, just click on 'Cancel' on each of the windows you are presented with.\n");
        JOptionPane.showMessageDialog(null, welcomeMessage.toString(), "Welcome to the Interest Calculator by Ben Schoen", JOptionPane.INFORMATION_MESSAGE);

        m_startAmount = InputCreator.askForPositiveDecimalNumber("What is your start amount?", "Start amount", new Integer("2"));
        m_interest = InputCreator.askForPositiveDecimalNumber("What is the rate of interest per period?\nPlease, enter without the '%' sign, but as 3.575 for 3.575%", "Rate of interest", null).divide(new BigDecimal(100));
        m_periods = InputCreator.askForPositiveInteger( "How many periods would you like to calculate?", "Number of periods");

        InterestCalculator interestCalculator = new InterestCalculator();
        interestCalculator.setPrincipalAmount(m_startAmount);
        interestCalculator.setRateOfInterest(m_interest);
        interestCalculator.setPeriods(m_periods);
        StringBuilder sb = getResultMessage();
        sb.append(DecimalFormat.getCurrencyInstance().format(interestCalculator.getTotalAmount(2, RoundingMode.HALF_UP)));
        JOptionPane.showMessageDialog(null, sb.toString(), "Total amount", JOptionPane.INFORMATION_MESSAGE);

	}

    /**
     * A fixed result message used to report to the user
     */
    private StringBuilder getResultMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("With a start amount of ");
        sb.append(DecimalFormat.getCurrencyInstance().format(m_startAmount));
        sb.append("\nand an interest rate of ");
        NumberFormat percentInstance = DecimalFormat.getPercentInstance();
        percentInstance.setMaximumFractionDigits(m_interest.scale());
        sb.append(percentInstance.format(m_interest));
        sb.append("\nfor ");
        sb.append(m_periods);
        sb.append(" periods, \nthe total accrued amount will be ");
        return sb;
    }

}
