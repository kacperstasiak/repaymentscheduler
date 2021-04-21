package com.kacperstasiak.repaymentscheduler;

/**
 * The controller part of the MVC structure, manages connection between
 * view and model
 * @author Kacper Stasiak
 */
public class ControllerImpl implements Controller {

    private final Model model;
    private final View view;
    private AddEditFrame addeditView;

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
     * Adds a new debt item instance into the model
     * @param ref User defined reference or description
     * @param oustanding Outstanding balance in pence
     * @param interest Annual interest rate
     * @param minpay Next minimum payment
     */
    @Override
    public void addDebt(String ref, int oustanding, double interest, int minpay) {
        model.addDebt(ref, oustanding, interest, minpay);
    }

    /**
     * Edits an existing debt item instance in the model
     * @param editing The debt instance to edit
     * @param ref New user defined reference or description
     * @param oustanding New outstanding balance in pence
     * @param interest New annual interest rate
     * @param minpay New next minimum payment
     */
    @Override
    public void editDebt(Debt editing, String ref, int oustanding, 
            double interest, int minpay) {
        model.setDebtInterestRate(editing, interest);
    }

    /**
     * Updates the budget amount used in calculating the suggestions
     * @param budget The repayment budget in pence
     */
    @Override
    public void updateBudgetAmount(int budget) {
        model.setBudgetAmount(budget);
    }
    
    @Override
    public void updateView() {
        view.update();
    }

    @Override
    public void openEditMenu() {
        
    }

    @Override
    public void openAddMenu() {
        if (addeditView == null) {
            addeditView = new AddEditFrame(this);
            addeditView.setVisible(true);
        }
    }
    
    @Override
    public void closeAddMenu() {
        if (addeditView != null) {
            addeditView.dispose();
            addeditView = null;
        }
    }
}
