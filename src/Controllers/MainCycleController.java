package Controllers;

import Controllers.*;
import Exceptions.*;
import Handlers.*;
import Interfaces.*;
import Commands.*;

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
        while (run) {
            String newCommandLine = this.inputer.getLine();
            HashMap<String, String> parsedCommand = this.parser.parseLine(newCommandLine);

            CommandBuilder builder = new StandardCommandBuilder();
            builder.setInputer(this.inputer);
            builder.setParser(this.parser);
            builder.setOutputer(this.outputer);

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
