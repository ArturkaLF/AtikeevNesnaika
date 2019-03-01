package story.about.painter.commands;

import story.about.painter.GirlsHashSet;
import story.about.painter.mp.Conversation;
import story.about.painter.mp.Neznaika;

public class StartCommand implements Command {

    private GirlsHashSet girlsHashSet;

    public StartCommand(GirlsHashSet girlsHashSet) {
        this.girlsHashSet = girlsHashSet;
    }

    @Override
    public void execute() {
        System.out.println("-------------------------------------------");
        Conversation conversation = new Conversation();
        Neznaika neznaika = new Neznaika("Незнайка");
        girlsHashSet.setNeznayka(neznaika);
        neznaika.setTalkHandler(conversation);
        girlsHashSet.setTalkHandler(conversation);
        neznaika.speak();
        System.out.println("-------------------------------------------");
    }
}
