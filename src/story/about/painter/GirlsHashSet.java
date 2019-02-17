package story.about.painter;

import java.util.*;

/**
 *
 */

public class GirlsHashSet<T> extends HashSet {

    public String show(){
        String line = "";
        for (Object o : this) {
            line = line.concat(o.toString()).concat(" ");
        }
        return line;
    }

    public String sortedList(){
        ArrayList<String> list = new ArrayList<>();
        for (Object o : this) {
            list.add(o.toString());
        }
        list.sort(Comparator.comparingInt(String::length));
        return list.toString();
    }

    public void remove(String element){
        for (Object o : this) {
            if(o.toString().equals(element)){
                this.remove(o);
                break;
            }
        }
    }

}

