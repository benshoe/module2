import java.math.BigDecimal;

/**
 * Created by ben on 20-01-16.
 */
public class InterestCalculatorTest {
    public static void main(String[] args) {

        BigDecimal startAmount = new BigDecimal("10000");
        BigDecimal interest = new BigDecimal("0.03875");
        int periods = 5;

        InterestCalculator interestCalculator = new InterestCalculator();
        interestCalculator.setPeriods(periods);
        interestCalculator.setPrincipalAmount(startAmount);
        interestCalculator.setRateOfInterest(interest);
        BigDecimal totalAmount = interestCalculator.getTotalAmount();
        System.out.println("totalAmount = " + totalAmount);
    }
}
