package dev.jagan.split_wise_application;

import dev.jagan.split_wise_application.commands.CommandExecutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitWiseApplication implements CommandLineRunner {
    private CommandExecutor commandExecutor;

    public SplitWiseApplication(CommandExecutor commandExecutor){
        this.commandExecutor = commandExecutor;
    }

    public static void main(String[] args) {
        SpringApplication.run(SplitWiseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true){
            String input = scanner.next();
            // give the input to command executor
            commandExecutor.execute(input);
        }
    }
}
