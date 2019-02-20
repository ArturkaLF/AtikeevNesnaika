package story.about.painter;
import java.util.Scanner;

/**
 *
 */

public class UserHandler {

    //метод для возврата hasSet из файла. Был заменен на метод import_file(fileName) из класса GirlsHashSet
//    public static GirlsHashSet<LittleGirl> fileReader(String fileName){
//        GirlsHashSet<LittleGirl> hashSet = new GirlsHashSet<>();
//        try{
//            File file = new File(fileName);
//            Scanner s = new Scanner(file); // чтение из файла с помощью класса java.util.Scanner
//            while (s.hasNext()){
//                String[] line = s.nextLine().split(",");
//                hashSet.add(new LittleGirl(line[0], new Message(line[1])));
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("Я не могу найти такой файл\nimport произошел из файла test.csv");
//            fileReader("test.csv");
//        }
//        return hashSet;
//    }

    //метод для записи hasSet в файл. Был заменен на метод save(fileName) из класса GirlsHashSe
//    /**
//     *
//     */
//    public static void fileWriter(GirlsHashSet<LittleGirl> hashSet){
//
//        File file = new File("Out.json");
//
//        try {
//            FileWriter writer = new FileWriter(file);
//            writer.write("{"+"\n");
//            for (LittleGirl littleGirl : (Iterable<LittleGirl>) hashSet) {
//                writer.write("\"" + littleGirl.toString() + "\"" + ":"
//                        + "\"" + littleGirl.getMsg() + "\"" + "," + "\n");
//            }
//            writer.write("}");
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

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
        }
        else if(s[0].equals("exit")){
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
