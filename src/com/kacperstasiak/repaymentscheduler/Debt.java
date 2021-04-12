package com.kacperstasiak.repaymentscheduler;

/**
 * Represents a single debt
 * @author Kacper Stasiak
 */
public class Debt {
    private String payee;           // The name of the creditor
    private String reference;       // User defined reference
    private int outstandingBalance; // Full amonunt owed in pence
    private float interestRate;     // Annaul interest rate (1.0f = 100% interest, 0.01f = 1%, 0.005f = 0.5%, etc)
    private int minimumPayment;     // Minimum payment owed in pence for next billing period
    
    public Debt(String payee, String ref, int principal, float rate, int minimum) {
        if (principal < 0) {
            throw new IllegalArgumentException("Principal must be non-negative.");
        }
        if (rate < 0.0f || rate >= 1.0f) {
            throw new IllegalArgumentException("Interest rate must be between 0.0f and 1.0f");
        }
        if (minimum < 0) {
            throw new IllegalArgumentException("Minimum payment must be non-negative.");
        }
        
        this.payee = payee;
        this.reference = ref;
        this.outstandingBalance = principal;
        this.interestRate = rate;
        this.minimumPayment = minimum;
    }
    
    public String getPayeeName() {
        return payee;
    }
    
    public void setPayeeName(String name) {
        payee = name;
    }
    
    public String getReference() {
        return reference;
    }
    
    public void setReference(String ref) {
        reference = ref;
    }
    
    public int getOutstandingBalance() {
        return outstandingBalance;
    }
    
    public void setOutstandingBalance(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Principal must be non-negative.");
        }
        
        outstandingBalance = amount;
    }
    
    public float getInterestRate() {
        return interestRate;
    }
    
    public void setInterestRate(float rate) {
        if (rate < 0.0f || rate >= 1.0f) {
            throw new IllegalArgumentException("Interest rate must be between 0.0f and 1.0f");
        }
        
        interestRate = rate;
    }
    
    public int getMinimumPayment() {
        return minimumPayment;
    }
    
    public void setMinimumPayment(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Minimum payment must be non-negative.");
        }
        
        minimumPayment = amount;
    }
}
