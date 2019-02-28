package story.about.painter;
import story.about.painter.VA.Conversation;
import story.about.painter.VA.Neznaika;

import java.util.Scanner;

/**
 * Класс обработчик пользовательских запросов
 *
 * @author Атикеев Роман
 * @version 1.1
 */

public class UserHandler {

    /**
     * Сатический метод для обработки запросов пользователя
     *
     * @param text строка вывода для пользователя
     * @param girlsHashSet обект коллекции для настройки
     * @param help стркоа инструкции по камандам
     */
    public static boolean getChoice(String text, GirlsHashSet girlsHashSet, String help){
        // Сканим пользовательский ввод
        Scanner in = new Scanner(System.in);
        System.out.print(text);
        // Разбиваем ввод пользователя на массив строк (игнорим пробелы)
        String[] s = in.nextLine().replaceAll("[\\s]{2,}", " ").split(" ");
        // Проверяем команду на список существующих команд
        while (    (!s[0].equalsIgnoreCase("save"))
                && (!s[0].equalsIgnoreCase("sort"))
                && (!s[0].equalsIgnoreCase("info"))
                && (!s[0].equalsIgnoreCase("add"))
                && (!s[0].equalsIgnoreCase("import"))
                && (!s[0].equalsIgnoreCase("help"))
                && (!s[0].equalsIgnoreCase("show"))
                && (!s[0].equalsIgnoreCase("exit"))
                && (!s[0].equalsIgnoreCase("remove"))
                && (!s[0].equalsIgnoreCase("remove_lower"))
                && (!s[0].equalsIgnoreCase("start"))){
            // Если введеной команды не существует, выводим сообщение, что произошла ошибка
            System.out.println("Ошибка! Такой команды нет");
            System.out.print("Введите команду управления коллекцией: ");
            // Запращиваем новую строчку от пользователя и так же делим ее
            s = in.nextLine().replaceAll("[\\s]{2,}", " ").split(" ");
        }

        // Если ввод проходил в формате json то заменяем {} на ""
        try{
            s[1] = s[1].replace("}","").replace("{","");
        }catch (ArrayIndexOutOfBoundsException ignored){}

        try {
            s[2] = s[2].replace("}","").replace("{","");
        }catch (ArrayIndexOutOfBoundsException ignored){}

        // Если строчка запроса прошла первую проверку
        // переходим к сравнению введеной команды с существующими
        // Если запрос совпадает с существующей командой
        // выполняем эту команду
        if(s[0].equals("save")){
            girlsHashSet.save();
        }
        else if(s[0].equals("sort")){
            System.out.println(girlsHashSet.sortedList());
        }
        else if(s[0].equals("info")){
            System.out.println(girlsHashSet.info());
        }
        else if(s[0].equals("add")){
            try{
                girlsHashSet.add(s[1],s[2]);
            }catch (ArrayIndexOutOfBoundsException e){
                // Если пользователь не ввел фразы но ввел имя
                System.out.println("Не было введено фразы");
                System.out.println("Была установлена фраза: Привет");
                try{
                    girlsHashSet.add(s[1],"Привет");
                }catch (ArrayIndexOutOfBoundsException e1){
                    // Если пользователь не ввел имя и фразу
                    girlsHashSet.add("Рома", "Привет");
                    System.out.println("Не было введено имени");
                    System.out.println("Была установлено имя: Рома");
                }
            }
        }
        else if(s[0].equals("remove_lower")){
            try{
                girlsHashSet.remove_lower(s[1]);
            }catch (ArrayIndexOutOfBoundsException e1){
                //Если пользователь не ввел элемент для сравнения
                girlsHashSet.remove("");
            }
        }
        else if(s[0].equals("show")){
            System.out.println(girlsHashSet.show());
        }
        else if(s[0].equals("help")){
            System.out.println(help);
        }
        else if(s[0].equals("import")){
            try{


                girlsHashSet.import_file(s[1]);
            }catch (ArrayIndexOutOfBoundsException e1){
                // Если пользователь не ввел файл для чтения
                girlsHashSet.import_file("test.csv");
            }
        }
        else if(s[0].equals("remove")){
            girlsHashSet.remove(s[1]);
        }
        else if(s[0].equals("start")){
            System.out.println("----------------------------------------\n");
            UserHandler.startMainProgram(girlsHashSet);
            System.out.println("----------------------------------------\n");
        }
        else if(s[0].equals("exit")){
            System.out.println("Конец сеанса!!!");
            System.out.println("Данные сохранены в Out.json");
            return false;
        }
        return true;
    }

    /**
     * Метод для запуска основной части программы с настроенной коллекцией
     *
     * @param hashSet коллекция для запуска основной части программы
     */
    public static void startMainProgram(GirlsHashSet hashSet){
        // Здесь запускаем прогу с 4 лабы, но юзаем новые методы коллекции,
        // которые позволяют вызывать старые методы для каждого элемента
        Conversation conversation = new Conversation();
        Neznaika neznaika = new Neznaika("Незнайка");
        hashSet.setNeznayka(neznaika);
        neznaika.setTalkHandler(conversation);
        hashSet.setTalkHandler(conversation);
        neznaika.speak();
    }
}
