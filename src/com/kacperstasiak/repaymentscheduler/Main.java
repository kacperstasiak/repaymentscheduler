package com.kacperstasiak.repaymentscheduler;

/**
 * The main class, initialises view, model and controller.
 * @author Kacper Stasiak
 */
public class Main {
    public static void main(String args[]) {
        Model model = new ModelImpl();
        model.addDebt("Test Debt 1", 100000, 0.124, 50);
        model.addDebt("Test Debt 2", 300000, 0.170, 150);
        model.addDebt("Test Debt 3", 200000, 0.150, 3000);
        
        View view = new ViewImpl();
        Controller controller = new ControllerImpl(model, view);
        
        controller.run();
    };
}
