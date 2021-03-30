package com.kacperstasiak.repaymentscheduler;

/**
 * Represents a single debt
 * @author Kacper Stasiak
 */
public class Debt {
    int principal;      // Full amonunt owed in pence
    float interestRate; // Annaul interest rate (1.0f = 100% interest, 0.01f = 1%, 0.005f = 0.5%, etc)
    int minimumPayment; // Minimum payment owed in pence for next billing period
}
