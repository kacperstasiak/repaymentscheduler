package com.kacperstasiak.repaymentassistant;

import com.kacperstasiak.repaymentassistant.UI.DebtTableModel;
import com.kacperstasiak.repaymentassistant.MVC.View;
import com.kacperstasiak.repaymentassistant.MVC.Model;
import com.kacperstasiak.repaymentassistant.MVC.Controller;
import com.kacperstasiak.repaymentassistant.UI.DebtsListFrame;

/**
 * The view part of the MVC structure, displays the debts list and amounts to
 * repay for each.
 *
 * @author Kacper Stasiak
 */
public class AssistantSwingView implements View {

    private Controller controller;
    private DebtsListFrame mainView;

    /**
     * Public constructor for the debt repayment assistant view. A controller
     * must be set before calling {@link #init() init()} through
     * {@link #setController(Controller) setController}
     */
    public AssistantSwingView() {
        // Begin with a null controller
        controller = null;
    }

    /**
     * Initialises the user interface for use. Throws IllegalStateException if a
     * controller isn't set up yet
     */
    @Override
    public void init() {
        // Make sure a controller is set up
        if (controller == null) {
            throw new IllegalStateException("Controller not set up yet."); //NOI18N
        }

        // Create the GUI
        Model model = controller.getModel();
        DebtTableModel tmodel = new DebtTableModel(model);

        //java.awt.EventQueue.invokeLater(() -> {
            mainView = new DebtsListFrame(tmodel, controller);
            mainView.setVisible(true);
        //});
    }

    /**
     * Updates the user interface
     */
    @Override
    public void update() {
        // Don't allow updating if main view was not initialised
        if (mainView == null) {
            throw new IllegalStateException("Cannot update before main view is initialised.");
        }
        mainView.update();
    }

    /**
     * Prepares the user interface for removal
     */
    @Override
    public void close() {
        // Make sure the main view was initialised
        if (mainView != null) {
            // Make the GUI invisible and removes it
            mainView.setVisible(false);
            mainView.dispose();
        }
    }

    /**
     * Returns the current controller. Throws IllegalStateException if no
     * controller is set up
     *
     * @return The controller being used
     */
    @Override
    public Controller getController() {
        // Make sure a controller is set up
        if (controller == null) {
            throw new IllegalStateException("Controller not set up yet."); //NOI18N
        }
        return controller;
    }

    /**
     * Returns the data model being used by the controller. Throws
     * IllegalStateException if controller isn't set up
     *
     * @return Data model
     */
    @Override
    public Model getModel() {
        Controller control = getController(); // throws if not set up
        return control.getModel();
    }

    /**
     * Sets up the controller for this view. Can be called multiple times, if a
     * controller is already set up,
     * {@link com.kacperstasiak.repaymentassistant.AssistantController#shutdown() shutdown()}
     * is called on it. Throws IllegalStateException if the passed controller is
     * invalid
     *
     * @param controller The controller instance to use
     */
    @Override
    public void setController(Controller controller) {
        // Make sure the controller is valid
        if (controller == null) {
            throw new IllegalStateException("Invalid controller."); //NOI18N
        }

        // If we're already using some controller, shut it down before 
        // continuing
        if (this.controller != null) {
            controller.shutdown();
        }

        // Update the controller to the new one
        this.controller = controller;
    }
}
