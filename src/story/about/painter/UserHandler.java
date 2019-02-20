package story.about.painter;
import java.util.Scanner;

/**
 *
 */

public class UserHandler {

    /**
     *
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
                girlsHashSet.add(s[1],"Привет");
            }
        }
        else if(s[0].equals("remove_lower")){
            girlsHashSet.remove_lower(s[1]);
        }
        else if(s[0].equals("show")){
            System.out.println(girlsHashSet.show());
        }
        else if(s[0].equals("help")){
            System.out.println(help);
        }
        else if(s[0].equals("import")){
            girlsHashSet.import_file(s[1]);
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
     *
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
