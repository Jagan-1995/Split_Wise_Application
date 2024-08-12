package dev.jagan.split_wise_application.commands;

import dev.jagan.split_wise_application.controllers.SettleUpController;
import dev.jagan.split_wise_application.dtos.SettleUpUserRequestDto;
import dev.jagan.split_wise_application.dtos.SettleUpUserResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpUserCommand implements Command{
    SettleUpController settleUpController;

    SettleUpUserCommand(SettleUpController settleUpController){
        this.settleUpController = settleUpController;
    }

    @Override
    public boolean matches(String input) {
        // input - 1234 settleUp => no of words - 2
        // words => [1234, settleUp]

        List<String> words = List.of(input.split(" "));

        return words.size() == 2 && words.get(1).equals(CommandKeywords.settleUpCommand);
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));

        Long userId = Long.valueOf(words.get(0));

        SettleUpUserRequestDto settleUpUserRequestDto = new SettleUpUserRequestDto();
        settleUpUserRequestDto.setUserId(userId);

        SettleUpUserResponseDto settleUpUserResponseDto = settleUpController.settleUpUser(settleUpUserRequestDto);
    }
}
