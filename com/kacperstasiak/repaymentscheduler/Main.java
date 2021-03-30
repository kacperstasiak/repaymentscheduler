package com.kacperstasiak.repaymentscheduler;

/**
 * The main class, initialises view, model and controller.
 * @author Kacper Stasiak
 */
public class Main {
    public static void main(String args[]) {
        ScheduleModel model = new ScheduleModel();
        ScheduleView view = new ScheduleView();
        ScheduleController controller = new ScheduleController(model, view);
        
        controller.run();
    };
}
