package Interfaces;

import java.util.HashMap;
import Controllers.*;
import Handlers.*;
import Interfaces.*;
import Commands.*;

public interface Parser {
    public HashMap<String, String> parseLine(String line);
}
