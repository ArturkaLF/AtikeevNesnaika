package story.about.painter;
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
        Scanner in = new Scanner(System.in);
        System.out.print(text);
        String[] s = in.nextLine().replaceAll("[\\s]{2,}", " ").split(" ");

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
            System.out.println("Ошибка! Такой команды нет");
            System.out.print("Введите команду управления коллекцией: ");
            s = in.nextLine().replaceAll("[\\s]{2,}", " ").split(" ");
        }
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
                System.out.println("Не было введено фразы");
                System.out.println("Была установлена фраза: Привет");
                try{
                    girlsHashSet.add(s[1],"Привет");
                }catch (ArrayIndexOutOfBoundsException e1){
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
                girlsHashSet.import_file("test.csv");
            }
        }
        else if(s[0].equals("remove")){
            girlsHashSet.remove(s[1]);
        }
        else if(s[0].equals("start")){
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
        Conversation conversation = new Conversation();
        Neznaika neznaika = new Neznaika("Незнайка");
        hashSet.setNeznayka(neznaika);
        neznaika.setTalkHandler(conversation);
        hashSet.setTalkHandler(conversation);
        neznaika.speak();
    }
}
