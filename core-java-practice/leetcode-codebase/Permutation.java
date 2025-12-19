import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public void recurse(List<List<Integer>> ans, List<Integer> list, int []nums){
        if(list.size()==nums.length){               //Base case: if the current list size equals the input array length, we found a permutation
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){     //Iterate through the input array
            if(list.contains(nums[i]))      continue;               //Skip if the number is already in the current permutation
            list.add(nums[i]);          //Add the number to the current permutation
            recurse(ans,list,nums);
            list.remove(list.size()-1);    //Backtrack: remove the last added number to explore other permutations
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer=new ArrayList<>();
        recurse(answer,new ArrayList<>(),nums);
        return answer;
    }

    public static void main(String[] args) {
        Permutation p=new Permutation();
        int nums[]={1,2,3};
        List<List<Integer>> result=p.permute(nums);
        System.out.println("All permutations: ");
        for(List<Integer> perm : result){
            System.out.print(perm + " ");
        }
    }
}
