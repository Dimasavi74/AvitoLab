package Commands;

import Controllers.MainCycleController;
import Interfaces.Command;
import Interfaces.Inputer;
import Interfaces.Outputer;
import Interfaces.Parser;

import java.util.HashMap;

public class Exit implements Command {

    public void execute() {
        MainCycleController.stop();
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
        return "Завершает работу программы" + "\n" + "Вид: /exit;";
    }

    public void setInputer(Inputer inp) { return; }

    public void setParser(Parser prs) {
        return;
    }

    public void setOutputer(Outputer out) {
        return;
    }

}
