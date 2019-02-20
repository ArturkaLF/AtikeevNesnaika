package story.about.painter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 *
 */

public class GirlsHashSet<T> extends HashSet {

    /**
     *
     */
    private int removeCounter = 0;
    private int addCounter = 0;

    /**
     *
     */
    public void add(String name, String text) {
        this.add(new LittleGirl(name, new Message(text)));
        addCounter++;

    }

    /**
     *
     */
    public String show(){
        String line = "";
        for (Object o : this) {
            line = line.concat(o.toString()).concat(" ");
        }
        return line;
    }

    /**
     *
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
     *
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
     *
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
     *
     */
    public String info(){
        return  "Подробная информация о коллекции: " + this.getClass() + "\n" +
                "Количество элементов: " + this.size() + "\n" +
                "HashCode: " + this.hashCode() + "\n" +
                "Количество удаленных элементов: " + this.removeCounter + "\n" +
                "Количевтво добавленныз элементво: " + this.addCounter;
    }


    /**
     *
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
     *
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
     *
     */
    public void setNeznayka(Neznaika neznaika){
        for (Iterator<LittleGirl> littleGirl = this.iterator(); littleGirl.hasNext();) {
            littleGirl.next().setNeznaika(neznaika);
        }
    }

    /**
     *
     */
    public void setTalkHandler(Conversation conversation){
        for (Iterator<LittleGirl> littleGirl = this.iterator(); littleGirl.hasNext();) {
            littleGirl.next().setTalkHandler(conversation);
        }
    }


}

