package story.about.painter.va;

import java.util.Objects;

import static story.about.painter.va.Message.Mood.*;

public abstract class LittleMan implements Talkable {//Абстрактный класс малышей

    public class Temper{//Вложенный non-static
        public void checkMessage(){
            try {
                switch (getIncomingMessage().getMood()){
                    case NEGATIVE:
                        moodDown();
                        break;
                    case NEUTRAL:
                        System.out.println(NAME+": Настроение не изменилось");
                        break;
                    case POSITIVE:
                        moodUp();
                        break;
                }
            }catch (IncomingMessageIsNullException e){
                System.out.println(e);
            }
        }
    }

    private TalkHandler talkHandler;//Обработчик беседы
    private Message incomingMessage;//Входящее сообщение
    private Message message;//Исходящее сообщение
    private Mood mood;
    private Temper temper;
    private final String NAME;

    public LittleMan(String name){
        temper=new Temper();
        mood=Mood.NORMAL;
        NAME=name;
        message=new Message("", NEUTRAL);
        message.setSender(this);
    }

    public void moodUp(){
        if(mood.ordinal()<Mood.PLEASED.ordinal()){//Если можно улучшить настроение, то
            mood=Mood.values()[mood.ordinal()+1];//оно повышается
        }
        System.out.println(NAME+": Настроение улучшилось до "+mood);
    }

    public void moodDown(){
        if(mood.ordinal()>Mood.ANGRY.ordinal()){//Если можно ухудшить настроение, то
            mood=Mood.values()[mood.ordinal()-1];//оно ухудшается
        }
        System.out.println(NAME + ": Настроение ухудшилось до "+mood);
    }

    public abstract boolean shouldSpeak() throws EndlessConversationException;//Нужно ли говорить?

    @Override
    public void speak() {//Говорить в беседу
        try {
            if (shouldSpeak()) {
                System.out.printf("\n%s говорит: \"%s\"\n", NAME, message);
                talkHandler.sendMessage(this);
            }
        }catch (EndlessConversationException e){
            System.out.println(e);
            System.out.println(NAME+" молчит");
        }
    }

    @Override
    public void speak(Talkable partner) {//Говорить лично
        try {
            if (shouldSpeak()) {
                System.out.printf("\n%s говорит: \"%s\"\n", NAME, message);
                talkHandler.sendMessage(this, partner);
            }
        }catch (EndlessConversationException e){
            System.out.println(e);
            System.out.println(NAME+" молчит");
        }
    }

    @Override
    public void listen(Talkable partner) {//Слушать собеседника
        incomingMessage=partner.getMessage();
        temper.checkMessage();
    }
    @Override
    public void setTalkHandler(TalkHandler talkHandler) {
        this.talkHandler=talkHandler;
        talkHandler.addTalkable(this);
    }
    @Override
    public Message getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LittleMan)) return false;
        LittleMan littleMan = (LittleMan) o;
        return Objects.equals(talkHandler, littleMan.talkHandler) &&
                Objects.equals(message, littleMan.message) &&
                Objects.equals(temper, littleMan.temper) &&
                Objects.equals(NAME, littleMan.NAME);
    }

//    @Override
//    public int hashCode() {
//        return talkHandler.hashCode()+message.hashCode()*NAME.hashCode();
//    }

    @Override
    public String toString() {
        return "Малыш по имени "+NAME;
    }

    public TalkHandler getTalkHandler() {
        return talkHandler;
    }

    public Message getIncomingMessage() {
        if(incomingMessage==null)throw new IncomingMessageIsNullException();
        return incomingMessage;
    }

    public void setIncomingMessage(Message incomingMessage) {
        this.incomingMessage = incomingMessage;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getNAME() {
        return NAME;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public Temper getTemper() {
        return temper;
    }

    public void setTemper(Temper temper) {
        this.temper = temper;
    }
}
