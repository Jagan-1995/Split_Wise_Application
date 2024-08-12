package dev.jagan.split_wise_application.dtos;

import dev.jagan.split_wise_application.models.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDto {
    private List<Expense> transactionsList;
}
