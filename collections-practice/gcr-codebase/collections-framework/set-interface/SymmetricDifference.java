import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {

    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2){
        Set<T> difference = new HashSet<>();

        for(T element: set1){
            if(!set2.contains(element)){
                difference.add(element);
            }
        }

        for(T element: set2){
            if(!set1.contains(element)){
                difference.add(element);
            }
        }
        
        return difference;
    }
    
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> difference = symmetricDifference(set1, set2);

        System.out.println("Set1: "+set1);
        System.out.println("Set2: "+set2);
        System.out.println("Symmetric Difference set: "+difference);

    }
}
