package story.about.painter;
import java.io.File;
import java.io.FileNotFoundException;
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

}
