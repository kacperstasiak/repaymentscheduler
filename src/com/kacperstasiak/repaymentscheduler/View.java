package com.kacperstasiak.repaymentscheduler;

/**
 * The interface for the view part of the MVC structure
 * @author Kacper Stasiak
 */
public interface View {
    public void init();
    public void close();
    
    public void setController(Controller controller);
    public Controller getController();
    
    public Model getModel();

}
