package com.kacperstasiak.repaymentassistant;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kacper Stasiak
 */
public class AssistantModelTest {

    private static final String DEBT_NAME_1 = "Test Debt 1";
    private static final String DEBT_NAME_2 = "Test Debt 2";
    private static final String DEBT_NAME_3 = "Test Debt 3";
    private static final String DEBT_NAME_4 = "Test Debt 4";
    private static final String DEBT_NAME_5 = "Test Debt 5";
    private static final String DEBT_NAME_6 = "Test Debt 6";
    private static final String DEBT_NAME_7 = "Test Debt 7";
    private static final String DEBT_NAME_8 = "Test Debt 8";

    /**
     * Test of addDebt method, of class AssistantModel.
     */
    @Test
    public void testAddDebtValid() {
        System.out.println("addDebt valid debt data");
        String desc = DEBT_NAME_1;
        int outstanding = 100;
        double interest = 0.1;
        int minPayment = 10;
        AssistantModel instance = new AssistantModel();
        instance.addDebt(desc, outstanding, interest, minPayment);
    }

    /**
     * Test of addDebt method, of class AssistantModel.
     */
    @Test
    public void testAddDebtOutstandingZero() {
        System.out.println("addDebt outstanding balance zero");
        String desc = DEBT_NAME_1;
        int outstanding = 0;
        double interest = 0.1;
        int minPayment = 10;
        AssistantModel instance = new AssistantModel();
        instance.addDebt(desc, outstanding, interest, minPayment);
    }

    /**
     * Test of addDebt method, of class AssistantModel.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddDebtInvalidOutstanding() {
        System.out.println("addDebt bad outstanding balance");
        String desc = DEBT_NAME_1;
        int outstanding = -100;
        double interest = 0.1;
        int minPayment = 10;
        AssistantModel instance = new AssistantModel();
        instance.addDebt(desc, outstanding, interest, minPayment);
    }

    /**
     * Test of addDebt method, of class AssistantModel.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddDebtInvalidInterestNegative() {
        System.out.println("addDebt bad interest negative value");
        String desc = DEBT_NAME_1;
        int outstanding = 100;
        double interest = -0.2;
        int minPayment = 10;
        AssistantModel instance = new AssistantModel();
        instance.addDebt(desc, outstanding, interest, minPayment);
    }

    /**
     * Test of addDebt method, of class AssistantModel.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddDebtInvalidInterestTooHigh() {
        System.out.println("addDebt bad interest too high");
        String desc = DEBT_NAME_1;
        int outstanding = 100;
        double interest = 3.2;
        int minPayment = 10;
        AssistantModel instance = new AssistantModel();
        instance.addDebt(desc, outstanding, interest, minPayment);
    }

    /**
     * Test of addDebt method, of class AssistantModel.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddDebtMinPayNegative() {
        System.out.println("addDebt bad minimum pay");
        String desc = DEBT_NAME_1;
        int outstanding = 100;
        double interest = 0.1;
        int minPayment = -20;
        AssistantModel instance = new AssistantModel();
        instance.addDebt(desc, outstanding, interest, minPayment);
    }

    /**
     * Test of addDebt method, of class AssistantModel.
     */
    @Test
    public void testAddDebtMinPayZero() {
        System.out.println("addDebt zero minimum pay");
        String desc = DEBT_NAME_1;
        int outstanding = 100;
        double interest = 0.1;
        int minPayment = 0;
        AssistantModel instance = new AssistantModel();
        instance.addDebt(desc, outstanding, interest, minPayment);
    }

    /**
     * Test of removeDebt method, of class AssistantModel.
     */
    @Test()
    public void testRemoveDebtNotAdded() {
        System.out.println("removeDebt that wasn't added");
        Debt debt = new Debt(DEBT_NAME_1, 100, 0.1, 10);
        AssistantModel instance = new AssistantModel();
        instance.removeDebt(debt);
    }

    /**
     * Test of removeDebt method, of class AssistantModel.
     */
    @Test
    public void testRemoveDebt() {
        System.out.println("removeDebt that was added");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        instance.removeDebt(debt);
    }

    /**
     * Test of getDebtRef method, of class AssistantModel.
     */
    @Test
    public void testGetDebtRef() {
        System.out.println("getDebtRef");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        String expResult = DEBT_NAME_1;
        String result = instance.getDebtRef(debt);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDebtRef method, of class AssistantModel.
     */
    @Test
    public void testGetDebtRefDescChangedExternally() {
        System.out.println("getDebtRef external change");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        debt.setDescription(DEBT_NAME_8);
        String expResult = DEBT_NAME_8;
        String result = instance.getDebtRef(debt);
        assertEquals(expResult, result);
    }

    /**
     * Test of setDebtRef method, of class AssistantModel.
     */
    @Test
    public void testSetDebtRef() {
        System.out.println("setDebtRef");
        String ref = DEBT_NAME_8;
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        instance.setDebtRef(debt, ref);
        assertEquals(ref, instance.getDebtRef(debt));
        assertEquals(ref, debt.getDescription());
    }

    /**
     * Test of getDebtInterestRate method, of class AssistantModel.
     */
    @Test
    public void testGetDebtInterestRate() {
        System.out.println("getDebtInterestRate");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        double expResult = 0.1;
        double result = instance.getDebtInterestRate(debt);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getDebtInterestRate method, of class AssistantModel.
     */
    @Test
    public void testGetDebtInterestRateInvalidRateChange() {
        System.out.println("getDebtInterestRate after attempted change to invalid value");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        try {
            // set to invalid value
            instance.setDebtInterestRate(debt, 2.0);
        } catch (IllegalArgumentException ex) {
            // do nothing
        }
        // expect unchanged
        double expResult = 0.1;
        double result = instance.getDebtInterestRate(debt);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getDebtInterestRate method, of class AssistantModel.
     */
    @Test
    public void testGetDebtInterestRateChangedExternally() {
        System.out.println("getDebtInterestRate external change");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        debt.setInterestRate(0.7);
        double expResult = 0.7;
        double result = instance.getDebtInterestRate(debt);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setDebtInterestRate method, of class AssistantModel.
     */
    @Test
    public void testSetDebtInterestRate() {
        System.out.println("setDebtInterestRate to 20%");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        double rate = 0.2;
        instance.setDebtInterestRate(debt, rate);
        assertEquals(rate, instance.getDebtInterestRate(debt), 0.0);
    }

    /**
     * Test of setDebtInterestRate method, of class AssistantModel.
     */
    @Test
    public void testSetDebtInterestRateZero() {
        System.out.println("setDebtInterestRate to 0%");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        double rate = 0;
        instance.setDebtInterestRate(debt, rate);
        assertEquals(rate, instance.getDebtInterestRate(debt), 0.0);
    }

    /**
     * Test of setDebtInterestRate method, of class AssistantModel.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDebtInterestRateTo100() {
        System.out.println("setDebtInterestRate to 100%");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        double rate = 1.0;
        instance.setDebtInterestRate(debt, rate);
    }

    /**
     * Test of setDebtInterestRate method, of class AssistantModel.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDebtInterestRateTooHigh() {
        System.out.println("setDebtInterestRate to 200%");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        double rate = 2.0;
        instance.setDebtInterestRate(debt, rate);
    }

    /**
     * Test of setDebtInterestRate method, of class AssistantModel.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDebtInterestRateNegative() {
        System.out.println("setDebtInterestRate to -50%");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        double rate = -0.5;
        instance.setDebtInterestRate(debt, rate);
    }

    /**
     * Test of getDebtOutstandingBalance method, of class AssistantModel.
     */
    @Test
    public void testGetDebtOutstandingBalance() {
        System.out.println("getDebtOutstandingBalance");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        int expResult = 100;
        int result = instance.getDebtOutstandingBalance(debt);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDebtOutstandingBalance method, of class AssistantModel.
     */
    @Test
    public void testGetDebtOutstandingBalanceAfterInvalidChange() {
        System.out.println("getDebtOutstandingBalance after attempted change to invalid value");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        try {
            instance.setDebtOutstandingBalance(debt, -100);
        } catch (IllegalArgumentException ex) {
            // do nothing
        }
        // expect unchanged
        int expResult = 100;
        int result = instance.getDebtOutstandingBalance(debt);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDebtOutstandingBalance method, of class AssistantModel.
     */
    @Test
    public void testGetDebtOutstandingBalanceChangedExternally() {
        System.out.println("getDebtOutstandingBalance external change");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        debt.setOutstandingBalance(500);
        int expResult = 500;
        int result = instance.getDebtOutstandingBalance(debt);
        assertEquals(expResult, result);
    }

    /**
     * Test of setDebtOutstandingBalance method, of class AssistantModel.
     */
    @Test
    public void testSetDebtOutstandingBalance() {
        System.out.println("setDebtOutstandingBalance to 200");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        int outstanding = 200;
        instance.setDebtOutstandingBalance(debt, outstanding);
        assertEquals(outstanding, instance.getDebtOutstandingBalance(debt));
    }

    /**
     * Test of setDebtOutstandingBalance method, of class AssistantModel.
     */
    @Test
    public void testSetDebtOutstandingBalanceZero() {
        System.out.println("setDebtOutstandingBalance to 0");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        int outstanding = 0;
        instance.setDebtOutstandingBalance(debt, outstanding);
        assertEquals(outstanding, instance.getDebtOutstandingBalance(debt));
    }

    /**
     * Test of setDebtOutstandingBalance method, of class AssistantModel.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDebtOutstandingBalanceNegative() {
        System.out.println("setDebtOutstandingBalance to -100");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        int outstanding = -100;
        instance.setDebtOutstandingBalance(debt, outstanding);
    }

    /**
     * Test of getDebtMinimumPayment method, of class AssistantModel.
     */
    @Test
    public void testGetDebtMinimumPayment() {
        System.out.println("getDebtMinimumPayment");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        int expResult = 10;
        int result = instance.getDebtMinimumPayment(debt);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDebtMinimumPayment method, of class AssistantModel.
     */
    @Test
    public void testGetDebtMinimumPaymentAfterInvalidChange() {
        System.out.println("getDebtMinimumPayment after attempted change to invalid value");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        try {
            instance.setDebtMinimumPayment(debt, -100);
        } catch (IllegalArgumentException ex) {
            // do nothing
        }
        // expect unchanged
        int expResult = 10;
        int result = instance.getDebtMinimumPayment(debt);
        assertEquals(expResult, result);
    }

    /**
     * Test of getDebtMinimumPayment method, of class AssistantModel.
     */
    @Test
    public void testGetDebtMinimumPaymentChangedExternally() {
        System.out.println("getDebtMinimumPayment external change");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        debt.setMinimumPayment(60);
        int expResult = 60;
        int result = instance.getDebtMinimumPayment(debt);
        assertEquals(expResult, result);
    }

    /**
     * Test of setDebtMinimumPayment method, of class AssistantModel.
     */
    @Test
    public void testSetDebtMinimumPayment() {
        System.out.println("setDebtMinimumPayment to 50");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        int amount = 50;
        instance.setDebtMinimumPayment(debt, amount);
        assertEquals(amount, instance.getDebtMinimumPayment(debt));
    }

    /**
     * Test of setDebtMinimumPayment method, of class AssistantModel.
     */
    @Test
    public void testSetDebtMinimumPaymentZero() {
        System.out.println("setDebtMinimumPayment to 0");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        int amount = 0;
        instance.setDebtMinimumPayment(debt, amount);
        assertEquals(amount, instance.getDebtMinimumPayment(debt));
    }

    /**
     * Test of setDebtMinimumPayment method, of class AssistantModel.
     */
    @Test
    public void testSetDebtMinimumPaymentBeyondOutstandingBalance() {
        System.out.println("setDebtMinimumPayment to 250");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        int amount = 250;
        instance.setDebtMinimumPayment(debt, amount);
        assertEquals(instance.getDebtOutstandingBalance(debt), instance.getDebtMinimumPayment(debt));
    }

    /**
     * Test of setDebtMinimumPayment method, of class AssistantModel.
     */
    @Test
    public void testSetDebtMinimumPaymentEqualOutstandingBalance() {
        System.out.println("setDebtMinimumPayment to 100");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        int amount = 100;
        instance.setDebtMinimumPayment(debt, amount);
        assertEquals(instance.getDebtOutstandingBalance(debt), instance.getDebtMinimumPayment(debt));
    }

    /**
     * Test of setDebtMinimumPayment method, of class AssistantModel.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDebtMinimumPaymentNegative() {
        System.out.println("setDebtMinimumPayment to -100");
        AssistantModel instance = new AssistantModel();
        Debt debt = instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        int amount = -100;
        instance.setDebtMinimumPayment(debt, amount);
    }

    /**
     * Test of getMinimumPaymentSum method, of class AssistantModel.
     */
    @Test
    public void testGetMinimumPaymentSumNoDebts() {
        System.out.println("getMinimumPaymentSum 1 debt");
        AssistantModel instance = new AssistantModel();
        int expResult = 0;
        int result = instance.getMinimumPaymentSum();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinimumPaymentSum method, of class AssistantModel.
     */
    @Test
    public void testGetMinimumPaymentSum1Debt() {
        System.out.println("getMinimumPaymentSum 1 debt");
        AssistantModel instance = new AssistantModel();
        instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        int expResult = 10;
        int result = instance.getMinimumPaymentSum();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinimumPaymentSum method, of class AssistantModel.
     */
    @Test
    public void testGetMinimumPaymentSum2Debts() {
        System.out.println("getMinimumPaymentSum 2 debt");
        AssistantModel instance = new AssistantModel();
        instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        instance.addDebt(DEBT_NAME_2, 4000, 0.14, 80);
        int expResult = 10 + 80;
        int result = instance.getMinimumPaymentSum();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMinimumPaymentSum method, of class AssistantModel.
     */
    @Test
    public void testGetMinimumPaymentSum1DebtPlus1InvalidAdd() {
        System.out.println("getMinimumPaymentSum 1 debt");
        AssistantModel instance = new AssistantModel();
        instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        try {
            // add debt with invalid values
            instance.addDebt(DEBT_NAME_2, -200, 0.15, 15);
        } catch (IllegalArgumentException ex) {
            // dp nothing
        }
        int expResult = 10;
        int result = instance.getMinimumPaymentSum();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBudgetAmount method, of class AssistantModel.
     */
    @Test
    public void testSetBudgetAmount() {
        System.out.println("setBudgetAmount");
        int budget = 1000;
        AssistantModel instance = new AssistantModel();
        instance.setBudgetAmount(budget);
        assertEquals(budget, instance.getBudgetAmount());
    }

    /**
     * Test of setBudgetAmount method, of class AssistantModel.
     */
    @Test
    public void testSetBudgetAmountZero() {
        System.out.println("setBudgetAmount");
        int budget = 0;
        AssistantModel instance = new AssistantModel();
        instance.setBudgetAmount(budget);
        assertEquals(budget, instance.getBudgetAmount());
    }

    /**
     * Test of setBudgetAmount method, of class AssistantModel.
     */
    @Test
    public void testSetBudgetAmountNegative() {
        System.out.println("setBudgetAmount");
        int budget = -100;
        AssistantModel instance = new AssistantModel();
        instance.setBudgetAmount(budget);
        // Should cap at 0
        assertEquals(0, instance.getBudgetAmount());
    }

    /**
     * Test of getDebtRepaymentSuggestions method, of class AssistantModel.
     */
    @Test
    public void testGetDebtRepaymentSuggestions1SmallBudget() {
        System.out.println("getDebtRepaymentSuggestions 30 budget normal debt");
        AssistantModel instance = new AssistantModel();
        Map<Debt, Integer> expResult = new HashMap<>();

        instance.setBudgetAmount(30);
        expResult.put(instance.addDebt(DEBT_NAME_1, 1000, 0.12, 10), 6);  // less than minimum
        expResult.put(instance.addDebt(DEBT_NAME_1, 2000, 0.08, 20), 0);  // nothing
        expResult.put(instance.addDebt(DEBT_NAME_2, 400, 0.21, 4), 4);    // full minimum payment
        expResult.put(instance.addDebt(DEBT_NAME_3, 600, 0.08, 6), 0);    // nothing
        expResult.put(instance.addDebt(DEBT_NAME_4, 2000, 0.16, 20), 20); // full minimum payment

        Map<Debt, Integer> result = instance.getDebtRepaymentSuggestions();
        result.entrySet().forEach((suggestion) -> {
            Debt d = suggestion.getKey();
            assertEquals(suggestion.getValue(), expResult.get(d));
        });
    }

    /**
     * Test of getDebtRepaymentSuggestions method, of class AssistantModel.
     */
    @Test
    public void testGetDebtRepaymentSuggestions1PerfectBudget() {
        System.out.println("getDebtRepaymentSuggestions 60 budget normal debt");
        AssistantModel instance = new AssistantModel();
        Map<Debt, Integer> expResult = new HashMap<>();

        instance.setBudgetAmount(60);
        expResult.put(instance.addDebt(DEBT_NAME_1, 1000, 0.12, 10), 10); // full minimum payment
        expResult.put(instance.addDebt(DEBT_NAME_2, 2000, 0.08, 20), 20); // full minimum payment
        expResult.put(instance.addDebt(DEBT_NAME_3, 400, 0.21, 4), 4);    // full minimum payment
        expResult.put(instance.addDebt(DEBT_NAME_4, 600, 0.08, 6), 6);    // full minimum payment
        expResult.put(instance.addDebt(DEBT_NAME_5, 2000, 0.16, 20), 20); // full minimum payment

        Map<Debt, Integer> result = instance.getDebtRepaymentSuggestions();
        result.entrySet().forEach((suggestion) -> {
            Debt d = suggestion.getKey();
            assertEquals(suggestion.getValue(), expResult.get(d));
        });
    }

    /**
     * Test of getDebtRepaymentSuggestions method, of class AssistantModel.
     */
    @Test
    public void testGetDebtRepaymentSuggestions1BigBudget() {
        System.out.println("getDebtRepaymentSuggestions 600 budget normal debt");
        AssistantModel instance = new AssistantModel();
        Map<Debt, Integer> expResult = new HashMap<>();

        instance.setBudgetAmount(600);
        expResult.put(instance.addDebt(DEBT_NAME_1, 1000, 0.12, 10), 10); // full minimum payment
        expResult.put(instance.addDebt(DEBT_NAME_2, 2000, 0.08, 20), 20); // full minimum payment
        expResult.put(instance.addDebt(DEBT_NAME_3, 400, 0.21, 4), 400);  // full outstanding balance
        expResult.put(instance.addDebt(DEBT_NAME_4, 600, 0.08, 6), 6);    // full minimum payment
        expResult.put(instance.addDebt(DEBT_NAME_5, 2000, 0.16, 20), 164);// full minimum payment + 144 of remaing budget

        Map<Debt, Integer> result = instance.getDebtRepaymentSuggestions();
        result.entrySet().forEach((suggestion) -> {
            Debt d = suggestion.getKey();
            assertEquals(suggestion.getValue(), expResult.get(d));
        });
    }

    /**
     * Test of getDebtRepaymentSuggestions method, of class AssistantModel.
     */
    @Test
    public void testGetDebtRepaymentSuggestions2SmallBudget() {
        System.out.println("getDebtRepaymentSuggestions 30 budget less debt");
        AssistantModel instance = new AssistantModel();
        Map<Debt, Integer> expResult = new HashMap<>();

        instance.setBudgetAmount(30);
        expResult.put(instance.addDebt(DEBT_NAME_1, 1000, 0.12, 10), 10);  // full minimum payment
        expResult.put(instance.addDebt(DEBT_NAME_2, 2000, 0.08, 20), 0);  // nothing
        expResult.put(instance.addDebt(DEBT_NAME_4, 600, 0.08, 6), 0);    // nothing
        expResult.put(instance.addDebt(DEBT_NAME_5, 2000, 0.16, 20), 20); // full minimum payment

        Map<Debt, Integer> result = instance.getDebtRepaymentSuggestions();
        result.entrySet().forEach((suggestion) -> {
            Debt d = suggestion.getKey();
            assertEquals(suggestion.getValue(), expResult.get(d));
        });
    }

    /**
     * Test of getDebtRepaymentSuggestions method, of class AssistantModel.
     */
    @Test
    public void testGetDebtRepaymentSuggestions2AtSameBudget() {
        System.out.println("getDebtRepaymentSuggestions 60 budget less debt");
        AssistantModel instance = new AssistantModel();
        Map<Debt, Integer> expResult = new HashMap<>();

        instance.setBudgetAmount(60);
        expResult.put(instance.addDebt(DEBT_NAME_1, 1000, 0.12, 10), 10); // full minimum payment
        expResult.put(instance.addDebt(DEBT_NAME_2, 2000, 0.08, 20), 20); // full minimum payment
        expResult.put(instance.addDebt(DEBT_NAME_4, 600, 0.08, 6), 6);    // full minimum payment
        expResult.put(instance.addDebt(DEBT_NAME_5, 2000, 0.16, 20), 24); // beyond full minimum payment

        Map<Debt, Integer> result = instance.getDebtRepaymentSuggestions();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDebtRepaymentSuggestions method, of class AssistantModel.
     */
    @Test
    public void testGetDebtRepaymentSuggestions2AtBigBudget() {
        System.out.println("getDebtRepaymentSuggestions 600 budget less debt");
        AssistantModel instance = new AssistantModel();
        Map<Debt, Integer> expResult = new HashMap<>();

        instance.setBudgetAmount(600);
        expResult.put(instance.addDebt(DEBT_NAME_1, 1000, 0.12, 10), 10); // full minimum payment
        expResult.put(instance.addDebt(DEBT_NAME_2, 2000, 0.08, 20), 20); // full minimum payment
        expResult.put(instance.addDebt(DEBT_NAME_4, 600, 0.08, 6), 6);    // full minimum payment
        expResult.put(instance.addDebt(DEBT_NAME_5, 2000, 0.16, 20), 564); // beyond full minimum payment

        Map<Debt, Integer> result = instance.getDebtRepaymentSuggestions();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDebtsCount method, of class AssistantModel.
     */
    @Test
    public void testGetDebtsCountNoDebts() {
        System.out.println("getDebtsCount");
        AssistantModel instance = new AssistantModel();
        int expResult = 0;
        int result = instance.getDebtsCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDebtsCount method, of class AssistantModel.
     */
    @Test
    public void testGetDebtsCount1Debt() {
        System.out.println("getDebtsCount");
        AssistantModel instance = new AssistantModel();
        instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        int expResult = 1;
        int result = instance.getDebtsCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDebtsCount method, of class AssistantModel.
     */
    @Test
    public void testGetDebtsCount7Debt() {
        System.out.println("getDebtsCount");
        AssistantModel instance = new AssistantModel();
        instance.addDebt(DEBT_NAME_1, 100, 0.12, 15);
        instance.addDebt(DEBT_NAME_2, 600, 0.15, 20);
        instance.addDebt(DEBT_NAME_3, 4000, 0.2, 12);
        instance.addDebt(DEBT_NAME_4, 1000, 0.08, 17);
        instance.addDebt(DEBT_NAME_5, 2000, 0.11, 400);
        instance.addDebt(DEBT_NAME_6, 2700, 0.04, 42);
        instance.addDebt(DEBT_NAME_7, 20, 0.09, 5);
        int expResult = 7;
        int result = instance.getDebtsCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDebtsCount method, of class AssistantModel.
     */
    @Test
    public void testGetDebtsCount7DebtWith1Deletion() {
        System.out.println("getDebtsCount");
        AssistantModel instance = new AssistantModel();
        instance.addDebt(DEBT_NAME_1, 100, 0.12, 15);
        instance.addDebt(DEBT_NAME_2, 600, 0.15, 20);
        instance.addDebt(DEBT_NAME_3, 4000, 0.2, 12);
        instance.addDebt(DEBT_NAME_4, 1000, 0.08, 17);
        Debt d = instance.addDebt(DEBT_NAME_5, 2000, 0.11, 400);
        instance.addDebt(DEBT_NAME_6, 2700, 0.04, 42);
        instance.addDebt(DEBT_NAME_7, 20, 0.09, 5);
        instance.removeDebt(d);
        int expResult = 6;
        int result = instance.getDebtsCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDebtsCount method, of class AssistantModel.
     */
    @Test
    public void testGetDebtsCount1DebtPlus1InvalidAdd() {
        System.out.println("getDebtsCount after attempted add invalid debt");
        AssistantModel instance = new AssistantModel();
        instance.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        try {
            // add debt with invalid values
            instance.addDebt(DEBT_NAME_2, -200, 0.15, 15);
        } catch (IllegalArgumentException ex) {
            // dp nothing
        }

        // expect unchanged
        int expResult = 1;
        int result = instance.getDebtsCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of load method, of class AssistantModel.
     */
    @Test
    public void testSaveLoad() {
        System.out.println("save and load");
        String filepath = "./testsave.ser";

        AssistantModel model = new AssistantModel();
        AssistantModel.save(model, filepath);
        AssistantModel result = AssistantModel.load(filepath);

        assertEquals(model.getDebtsCount(), result.getDebtsCount());
        for (int i = 0; i < model.getDebtsCount(); i++) {
            Debt debt1 = model.getDebts().get(i);
            Debt debt2 = result.getDebts().get(i);
            assertEquals(debt1.getDescription(), debt2.getDescription());
            assertEquals(debt1.getOutstandingBalance(), debt2.getOutstandingBalance());
            assertEquals(debt1.getInterestRate(), debt2.getInterestRate(), 0.0);
            assertEquals(debt1.getMinimumPayment(), debt2.getMinimumPayment());
        }
    }

    /**
     * Test of load method, of class AssistantModel.
     */
    @Test
    public void testSaveLoad1Debt() {
        System.out.println("save 1 debt and load");
        String filepath = "./testsave.ser";

        AssistantModel model = new AssistantModel();
        model.addDebt(DEBT_NAME_1, 100, 0.1, 10);
        AssistantModel.save(model, filepath);
        AssistantModel result = AssistantModel.load(filepath);

        assertEquals(model.getDebtsCount(), result.getDebtsCount());
        for (int i = 0; i < model.getDebtsCount(); i++) {
            Debt debt1 = model.getDebts().get(i);
            Debt debt2 = result.getDebts().get(i);
            assertEquals(debt1.getDescription(), debt2.getDescription());
            assertEquals(debt1.getOutstandingBalance(), debt2.getOutstandingBalance());
            assertEquals(debt1.getInterestRate(), debt2.getInterestRate(), 0.0);
            assertEquals(debt1.getMinimumPayment(), debt2.getMinimumPayment());
        }
    }

    /**
     * Test of load method, of class AssistantModel.
     */
    @Test
    public void testSaveLoad3Debts() {
        System.out.println("save 3 debts and load");
        String filepath = "./testsave.ser";

        AssistantModel model = new AssistantModel();
        model.addDebt(DEBT_NAME_1, 200, 0.1, 10);
        model.addDebt(DEBT_NAME_2, 1000, 0.15, 150);
        model.addDebt(DEBT_NAME_3, 150, 0.2, 100);
        AssistantModel.save(model, filepath);
        AssistantModel result = AssistantModel.load(filepath);

        assertEquals(model.getDebtsCount(), result.getDebtsCount());
        for (int i = 0; i < model.getDebtsCount(); i++) {
            Debt debt1 = model.getDebts().get(i);
            Debt debt2 = result.getDebts().get(i);
            assertEquals(debt1.getDescription(), debt2.getDescription());
            assertEquals(debt1.getOutstandingBalance(), debt2.getOutstandingBalance());
            assertEquals(debt1.getInterestRate(), debt2.getInterestRate(), 0.0);
            assertEquals(debt1.getMinimumPayment(), debt2.getMinimumPayment());
        }
    }

    /**
     * Test of load method, of class AssistantModel.
     */
    @Test
    public void testLoadMissingFile() {
        System.out.println("load from nonexisting file");
        String filepath = "./nonexistantfile.ser";

        AssistantModel result = AssistantModel.load(filepath);
        
        // ensure it returns an empty model
        assertEquals(result.getDebtsCount(), 0);
    }

}
