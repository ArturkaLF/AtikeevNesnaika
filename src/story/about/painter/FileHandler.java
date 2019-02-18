package story.about.painter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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


}
