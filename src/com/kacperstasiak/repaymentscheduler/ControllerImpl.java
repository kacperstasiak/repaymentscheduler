package com.kacperstasiak.repaymentscheduler;

/**
 * The controller part of the MVC structure, manages connection between
 * view and model
 * @author Kacper Stasiak
 */
public class ControllerImpl implements Controller {

    private final Model model;
    private final View view;

    /**
     * Public constructor for the Schedule Controller
     * @param model The data model instance to use
     * @param view The data view instance to use
     */
    public ControllerImpl(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setController(this);
    }

    /**
     * Begins the operation of the view and model
     */
    @Override
    public void run() {
        view.init();
    }

    /**
     * Ends the operation of the view and model and saves it
     */
    @Override
    public void shutdown() {
        // todo: destroy views and save model
        view.close();
    }

    /**
     * Returns the data model instance being used
     * @return Data model instance
     */
    @Override
    public Model getModel() {
        return model;
    }

    /**
     * Returns the data view instance being used
     * @return Data view instance
     */
    @Override
    public View getView() {
        return view;
    }

    /**
     * Updates the budget amount used in calculating the suggestions
     * @param budget The repayment budget in pence
     */
    @Override
    public void updateBudgetAmount(int budget) {
        model.setBudgetAmount(budget);
    }
}
