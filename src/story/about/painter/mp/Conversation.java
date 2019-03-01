package story.about.painter.mp;

import java.util.Arrays;

public class Conversation implements TalkHandler {
    public static final int MAX_MEMBERS=50;
    private Talkable members[];
    private int membersCount;

    public Conversation(){
        members=new Talkable[MAX_MEMBERS];
        membersCount=0;
    }
    @Override
    public void addTalkable(Talkable talkable) {
        if (membersCount<MAX_MEMBERS)
            members[membersCount++]=talkable;
    }

    @Override
    public void sendMessage(Talkable sender) { //Когда кто-то говорит
        for (int i=0;i<membersCount;i++) {//Все его слушают
            if (members[i]!=sender)
                members[i].listen(sender);
        }
        for(int i=0;i<membersCount;i++){//И отвечают
            if (members[i]!=sender)
                members[i].speak(sender);
        }
    }

    @Override
    public void sendMessage(Talkable sender, Talkable receiver) {//Когда кто-то обращается лично
        for (int i=0;i<membersCount;i++) {//Получатель слушает
            if (members[i]==receiver)
                members[i].listen(sender);
        }
    }

    @Override
    public String toString() {
        return "Класс беседы на 5 человек";
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(members)+toString().hashCode()*membersCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conversation)) return false;
        Conversation that = (Conversation) o;
        return membersCount == that.membersCount &&
                Arrays.equals(members, that.members);
    }
}
