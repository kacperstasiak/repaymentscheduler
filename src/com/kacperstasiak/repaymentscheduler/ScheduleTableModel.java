package com.kacperstasiak.repaymentscheduler;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * Encapsulates the Schedule data model for use in Java Swing tables
 * @author Kacper Stasiak
 */
public class ScheduleTableModel extends AbstractTableModel {
    private final ArrayList<String[]> data;
    private final String[] columns = {
        "Debt", "Interest rate", "Outstanding balance", "Minimum payment", "Suggested payment"
    };
    
    public ScheduleTableModel() {
        data = new ArrayList<>();
    }

    ScheduleTableModel(ScheduleModel model) {
        // todo
        data = new ArrayList<>();
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
}
