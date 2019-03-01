package story.about.painter.commands;

import java.util.ArrayList;
import java.util.LinkedList;

public class Navigator {

    private Command command;
    private LinkedList<Command> listCommands = new LinkedList<>();

    public void setCommand(Command command){
        this.command = command;
        this.go();
    }

    public void addCommand(Command command){
        this.listCommands.add(command);
    }


    public void runListCommands(){
        for(Command command:listCommands){
            command.execute();
        }
    }

    public void go(){
        command.execute();
    }

}
