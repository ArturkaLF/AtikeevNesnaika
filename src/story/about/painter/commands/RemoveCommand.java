package story.about.painter.commands;

import story.about.painter.GirlsHashSet;

public class RemoveCommand implements Command {

    private GirlsHashSet girlsHashSet;
    private String name;

    public RemoveCommand(GirlsHashSet girlsHashSet, String name) {
        this.girlsHashSet = girlsHashSet;
        this.name = name;
    }

    @Override
    public void execute() {
        girlsHashSet.remove(name);
    }
}
