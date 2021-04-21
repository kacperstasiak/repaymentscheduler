package com.kacperstasiak.repaymentscheduler;

import java.util.List;
import java.util.Map;

/**
 * The interface for the model part of the MVC structure
 * @author Kacper Stasiak
 */
public interface Model {
    public List<Debt> getDebts();
    
    public void addDebt(String desc, int outstanding, double interest, int minPayment);
    public void removeDebt(Debt d);
    
    public String getDebtRef(Debt d);
    public void setDebtRef(Debt d, String ref);
    
    public int getDebtOutstandingBalance(Debt d);
    public void setDebtOutstandingBalance(Debt d, int outstanding);
    
    public double getDebtInterestRate(Debt d);
    public void setDebtInterestRate(Debt d, double rate);
    
    public int getDebtMinimumPayment(Debt d);
    public void setDebtMinimumPayment(Debt d, int amount);

    public int getMinimumPaymentSum();

    public void setBudgetAmount(int budget);
    public int getBudgetAmount();

    public Map<Debt, Integer> getDebtRepaymentSuggestions();

    public int getDebtsCount();
}
