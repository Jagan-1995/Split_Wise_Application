package dev.jagan.split_wise_application.services;

import dev.jagan.split_wise_application.models.Expense;
import dev.jagan.split_wise_application.models.ExpenseUser;
import dev.jagan.split_wise_application.models.Group;
import dev.jagan.split_wise_application.models.User;
import dev.jagan.split_wise_application.repositories.ExpenseRepository;
import dev.jagan.split_wise_application.repositories.ExpenseUserRepository;
import dev.jagan.split_wise_application.repositories.GroupRepository;
import dev.jagan.split_wise_application.repositories.UserRepository;
import dev.jagan.split_wise_application.strategies.SettleUpStrategy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettleUpService {

    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;
    private SettleUpStrategy settleUpStrategy;
    private GroupRepository groupRepository;
    private ExpenseRepository expenseRepository;

    public SettleUpService(UserRepository userRepository,
                           ExpenseUserRepository expenseUserRepository,
                           SettleUpStrategy settleUpStrategy,
                           GroupRepository groupRepository,
                           ExpenseRepository expenseRepository){
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.settleUpStrategy = settleUpStrategy;
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> settleUpUser(Long userId) {
        /*
            1. Get the user object from the User table
            2. Get all expense this user was a part of.
            3. Iterate through all the expenses, and find out total extra / lesser amount
               paid by every user involved in the expenses.
            4. Implement Min / Max Heap algorithms to settle up user.
         */

        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()){
            throw  new RuntimeException("Invalid UserId " + userId);
        }

        User user = optionalUser.get();

        List<ExpenseUser> expenseUsers = expenseUserRepository.findAllByUser(user);

        Set<Expense> expenses = new HashSet<>();

        for (ExpenseUser expenseUser : expenseUsers){
            expenses.add(expenseUser.getExpense());
        }

        // Settle up the expenses

        List<Expense> transactionsToBeDone = settleUpStrategy.settleUp(expenses.stream().toList());
        /*
        A -> B : 200
        A -> C : 700
        D -> C : 500
         */
        List<Expense> expensesToReturn = new ArrayList<>();

        for (Expense expense : transactionsToBeDone){
            for (ExpenseUser expenseUser : expense.getExpenseUsers()){
                if (expenseUser.getUser().equals(user)){
                    expensesToReturn.add(expense);
                    break;
                }
            }
        }

        return expensesToReturn;

    }

    public List<Expense> settleUpGroup(Long groupId){

        Optional<Group> optionalGroup = groupRepository.findById(groupId);

        if (optionalGroup.isEmpty()){
            throw new RuntimeException("Invalid group Id " + groupId);
        }

        Group group = optionalGroup.get();
        // Find all the expenses for the group.
        // select * from expenses where group_id = 123.

        List<Expense> expenses = expenseRepository.findAllByGroup(group);

        return settleUpStrategy.settleUp(expenses);

    }
}

/*

  Settle up a user

  Expense1 -> Coffee -> multiple expenseUsers
  Expense2 -> Dinner
  Expense3 -> Lunch
  Expense4 -> Party

  User - Jagan
  List of all expense users for a user :

  Coffee, jagan, 500, PAID_BY
  Dinner, jagan, 1000, HAD_TO_PAY
  Dinner, jagan, 800, PAID_BY
  Goa trip, jagan, 5000, PAID_BY
  Goa trip, jagan, 2000, HAD_TO_PAY

 balance for jagan can be known from above - who should pay back (or)
  whom he should pay

  List of all expenses jagan was a part of :
  Coffee
  Dinner
  Goa Trip..

 */