package com.kacperstasiak.repaymentscheduler;

import java.util.ArrayList;

/**
 * The Schedule view, listing debts and amounts to repay for each.
 * @author Kacper Stasiak
 */
public class ScheduleView {

    private ScheduleController controller;

    protected ScheduleView() {
        this.controller = null;
    }

    public void init() {
        if (this.controller == null) {
            throw new IllegalStateException("Controller not set up yet.");
        }
        
        System.out.println("View initialised.");
    }

    public void close() {
        //throw new UnsupportedOperationException("Not supported yet.");
        // nothing yet?
    }

    public void update() {
        //throw new UnsupportedOperationException("Not supported yet.");
        
        ArrayList<ScheduleItem> schedule = getModel().getSchedule();
        
        int num = 1;
        for (ScheduleItem item : schedule) {
            float minPay = item.getDebt().getMinimumPayment() / 100.0f;
            float amount = item.getAmount() / 100.0f;
            
            String recommendation = "The minimum payment is " + 
                    String.format("£%.2f", minPay) + 
                    " and that's the amount we recommend you pay.";
            if (minPay != amount) {
                recommendation = "The minimum payment is " + 
                        String.format("£%.2f", minPay) + 
                        " but we recommend making a payment of " + 
                        String.format("£%.2f", amount);
            }
            
            float rate = item.getDebt().getInterestRate() * 100.0f;
            
            System.out.println(
                    num++ + ". " + item.getDebt().getPayeeName() + 
                            " (" + item.getDebt().getReference() + ") " + 
                            " (" + rate + "%): " + recommendation
            );
        }
    }

    public ScheduleController getController() {
        if (this.controller == null) {
            throw new IllegalStateException("Controller not set up yet.");
        }
        return this.controller;
    }

    public ScheduleModel getModel() {
        return getController().getModel();
    }

    public void setController(ScheduleController controller) {
        if (controller == null) {
            throw new IllegalStateException("Controller not set up yet.");
        }
        if (this.controller != null) {
            controller.shutdown();
        }
        this.controller = controller;
    }
    
}
