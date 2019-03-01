package story.about.painter.commands;

import story.about.painter.commands.Command;

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
    }

    public void addCommand(Command command){
        listCommands.add(command);
    }

    public void run(){
        for(Command command:listCommands){
            command.execute();
        }
    }

    public void go(){
        command.execute();
    }

}
