package dev.jagan.split_wise_application.strategies;

import dev.jagan.split_wise_application.models.Expense;

import java.util.List;

public interface SettleUpStrategy {
    List<Expense> settleUp(List<Expense> expenses);

    /*
    Given a list of expenses, the function should return
    the transactions to be done in order to settle up all expenses.
     */
}

// Dummy Expense == Transaction
