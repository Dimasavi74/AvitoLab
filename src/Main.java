import Controllers.*;
import Handlers.*;
import Interfaces.*;
import Commands.*;

public class Main {
    public static void main(String[] args) {
        Inputer inputer = new StandardConsoleInputer();
        Parser parser = new StandardParser();
        Outputer outputer = new ConsoleOutputer();
        MainCycleController mainCycleController = new MainCycleController(inputer, parser, outputer);
        mainCycleController.start();
        mainCycleController.mainCycle();
    }
}