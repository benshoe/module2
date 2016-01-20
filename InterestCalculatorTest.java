import javax.swing.*;
import javax.swing.UIManager.*;
import java.math.*;

/**
 * Created by ben on 20-01-16.
 */
public class InterestCalculatorTest {

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
		BigDecimal startAmount = new BigDecimal("10000");
		BigDecimal interest = new BigDecimal("0.03875");
		int periods = 5;
		System.out.println( "362.2 - 362.6 = " + ( 362.2 - 362.6 ) );

		InterestCalculator interestCalculator = new InterestCalculator();
		//interestCalculator.setPeriods(periods);
		//interestCalculator.setPrincipalAmount(startAmount);
		//interestCalculator.setRateOfInterest(interest);
		//BigDecimal totalAmount = interestCalculator.getTotalAmount();
		//System.out.println("totalAmount = " + totalAmount);

		startAmount = getStartAmount();
		interest = getInterest();
		periods = getPeriods();

		interestCalculator.setPrincipalAmount(startAmount);
		interestCalculator.setRateOfInterest(interest);
		interestCalculator.setPeriods(periods);
		JOptionPane.showMessageDialog(null, new String("The total accrued amount will be: " + interestCalculator.getTotalAmount()), "Total amount", JOptionPane.INFORMATION_MESSAGE);
	}

	private int getPeriods() {
		final String periodsAnswer = JOptionPane.showInputDialog(null, "How many periods would you like to calculate?", "Number of periods", JOptionPane.QUESTION_MESSAGE);
		int periods = Integer.valueOf(periodsAnswer).intValue();
		return periods;
	}

	private BigDecimal getInterest() {
		final String interestAnswer = JOptionPane.showInputDialog(null, "What is the rate of interest per period?", "Rate of interest", JOptionPane.QUESTION_MESSAGE);
		BigDecimal interest = new BigDecimal(interestAnswer);
		return interest;
	}

	private BigDecimal getStartAmount() {
		final String startAmountAnswer = JOptionPane.showInputDialog(null, "What is your start amount?", "Start amount", JOptionPane.QUESTION_MESSAGE);
		BigDecimal startAmount = new BigDecimal(startAmountAnswer, MathContext.DECIMAL64);
		return startAmount;
	}
}
