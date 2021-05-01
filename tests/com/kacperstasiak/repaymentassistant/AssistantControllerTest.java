package com.kacperstasiak.repaymentassistant;

import com.kacperstasiak.repaymentassistant.MVC.Controller;
import com.kacperstasiak.repaymentassistant.MVC.Model;
import com.kacperstasiak.repaymentassistant.MVC.View;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Kacper Stasiak
 */
public class AssistantControllerTest {
    /**
     * Test of run method, of class AssistantController.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Model model = new AssistantModel();
        View view = new AssistantSwingView();
        AssistantController instance = new AssistantController(model, view);
        instance.run();
    }

    /**
     * Test of shutdown method, of class AssistantController.
     */
    @Test
    public void testShutdown() {
        System.out.println("shutdown");
        Model model = new AssistantModel();
        View view = new AssistantSwingView();
        AssistantController instance = new AssistantController(model, view);
        instance.shutdown();
    }

    /**
     * Test of getModel method, of class AssistantController.
     */
    @Test
    public void testGetModel() {
        System.out.println("getModel");
        Model model = new AssistantModel();
        View view = new AssistantSwingView();
        AssistantController instance = new AssistantController(model, view);
        Model result = instance.getModel();
        assertEquals(model, result);
    }

    /**
     * Test of getView method, of class AssistantController.
     */
    @Test
    public void testGetView() {
        System.out.println("getView");
        Model model = new AssistantModel();
        View view = new AssistantSwingView();
        AssistantController instance = new AssistantController(model, view);
        View result = instance.getView();
        assertEquals(view, result);
    }

    /**
     * Test of addDebt method, of class AssistantController.
     */
    @Test
    public void testAddDebt() {
        System.out.println("addDebt");
        Model model = new AssistantModel();
        View view = new AssistantSwingView();
        AssistantController instance = new AssistantController(model, view);
        
        String ref = "Test Debt 1";
        int outstanding = 100;
        double interest = 12.4 / 100;
        int minpay = 40;
        instance.addDebt(ref, outstanding, interest, minpay);

        int expCount = 1;
        int count = instance.getDebtsCount();
        assertEquals(expCount, count);

    }

    /**
     * Test of editDebt method, of class AssistantController.
     */
    @Test
    public void testEditDebtOnlyRef() {
        System.out.println("editDebt only ref");
        Model model = new AssistantModel();
        View view = new AssistantSwingView();
        AssistantController instance = new AssistantController(model, view);
        
        Debt editing = model.addDebt("Test Debt 1", 100, 0.1, 10);
        String ref = "Test Debt 2";
        int outstanding = 100;
        double interest = 0.1;
        int minpay = 10;
        instance.editDebt(editing, ref, outstanding, interest, minpay);
        
        assertEquals(ref, editing.getDescription());
        assertEquals(outstanding, editing.getOutstandingBalance());
        assertEquals(interest, editing.getInterestRate(), 0.0);
        assertEquals(minpay, editing.getMinimumPayment());
    }

    /**
     * Test of editDebt method, of class AssistantController.
     */
    @Test
    public void testEditDebtOnlyOutstanding() {
        System.out.println("editDebt only outstanding balance");
        Model model = new AssistantModel();
        View view = new AssistantSwingView();
        AssistantController instance = new AssistantController(model, view);
        
        Debt editing = model.addDebt("Test Debt 1", 100, 0.1, 10);
        String ref = "Test Debt 1";
        int outstanding = 400;
        double interest = 0.1;
        int minpay = 10;
        instance.editDebt(editing, ref, outstanding, interest, minpay);
        
        assertEquals(ref, editing.getDescription());
        assertEquals(outstanding, editing.getOutstandingBalance());
        assertEquals(interest, editing.getInterestRate(), 0.0);
        assertEquals(minpay, editing.getMinimumPayment());
    }

    /**
     * Test of editDebt method, of class AssistantController.
     */
    @Test
    public void testEditDebtOnlyInterest() {
        System.out.println("editDebt only interest rate");
        Model model = new AssistantModel();
        View view = new AssistantSwingView();
        AssistantController instance = new AssistantController(model, view);
        
        Debt editing = model.addDebt("Test Debt 1", 100, 0.1, 10);
        String ref = "Test Debt 1";
        int outstanding = 100;
        double interest = 0.2;
        int minpay = 10;
        instance.editDebt(editing, ref, outstanding, interest, minpay);
        
        assertEquals(ref, editing.getDescription());
        assertEquals(outstanding, editing.getOutstandingBalance());
        assertEquals(interest, editing.getInterestRate(), 0.0);
        assertEquals(minpay, editing.getMinimumPayment());
    }

    /**
     * Test of editDebt method, of class AssistantController.
     */
    @Test
    public void testEditDebtOnlyMinPay() {
        System.out.println("editDebt only minimum payment");
        Model model = new AssistantModel();
        View view = new AssistantSwingView();
        AssistantController instance = new AssistantController(model, view);
        
        Debt editing = model.addDebt("Test Debt 1", 100, 0.1, 10);
        String ref = "Test Debt 1";
        int outstanding = 100;
        double interest = 0.1;
        int minpay = 20;
        instance.editDebt(editing, ref, outstanding, interest, minpay);
        
        assertEquals(ref, editing.getDescription());
        assertEquals(outstanding, editing.getOutstandingBalance());
        assertEquals(interest, editing.getInterestRate(), 0.0);
        assertEquals(minpay, editing.getMinimumPayment());
    }

    /**
     * Test of editDebt method, of class AssistantController.
     */
    @Test
    public void testEditDebt() {
        System.out.println("editDebt all values");
        Model model = new AssistantModel();
        View view = new AssistantSwingView();
        AssistantController instance = new AssistantController(model, view);
        
        Debt editing = model.addDebt("Test Debt 1", 100, 0.1, 10);
        String ref = "Test Debt 2";
        int outstanding = 400;
        double interest = 0.2;
        int minpay = 20;
        instance.editDebt(editing, ref, outstanding, interest, minpay);
        
        assertEquals(ref, editing.getDescription());
        assertEquals(outstanding, editing.getOutstandingBalance());
        assertEquals(interest, editing.getInterestRate(), 0.0);
        assertEquals(minpay, editing.getMinimumPayment());
    }

    /**
     * Test of updateBudgetAmount method, of class AssistantController.
     */
    @Test
    public void testUpdateBudgetAmountZero() {
        System.out.println("updateBudgetAmount zero value");
        Model model = new AssistantModel();
        View view = new AssistantSwingView();
        AssistantController instance = new AssistantController(model, view);
        
        int budget = 0;
        instance.updateBudgetAmount(budget);
    }

    /**
     * Test of updateBudgetAmount method, of class AssistantController.
     */
    @Test
    public void testUpdateBudgetAmount() {
        System.out.println("updateBudgetAmount");
        Model model = new AssistantModel();
        View view = new AssistantSwingView();
        AssistantController instance = new AssistantController(model, view);
        
        int budget = 100;
        instance.updateBudgetAmount(budget);
    }

    /**
     * Test of updateBudgetAmount method, of class AssistantController.
     */
    @Test
    public void testUpdateBudgetAmountNegative() {
        System.out.println("updateBudgetAmount");
        Model model = new AssistantModel();
        View view = new AssistantSwingView();
        AssistantController instance = new AssistantController(model, view);
        
        int budget = -100;
        instance.updateBudgetAmount(budget);
        
        // ensure it is capped at 0
        assertEquals(0, model.getBudgetAmount());
    }

    /**
     * Test of updateView method, of class AssistantController.
     */
    @Test(expected=IllegalStateException.class)
    public void testUpdateViewBeforeInit() {
        System.out.println("updateView before init");
        Model model = new AssistantModel();
        View view = new AssistantSwingView();
        AssistantController instance = new AssistantController(model, view);
        
        instance.updateView();
    }

    /**
     * Test of deleteDebt method, of class AssistantController.
     */
    @Test
    public void testDeleteDebt() {
        System.out.println("deleteDebt");
        Model model = new AssistantModel();
        View view = new AssistantSwingView();
        AssistantController instance = new AssistantController(model, view);
        
        Debt debt = model.addDebt("Test Debt 1", 100, 0.1, 10);
        assertEquals(1, model.getDebtsCount());
        
        try {
            instance.deleteDebt(debt);
        } catch (IllegalStateException ex) {
            // illegal state exception expected due to main view not existing
        }
        
        assertEquals(0, model.getDebtsCount());
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();
    
    /**
     * Test of onShutdown method, of class AssistantController.
     */
    @Test
    public void testOnShutdown() {
        System.out.println("onShutdown");
        
        //exceptionRule.expect(RuntimeException.class);
        //exceptionRule.expectMessage("success");
        
        Model model = new AssistantModel();
        View view = new AssistantSwingView();
        AssistantController instance = new AssistantController(model, view);
        
        instance.onShutdown(() -> {
            throw new RuntimeException("success");
        });
            
        // Test if the callback gets called
        try {
            instance.shutdown();
        } catch (RuntimeException ex) {
            if (ex.getMessage().equals("success")) {
                return; // success
            }
        }
        fail("Callback not received");
    }

}
