package dev.jagan.split_wise_application.commands;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandExecutor {

//    private SettleUpUserCommand settleUpUserCommand;
//    private RegisterUserCommand registerUserCommand;
//    private CreateGroupCommand createGroupCommand;
//
//    public CommandExecutor(SettleUpUserCommand settleUpUserCommand,
//                           RegisterUserCommand registerUserCommand,
//                           CreateGroupCommand createGroupCommand){
//        this.settleUpUserCommand = settleUpUserCommand;
//        this.registerUserCommand = registerUserCommand;
//        this.createGroupCommand = createGroupCommand;
//    }

    public static List<Command> commands = List.of(

    );

    public void addCommand(Command command){
        commands.add(command);
    }

    public void removeCommand(Command command){
        commands.remove(command);
    }

    public void execute(String input){
        for (Command command : commands){
            if (command.matches(input)){
                command.execute(input);
                break;
            }
        }
    }
}
