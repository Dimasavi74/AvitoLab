package Interfaces;

import java.util.HashMap;
import Controllers.*;
import Handlers.*;
import Interfaces.*;
import Commands.*;

public interface CommandBuilder {
    public Command build(String commandName, HashMap<String, String> commandArgs);
    public Command getCommandObject(String commandName);
    public void setInputer(Inputer inp);
    public void setParser(Parser prs);
    public void setOutputer(Outputer out);
    public Inputer getInputer();
    public Parser getParser();
    public Outputer getOutputer();
}
