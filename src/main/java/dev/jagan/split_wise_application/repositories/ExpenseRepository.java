package dev.jagan.split_wise_application.repositories;

import dev.jagan.split_wise_application.models.Expense;
import dev.jagan.split_wise_application.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findAllByGroup(Group group);
}
