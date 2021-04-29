package com.kacperstasiak.repaymentassistant.MVC;

import com.kacperstasiak.repaymentassistant.Debt;
import java.util.List;
import java.util.Map;

/**
 * The interface for the model part of the MVC structure
 *
 * @author Kacper Stasiak
 */
public interface Model {

    public List<Debt> getDebts();

    /**
     * Inserts a debt into the debts list
     *
     * @param desc A user defined description or reference
     * @param outstanding The outstanding balance (in pence)
     * @param interest The annual interest rate (1.0 = 100%)
     * @param minPayment The next minimum payment amount (in pence)
     */
    public void addDebt(String desc, int outstanding, double interest, int minPayment);

    /**
     * Removes a debt from the debts list
     *
     * @param d The debt instance to remove
     */
    public void removeDebt(Debt d);

    /**
     * Returns the description of the debt
     *
     * @param d The debt instance
     * @return The description or reference set by the user
     */
    public String getDebtRef(Debt d);

    /**
     * Sets the description of the debt
     *
     * @param d The debt instance
     * @param ref The description or reference to set
     */
    public void setDebtRef(Debt d, String ref);

    /**
     * Returns the AER interest for the debt
     *
     * @param d The debt instance
     * @return The annual interest (1.0 = 100%)
     */
    public double getDebtInterestRate(Debt d);

    /**
     * Sets the AER interest for the debt
     *
     * @param d The debt instance
     * @param rate The annual interest (1.0 = 100%)
     */
    public void setDebtInterestRate(Debt d, double rate);

    /**
     * Returns the outstanding balance for the debt
     *
     * @param d The debt instance
     * @return The outstanding amount (in pence)
     */
    public int getDebtOutstandingBalance(Debt d);

    /**
     * Sets the outstanding balance for the debt
     *
     * @param d The debt instance
     * @param outstanding The oustanding amount (in pence)
     */
    public void setDebtOutstandingBalance(Debt d, int outstanding);

    /**
     * Returns the minimum payment amount for the debt
     *
     * @param d The debt instance
     * @return The minimum payment amount (in pence)
     */
    public int getDebtMinimumPayment(Debt d);

    /**
     * Sets the minimum payment amount for the debt
     *
     * @param d The debt instance
     * @param amount The minimum payment amount (in pence)
     */
    public void setDebtMinimumPayment(Debt d, int amount);

    /**
     * Returns the list of debts stored on the system
     *
     * @return Debts list
     */
    public int getDebtsCount();

    /**
     * Returns the sum of all minimum payments
     *
     * @return The sum of all minimum payment amounts
     */
    public int getMinimumPaymentSum();

    /**
     * Sets the repayment budget amount
     *
     * @param budget Repayment budget in pence
     */
    public void setBudgetAmount(int budget);

    /**
     * Returns the repayment budget amount
     *
     * @return Budget in pounds
     */
    public int getBudgetAmount();

    /**
     * Produces a map linking debts to repayment suggestions
     *
     * @return A map from Debt to Integer, the latter representing the suggested
     * repayment amount in pence
     */
    public Map<Debt, Integer> getDebtRepaymentSuggestions();
}
