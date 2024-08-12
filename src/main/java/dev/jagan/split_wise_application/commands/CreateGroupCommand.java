package dev.jagan.split_wise_application.commands;

import org.springframework.stereotype.Component;

@Component
public class CreateGroupCommand implements Command{

    @Override
    public boolean matches(String input) {
        return false;
    }

    @Override
    public void execute(String input) {

    }
}
