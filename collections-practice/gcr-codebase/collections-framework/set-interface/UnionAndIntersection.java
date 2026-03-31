import java.util.HashSet;
import java.util.Set;

public class UnionAndIntersection {

    public static <T> Set<T> union(Set<T> set1, Set<T> set2){
        Set<T> union = new HashSet<>();

        for(T element: set1){
            union.add(element);
        }

        for(T element: set2){
            union.add(element);
        }

        return union;
    }

    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2){
        Set<T> intersection = new HashSet<>();

        for(T element: set1){
            if(set2.contains(element)){
                intersection.add(element);
            }
        }
        
        return intersection;
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

        Set<Integer> union = union(set1, set2);
        Set<Integer> intersection = intersection(set1, set2);

        System.out.println("Set1: "+set1);
        System.out.println("Set2: "+set2);
        System.out.println("Union set: "+union);
        System.out.println("Intersection set: "+intersection);
    }
}
