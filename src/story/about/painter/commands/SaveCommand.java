package story.about.painter.commands;

import story.about.painter.GirlsHashSet;

public class SaveCommand implements Command {

    private GirlsHashSet girlsHashSet;

    public SaveCommand(GirlsHashSet girlsHashSet) {
        this.girlsHashSet = girlsHashSet;
    }

    @Override
    public void execute() {
        System.out.println("Коллекция была сохранена в файл Out.json");
        girlsHashSet.save();
    }
}
