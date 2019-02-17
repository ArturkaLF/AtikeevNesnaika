package story.about.painter;

import java.util.Comparator;

public class LittleGirl extends LittleMan implements Comparable<LittleGirl>{
    private Neznaika neznaika;//Незнайка - партнер для разговора

    public LittleGirl(String name,Message message) {
        super(name);
        setMood(Mood.PLEASED);
        message.setMood(Message.Mood.POSITIVE);
        message.setSender(this);
        setMessage(message);
    }

    @Override
    public void speak(Talkable partner) {
        if(neznaika.getMood()==Mood.PLEASED)getMessage().setText("Спасибо");
        super.speak(partner);
    }

    @Override
    public boolean shouldSpeak() {
        return getMood()!=Mood.ANGRY&&(neznaika.getMood()!=Mood.PLEASED);//Говорит, если хочет и если Незнайка не доволен
    }

//    @Override
//    public String toString() {
//        return "Малышка, которую зовут "+getNAME();
//    }

    public String toString(){
        return getNAME();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LittleGirl)) return false;
        if (!super.equals(o)) return false;
        LittleGirl that = (LittleGirl) o;
        return neznaika.equals(that.neznaika);
    }

//    @Override
//    public int hashCode() {
//        return super.hashCode()+neznaika.hashCode();
//    }

    public Neznaika getNeznaika() {
        return neznaika;
    }

    public void setNeznaika(Neznaika neznaika) {
        this.neznaika = neznaika;
    }

    @Override
    public int compareTo(LittleGirl o) {
        return this.getNAME().length() - o.getNAME().length();
    }
}
