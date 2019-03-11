package story.about.painter;
import story.about.painter.mp.Conversation;
import story.about.painter.mp.LittleGirl;
import story.about.painter.mp.Message;
import story.about.painter.mp.Neznaika;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Класс-коллекия основанная на HashSet
 *
 * @author Атикеев Роман
 * @version 1.2
 */

public class GirlsHashSet extends HashSet{

    private HashSet <LittleGirl> set;



    /**
     * Поле-счетчик удаленных элементов коллекции
     */
    private int removeCounter = 0;
    /**
     * Поле-счетчик добавленных элементов коллекции
     */
    private int addCounter = 0;

    public GirlsHashSet(HashSet<LittleGirl> hashset) {
        set = hashset;
    }

    /**
     * Метод добавления нового элемента коллекции
     *
     * @param name имя нового элемента коллекции (имя девочки)
     * @param text текст нового элемента коллекции (речь девочки)
     */


    public void add(String name, String text) {
        set.add(new LittleGirl(name, new Message(text)));
        addCounter++;
    }

    /**
     * Метод вывода списка элементов коллекции
     *
     * @return Список элеметов коллекции
     */
    public String show(){
        // Создаем строку, куда добавляем все имена нашей коллекции
        String line = "";
        for (LittleGirl o : set) {
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
            // чтение из файла с помощью класса java.util.Scanner
            Scanner s = new Scanner(file);
            // Удаляем все элементы коллекции
            // мы их заменим на новые
            set.removeAll(set);
            while (s.hasNext()){
                // Читаем строчку и делим ее на элементы массива
                String[] line = s.nextLine().split(",");
                // Первый элемент добавляем как имя элемента коллекции
                // второй элмент - текст этого элемента
                set.add(new LittleGirl(line[0], new Message(line[1])));
            }
        } catch (FileNotFoundException e){
            // Если файл не был найден
            System.out.println("Я не могу найти такой файл\nimport произошел из файла test.csv");
            // читаем из файла test.csv
            import_file("test.csv");
        }
    }


    /**
     * Метод вывода отсортированного списка элеметов коллекции
     *
     * @return отсортированный список элементов коллекции по длине имени
     */
    public String sortedList(){
        // Создаем список
        ArrayList<String> list = new ArrayList<>();
        // Добавляем туда наши элементы коллекции
        for (Object o : set) {
            list.add(o.toString());
        }
        // Сортим список
        list.sort(Comparator.comparingInt(String::length));
        String s ="";
        // Добавляем все элементы этого списка в строку
        for (Object o : list) {
            s = s.concat(o.toString()).concat(" ");
        }
        // Выводим отсортированный список наших элементов
        return s;
    }

    /**
     * Метод удаления элемента коллекции
     *
     * @param element элемент для удаления
     */
    public void remove(String element){
        // Сравниваем каждый элемент коллекции с введеным элементов
        set.removeIf(o -> o.toString().equals(element));
        removeCounter += 1;
    }

    /**
     * Метод вывода информации о коллекции
     *
     * @return подробная информация о коллекции(кол-во элементов, кол-во удаленных элементов и т.д.)
     */
    public String info(){
        return  "Подробная информация о коллекции: " + this.getClass() + "\n" +
                "Количество элементов: " + set.size() + "\n" +
                "HashCode: " + this.hashCode() + "\n" +
                "Количество удаленных элементов: " + this.removeCounter + "\n" +
                "Количевтво добавленных элементво: " + this.addCounter;
    }


    public HashSet<LittleGirl> getSet() {
        return set;
    }

    /**
     * Метод удаления элеметов коллекции меньших чем введеный
     *
     * @param element элемент для сравнения
     */
    public void remove_lower(LittleGirl element){

        //set.removeIf(o -> o.compareTo(element) < 0); // недостаточно

        set.forEach(o->{
            if (o.compareTo(element) < 0){
                set.remove(o);
                System.out.println("Был удален элемент: " + o.toString());
                removeCounter++;
            }
        }); // ломается



//        for(LittleGirl el: set){
//            if (el.compareTo(element) < 0){
//                set.remove(el);
//                removeCounter++;
//                System.out.println("Был удален элемент:" + el.toString());
//            }
//        }
    }


    /**
     * Метод сохранения коллекции в файл (Out.json)
     */
    public void save(){

        // сохранение коллекции в формате JSON
        File file = new File("Out.json");
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("{"+"\n");
            for (LittleGirl littleGirl : set) {
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
        // Юзаем старый метод ко всем элементам коллекции
        set.forEach(o -> o.setNeznaika(neznaika));
    }

    /**
     * Метод настройки разговора для всех элементов коллекции
     *
     * @param conversation объект разговора для привязки
     */
    public void setTalkHandler(Conversation conversation){
        // Юзаем старый метод ко всем элементам коллекции
        set.forEach(o -> o.setTalkHandler(conversation));
    }
}

