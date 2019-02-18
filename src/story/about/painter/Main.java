package story.about.painter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {

        /**
         *
         */

        //GirlsHashSet<LittleGirl> hashSet = FileHandler.fileReader(args[0]); // "import" in a task FINAL

        GirlsHashSet<LittleGirl> hashSet = FileHandler.fileReader("test2.csv"); // "import" in a task FINAL

        System.out.println(hashSet.show());
        System.out.println(hashSet.sortedList());

        hashSet.remove("Артур");
        hashSet.remove("Ромашка");
        hashSet.remove("Звёздочка");

        System.out.println(hashSet.show());

        System.out.println(hashSet.info());

        hashSet.add(new LittleGirl("Звёздочка",new Message("Пожалуйста")));
        hashSet.add(new LittleGirl("Артур",new Message("Ку")));
        hashSet.remove("Артур");
        hashSet.remove("Звёздочка");

        hashSet.save();
        hashSet.import_file("test.csv");
        System.out.println(hashSet.show());


//        Conversation conversation=new Conversation();
//
//        Neznaika neznaika=new Neznaika("Незнайка");
//
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