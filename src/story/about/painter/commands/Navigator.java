package story.about.painter.commands;

import java.util.ArrayList;

public class Navigator {

    private Command command;
    private ArrayList<Command> listCommands;

    public Navigator(){}

    public Navigator(ArrayList<Command> listCommands) {
        this.listCommands = listCommands;
    }

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
