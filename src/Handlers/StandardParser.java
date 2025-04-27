package Handlers;

import java.util.HashMap;
import Controllers.*;
import Exceptions.DefaultException;
import Handlers.*;
import Interfaces.*;
import Commands.*;

import javax.xml.crypto.dsig.keyinfo.KeyName;

public class StandardParser implements Parser {
    public HashMap<String, String> parseLine(String line) {
        HashMap<String, String> map = new HashMap<>();

        if (line.charAt(line.length() - 1) != ';') {
            throw new DefaultException("");
        }

        // Получение команды
        if (line.charAt(0) == '/') {
            String commandName = "";
            for (int i = 1; i < line.length(); i++) {
                char c = line.charAt(i);
                if ((c != ' ') & (c != ';')) {
                    commandName += c;
                } else {
                    line = line.substring(i);
                    break;
                }
            }
            map.put("command", commandName);
        }

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '{') {
                String keyName = line.substring(0, i).strip();
                String value = "";
                i++;
                c = line.charAt(i);
                while ((c != '}') & (c != ';')) {
                    value += c;
                    i++;
                    c = line.charAt(i);
                }
                map.put(keyName, value);
                line = line.substring(i + 1);
                i = 0;
            }
        }
        return map;
    }
}
