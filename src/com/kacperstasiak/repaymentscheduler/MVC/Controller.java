package com.kacperstasiak.repaymentscheduler.MVC;

import com.kacperstasiak.repaymentscheduler.Debt;

/**
 * The interface for the controller part of the MVC structure
 * @author Kacper Stasiak
 */
public interface Controller {
    public void shutdown();

    public Model getModel();
    public View getView();

    public void run();
    
    public void addDebt(String ref, int oustanding, double interest, 
            int minpay);

    public void editDebt(Debt editing, String ref, int outstanding, 
            double interest, int minpay);
    
    public int getDebtsCount();

    public void updateBudgetAmount(int budget);

    public void updateView();

    public void deleteDebt(Debt debt);
    
    
    public interface Callback {
        void callback();
    }
    
    public void onShutdown(Callback callback);
}
