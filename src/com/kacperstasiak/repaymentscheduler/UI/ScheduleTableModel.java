package com.kacperstasiak.repaymentscheduler.UI;

import com.kacperstasiak.repaymentscheduler.Debt;
import com.kacperstasiak.repaymentscheduler.MVC.Model;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 * Encapsulates the Schedule data model for use in Java Swing tables
 * @author Kacper Stasiak
 */
public final class ScheduleTableModel extends AbstractTableModel {
    private final String[] columns = {
        java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentscheduler/English").getString("DEBT COLUMN NAME"), 
        java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentscheduler/English").getString("INTEREST RATE COLUMN NAME"), 
        java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentscheduler/English").getString("OUTSTANDING BALANCE COLUMN NAME"), 
        java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentscheduler/English").getString("MINIMUM PAYMENT COLUMN NAME"), 
        java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentscheduler/English").getString("SUGGESTED PAYMENT COLUMN NAME")
    };
    final private Model model;
    private Map<Debt, Integer> suggestions;

    public ScheduleTableModel(Model model) {
        this.model = model;
        this.suggestions = model.getDebtRepaymentSuggestions();
    }
    
    @Override
    public int getRowCount() {
        return model.getDebtsCount();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex > 5) return ""; //NOI18N
        return columns[columnIndex];
    }

    public Debt getDebtAt(int rowIndex) {
        if (rowIndex < 0) return null;
        if (rowIndex >= getRowCount()) return null;
        return model.getDebts().get(rowIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Debt debt = getDebtAt(rowIndex);
        if (debt == null) return null;
        switch (columnIndex) {
            case 0: // Debt reference, name or description
                return debt.getDescription();
            case 1: // Interest rate
                return String.format(java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentscheduler/English").getString("INTEREST RATE FORMAT"), debt.getInterestRate() * 100.0);
            case 2: // Outstanding balance
                return String.format(java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentscheduler/English").getString("BALANCE FORMAT"), 
                        debt.getOutstandingBalance() / 100.0);
            case 3: // Next minimum payment
                return String.format(java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentscheduler/English").getString("MINIMUM PAYMENT FORMAT"), debt.getMinimumPayment() / 100.0);
            case 4: // Suggested payment amount
                return String.format(java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentscheduler/English").getString("SUGGESTED PAYMENT FORMAT"), suggestions.get(debt) / 100.0);
            default:
                return java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentscheduler/English").getString("EMPTY ROW/COLUMN");
        }
    }

    public int getMinimumPaymentSum() {
        return model.getMinimumPaymentSum();
    }

    public void setBudgetAmount(int budget) {
        model.setBudgetAmount(budget);
    }

    public void update() {
        suggestions = model.getDebtRepaymentSuggestions();
    }
}