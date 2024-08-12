package dev.jagan.split_wise_application.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel{
    private String description;
    private int amount;

    @ManyToOne
    private User createdBy;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;

    @OneToMany(mappedBy = "expense")
    private List<ExpenseUser> expenseUsers;
     /*

    settle up A
    fetched A
    list of all expense users corresponding to A
    expnse1, A 100 had_to_pay,
    espense2, A 100 had_to_pay
    expems2, A 500 paid_by

    creating list of unique expenses that A was part of

    expense1
    expens2
    expense3

    expense1
    A 100 had_to_pay,
    B 200, had_to_pay
    C 300, had_to_pay
    A 600, paid_by


    expense2
    A 100 had_to_pay
    A 500 paid_by
    B
    C

    expense3
    A
    B
    C
    D

    expense4
    C
    D
      */

    @ManyToOne
    private Group group;
}

/*
  1            1
 Expense ---- User => M : 1
   M            1

   1            M
 Expense ---- ExpenseUser => 1 : M
   1            1

   E1

   E1U1 200 PAID_BY
   E1U2
   E1U3

   XY - X => M : 1

    1            1
  Expense ---- Group => M : 1
    M            1

 */