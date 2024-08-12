package dev.jagan.split_wise_application.repositories;

import dev.jagan.split_wise_application.models.ExpenseUser;
import dev.jagan.split_wise_application.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Long> {
    List<ExpenseUser> findAllByUser(User user);
}

/*
  Expense user -> expense, user, amount, had_to_pay / paid_by
 */