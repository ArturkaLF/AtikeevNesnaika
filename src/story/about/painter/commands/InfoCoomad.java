package story.about.painter.commands;

import story.about.painter.GirlsHashSet;

public class InfoCoomad implements Command {

    private GirlsHashSet girlsHashSet;

    public InfoCoomad(GirlsHashSet girlsHashSet) {
        this.girlsHashSet = girlsHashSet;
    }

    @Override
    public void execute() {
        System.out.println(girlsHashSet.show());
    }
}
