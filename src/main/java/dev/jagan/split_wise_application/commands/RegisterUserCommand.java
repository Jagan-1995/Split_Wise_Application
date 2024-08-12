package dev.jagan.split_wise_application.commands;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterUserCommand implements Command{

    @Override
    public boolean matches(String input) {
        // Register vinsmokesanji 003 namisswwaann
        List<String> words = List.of(input.split(" "));
        return words.size() == 4 && words.get(0).equals(CommandKeywords.registerCommand);
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
    }
}
