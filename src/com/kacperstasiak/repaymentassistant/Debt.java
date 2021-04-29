package com.kacperstasiak.repaymentassistant;

/**
 * A class to represents a single debt
 *
 * @author Kacper Stasiak
 */
public class Debt implements java.io.Serializable {

    private String reference;
    private int outstandingBalance;
    private double interestRate;
    private int minimumPayment;

    /**
     * Public constructor for a single debt
     *
     * @param desc A user defined reference or description
     * @param outstanding The full amount owed (in pence)
     * @param rate The annual interest rate (1.0 = 100%)
     * @param minimum The minimum payment due next billing period (in pence)
     */
    public Debt(String desc, int outstanding, double rate, int minimum) {
        if (outstanding < 0) {
            throw new IllegalArgumentException("Outstanding balance must be non-negative."); //NOI18N
        }
        if (rate < 0.0 || rate >= 1.0) {
            throw new IllegalArgumentException("Interest rate must be between 0.0 and 1.0"); //NOI18N
        }
        if (minimum < 0) {
            throw new IllegalArgumentException("Minimum payment must be non-negative."); //NOI18N
        }

        reference = desc;
        outstandingBalance = outstanding;
        interestRate = rate;
        minimumPayment = minimum;
    }

    /**
     * Returns a user defined description or reference for the debt
     *
     * @return
     */
    public String getDescription() {
        return reference;
    }

    /**
     * Sets a user defined description or reference for the debt
     *
     * @param desc A user defined description or reference
     */
    public void setDescription(String desc) {
        reference = desc;
    }

    /**
     * Returns the outstanding balance for the debt
     *
     * @return The outstanding balance (in pence)
     */
    public int getOutstandingBalance() {
        return outstandingBalance;
    }

    /**
     * Sets the outstanding balance for the debt
     *
     * @param amount The outstanding balance (in pence)
     */
    public void setOutstandingBalance(int amount) {
        // Make sure the amount is valid
        if (amount < 0) {
            throw new IllegalArgumentException("Outstanding balance must be non-negative."); //NOI18N
        }

        // Adjust the stored outstanding balance
        outstandingBalance = amount;
    }

    /**
     * Returns the AER interest for the debt
     *
     * @return The annual interest rate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Sets the AER interest for this debt
     *
     * @param rate The annual interest rate
     */
    public void setInterestRate(double rate) {
        // Make sure the rate is valid
        if (rate < 0.0 || rate >= 1.0) {
            throw new IllegalArgumentException("Interest rate must be between 0.0 and 1.0"); //NOI18N
        }

        // Adjust the stored interest rate
        interestRate = rate;
    }

    /**
     * Returns the minimum amount that needs to be paid next billing period
     *
     * @return The minimum payment amount (in pence)
     */
    public int getMinimumPayment() {
        if (outstandingBalance < minimumPayment) {
            return outstandingBalance;
        }
        return minimumPayment;
    }

    /**
     * Sets the minimum amount that needs to be paid next billing period
     *
     * @param amount The minimum payment amount (in pence)
     */
    public void setMinimumPayment(int amount) {
        // Make sure the amount is valid
        if (amount < 0) {
            throw new IllegalArgumentException("Minimum payment must be non-negative."); //NOI18N
        }

        // Adjust the stored minimum payment
        minimumPayment = amount;
    }
}
