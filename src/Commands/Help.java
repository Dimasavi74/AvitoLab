package Commands;

import Controllers.*;
import Handlers.*;
import Interfaces.*;
import Commands.*;
import java.util.HashMap;

public class Help implements Command {
    private Outputer outputer;
    final String[] commandList = {"help", "exit", "getInfo"};

    public void execute() {
        this.outputer.outputLine("Список доступных команд:\n" + String.join("\n", commandList));
    }

    public void getData(HashMap<String, String> data) {
        return;
    }

    public boolean checkCompleteness() {
        return true;
    }

    public String[] getEmptyFields() {
        return new String[0];
    }

    public String getInfo() {
        return "Возвращает список команд" + "\n" + "Вид: /help;";
    }

    public void setInputer(Inputer inp) { return; }

    public void setParser(Parser prs) {
        return;
    }

    public void setOutputer(Outputer out) { this.outputer = out; }

    public Outputer getOutputer() { return this.outputer; }
}
