package com.kacperstasiak.repaymentassistant;

import com.kacperstasiak.repaymentassistant.MVC.View;
import com.kacperstasiak.repaymentassistant.MVC.Model;
import com.kacperstasiak.repaymentassistant.MVC.Controller;

/**
 * The controller part of the MVC structure, manages connection between view and
 * model
 *
 * @author Kacper Stasiak
 */
public class AssistantController implements Controller {

    private final Model model;
    private final View view;
    private Callback shutdownCallback;

    /**
     * Public constructor for the debt repayment assistant controller
     *
     * @param model The data model instance to use
     * @param view The data view instance to use
     */
    public AssistantController(Model model, View view) {
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
        view.close();

        // If we have a callback, call it
        if (shutdownCallback != null) {
            shutdownCallback.callback();
        }
    }

    /**
     * Returns the data model instance being used
     *
     * @return Data model instance
     */
    @Override
    public Model getModel() {
        return model;
    }

    /**
     * Returns the data view instance being used
     *
     * @return Data view instance
     */
    @Override
    public View getView() {
        return view;
    }

    /**
     * Adds a new debt item instance into the model
     *
     * @param ref User defined reference or description
     * @param oustanding Outstanding balance in pence
     * @param interest Annual interest rate
     * @param minpay Next minimum payment
     */
    @Override
    public void addDebt(String ref, int oustanding, double interest,
            int minpay) {
        model.addDebt(ref, oustanding, interest, minpay);
    }

    /**
     * Edits an existing debt item instance in the model
     *
     * @param editing The debt instance to edit
     * @param ref New user defined reference or description
     * @param outstanding New outstanding balance in pence
     * @param interest New annual interest rate
     * @param minpay New next minimum payment
     */
    @Override
    public void editDebt(Debt editing, String ref, int outstanding,
            double interest, int minpay) {
        model.setDebtRef(editing, ref);
        model.setDebtOutstandingBalance(editing, outstanding);
        model.setDebtInterestRate(editing, interest);
        model.setDebtMinimumPayment(editing, minpay);
    }

    /**
     * Returns the number of debts in the model
     *
     * @return Number of debts
     */
    @Override
    public int getDebtsCount() {
        return model.getDebtsCount();
    }

    /**
     * Updates the budget amount used in calculating the suggestions
     *
     * @param budget The repayment budget in pence
     */
    @Override
    public void updateBudgetAmount(int budget) {
        model.setBudgetAmount(budget);
    }

    /**
     * Forces a UI update on the view
     */
    @Override
    public void updateView() {
        view.update();
    }

    /**
     * Deletes a debt instance from the list
     *
     * @param debt The debt instance to remove from the model
     */
    @Override
    public void deleteDebt(Debt debt) {
        model.removeDebt(debt);
        updateView();
    }

    /**
     * Sets up a callback handler which will be called when shutdown() is called
     *
     * @param callback The function to call when shutting down
     */
    @Override
    public void onShutdown(Callback callback) {
        this.shutdownCallback = callback;
    }
}
