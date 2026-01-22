import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ConvertASetToASortedList {
    
    public static List<Integer> convertToSortedList(Set<Integer> set){

        List<Integer> list = new ArrayList<>();

        for(int element: set){
            list.add(element);
        }

        Collections.sort(list);

        return list;
    }

    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();

        set.add(5);
        set.add(3);
        set.add(9);
        set.add(1);

        System.out.println("Unsorted hashset: "+set);

        List<Integer> sortedList = convertToSortedList(set);

        System.out.println("Sorted List: "+sortedList);
    }
}
