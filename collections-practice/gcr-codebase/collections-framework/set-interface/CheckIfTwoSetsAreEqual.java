import java.util.HashSet;
import java.util.Set;

public class CheckIfTwoSetsAreEqual {

    public static <T> boolean checkIfEqual(Set<T> set1, Set<T> set2){
        return set1.containsAll(set2) && set2.containsAll(set1);
    } 

    public static void main(String[] args) {
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(3);
        set2.add(2);
        set2.add(1);
        System.out.println(checkIfEqual(set1, set2));
    }
}
