package story.about.painter;

public interface Talkable {//Интерфейс собеседника
    void speak();//Говорить
    void speak(Talkable partner);//Говорить лично
    void listen(Talkable partner);//Слушать
    void setTalkHandler(TalkHandler talkHandler);//Установить обработчика беседы
    Message getMessage();//Получить сообщение
}
