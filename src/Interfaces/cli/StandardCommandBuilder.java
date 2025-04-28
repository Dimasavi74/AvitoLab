package Interfaces.cli;

import java.util.HashMap;

import Commands.*;
import Interfaces.cli.io.Inputer;
import Interfaces.cli.io.Outputer;
import Interfaces.cli.io.Parser;
import Interfaces.cli.Exceptions.WrongInput;

public class StandardCommandBuilder implements CommandBuilder {
    private Inputer inputer;
    private Parser parser;
    private Outputer outputer;
    private final HashMap<String, Command> commandObjects = new HashMap<>();

    public StandardCommandBuilder(Outputer outputer, Inputer inputer, Parser parser) {
        commandObjects.put("help", new Help(outputer, commandObjects));
        commandObjects.put("exit", new Exit());
        commandObjects.put("getInfo", new GetInfo(outputer, commandObjects));

        this.inputer = inputer;
        this.parser = parser;
        this.outputer = outputer;
    }

    public Command build(String commandName, HashMap<String, String> commandArgs) {
        Command command = getCommandObject(commandName);
        command.setData(commandArgs);
        while (!command.checkCompleteness()) {

            outputer.outputLine("Некоторые обязательные поля остались незаполненными: "
                    + String.join(" ", command.getEmptyFields()));
            String newDataLine = this.inputer.getLine();
            HashMap<String, String> parsedData = this.parser.parseLine(newDataLine);
            command.setData(parsedData);
        }
        return command;
    }


    public Command getCommandObject(String commandName) {
        if (commandObjects.containsKey(commandName)) {
            return commandObjects.get(commandName);
        } else {
            throw new WrongInput(String.format("Команда %s не найдена. Список доступных команд /help;", commandName));
        }
    }

    public void setInputer(Inputer inp) {this.inputer = inp;}

    public void setParser(Parser prs) {
        this.parser = prs;
    }

    public void setOutputer(Outputer out) {
        this.outputer = out;
    }

    public Inputer getInputer() {
        return this.inputer;
    }

    public Parser getParser() {
        return this.parser;
    }

    public Outputer getOutputer() {
        return this.outputer;
    }
}
