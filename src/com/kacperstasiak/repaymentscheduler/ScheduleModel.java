package com.kacperstasiak.repaymentscheduler;

import java.util.ArrayList;

/**
 * The model part of the MVC structure, stores and manages the data.
 * @author Kacper Stasiak
 */
public class ScheduleModel {
    ArrayList<Debt> debts;

    /**
     * Inserts a debt into the debts list
     * @param desc A user defined description or reference
     * @param outstanding The outstanding balance (in pence)
     * @param interest The annual interest rate (1.0f = 100%)
     * @param minPayment The next minimum payment amount (in pence)
     */
    public void addDebt(String desc, int outstanding, float interest, 
            int minPayment) {
        Debt debt = new Debt(desc, outstanding, interest, minPayment);
        debts.add(debt);
    }
    
    /**
     * Removes a debt from the debts list
     * @param debt The debt instance to remove
     */
    public void removeDebt(Debt debt) {
        debts.remove(debt);
    }
    
    /**
     * Returns the description of a debt
     * @param debt The debt instance
     * @return The description or reference set by the user
     */
    public String getDebtDescription(Debt debt) {
        return debt.getDescription();
    }
    
    /**
     * Returns the AER interest for the debt
     * @param debt The debt instance
     * @return The annual interest (1.0f = 100%)
     */
    public float getInterestRate(Debt debt) {
        return debt.getInterestRate();
    }
    
    /**
     * Returns the outstanding balance for the debt
     * @param debt The debt instance
     * @return The outstanding amount (in pence)
     */
    public int getOutstandingBalance(Debt debt) {
        return debt.getOutstandingBalance();
    }
    
    /**
     * Returns the minimum payment amount for the debt
     * @param debt The debt instance
     * @return The minimum payment (in pence)
     */
    public int getMinimumPayment(Debt debt) {
        return debt.getMinimumPayment();
    }

    /**
     * Returns the list of debts stored on the system
     * @return Debts list
     */
    public ArrayList<Debt> getDebts() {
        return debts;
    }
    
}
