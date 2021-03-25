/*
 * Kacper Stasiak 2021 - University of Hertfordshire
 */
package com.kacperstasiak.repaymentscheduler;

/**
 *
 * @author Kacper Stasiak (k.stasiak@icloud.com)
 */
public class Debt {
    int principal;          // Full amonunt owed in pence
    float interestRate;     // Annaul interest rate (1.0f = 100% interest, 0.01f = 1%, 0.005f = 0.5%, etc)
    Date nextRepayment;     // Date of the day on which the repayment needs to be made
}
