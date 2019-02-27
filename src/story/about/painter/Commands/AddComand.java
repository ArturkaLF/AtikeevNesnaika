package story.about.painter.Commands;

import story.about.painter.Command;
import story.about.painter.GirlsHashSet;

public class AddComand implements Command {
    private GirlsHashSet girlsHashSet;
    private String name;
    private String text;

    public AddComand(GirlsHashSet girlsHashSet, String name, String text){
        this.name = name;
        this.text = text;
        this.girlsHashSet = girlsHashSet;
    }

    @Override
    public void execute() {
        girlsHashSet.add(name, text);
    }

}
