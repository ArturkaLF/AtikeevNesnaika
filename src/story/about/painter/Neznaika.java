package story.about.painter;

public class Neznaika extends LittleMan{

    private Talkable lastPartner;
    private boolean enable;

    public Neznaika(String name) {
        super(name);
        enable=true;

        setTemper(new  Temper() {//анонимный локальный класс
            @Override
            public void checkMessage() {
                if (likeMessage(getIncomingMessage().getText())) {
                    super.checkMessage();
                }
            }
        });
        setMood(Mood.ANGRY);
        setMessage(new Message("Я очень недоволен. Уходите!",Message.Mood.NEGATIVE));
    }


    @Override
    public boolean shouldSpeak() throws EndlessConversationException{
        if (lastPartner!=null) {
            if (lastPartner==getIncomingMessage().getSender()){
                enable=false;
                throw new EndlessConversationException();
            }else lastPartner=getIncomingMessage().getSender();
        }else try{
            lastPartner=getIncomingMessage().getSender();
        }catch (IncomingMessageIsNullException e){
            //Ничего не делаетн
        }
        return true;//Говорит всегда
    }

    @Override
    public void listen(Talkable partner) {
        if(enable) {
            super.listen(partner);
            switch (getMood()) {//Меняет сообщение в зависимости от настроения
                case ANGRY:
                    setMessage(new Message("Я очень недоволен. Уходите!", Message.Mood.NEGATIVE));
                    speak(partner);
                    break;
                case NORMAL:
                    setMessage(new Message("Уходите.", Message.Mood.NEUTRAL));
                    speak(partner);
                    break;
                default:
                    setMessage(new Message("Ладно, оставайтесь.", Message.Mood.POSITIVE));
                    speak();
                    break;
            }
        }

    }

    private boolean likeMessage(String message){//Оценивает личные сообщения
        System.out.println(getNAME()+" оценил сообщение \""+getIncomingMessage()+'"');
        message=message.toLowerCase();
        if ((message.contains(getNAME().toLowerCase()))&&(message.contains("милый"))){
            System.out.println(getNAME()+": Сообщение понравилось.");
            return true;
        }
        System.out.println(getNAME()+": Сообщение не понравилось.");
        return false;
    }


    @Override
    public int hashCode() {
        return super.hashCode();}

    @Override
    public String toString() {
        return "Незнайка по имени "+getNAME();
    }

}
