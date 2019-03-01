package story.about.painter.commands;

import story.about.painter.GirlsHashSet;

public class ImportCommand implements Command {

    private GirlsHashSet girlsHashSet;

    public ImportCommand(GirlsHashSet girlsHashSet, String fileName) {
        this.girlsHashSet = girlsHashSet;
        this.fileName = fileName;
    }

    private String fileName;

    @Override
    public void execute() {
        girlsHashSet.import_file(fileName);
    }
}
