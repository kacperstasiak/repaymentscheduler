package com.kacperstasiak.repaymentassistant;

import com.kacperstasiak.repaymentassistant.MVC.Model;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The model part of the MVC structure, stores and manages the data.
 *
 * @author Kacper Stasiak
 */
public class AssistantModel implements Model, java.io.Serializable {

    List<Debt> debts;
    private int budget;

    /**
     * Public constructor for the debt repayment assistant model
     */
    public AssistantModel() {
        debts = new ArrayList<>();
    }

    /**
     * Inserts a debt into the debts list
     *
     * @param desc A user defined description or reference
     * @param outstanding The outstanding balance (in pence)
     * @param interest The annual interest rate (1.0 = 100%)
     * @param minPayment The next minimum payment amount (in pence)
     */
    @Override
    public void addDebt(String desc, int outstanding, double interest,
            int minPayment) {
        Debt debt = new Debt(desc, outstanding, interest, minPayment);
        debts.add(debt);
    }

    /**
     * Removes a debt from the debts list
     *
     * @param debt The debt instance to remove
     */
    @Override
    public void removeDebt(Debt debt) {
        debts.remove(debt);
    }

    /**
     * Returns the description of the debt
     *
     * @param debt The debt instance
     * @return The description or reference set by the user
     */
    @Override
    public String getDebtRef(Debt debt) {
        return debt.getDescription();
    }

    /**
     * Sets the description of the debt
     *
     * @param debt The debt instance
     * @param ref The description or reference to set
     */
    @Override
    public void setDebtRef(Debt debt, String ref) {
        debt.setDescription(ref);
    }

    /**
     * Returns the AER interest for the debt
     *
     * @param debt The debt instance
     * @return The annual interest (1.0 = 100%)
     */
    @Override
    public double getDebtInterestRate(Debt debt) {
        return debt.getInterestRate();
    }

    /**
     * Sets the AER interest for the debt
     *
     * @param debt The debt instance
     * @param rate The annual interest (1.0 = 100%)
     */
    @Override
    public void setDebtInterestRate(Debt debt, double rate) {
        debt.setInterestRate(rate);
    }

    /**
     * Returns the outstanding balance for the debt
     *
     * @param debt The debt instance
     * @return The outstanding amount (in pence)
     */
    @Override
    public int getDebtOutstandingBalance(Debt debt) {
        return debt.getOutstandingBalance();
    }

    /**
     * Sets the outstanding balance for the debt
     *
     * @param debt The debt instance
     * @param outstanding The oustanding amount (in pence)
     */
    @Override
    public void setDebtOutstandingBalance(Debt debt, int outstanding) {
        debt.setOutstandingBalance(outstanding);
    }

    /**
     * Returns the minimum payment amount for the debt
     *
     * @param debt The debt instance
     * @return The minimum payment amount (in pence)
     */
    @Override
    public int getDebtMinimumPayment(Debt debt) {
        return debt.getMinimumPayment();
    }

    /**
     * Sets the minimum payment amount for the debt
     *
     * @param debt The debt instance
     * @param amount The minimum payment amount (in pence)
     */
    @Override
    public void setDebtMinimumPayment(Debt debt, int amount) {
        debt.setMinimumPayment(amount);
    }

    /**
     * Returns the list of debts stored on the system
     *
     * @return Debts list
     */
    @Override
    public List<Debt> getDebts() {
        return debts;
    }

    /**
     * Returns the sum of all minimum payments
     *
     * @return The sum of all minimum payment amounts
     */
    @Override
    public int getMinimumPaymentSum() {
        int total = 0;
        for (Debt d : debts) {
            total += d.getMinimumPayment();
        }
        return total;
    }

    /**
     * Sets the repayment budget amount
     *
     * @param budget Repayment budget in pence
     */
    @Override
    public void setBudgetAmount(int budget) {
        this.budget = budget;
    }

    /**
     * Returns the repayment budget amount
     *
     * @return Budget in pounds
     */
    @Override
    public int getBudgetAmount() {
        return budget;
    }

    /**
     * Produces a map linking debts to repayment suggestions
     *
     * @return A map from Debt to Integer, the latter representing the suggested
     * repayment amount in pence
     */
    @Override
    public Map<Debt, Integer> getDebtRepaymentSuggestions() {
        Map<Debt, Integer> map = new HashMap<>();

        // Sort the debts list by interest
        debts.sort((Debt o1, Debt o2) -> {
            if (o1.getInterestRate() == o2.getInterestRate()) {
                return 0;
            }
            if (o1.getInterestRate() > o2.getInterestRate()) {
                return -1;
            }
            if (o1.getInterestRate() < o2.getInterestRate()) {
                return 1;
            }
            return 0;
        });

        // First pass: distribute budget to cover all minimum payments if possible
        int availableBudget = budget;
        for (Debt d : debts) {
            int minPay = d.getMinimumPayment();

            // If available budget is less than the minimum payment for this debt
            // then only suggest as much as the available budget
            if (availableBudget < minPay) {
                minPay = (int) availableBudget;
            }

            map.put(d, minPay);
            availableBudget -= minPay;
        }

        // Second pass: distribute remaining budget to the highest interest debts(s)
        for (Debt d : debts) {
            int outstanding = d.getOutstandingBalance();

            // Calculcate the additional pay to cover entire balance
            int additionalPaySuggestion = outstanding - map.get(d);

            // If available budget is less than suggested additional pay
            if (availableBudget < additionalPaySuggestion) {
                // Limit the suggestion to only as much as possible
                additionalPaySuggestion = availableBudget;
            }
            int totalSuggestion = map.get(d) + additionalPaySuggestion;
            map.put(d, totalSuggestion);
            availableBudget -= additionalPaySuggestion;
        }

        // Return the map
        return map;
    }

    /**
     * Returns the size of the debts list
     *
     * @return The number of debts in the list
     */
    @Override
    public int getDebtsCount() {
        return debts.size();
    }

    /**
     * Loads a model from a serialised file
     *
     * @param filepath The path where the serialised file is
     * @return The loaded model or a new AssistantModel instance if loading
     * failed
     */
    public static AssistantModel load(String filepath) {
        try (
                FileInputStream filein = new FileInputStream(filepath);
                ObjectInputStream in = new ObjectInputStream(filein)) {
            AssistantModel model = (AssistantModel) in.readObject();
            System.out.println(
                    java.text.MessageFormat.format(
                            java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentassistant/strings")
                                    .getString("LOADED MODEL FROM {0}"),
                            new Object[]{filepath}
                    )
            );
            return model;
        } catch (ClassNotFoundException e) {
            System.out.println(
                    java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentassistant/strings")
                            .getString("FAILED TO LOAD MODEL DUE TO CLASSNOTFOUNDEXCEPTION.")
            );
        } catch (IOException e) {
            System.out.println(
                    java.text.MessageFormat.format(
                            java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentassistant/strings")
                                    .getString("CAUGHT IOEXCEPTION WHEN LOADING MODEL AT {0}"),
                            new Object[]{filepath}
                    )
            );
        }
        return new AssistantModel();
    }

    ;
    
    /**
     * Saves a model into a serialised file
     * @param model The model to save
     * @param filepath The path where the serialised file is or should be
     */
    public static void save(AssistantModel model, String filepath) {
        try (
                FileOutputStream fileout = new FileOutputStream(filepath);
                ObjectOutputStream out = new ObjectOutputStream(fileout)) {
            out.writeObject(model);
            System.out.println(
                    java.text.MessageFormat.format(
                            java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentassistant/strings")
                                    .getString("SAVED MODEL AT {0}"),
                            new Object[]{filepath}
                    )
            );
        } catch (FileNotFoundException e) {
            System.out.println(
                    java.text.MessageFormat.format(
                            java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentassistant/strings")
                                    .getString("FAILED TO SAVE MODEL AT {0} DUE TO FILENOTFOUNDEXCEPTION"),
                            new Object[]{filepath}
                    )
            );
        } catch (IOException e) {
            System.out.println(
                    java.text.MessageFormat.format(
                            java.util.ResourceBundle.getBundle("com/kacperstasiak/repaymentassistant/strings")
                                    .getString("CAUGHT IOEXCEPTION WHEN SAVING MODEL AT {0}"),
                            new Object[]{filepath}
                    )
            );
        }
    }
;
}
