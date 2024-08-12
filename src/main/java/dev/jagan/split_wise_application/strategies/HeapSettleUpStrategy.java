package dev.jagan.split_wise_application.strategies;

import dev.jagan.split_wise_application.models.Expense;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HeapSettleUpStrategy implements SettleUpStrategy {

    @Override
    public List<Expense> settleUp(List<Expense> expenses) {
        /*
        Iterate through all the expenses, and find out total extra / lesser amount
            paid by every user involved in the expenses.

        Implement Min / Max Heap algorithms to settle up user.
         */
        return null;
    }
}
