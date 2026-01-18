import java.util.HashSet;
import java.util.TreeSet;

public class DataStructureForSearchingComparison {
    
    public static void fillDataStructures(int[] array, HashSet<Integer> hashSet, TreeSet<Integer> treeSet){

        for(int i=0; i<array.length ; i++){
            int x = (int)(Math.random() * Integer.MAX_VALUE);
            while(hashSet.contains(x)){
                x = (int)(Math.random() * Integer.MAX_VALUE);
            }
            array[i]=x;
            hashSet.add(x);
            treeSet.add(x);
        }
    }

    public static void analyze(int dataSize, int target){
        int[] array = new int[dataSize];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        fillDataStructures(array, hashSet, treeSet);

        long arrayStartTime = System.nanoTime();
        for(int i: array){
            if(i==target){
                break;
            }
        }
        long arrayEndTime = System.nanoTime();
        long arrayTimeTaken = arrayEndTime - arrayStartTime;

        long hashsetStartTime = System.nanoTime();
        boolean flag1 = hashSet.contains(target);
        long hashsetEndTime = System.nanoTime();
        long hashsetTimeTaken = hashsetEndTime - hashsetStartTime;

        long treesetStartTime = System.nanoTime();
        boolean flag2 = treeSet.contains(target);
        long treesetEndTime = System.nanoTime();
        long treesetTimeTaken = treesetEndTime - treesetStartTime;
        
        System.out.println("Analysis for data size "+dataSize+": ");
        System.out.println("Search time taken by array: "+arrayTimeTaken+" nanoseconds");
        System.out.println("Search time taken by hashset: "+hashsetTimeTaken+" nanoseconds");
        System.out.println("Search time taken by treeset: "+treesetTimeTaken+" nanoseconds");
    }

    public static void main(String[] args) {
        
        int target = (int)(Math.random() * Integer.MAX_VALUE);

        //Perform analysis
        analyze(1000, target);
        System.out.println();

        analyze(10000, target);
        System.out.println();

        analyze(1000000, target);
    }

}
