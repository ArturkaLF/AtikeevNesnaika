package story.about.painter;

public class Navigator {

    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    public void go(){
        command.execute();
    }

}
