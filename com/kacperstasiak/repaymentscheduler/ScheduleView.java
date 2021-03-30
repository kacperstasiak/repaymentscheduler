package com.kacperstasiak.repaymentscheduler;

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
    }

    public void close() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update() {
        throw new UnsupportedOperationException("Not supported yet.");
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
