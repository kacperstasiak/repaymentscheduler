package com.kacperstasiak.repaymentassistant;

import com.kacperstasiak.repaymentassistant.MVC.View;
import com.kacperstasiak.repaymentassistant.MVC.Model;
import com.kacperstasiak.repaymentassistant.MVC.Controller;

/**
 * The main class, initialises view, model and controller. Handles saving and
 * loading the model
 *
 * @author Kacper Stasiak
 */
public class Main {

    public static void main(String args[]) {
        // Ensures the controller's shutdown function is called when quitting 
        // the app on macOS, thus ensuring the shutdown callback is triggered
        // in this function, so that the model is saved.
        //com.apple.eawt.Application.getApplication().setQuitStrategy(com.apple.eawt.QuitStrategy.CLOSE_ALL_WINDOWS);

        Model model = AssistantModel.load("./debts.ser"); //NOI18N

        View view = new AssistantSwingView();
        Controller controller = new AssistantController(model, view);

        controller.run();

        // Add callback handler when window closes
        controller.onShutdown(
                () -> {
                    // Save the model
                    AssistantModel.save((AssistantModel) model, "./debts.ser"); //NOI18N
                }
        );
    }
;

}
