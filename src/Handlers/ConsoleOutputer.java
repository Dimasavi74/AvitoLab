package Handlers;

import Controllers.*;
import Handlers.*;
import Interfaces.*;
import Commands.*;

public class ConsoleOutputer implements Outputer {
    public void outputLine(String line) {
        System.out.println(line);
    }
}
