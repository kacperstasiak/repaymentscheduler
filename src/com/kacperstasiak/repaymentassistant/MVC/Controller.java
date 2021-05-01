package com.kacperstasiak.repaymentassistant.MVC;

import com.kacperstasiak.repaymentassistant.Debt;

/**
 * The interface for the controller part of the MVC structure
 *
 * @author Kacper Stasiak
 */
public interface Controller {

    /**
     * Ends the operation of the view and model
     */
    public void shutdown();

    /**
     * Returns the data model instance being used
     *
     * @return Data model instance
     */
    public Model getModel();

    /**
     * Returns the data view instance being used
     *
     * @return Data view instance
     */
    public View getView();

    /**
     * Begins the operation of the view and model
     */
    public void run();

    /**
     * Adds a new debt item instance into the model
     *
     * @param ref User defined reference or description
     * @param outstanding Outstanding balance in pence
     * @param interest Annual interest rate
     * @param minpay Next minimum payment
     */
    public void addDebt(String ref, int outstanding, double interest,
            int minpay);

    /**
     * Edits an existing debt item instance in the model
     *
     * @param editing The debt instance to edit
     * @param ref New user defined reference or description
     * @param outstanding New outstanding balance in pence
     * @param interest New annual interest rate
     * @param minpay New next minimum payment
     */
    public void editDebt(Debt editing, String ref, int outstanding,
            double interest, int minpay);

    /**
     * Returns the number of debts in the model
     *
     * @return Number of debts
     */
    public int getDebtsCount();

    /**
     * Updates the budget amount used in calculating the suggestions
     *
     * @param budget The repayment budget in pence
     */
    public void updateBudgetAmount(int budget);

    /**
     * Forces a UI update on the view
     */
    public void updateView();

    /**
     * Deletes a debt instance from the list
     *
     * @param debt The debt instance to remove from the model
     */
    public void deleteDebt(Debt debt);

    /**
     * The interface that describes a callback class. Can be used in lambda
     * expressions.
     */
    public interface Callback {

        /**
         * The function that will be called when triggered
         */
        public void callback();
    }

    /**
     * Sets up a callback handler which will be called when shutdown() is called
     *
     * @param callback The function to call when shutting down
     */
    public void onShutdown(Callback callback);
}
