import java.util.HashSet;
import java.util.Set;

public class FindIfSubset {
    public static <T> boolean checkIfSubset(Set<T> set1, Set<T> set2){
        return set1.containsAll(set2) || set2.containsAll(set1);
    } 

    public static void main(String[] args) {
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(2);
        set1.add(3);
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        boolean isSubset = checkIfSubset(set1, set2);

        System.out.println("Set1: "+set1);
        System.out.println("Set2: "+set2);
        System.out.println("Is one set a subset of another?: "+isSubset);
    }
}
