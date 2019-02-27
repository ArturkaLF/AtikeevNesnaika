package story.about.painter.Commands;

import story.about.painter.Command;
import story.about.painter.GirlsHashSet;

public class InfoCommand implements Command {

    private GirlsHashSet girlsHashSet;

    public InfoCommand(GirlsHashSet girlsHashSet){
        this.girlsHashSet = girlsHashSet;
    }

    @Override
    public void execute() {
        System.out.println(girlsHashSet.info());
    }


}
