package com.kacperstasiak.repaymentscheduler;

/**
 * The user interface frame displaying the debts list
 * @author Kacper Stasiak
 */
public class DebtsListFrame extends javax.swing.JFrame {
    ScheduleTableModel model = null;
    Controller controller = null;
    
    /**
     * Creates new form testJFrame
     * @param model The model class for the schedule
     * @param controller The controller class for the schedule
     */
    public DebtsListFrame(ScheduleTableModel model, Controller controller) {
        this.model = model;
        this.controller = controller;
        initComponents();
        
        debtTable.setRowSelectionAllowed(true);
        debtTable.getSelectionModel().addListSelectionListener(
                (javax.swing.event.ListSelectionEvent event) -> 
                        listSelectionPerformed(event)
        );
        
        // By default, warning shouldn't be displayed
        budgetWarningLabel.setVisible(false);
        
        double minpaySum = 0;
        budgetInputField.setValue(minpaySum);
        budgetInputField.addPropertyChangeListener("value", 
                (java.beans.PropertyChangeEvent event) -> 
                        budgetInputValueChanged(event)
        );
        
        int minPaySumPence = model.getMinimumPaymentSum();
        budgetInputField.setValue(minPaySumPence / 100.0);
        controller.updateBudgetAmount(minPaySumPence);
        
        updateSidepanel();
    }
    
    /**
     * Updates the frame view, specifically the debts table
     */
    final public void update() {
        // Update the table UI
        model.update();
        debtTable.updateUI();
        
        double budget = ((Number)budgetInputField.getValue()).doubleValue();
        
        int minPaySumPence = model.getMinimumPaymentSum();
        double minPaySum = minPaySumPence / 100.0;
        if (budget < minPaySum) {
            budgetWarningLabel.setVisible(true);
        } else {
            budgetWarningLabel.setVisible(false);
        }
        
        updateSidepanel();
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addButton = new javax.swing.JButton();
        sidepanelSplitter = new javax.swing.JSplitPane();
        debtTableScroll = new javax.swing.JScrollPane();
        debtTable = new javax.swing.JTable();
        sidepanel = new javax.swing.JPanel();
        editButton = new javax.swing.JButton();
        delButton = new javax.swing.JButton();
        sidepanelTitle = new javax.swing.JLabel();
        budgetInputField = new javax.swing.JFormattedTextField();
        budgetAmountLabel = new javax.swing.JLabel();
        budgetWarningLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Debt Repayment Assistant");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setLocation(new java.awt.Point(0, 0));
        setSize(new java.awt.Dimension(1000, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        sidepanelSplitter.setDividerLocation(850);

        debtTable.setModel(model);
        debtTable.setFillsViewportHeight(true);
        debtTable.getTableHeader().setReorderingAllowed(false);
        debtTableScroll.setViewportView(debtTable);

        sidepanelSplitter.setLeftComponent(debtTableScroll);

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        delButton.setText("Delete");
        delButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delButtonActionPerformed(evt);
            }
        });

        sidepanelTitle.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        sidepanelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sidepanelTitle.setText("Debt 1");

        javax.swing.GroupLayout sidepanelLayout = new javax.swing.GroupLayout(sidepanel);
        sidepanel.setLayout(sidepanelLayout);
        sidepanelLayout.setHorizontalGroup(
            sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidepanelLayout.createSequentialGroup()
                        .addComponent(sidepanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(sidepanelLayout.createSequentialGroup()
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delButton)
                        .addGap(0, 65, Short.MAX_VALUE))))
        );
        sidepanelLayout.setVerticalGroup(
            sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sidepanelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(delButton))
                .addContainerGap(329, Short.MAX_VALUE))
        );

        sidepanelSplitter.setRightComponent(sidepanel);

        budgetInputField.setText("1000");

        budgetAmountLabel.setText("Available repayment budget: £");

        budgetWarningLabel.setForeground(new java.awt.Color(200, 0, 0));
        budgetWarningLabel.setText("Warning: Not enough to cover all minimum paments");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sidepanelSplitter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1051, Short.MAX_VALUE)
                    .addComponent(addButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(budgetAmountLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(budgetInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(budgetWarningLabel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(budgetInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(budgetAmountLabel)
                    .addComponent(budgetWarningLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sidepanelSplitter, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        controller.openAddEditMenu();
    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int selectedRow = debtTable.getSelectedRow();
        if (selectedRow == -1) return;
        Debt selected = model.getDebtAt(selectedRow);
        controller.openAddEditMenu(selected);
    }//GEN-LAST:event_editButtonActionPerformed

    private void delButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButtonActionPerformed
        int selectedRow = debtTable.getSelectedRow();
        if (selectedRow == -1) return;
        Debt selected = model.getDebtAt(selectedRow);
        controller.deleteDebt(selected);
    }//GEN-LAST:event_delButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        controller.shutdown();
    }//GEN-LAST:event_formWindowClosed
    
    private void listSelectionPerformed(javax.swing.event.ListSelectionEvent evt) {
        if (evt.getValueIsAdjusting()) return;
        updateSidepanel();
    }
    
    private void budgetInputValueChanged(java.beans.PropertyChangeEvent event) {
        // Display a warning if budget is less than sum of all minimum payments
        double budget = ((Number)budgetInputField.getValue()).doubleValue();
        
        int minPaySumPence = model.getMinimumPaymentSum();
        double minPaySum = minPaySumPence / 100.0;
        if (budget < minPaySum) {
            budgetWarningLabel.setVisible(true);
        } else {
            budgetWarningLabel.setVisible(false);
        }
        
        controller.updateBudgetAmount((int) Math.floor(budget * 100));
        model.update();
        
        update();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel budgetAmountLabel;
    private javax.swing.JFormattedTextField budgetInputField;
    private javax.swing.JLabel budgetWarningLabel;
    private javax.swing.JTable debtTable;
    private javax.swing.JScrollPane debtTableScroll;
    private javax.swing.JButton delButton;
    private javax.swing.JButton editButton;
    private javax.swing.JPanel sidepanel;
    private javax.swing.JSplitPane sidepanelSplitter;
    private javax.swing.JLabel sidepanelTitle;
    // End of variables declaration//GEN-END:variables

    private void updateSidepanel() {
        int selectedRow = debtTable.getSelectedRow();
        
        if (selectedRow == -1 || model.getValueAt(selectedRow, 0) == null) {
            sidepanelTitle.setText("Nothing selected");
        
            // Disable the edit and delete buttons if selection is invalid
            editButton.setEnabled(false);
            delButton.setEnabled(false);
            
            return;
        }
        
        String title = (String) model.getValueAt(selectedRow, 0);
        sidepanelTitle.setText(title);
        editButton.setEnabled(true);
        delButton.setEnabled(true);
    }
}
