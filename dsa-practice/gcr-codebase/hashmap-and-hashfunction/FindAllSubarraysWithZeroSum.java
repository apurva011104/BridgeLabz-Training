
import java.util.ArrayList;
import java.util.HashMap;

public class FindAllSubarraysWithZeroSum {

    public static ArrayList<int[]> findSubarraysWithZeroSum(int[] array){
        ArrayList<int[]> subarraysIndices = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> sumMap = new HashMap<>();
        int sum =0;
        for(int i=0; i<array.length;i++){
            sum += array[i];
            if(sum == 0){
                subarraysIndices.add(new int[]{0,i});
            }
            sumMap.putIfAbsent(sum, new ArrayList<>());
            for(Integer index: sumMap.get(sum)){
                subarraysIndices.add(new int[]{index+1 , i});
            }
            sumMap.get(sum).add(i);
        }
        return subarraysIndices;
    }

    public static void displaySubarray(int[]array, int start, int end){
        System.out.print("[");
        for(int i=start; i<end ; i++){
            System.out.print(array[i]+", ");
        }
        System.out.println(array[end]+"]");
    }

    public static void main(String[] args) {
        int []array = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        ArrayList<int[]> subarraysIndices = findSubarraysWithZeroSum(array);

        for(int[] indices : subarraysIndices){
            displaySubarray(array, indices[0], indices[1]);
        }
    }
}
