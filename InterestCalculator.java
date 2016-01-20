import java.math.BigDecimal;

/**
 * @author Ben Schoen<ben.schoen@online.liverpool.ac.uk>
 * @since 20 January 2016
 */
public class InterestCalculator {

    private int m_periods; // The number of periods for the calculation

    private BigDecimal m_principalAmount;
    private BigDecimal m_rateOfInterest;


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
     * @return BigDecimal with two decimals rounded with BigDecimal.ROUND_HALF_UP
     */
    public BigDecimal getTotalAmount() {
        if(getRateOfInterest() == null || getPrincipalAmount() == null) {
            return null;
        }
        return getPrincipalAmount().add(getPrincipalAmount().multiply(getRateOfInterest()).multiply(new BigDecimal(getPeriods()))).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * The rate of interest is returned as entered with all decimals
     * @return
     */
    public BigDecimal getRateOfInterest() {
        return m_rateOfInterest;
    }

    /**
     * Set the rate of interest to calculate the total amount with
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
}
