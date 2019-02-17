package story.about.painter;
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
    @Override
    public boolean add(Object o) {
        addCounter++;
        return super.add(o);
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
        for (Object o : this) {
            if(o.toString().equals(element)){
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

}

