package com.kacperstasiak.repaymentscheduler;

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
        "Debt", 
        "Interest rate", 
        "Outstanding balance", 
        "Minimum payment", 
        "Suggested payment"
    };
    final private Model model;
    private Map<Debt, Integer> suggestions;

    ScheduleTableModel(Model model) {
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
        if (columnIndex > 5) return "";
        return columns[columnIndex];
    }

    Debt getDebtAt(int rowIndex) {
        return model.getDebts().get(rowIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Debt debt = getDebtAt(rowIndex);
        switch (columnIndex) {
            case 0: // Debt reference, name or description
                return debt.getDescription();
            case 1: // Interest rate
                return String.format("%.1f%%", debt.getInterestRate() * 100.0);
            case 2: // Outstanding balance
                return String.format("£%.2f", 
                        debt.getOutstandingBalance() / 100.0);
            case 3: // Next minimum payment
                return String.format("£%.2f", debt.getMinimumPayment() / 100.0);
            case 4: // Suggested payment amount
                return String.format("£%.2f", suggestions.get(debt) / 100.0);
            default:
                return "-";
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
