package com.kacperstasiak.repaymentscheduler;

/**
 * The view part of the MVC structure, displays the debts list and amounts to 
 * repay for each.
 * @author Kacper Stasiak
 */
public class ViewImpl implements View {
    private Controller controller;
    private DebtsListFrame mainView;
    
    /**
     * Public constructor for schedule view. A controller must be set before
     * calling {@link #init() init()} through 
     * {@link #setController(ScheduleController) setController}
     */
    public ViewImpl() {
        // Begin with a null controller
        controller = null;
    }
    
    /**
     * Initialises the user interface for use. Throws IllegelStateException
     * if a controller isn't set up yet
     */
    @Override
    public void init() {
        // Make sure a controller is set up
        if (controller == null) {
            throw new IllegalStateException("Controller not set up yet.");
        }
        
        // Create the GUI
        //java.awt.EventQueue.invokeLater(() -> {
            Model model = controller.getModel();
            ScheduleTableModel tmodel = new ScheduleTableModel(model);
            mainView = new DebtsListFrame(tmodel);
            mainView.setVisible(true);
        //});
    }
    
    /**
     * Prepares the user interface for removal
     */
    @Override
    public void close() {
        // Make the GUI invisible and remove all components
        mainView.setVisible(false);
        mainView.removeAll();
    }
    
    /**
     * Returns the current schedule controller. Throws IllegalStateException if
     * no controller is set up
     * @return Schedule controller being used
     */
    @Override
    public Controller getController() {
        // Make sure a controller is set up
        if (controller == null) {
            throw new IllegalStateException("Controller not set up yet.");
        }
        return controller;
    }
    
    /**
     * Returns the data model being used by the controller.
     * Throws IllegalStateException if controller isn't set up
     * @return Data model
     */
    @Override
    public Model getModel() {
        Controller contr = getController(); // throws if not set up
        return contr.getModel();
    }
    
    /**
     * Sets up the controller for this view. Can be called multiple times, 
     * if a controller is already set up, 
     * {@link com.kacperstasiak.repaymentscheduler.ControllerImpl#shutdown() shutdown()} 
     * is called on it. Throws IllegelStateException if the passed controller 
     * is invalid
     * @param controller The controller instance to use
     */
    @Override
    public void setController(Controller controller) {
        // Make sure the controller is valid
        if (controller == null) {
            throw new IllegalStateException("Invalid controller.");
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