package com.kacperstasiak.repaymentscheduler.mvc;

/**
 * An abstract class for views to extend.
 * @author Kacper Stasiak
 */
public abstract class AbstractView {

    private AbstractController controller;

    protected AbstractView() {
        this.controller = null;
    }

    public void init() {
        if (this.controller == null) {
            throw new IllegalStateException("Controller not set up yet.");
        }
    }

    public abstract void close();

    public abstract void update();

    protected AbstractController getController() {
        if (this.controller == null) {
            throw new IllegalStateException("Controller not set up yet.");
        }
        return this.controller;
    }

    protected AbstractModel getModel() {
        return getController().getModel();
    }

    protected void setController(final AbstractController controller) {
        if (controller == null) {
            throw new IllegalStateException("Controller not set up yet.");
        }
        if (this.controller != null) {
            controller.shutdown();
        }
        this.controller = controller;
    }
}
