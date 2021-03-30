package com.kacperstasiak.repaymentscheduler.mvc;

/**
 * An abstract class for controllers to extend.
 * @author Kacper Stasiak
 */
public abstract class AbstractController {
    private final AbstractModel model;
    private final AbstractView view;
    
    protected AbstractController(final AbstractModel model, final AbstractView view) {
        this.model = model;
        this.view = view;
        
        view.setController(this);
    }
    
    public abstract void shutdown();
    
    public abstract void run();
    
    protected AbstractModel getModel() {
        return this.model;
    }

    protected AbstractView getView() {
        return this.view;
    }
}
