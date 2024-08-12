package dev.jagan.split_wise_application.controllers;

import dev.jagan.split_wise_application.dtos.SettleUpGroupRequestDto;
import dev.jagan.split_wise_application.dtos.SettleUpGroupResponseDto;
import dev.jagan.split_wise_application.dtos.SettleUpUserRequestDto;
import dev.jagan.split_wise_application.dtos.SettleUpUserResponseDto;
import dev.jagan.split_wise_application.models.Expense;
import dev.jagan.split_wise_application.services.SettleUpService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {
    private SettleUpService settleUpService;

    public SettleUpController(SettleUpService settleUpService){
        this.settleUpService = settleUpService;
    }

    public SettleUpUserResponseDto settleUpUser(SettleUpUserRequestDto settleUpUserRequestDto){
        List<Expense> expenseList = settleUpService.settleUpUser(settleUpUserRequestDto.getUserId());

        SettleUpUserResponseDto settleUpUserResponseDto = new SettleUpUserResponseDto();
        settleUpUserResponseDto.setTransactionsList(expenseList);

        return settleUpUserResponseDto;
    }

    public SettleUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto settleUpGroupRequestDto) {
        return null;
    }
}
