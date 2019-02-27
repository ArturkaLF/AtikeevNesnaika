package story.about.painter;

public class Navigator {

    private Command command;

    public Navigator(Command command) {
        this.command = command;
    }

    public void setCommand(Command command){
        this.command = command;
    }

    public void go(){
        command.execute();
    }

}
