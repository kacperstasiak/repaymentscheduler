package com.kacperstasiak.repaymentscheduler.UI;

import com.kacperstasiak.repaymentscheduler.MVC.Controller;
import com.kacperstasiak.repaymentscheduler.Debt;

/**
 * The user interface frame for adding or editing a debt instance
 * @author Kacper Stasiak
 */
public class AddEditFrame extends javax.swing.JFrame {
    Controller controller;
    Debt editing;

    /**
     * Creates a add new debt form
     * @param controller The controller that handles the main view
     */
    public AddEditFrame(Controller controller) {
        this.controller = controller;
        initComponents();                                 
        refInput.setValue(""); //NOI18N
        balInput.setValue(0.0);
        rateInput.setValue(0.0);
        payInput.setValue(0.0);
        this.setTitle(java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentscheduler/English").getString("ADD DEBT"));
    }
    
    /**
     * Creates an edit debt form
     * @param controller The controller that handles the main view
     * @param debt The debt instance that is being edited
     */
    public AddEditFrame(Controller controller, Debt debt) {
        this.controller = controller;
        initComponents();                                
        this.editing = debt;
        refInput.setValue(debt.getDescription());
        balInput.setValue(debt.getOutstandingBalance() * 100);
        rateInput.setValue(debt.getInterestRate() * 100);
        payInput.setValue(debt.getMinimumPayment() * 100);
        this.setTitle(java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentscheduler/English").getString("EDIT DEBT"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        refPanel = new javax.swing.JPanel();
        refLabel = new javax.swing.JLabel();
        refInput = new javax.swing.JFormattedTextField();
        balPanel = new javax.swing.JPanel();
        balLabel = new javax.swing.JLabel();
        balInput = new javax.swing.JFormattedTextField();
        ratePanel = new javax.swing.JPanel();
        rateLabel = new javax.swing.JLabel();
        rateInput = new javax.swing.JFormattedTextField();
        payPanel = new javax.swing.JPanel();
        payLabel = new javax.swing.JLabel();
        payInput = new javax.swing.JFormattedTextField();
        cancelBtn = new javax.swing.JButton();
        okBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        refLabel.setLabelFor(refInput);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentscheduler/English"); // NOI18N
        refLabel.setText(bundle.getString("DEBT NAME/REFERENCE")); // NOI18N

        javax.swing.GroupLayout refPanelLayout = new javax.swing.GroupLayout(refPanel);
        refPanel.setLayout(refPanelLayout);
        refPanelLayout.setHorizontalGroup(
            refPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(refPanelLayout.createSequentialGroup()
                .addComponent(refLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refInput, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        refPanelLayout.setVerticalGroup(
            refPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(refPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(refLabel)
                .addComponent(refInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        balLabel.setLabelFor(balInput);
        balLabel.setText(bundle.getString("OUTSTANDING BALANCE")); // NOI18N

        javax.swing.GroupLayout balPanelLayout = new javax.swing.GroupLayout(balPanel);
        balPanel.setLayout(balPanelLayout);
        balPanelLayout.setHorizontalGroup(
            balPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(balPanelLayout.createSequentialGroup()
                .addComponent(balLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(balInput, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        balPanelLayout.setVerticalGroup(
            balPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(balPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(balLabel)
                .addComponent(balInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        rateLabel.setLabelFor(rateInput);
        rateLabel.setText(bundle.getString("ANNUAL INTEREST RATE")); // NOI18N

        javax.swing.GroupLayout ratePanelLayout = new javax.swing.GroupLayout(ratePanel);
        ratePanel.setLayout(ratePanelLayout);
        ratePanelLayout.setHorizontalGroup(
            ratePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ratePanelLayout.createSequentialGroup()
                .addComponent(rateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rateInput, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ratePanelLayout.setVerticalGroup(
            ratePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ratePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(rateLabel)
                .addComponent(rateInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        payLabel.setLabelFor(payInput);
        payLabel.setText(bundle.getString("NEXT MINIMUM PAYMENT")); // NOI18N

        javax.swing.GroupLayout payPanelLayout = new javax.swing.GroupLayout(payPanel);
        payPanel.setLayout(payPanelLayout);
        payPanelLayout.setHorizontalGroup(
            payPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(payPanelLayout.createSequentialGroup()
                .addComponent(payLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(payInput, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        payPanelLayout.setVerticalGroup(
            payPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(payPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(payLabel)
                .addComponent(payInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cancelBtn.setText(bundle.getString("CANCEL")); // NOI18N
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        okBtn.setText(bundle.getString("OK")); // NOI18N
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okBtn))
                    .addComponent(balPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ratePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(payPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(refPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(balPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ratePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(payPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(okBtn)
                    .addComponent(cancelBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        String ref = ((String) refInput.getValue());
        double bal = ((Number) balInput.getValue()).doubleValue();
        double rate = ((Number) rateInput.getValue()).doubleValue();
        double pay = ((Number) payInput.getValue()).doubleValue();
        int balance = (int) Math.floor(bal * 100);
        int minpay = (int) Math.floor(pay * 100);
        if (ref.length() < 1) {
            System.out.println(java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentscheduler/English").getString("INVALID REFERENCE!"));
            return;
        }
        if (balance < 0) {
            System.out.println(java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentscheduler/English").getString("INVALID BALANCE!"));
            return;
        }
        if (rate < 0.0 || rate > 100.0) {
            System.out.println(java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentscheduler/English").getString("INVALID INTEREST RATE!"));
        }
        if (minpay < 0) {
            System.out.println(java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentscheduler/English").getString("INVALID MIN PAYMENT!"));
            return;
        }
        if (editing != null) {
            controller.editDebt(editing, ref, balance, rate / 100, minpay);
        } else {
            controller.addDebt(ref, balance, rate / 100, minpay);
        }
        controller.updateView();
        controller.closeAddEditMenu();

    }//GEN-LAST:event_okBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        controller.closeAddEditMenu();
    }//GEN-LAST:event_cancelBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField balInput;
    private javax.swing.JLabel balLabel;
    private javax.swing.JPanel balPanel;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton okBtn;
    private javax.swing.JFormattedTextField payInput;
    private javax.swing.JLabel payLabel;
    private javax.swing.JPanel payPanel;
    private javax.swing.JFormattedTextField rateInput;
    private javax.swing.JLabel rateLabel;
    private javax.swing.JPanel ratePanel;
    private javax.swing.JFormattedTextField refInput;
    private javax.swing.JLabel refLabel;
    private javax.swing.JPanel refPanel;
    // End of variables declaration//GEN-END:variables
}