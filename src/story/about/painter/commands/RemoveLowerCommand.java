package story.about.painter.commands;

import story.about.painter.GirlsHashSet;
import story.about.painter.mp.LittleGirl;

import java.util.ListIterator;

public class RemoveLowerCommand implements Command {

    private GirlsHashSet girlsHashSet;
    private LittleGirl littlegirl;

    public RemoveLowerCommand(GirlsHashSet girlsHashSet, LittleGirl littlegirl) {
        this.girlsHashSet = girlsHashSet;
        this.littlegirl = littlegirl;
    }

    @Override
    public void execute() {
        girlsHashSet.remove_lower(littlegirl);
    }
}
