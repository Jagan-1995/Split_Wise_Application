package dev.jagan.split_wise_application.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ExpenseUser extends BaseModel{
    @ManyToOne
    private Expense expense;

    @ManyToOne
    private User user;

    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseUserType expenseUserType;
}

/*
    1               1
 ExpenseUser ---- Expense => M : 1
    M               1

    1              1
 ExpenseUser ---- User => M : 1
    M              1
 */


