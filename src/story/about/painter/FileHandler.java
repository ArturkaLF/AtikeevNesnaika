package story.about.painter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 *
 */

public class FileHandler {

    /**
     *
     */
    public static GirlsHashSet<LittleGirl> fileReader(String fileName){
        GirlsHashSet<LittleGirl> hashSet = new GirlsHashSet<>();
        try{
            File file = new File(fileName);
            Scanner s = new Scanner(file); // чтение из файла с помощью класса java.util.Scanner
            while (s.hasNext()){
                String[] line = s.nextLine().split(",");
                hashSet.add(new LittleGirl(line[0], new Message(line[1])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return hashSet;
    }

    /**
     *
     */
    public static void fileWriter(GirlsHashSet<LittleGirl> hashSet){

        File file = new File("Out.txt");

        try {
            FileWriter writer = new FileWriter(file);
            writer.write("{"+"\n");
            for (LittleGirl littleGirl : (Iterable<LittleGirl>) hashSet) {
                writer.write("\"" + littleGirl.toString() + "\"" + ":"
                        + "\"" + littleGirl.getMsg() + "\"" + "," + "\n");
            }
            writer.write("}");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static boolean getChoice(String text, GirlsHashSet girlsHashSet){
        Scanner in = new Scanner(System.in);
        System.out.print(text);
        String s = in.nextLine();
        s = s.replaceAll("\\s+","");
        while ((!s.equalsIgnoreCase("save")) && (!s.equalsIgnoreCase("sort"))
                && (!s.equalsIgnoreCase("info")) && (!s.equalsIgnoreCase("exite"))){
            System.out.print("Введите save или sort: ");
            s = in.nextLine();
        }
        if(s.equals("save")){
            girlsHashSet.save();
        }
        else if(s.equals("sort")){
            System.out.println(girlsHashSet.sortedList());
        }
        else if(s.equals("info")){
            System.out.println(girlsHashSet.info());
        }
        else if(s.equals("exite")){
            return false;
        }
        return true;
    }


}
