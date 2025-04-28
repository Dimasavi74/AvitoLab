import Interfaces.cli.io.Inputer;
import Interfaces.MainCycleController;
import Interfaces.cli.io.Outputer;
import Interfaces.cli.io.Parser;
import Interfaces.cli.io.ConsoleOutputer;
import Interfaces.cli.io.ConsoleInputer;
import Interfaces.cli.io.StandardParser;

public class Main {
    public static void main(String[] args) {
        Inputer inputer = new ConsoleInputer();
        Parser parser = new StandardParser();
        Outputer outputer = new ConsoleOutputer();
        MainCycleController mainCycleController = new MainCycleController(inputer, parser, outputer);
        mainCycleController.mainCycle();
    }
}