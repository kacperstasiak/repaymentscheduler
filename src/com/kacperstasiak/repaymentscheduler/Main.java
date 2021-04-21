package com.kacperstasiak.repaymentscheduler;

import com.kacperstasiak.repaymentscheduler.MVC.View;
import com.kacperstasiak.repaymentscheduler.MVC.Model;
import com.kacperstasiak.repaymentscheduler.MVC.Controller;
import java.io.File;

/**
 * The main class, initialises view, model and controller.
 * @author Kacper Stasiak
 */
public class Main {
    public static void main(String args[]) {
        Model model;
        
        // Check if ./debts.ser exists
        File file = new File("./debts.ser"); //NOI18N
        if (file.exists()) {
            // Load from file
            model = ModelImpl.load("./debts.ser"); //NOI18N
        } else {
            // Create a new model with sample data
            model = new ModelImpl();
            model.addDebt("Test Debt 1", 100000, 0.124, 50);
            model.addDebt("Test Debt 2", 300000, 0.170, 150);
            model.addDebt("Test Debt 3", 200000, 0.150, 3000);
        }
        
        View view = new ViewImpl();
        Controller controller = new ControllerImpl(model, view);
        
        controller.run();
        
        controller.onShutdown(
                () -> {
                    ModelImpl.save((ModelImpl) model, "./debts.ser"); //NOI18N
                }
        );
        
        
    };
}
