import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list=new ArrayList<>();
        boolean[] isPresent = new boolean[nums.length + 1];
        for(int i: nums){
            isPresent[i]=true;
        }
        for(int i=1; i<isPresent.length ; i++){
            if(!isPresent[i]){
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};

        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
        System.out.println("All disappeared numbers: "+disappearedNumbers);
    }
}
