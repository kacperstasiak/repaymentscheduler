package com.kacperstasiak.repaymentscheduler;

/**
 * Represents a single repayment suggestion
 * @author Kacper Stasiak
 */
public class ScheduleItem {
    private Debt debt;  // References which debt to pay
    private int amount; // Amount recommended to pay, in pence
    
    public ScheduleItem(Debt debt, int amount) {
        this.debt = debt;
        this.amount = amount;
    }
    
    public Debt getDebt() {
        return debt;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
