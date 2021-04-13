package com.kacperstasiak.repaymentscheduler;

/**
 * The controller part of the MVC structure, manages connection between
 * view and model
 * @author Kacper Stasiak
 */
public class ScheduleController {

    private final ScheduleModel model;
    private final ScheduleView view;

    /**
     * Public constructor for the Schedule Controller
     * @param model The data model instance to use
     * @param view The data view instance to use
     */
    public ScheduleController(ScheduleModel model, ScheduleView view) {
        this.model = model;
        this.view = view;
        view.setController(this);
    }

    /**
     * Begins the operation of the view and model
     */
    public void run() {
        // todo: init view
        view.init();
    }

    /**
     * Returns the data model instance being used
     * @return Data model instance
     */
    public ScheduleModel getModel() {
        return this.model;
    }

    /**
     * Ends the operation of the view and model and saves it
     */
    public void shutdown() {
        // todo: destroy views and save model
        view.close();
    }
    
}
