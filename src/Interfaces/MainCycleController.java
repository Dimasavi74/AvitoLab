package Interfaces;

import Commands.Command;
import Interfaces.cli.CommandBuilder;
import Interfaces.cli.Exceptions.WrongInput;
import Interfaces.cli.StandardCommandBuilder;
import Interfaces.cli.io.Inputer;
import Interfaces.cli.io.Outputer;
import Interfaces.cli.io.Parser;

import java.util.HashMap;

public class MainCycleController {
    private static boolean run = false;
    private Inputer inputer;
    private Parser parser;
    private Outputer outputer;

    public MainCycleController(Inputer inp, Parser prs, Outputer out) {
        this.inputer = inp;
        this.parser = prs;
        this.outputer = out;
    }

    public void mainCycle() {
        run = true;
        while (run) {
            String newCommandLine = this.inputer.getLine();
            HashMap<String, String> parsedCommand = this.parser.parseLine(newCommandLine);

            CommandBuilder builder = new StandardCommandBuilder(outputer, inputer, parser);

            try {
                Command command = builder.build(parsedCommand.get("command"), parsedCommand);
                command.execute();
            } catch (WrongInput e) {
                this.outputer.outputLine(e.getMessage());
            }
        }
    }

    public static void start() {
        run = true;
    }

    public static void stop() {
        run = false;
    }

    public void setInputer(Inputer inp) {
        this.inputer = inp;
    }

    public void setParser(Parser prs) {
        this.parser = prs;
    }

    public void setOutputer(Outputer out) {
        this.outputer = out;
    }


}
