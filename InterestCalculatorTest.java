import javax.swing.*;
import javax.swing.UIManager.*;
import java.math.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by ben on 20-01-16.
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

	private void run() {

        m_startAmount = InputCreator.askForPositiveDecimalNumber("What is your start amount?", "Start amount");
        m_interest = InputCreator.askForPositiveDecimalNumber("What is the rate of interest per period?", "Rate of interest");
        m_periods = InputCreator.askForPositiveInteger( "How many periods would you like to calculate?", "Number of periods");

        InterestCalculator interestCalculator = new InterestCalculator();
        interestCalculator.setPrincipalAmount(m_startAmount);
        interestCalculator.setRateOfInterest(m_interest);
        interestCalculator.setPeriods(m_periods);
        StringBuilder sb = getResultMessage();
        sb.append(DecimalFormat.getCurrencyInstance().format(interestCalculator.getTotalAmount()));
        JOptionPane.showMessageDialog(null, sb.toString(), "Total amount", JOptionPane.INFORMATION_MESSAGE);

	}

    private StringBuilder getResultMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("With a start amount of ");
        sb.append(DecimalFormat.getCurrencyInstance().format(m_startAmount));
        sb.append(" and an interest of ");
        NumberFormat percentInstance = DecimalFormat.getPercentInstance();
        percentInstance.setMaximumFractionDigits(m_interest.scale());
        sb.append(percentInstance.format(m_interest));
        sb.append(" for ");
        sb.append(m_periods);
        sb.append(" periods, the total accrued amount will be: ");
        return sb;
    }

}
