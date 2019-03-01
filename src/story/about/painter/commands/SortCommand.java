package story.about.painter.commands;

import story.about.painter.Command;
import story.about.painter.GirlsHashSet;

public class SortCommand implements Command {

    private GirlsHashSet girlsHashSet;

    public SortCommand(GirlsHashSet girlsHashSet) {
        this.girlsHashSet = girlsHashSet;
    }

    @Override
    public void execute() {
        System.out.println(girlsHashSet.sortedList());
    }
}
