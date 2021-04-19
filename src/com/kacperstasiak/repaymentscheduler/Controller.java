package com.kacperstasiak.repaymentscheduler;

/**
 * The interface for the controller part of the MVC structure
 * @author Kacper Stasiak
 */
public interface Controller {
    public void shutdown();

    public Model getModel();
    public View getView();

    public void run();
    
    public void addDebt(String ref, int oustanding, double interest, int minpay);

    public void updateBudgetAmount(int budget);
}
