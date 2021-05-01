package com.kacperstasiak.repaymentassistant;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kacper Stasiak
 */
public class DebtTest {

    private static final String DEBT_NAME_1 = "Test Debt 1";
    private static final String DEBT_NAME_8 = "Test Debt 8";

    /**
     * Test of constructor of class Debt. Negative balance.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegativeBalance() {
        System.out.println("constructor - negative balance");
        Debt instance = new Debt(DEBT_NAME_1, -10, 0.1, 10);
    }

    /**
     * Test of constructor of class Debt. Zero balance.
     */
    @Test
    public void testConstructorZeroBalance() {
        System.out.println("constructor - zero balance");
        Debt instance = new Debt(DEBT_NAME_1, 0, 0.1, 10);
    }

    /**
     * Test of constructor of class Debt. Zero interest
     */
    @Test
    public void testConstructorZeroInterest() {
        System.out.println("constructor - zero interest");
        Debt instance = new Debt(DEBT_NAME_1, 100, 0, 10);
    }

    /**
     * Test of constructor of class Debt. Negative interest
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNegativeInterest() {
        System.out.println("constructor - negative interest");
        Debt instance = new Debt(DEBT_NAME_1, 100, -0.2, 10);
    }

    /**
     * Test of constructor of class Debt. Valid interest
     */
    @Test
    public void testConstructorValidInterest() {
        System.out.println("constructor - valid interest");
        Debt instance = new Debt(DEBT_NAME_1, 100, 0.1, 10);
    }

    /**
     * Test of constructor of class Debt. Too high interest
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorTooHighInterest() {
        System.out.println("constructor - too high interest");
        Debt instance = new Debt(DEBT_NAME_1, 100, 1.1, 10);
    }

    /**
     * Test of getDescription method, of class Debt.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Debt instance = new Debt(DEBT_NAME_1, 100, 0.1, 10);
        String expResult = DEBT_NAME_1;
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Debt.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String desc = DEBT_NAME_8;
        Debt instance = new Debt(DEBT_NAME_1, 100, 0.1, 10);
        instance.setDescription(desc);
        assertEquals(desc, instance.getDescription());
    }

    /**
     * Test of setDescription method, of class Debt.
     */
    @Test
    public void testSetDescriptionNumbers() {
        System.out.println("setDescription to 1234567");
        String desc = "1234567";
        Debt instance = new Debt(DEBT_NAME_1, 100, 0.1, 10);
        instance.setDescription(desc);
        assertEquals(desc, instance.getDescription());
    }

    /**
     * Test of getOutstandingBalance method, of class Debt.
     */
    @Test
    public void testGetOutstandingBalance() {
        System.out.println("getOutstandingBalance");
        Debt instance = new Debt(DEBT_NAME_1, 100, 0.1, 10);
        int expResult = 100;
        int result = instance.getOutstandingBalance();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOutstandingBalance method, of class Debt.
     */
    @Test
    public void testSetOutstandingBalance() {
        System.out.println("setOutstandingBalance to 1,000");
        int amount = 1000;
        Debt instance = new Debt(DEBT_NAME_1, 100, 0.1, 10);
        instance.setOutstandingBalance(amount);
        assertEquals(amount, instance.getOutstandingBalance());
    }

    /**
     * Test of setOutstandingBalance method, of class Debt.
     */
    @Test
    public void testSetOutstandingBalanceZero() {
        System.out.println("setOutstandingBalance to 0");
        int amount = 0;
        Debt instance = new Debt(DEBT_NAME_1, 100, 0.1, 10);
        instance.setOutstandingBalance(amount);
        assertEquals(amount, instance.getOutstandingBalance());
    }

    /**
     * Test of setOutstandingBalance method, of class Debt.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetOutstandingBalanceNegative() {
        System.out.println("setOutstandingBalance to -100");
        int amount = -100;
        Debt instance = new Debt(DEBT_NAME_1, 100, 0.1, 10);
        instance.setOutstandingBalance(amount);
    }

    /**
     * Test of getInterestRate method, of class Debt.
     */
    @Test
    public void testGetInterestRate() {
        System.out.println("getInterestRate");
        Debt instance = new Debt(DEBT_NAME_1, 100, 0.1, 10);
        double expResult = 0.1;
        double result = instance.getInterestRate();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setInterestRate method, of class Debt.
     */
    @Test
    public void testSetInterestRate() {
        System.out.println("setInterestRate to 0.2%");
        double rate = 0.2;
        Debt instance = new Debt(DEBT_NAME_1, 100, 0.1, 10);
        instance.setInterestRate(rate);
        assertEquals(rate, instance.getInterestRate(), 0.0);
    }

    /**
     * Test of setInterestRate method, of class Debt.
     */
    @Test
    public void testSetInterestRateZero() {
        System.out.println("setInterestRate to 0%");
        double rate = 0.0;
        Debt instance = new Debt(DEBT_NAME_1, 100, 0.1, 10);
        instance.setInterestRate(rate);
        assertEquals(rate, instance.getInterestRate(), 0.0);
    }

    /**
     * Test of setInterestRate method, of class Debt.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetInterestRateNegative() {
        System.out.println("setInterestRate to -20%");
        double rate = -0.2;
        Debt instance = new Debt(DEBT_NAME_1, 100, 0.1, 10);
        instance.setInterestRate(rate);
    }

    /**
     * Test of setInterestRate method, of class Debt.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetInterestRateTooHigh() {
        System.out.println("setInterestRate to 200%");
        double rate = 2.0;
        Debt instance = new Debt(DEBT_NAME_1, 100, 0.1, 10);
        instance.setInterestRate(rate);
    }

    /**
     * Test of getMinimumPayment method, of class Debt.
     */
    @Test
    public void testGetMinimumPayment() {
        System.out.println("getMinimumPayment to 10");
        Debt instance = new Debt(DEBT_NAME_1, 100, 0.1, 10);
        int expResult = 10;
        int result = instance.getMinimumPayment();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMinimumPayment method, of class Debt.
     */
    @Test
    public void testSetMinimumPayment() {
        System.out.println("setMinimumPayment to 50");
        int amount = 50;
        Debt instance = new Debt(DEBT_NAME_1, 100, 0.1, 10);
        instance.setMinimumPayment(amount);
        assertEquals(amount, instance.getMinimumPayment());
    }

    /**
     * Test of setMinimumPayment method, of class Debt.
     */
    @Test
    public void testSetMinimumPaymentZero() {
        System.out.println("setMinimumPayment to 0");
        int amount = 0;
        Debt instance = new Debt(DEBT_NAME_1, 100, 0.1, 10);
        instance.setMinimumPayment(amount);
        assertEquals(amount, instance.getMinimumPayment());
    }

    /**
     * Test of setMinimumPayment method, of class Debt.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetMinimumPaymentNegative() {
        System.out.println("setMinimumPayment to -50");
        int amount = -50;
        Debt instance = new Debt(DEBT_NAME_1, 100, 0.1, 10);
        instance.setMinimumPayment(amount);
    }

    /**
     * Test of setMinimumPayment method, of class Debt.
     */
    @Test
    public void testSetMinimumPaymentBeyondOutstandingBalance() {
        System.out.println("setMinimumPayment to 150");
        int amount = 150;
        Debt instance = new Debt(DEBT_NAME_1, 100, 0.1, 10);
        instance.setMinimumPayment(amount);

        // Expected capped to outstanding balance
        assertEquals(instance.getOutstandingBalance(), instance.getMinimumPayment());
    }

    /**
     * Test of setMinimumPayment method, of class Debt.
     */
    @Test
    public void testSetMinimumPaymentEqualToOutstandingBalance() {
        System.out.println("setMinimumPayment to 100");
        int amount = 100;
        Debt instance = new Debt(DEBT_NAME_1, 100, 0.1, 10);
        instance.setMinimumPayment(amount);

        // Expected capped to outstanding balance
        assertEquals(instance.getOutstandingBalance(), instance.getMinimumPayment());
    }

}
