package story.about.painter;

public class LittleGirl extends LittleMan implements Comparable<LittleGirl>{
    private Neznaika neznaika;//Незнайка - партнер для разговора

    public LittleGirl(String name,Message message) {
        super(name);
        setMood(Mood.PLEASED);
        message.setMood(Message.Mood.POSITIVE);
        message.setSender(this);
        setMessage(message);
    }

    public String getMsg(){
        return getMessage().getText();
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
