package story.about.painter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Класс-коллекия основанная на HashSet
 *
 * @author Атикеев Роман
 * @version 1.1
 */

public class GirlsHashSet<T> extends HashSet {

    /**
     * Поле-счетчик удаленных элементов коллекции
     */
    private int removeCounter = 0;
    /**
     * Поле-счетчик добавленных элементов коллекции
     */
    private int addCounter = 0;

    /**
     * Метод добавления нового элемента коллекции
     *
     * @param name имя нового элемента коллекции (имя девочки)
     * @param text текст нового элемента коллекции (речь девочки)
     */
    public void add(String name, String text) {
        this.add(new LittleGirl(name, new Message(text)));
        addCounter++;
    }

    /**
     * Метод вывода списка элементов коллекции
     *
     * @return Список элеметов коллекции
     */
    public String show(){
        String line = "";
        for (Object o : this) {
            line = line.concat(o.toString()).concat(" ");
        }
        return line;
    }

    /**
     * Метод чтения новых элементов коллекции из выбранного файла
     *
     * @param fileName имя файла откуда будет проходить чтение
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
     * Метод вывода отсортированного списка элеметов коллекции
     *
     * @return отсортированный список элементов коллекции по длине имени
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
     * Метод удаления элемента коллекции
     *
     * @param element элемент для удаления
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
     * Метод вывода информации о коллекции
     *
     * @return подробная информация о коллекции(кол-во элементов, кол-во удаленных элементов и т.д.)
     */
    public String info(){
        return  "Подробная информация о коллекции: " + this.getClass() + "\n" +
                "Количество элементов: " + this.size() + "\n" +
                "HashCode: " + this.hashCode() + "\n" +
                "Количество удаленных элементов: " + this.removeCounter + "\n" +
                "Количевтво добавленных элементво: " + this.addCounter;
    }


    /**
     * Метод удаления элеметов коллекции меньших чем введеный
     *
     * @param element элемент для сравнения
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
     * Метод сохранения коллекции в файл (Out.json)
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
     * Метод настройки Незнайки для каждого элемента коллекции
     *
     * @param neznaika объект Незнайка для привязки
     */
    public void setNeznayka(Neznaika neznaika){
        for (Iterator<LittleGirl> littleGirl = this.iterator(); littleGirl.hasNext();) {
            littleGirl.next().setNeznaika(neznaika);
        }
    }

    /**
     * Метод настройки разговора для всех элементов коллекции
     *
     * @param conversation объект разговора для привязки
     */
    public void setTalkHandler(Conversation conversation){
        for (Iterator<LittleGirl> littleGirl = this.iterator(); littleGirl.hasNext();) {
            littleGirl.next().setTalkHandler(conversation);
        }
    }


}

