package story.about.painter;

/**
 *
 */
public class Main {
    public static void main(String[] args) {


        //GirlsHashSet<LittleGirl> hashSet = UserHandler.fileReader(args[0]); // "import" in a task FINAL

        GirlsHashSet<LittleGirl> hashSet = new GirlsHashSet<>();
        hashSet.import_file("test.csv");


        String help = "save - сохранить коллекцию и тд (допишу позже)";
        while(UserHandler.getChoice("Введите команду управления коллекцией: ", hashSet, help)){}
        hashSet.save();


//        Старая версия программы

//        LittleGirl zvezdochka = new LittleGirl("Звёздочка",new Message("Пожалуйста"));//new Message() <-- анонимный класс
//        zvezdochka.setNeznaika(neznaika);
//        LittleGirl sineglazka = new LittleGirl("Синеглазка",new Message("милый Незнайка"));
//        sineglazka.setNeznaika(neznaika);
//        LittleGirl romashka = new LittleGirl("Ромашка",new Message("Незнайка, ну пожалуйста"));
//        romashka.setNeznaika(neznaika);
//        LittleGirl knopochka = new LittleGirl("Кнопочка",new Message("милый милый Незнайка, пожалуйста"));
//        knopochka.setNeznaika(neznaika);
//
//        neznaika.setTalkHandler(conversation);
//        zvezdochka.setTalkHandler(conversation);
//        sineglazka.setTalkHandler(conversation);
//        romashka.setTalkHandler(conversation);
//        knopochka.setTalkHandler(conversation);
//
//        neznaika.speak();

    }
}