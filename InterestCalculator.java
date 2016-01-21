import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This receives the input to calculate the total amount with.
 *
 * It is the responsibility of the calling class to provide valid values.
 * If negative values are provided, this class will calculate with those numbers.
 *
 * Because we calculate with currencies, the BigDecimal object is used because it
 * is the object that handles all decimal input correctly.
 *
 * double and float will not always calculate numbers correctly. E.g. the following calculation:
 * 1.03 - .42 representing $1.03 minus 42 cents
 * will result in 0.6100000000000001 (Bloch, 2008)
 *
 * Reference
 * Bloch, J., 2008, “Effective Java: Second Edition”, Addison-Wesley, Upper Saddle River, NJ, United States
 *
 * The BigDecimal will perform this calculation correctly.
 *
 * Since the number of periods is an integer, I chose to use that primitive. I could use this also, because
 * it is a mandatory amount to calculate with.
 *
 * @author Ben Schoen<ben.schoen@online.liverpool.ac.uk>
 * @since 20 January 2016
 */
public class InterestCalculator {

    private int m_periods; // The number of periods for the calculation
    private BigDecimal m_principalAmount; // The initial amount
    private BigDecimal m_rateOfInterest;
    private BigDecimal rateOfInterest;
    private BigDecimal principalAmount;


    /**
     * @return BigDecimal with the principal amount
     */
    public BigDecimal getPrincipalAmount() {
        return m_principalAmount;
    }

    /**
     * Set the principal amount to use as start amount for the interest calculation
     * @param principalAmount
     */
    public void setPrincipalAmount(BigDecimal principalAmount) {
        m_principalAmount = principalAmount;
    }

    /**
     * Returns null if the total amount cannot be calculated
     * @param scale The user can set the scale of the amount (even a negative number is possible to round to 1,000 e.g.)
     * @param roundingMode The user can specify how rounding should take place
     * @return BigDecimal with two decimals rounded with BigDecimal.ROUND_HALF_UP
     */
    public BigDecimal getTotalAmount(int scale, RoundingMode roundingMode) {
        rateOfInterest = getRateOfInterest();
        principalAmount = getPrincipalAmount();
        if(rateOfInterest == null || principalAmount == null) {
            return null;
        }
        return principalAmount.add(principalAmount.multiply(rateOfInterest).multiply(new BigDecimal(getPeriods()))).setScale(scale, roundingMode);
    }

    /**
     * The rate of interest is returned as entered with all decimals
     * @return
     */
    public BigDecimal getRateOfInterest() {
        return m_rateOfInterest;
    }

    /**
     * Set the rate of interest to calculate the total amount and use 0.0375 for 3.75%
     * @param rateOfInterest
     */
    public void setRateOfInterest(BigDecimal rateOfInterest) {
        m_rateOfInterest = rateOfInterest;
    }

    /**
     * The number of periods used to calculate the total amount
     * @return int
     */
    public int getPeriods() {
        return m_periods;
    }

    /**
     * The number of periods entered
     * @param periods
     */
    public void setPeriods(int periods) {
        m_periods = periods;
    }
} // end of InterestCalculator
