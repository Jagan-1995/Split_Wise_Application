package dev.jagan.split_wise_application.commands;

public interface Command {
    public boolean matches(String input);

    public void execute(String input);
}
