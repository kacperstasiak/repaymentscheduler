package com.kacperstasiak.repaymentscheduler;

import java.util.ArrayList;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 * Encapsulates the Schedule data model for use in Java Swing tables
 * @author Kacper Stasiak
 */
public final class ScheduleTableModel extends AbstractTableModel {
    private final ArrayList<String[]> data;
    private final String[] columns = {
        "Debt", 
        "Interest rate", 
        "Outstanding balance", 
        "Minimum payment", 
        "Suggested payment"
    };
    private Model model = null;

    ScheduleTableModel(Model model) {
        this.model = model;
        data = new ArrayList<>();
        update();
    }
    
    @Override
    public int getRowCount() {
        return data.size();
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

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex)[columnIndex];
    }

    public int getMinimumPaymentSum() {
        return model.getMinimumPaymentSum();
    }

    public void setBudgetAmount(int budget) {
        model.setBudgetAmount(budget);
    }

    public void update() {
        Map<Debt, Integer> suggestions = model.getDebtRepaymentSuggestions();
        
        data.clear();
        for (Debt d : model.getDebts()) {
            String ref = model.getDebtRef(d);
            double rate = model.getDebtInterestRate(d);
            int outstanding = model.getDebtOutstandingBalance(d);
            int minpay = model.getDebtMinimumPayment(d);
            int suggestPay = suggestions.get(d);
            
            String[] row = {
                ref,                                            // Debt Name
                String.format("%.1f%%", rate * 100.0),          // Interest rate
                String.format("£%.2f", outstanding / 100.0),    // Outstanding balance
                String.format("£%.2f", minpay / 100.0),         // Minimum payment
                String.format("£%.2f", suggestPay / 100.0)      // Suggested payment
            };
            data.add(row);
        }
    }
}
