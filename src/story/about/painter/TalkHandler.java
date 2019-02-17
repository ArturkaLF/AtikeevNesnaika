package story.about.painter;

public interface TalkHandler {//Обработчик беседы
    void addTalkable(Talkable talkable);//Добавить участника
    void sendMessage(Talkable sender);//Отправить сообщение
    void sendMessage(Talkable sender, Talkable receiver);//Личное сссбщение
}
