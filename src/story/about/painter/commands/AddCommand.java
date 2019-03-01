package story.about.painter.commands;

import story.about.painter.Command;
import story.about.painter.GirlsHashSet;

public class AddCommand implements Command {

    private GirlsHashSet girlsHashSet;
    private String name;
    private String text;

    public AddCommand(GirlsHashSet girlsHashSet, String name, String text) {
        this.girlsHashSet = girlsHashSet;
        this.name = name;
        this.text = text;
    }

    @Override
    public void execute() {
        girlsHashSet.add(name, text);
    }
}
