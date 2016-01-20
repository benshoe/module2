import java.math.BigDecimal;

/**
 * Created by ben on 20-01-16.
 */
public class InterestCalculator {

    private int m_periods; // The number of periods for the calculation

    private BigDecimal m_principalAmount;
    private BigDecimal m_rateOfInterest;


    public BigDecimal getPrincipalAmount() {
        return m_principalAmount;
    }

    public void setPrincipalAmount(BigDecimal principalAmount) {
        m_principalAmount = principalAmount;
    }

    /**
     * Returns null if the total amount cannot be calculated
     * @return
     */
    public BigDecimal getTotalAmount() {
        if(getRateOfInterest() == null || getPrincipalAmount() == null) {
            return null;
        }
        return getPrincipalAmount().add(getPrincipalAmount().multiply(getRateOfInterest()).multiply(new BigDecimal(getPeriods())));
    }

    public BigDecimal getRateOfInterest() {
        return m_rateOfInterest;
    }

    public void setRateOfInterest(BigDecimal rateOfInterest) {
        m_rateOfInterest = rateOfInterest;
    }

    public int getPeriods() {
        return m_periods;
    }

    public void setPeriods(int periods) {
        m_periods = periods;
    }
}
