package Handlers;

import java.util.HashMap;
import Controllers.*;
import Exceptions.*;
import Handlers.*;
import Interfaces.*;
import Commands.*;

public class StandardCommandBuilder implements CommandBuilder {
    private Inputer inputer;
    private Parser parser;
    private Outputer outputer;
    private HashMap<String, Command> commandObjects = new HashMap<>();

    {
        commandObjects.put("help", new Help());
        commandObjects.put("exit", new Exit());
        commandObjects.put("getInfo", new GetInfo());
    }

    public Command build(String commandName, HashMap<String, String> commandArgs) {
        Command command = getCommandObject(commandName);

        command.setInputer(this.inputer);
        command.setParser(this.parser);
        command.setOutputer(this.outputer);

        command.getData(commandArgs);
        while (!command.checkCompleteness()) {

            outputer.outputLine("Некоторые обязательные поля остались незаполненными:"
                    + String.join(" ", command.getEmptyFields()));
            String newDataLine = this.inputer.getLine();
            HashMap<String, String> parsedData = this.parser.parseLine(newDataLine);
            command.getData(parsedData);
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
