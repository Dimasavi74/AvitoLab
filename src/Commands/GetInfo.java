package Commands;

import Handlers.StandardCommandBuilder;
import Interfaces.Command;
import Interfaces.Inputer;
import Interfaces.Outputer;
import Interfaces.Parser;

import java.util.HashMap;
import java.util.Arrays;

public class GetInfo implements Command {
    private Outputer outputer;
    private HashMap<String, String> data = new HashMap<>();
    final String[] necessaryKeys = {"commandName"};
    final String[] commandList = {"help", "exit", "getInfo"};

    public void execute() {
        this.outputer.outputLine(new StandardCommandBuilder().getCommandObject(data.get("commandName")).getInfo());
    }

    public void getData(HashMap<String, String> d) {
        if (Arrays.asList(commandList).contains(d.get("commandName"))) {
            data.put("commandName", d.get("commandName"));
        }
    }

    public boolean checkCompleteness() {
        for (String el: necessaryKeys) {
            if (data.get(el) == null) {
                return false;
            }
        }
        return true;
    }

    public String[] getEmptyFields() {
        return new String[0];
    }

    public String getInfo() {
        return "Возвращает информацию о команде" + "\n" + "Вид: /getInfo commandName{};";
    }

    public void setInputer(Inputer inp) { return; }

    public void setParser(Parser prs) {
        return;
    }

    public void setOutputer(Outputer out) { this.outputer = out; }

    public Outputer getOutputer() { return this.outputer; }
}
