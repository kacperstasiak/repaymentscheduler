package com.kacperstasiak.repaymentassistant.MVC;

/**
 * The interface for the view part of the MVC structure
 *
 * @author Kacper Stasiak
 */
public interface View {

    /**
     * Initialises the user interface for use.
     */
    public void init();

    /**
     * Updates the user interface
     */
    public void update();

    /**
     * Prepares the user interface for removal
     */
    public void close();

    /**
     * Sets up the controller for this view. Can be called multiple times, if a
     * controller is already set up,
     * {@link com.kacperstasiak.repaymentassistant.Controller.MVC#shutdown() shutdown()}
     * is called on it. Should throw IllegalStateException if the passed
     * controller is invalid
     *
     * @param controller The controller instance to use
     */
    public void setController(Controller controller);

    /**
     * Returns the current controller. Should throw IllegalStateException if no
     * controller is set up
     *
     * @return The controller being used
     */
    public Controller getController();

    /**
     * Returns the data model being used by the controller. Should throw
     * IllegalStateException if controller isn't set up
     *
     * @return Data model
     */
    public Model getModel();

}
