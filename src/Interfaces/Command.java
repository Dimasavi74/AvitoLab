package Interfaces;

import java.util.HashMap;
import Controllers.*;
import Handlers.*;
import Interfaces.*;
import Commands.*;

public interface Command {
    public void execute();
    public void getData(HashMap<String, String> data);
    public boolean checkCompleteness();
    public String[] getEmptyFields();
    public String getInfo();
    public void setInputer(Inputer inp);
    public void setParser(Parser prs);
    public void setOutputer(Outputer out);
}
