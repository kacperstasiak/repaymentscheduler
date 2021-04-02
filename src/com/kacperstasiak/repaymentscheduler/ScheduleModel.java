package com.kacperstasiak.repaymentscheduler;

import java.util.ArrayList;

/**
 * The Schedule model, stores all debts and sorts them for optimal repayment strategy.
 * @author Kacper Stasiak
 */
public class ScheduleModel {
    public void addDebt() {
        
    }
    
    public void removeDebt() {
        
    }
    
    public void getDebtDetails() {
        
    }
    
    public void setDebtDetails() {
        
    }
    
    public ArrayList<ScheduleItem> getSchedule() {
        ArrayList<ScheduleItem> list = new ArrayList<>();
        list.add(new ScheduleItem(new Debt("Payday Loan 1", "ABC1", 1000, 0.275f, 100), 500));
        list.add(new ScheduleItem(new Debt("Payday Loan 2", "ABC2", 7500, 0.2225f, 2500), 4000));
        return list;
    }
}
