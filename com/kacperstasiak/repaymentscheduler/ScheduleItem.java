package com.kacperstasiak.repaymentscheduler;

/**
 * Represents a single repayment suggestion
 * @author Kacper Stasiak
 */
class ScheduleItem {
    Debt debtReference; // References which debt to pay
    int amount;         // Amount recommended to pay, in pence
}
