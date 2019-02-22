package story.about.painter;

/**
 *
 */
public class Main {
    public static void main(String[] args) {

        final String HELP = "           Команды для интерактивного управления коллекцией \n" +
                "add element:          |добавить новый элемент в коллекцию.\n" +
                "show:                 |вывести в стандартный поток вывода все элементы коллекции в строковом представлении.\n" +
                "import path:          |добавить в коллекцию все данные из файла.\n" +
                "save:                 |сохранить коллекцию в файл.\n" +
                "sort:                 |вывод итсортированного список элементов коллекции.\n" +
                "info:                 |вывести в стандартный поток вывода основную информацию о коллекции.\n" +
                "remove element:       |удалить элемент из коллекции по его значению.\n" +
                "remove_lower element: |удалить из коллекции все элементы, меньшие, чем заданный.\n" +
                "start:                |запустить основную программу для настроенной коллекции.\n" +
                "exit:                 |выход из программы (сохранение текущей коллекции в файл)\n" +
                "help:                 |вывод списка доступных команд.\n";

        GirlsHashSet<LittleGirl> hashSet = new GirlsHashSet<>();
        try {
            hashSet.import_file(args[0]);
        }catch (ArrayIndexOutOfBoundsException e){
            hashSet.import_file("test.csv");
        }

        System.out.println(HELP);
        while(UserHandler.getChoice("Введите команду управления коллекцией: ", hashSet, HELP)){}
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