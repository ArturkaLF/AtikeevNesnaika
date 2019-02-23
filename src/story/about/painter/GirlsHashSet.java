package story.about.painter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Сатический метод для обработки запросов пользователя
 * @author Атикеев Роман
 * @version 1.1
 */

public class GirlsHashSet<T> extends HashSet {

    /**
     * Сатический метод для обработки запросов пользователя
     * @author Атикеев Роман
     * @version 1.1
     */
    private int removeCounter = 0;
    private int addCounter = 0;

    /**
     * Сатический метод для обработки запросов пользователя
     * @author Атикеев Роман
     * @version 1.1
     */
    public void add(String name, String text) {
        this.add(new LittleGirl(name, new Message(text)));
        addCounter++;

    }

    /**
     * Сатический метод для обработки запросов пользователя
     * @author Атикеев Роман
     * @version 1.1
     */
    public String show(){
        String line = "";
        for (Object o : this) {
            line = line.concat(o.toString()).concat(" ");
        }
        return line;
    }

    /**
     * Сатический метод для обработки запросов пользователя
     * @author Атикеев Роман
     * @version 1.1
     */
    public void import_file(String fileName){
        try{
            File file = new File(fileName);
            Scanner s = new Scanner(file); // чтение из файла с помощью класса java.util.Scanner
            this.removeAll(this);
            while (s.hasNext()){
                String[] line = s.nextLine().split(",");
                this.add(new LittleGirl(line[0], new Message(line[1])));
            }
        } catch (FileNotFoundException e){
            System.out.println("Я не могу найти такой файл\nimport произошел из файла test.csv");
            import_file("test.csv");
        }
    }


    /**
     * Сатический метод для обработки запросов пользователя
     * @author Атикеев Роман
     * @version 1.1
     */
    public String sortedList(){
        ArrayList<String> list = new ArrayList<>();
        for (Object o : this) {
            list.add(o.toString());
        }
        list.sort(Comparator.comparingInt(String::length));
        String s ="";
        for (Object o : list) {
            s = s.concat(o.toString()).concat(" ");
        }
        return s;
    }

    /**
     * Сатический метод для обработки запросов пользователя
     * @author Атикеев Роман
     * @version 1.1
     */
    public void remove(String element){
        for (Object o: this) {
            if (o.toString().equals(element)){
                this.remove(o);
                removeCounter++;
                break;
            }
        }
    }

    /**
     * Сатический метод для обработки запросов пользователя
     * @author Атикеев Роман
     * @version 1.1
     */
    public String info(){
        return  "Подробная информация о коллекции: " + this.getClass() + "\n" +
                "Количество элементов: " + this.size() + "\n" +
                "HashCode: " + this.hashCode() + "\n" +
                "Количество удаленных элементов: " + this.removeCounter + "\n" +
                "Количевтво добавленных элементво: " + this.addCounter;
    }


    /**
     * Сатический метод для обработки запросов пользователя
     * @author Атикеев Роман
     * @version 1.1
     */
    public void remove_lower(String element){
        for (Iterator<LittleGirl> set = this.iterator(); set.hasNext();) {
            String s = set.next().toString();
            if(element.length() > s.length()){
                set.remove();
                removeCounter++;
            }
        }
    }

    /**
     * Сатический метод для обработки запросов пользователя
     * @author Атикеев Роман
     * @version 1.1
     */
    public void save(){

        File file = new File("Out.json");

        try {
            FileWriter writer = new FileWriter(file);
            writer.write("{"+"\n");
            for (LittleGirl littleGirl : (Iterable<LittleGirl>) this) {
                writer.write("\"" + littleGirl.toString() + "\"" + ":"
                        + "\"" + littleGirl.getMsg() + "\"" + "," + "\n");
            }
            writer.write("}");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Сатический метод для обработки запросов пользователя
     * @author Атикеев Роман
     * @version 1.1
     */
    public void setNeznayka(Neznaika neznaika){
        for (Iterator<LittleGirl> littleGirl = this.iterator(); littleGirl.hasNext();) {
            littleGirl.next().setNeznaika(neznaika);
        }
    }

    /**
     * Сатический метод для обработки запросов пользователя
     * @author Атикеев Роман
     * @version 1.1
     */
    public void setTalkHandler(Conversation conversation){
        for (Iterator<LittleGirl> littleGirl = this.iterator(); littleGirl.hasNext();) {
            littleGirl.next().setTalkHandler(conversation);
        }
    }


}

