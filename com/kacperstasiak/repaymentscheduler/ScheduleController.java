package com.kacperstasiak.repaymentscheduler;

/**
 * The Schedule controller, controls the model and view.
 * @author Kacper Stasiak
 */
public class ScheduleController {
    private ScheduleModel model;
    private ScheduleView view;
    
    public ScheduleController(ScheduleModel model, ScheduleView view) {
        this.model = model;
        this.view = view;
        view.setController(this);
    }
    
    public void shutdown() {
        //todo: remove gui
    }

    public void run() {
        //todo: add gui
        
        getModel().getSchedule();
        getView().update();
    }
    
    public ScheduleModel getModel() {
        return this.model;
    }

    public ScheduleView getView() {
        return this.view;
    }

}
