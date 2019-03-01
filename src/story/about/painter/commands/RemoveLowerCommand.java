package story.about.painter.commands;

import story.about.painter.Command;
import story.about.painter.GirlsHashSet;

public class RemoveLowerCommand implements Command {

    private GirlsHashSet girlsHashSet;
    private String name;

    public RemoveLowerCommand(GirlsHashSet girlsHashSet, String name) {
        this.girlsHashSet = girlsHashSet;
        this.name = name;
    }

    @Override
    public void execute() {
        girlsHashSet.remove_lower(name);
    }
}
