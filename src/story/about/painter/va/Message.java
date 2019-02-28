package story.about.painter.va;

import java.util.Objects;

public class Message {

    public enum Mood {//вложенный static (inner enum is always static)
        POSITIVE,//позитивный посыл
        NEGATIVE,//негативный посыл
        NEUTRAL;//нейтральный посыл
        @Override
        public String toString() {
            switch (this){
                case POSITIVE:
                    return "позитивное";
                case NEGATIVE:
                    return "негативное";
                case NEUTRAL:
                    return "нейтральное";
                default:
                    return "Посыл сообщения";
            }
        }
    }

    private Talkable sender;
    private Message.Mood mood;//настроение сообщения
    private String text;//содержание (текст)

    public Message(String text,Message.Mood mood) {
        this.text=text;
        this.mood=mood;
    }
    public Message(String text){
        this.text=text;
        mood=Message.Mood.NEUTRAL;
    }

    public Talkable getSender() {
        return sender;
    }

    public void setSender(Talkable sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return mood == message.mood &&
                text.equals(message.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mood, text);
    }


    public Message.Mood getMood() {
        return mood;
    }

    public void setMood(Message.Mood mood) {
        this.mood = mood;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
