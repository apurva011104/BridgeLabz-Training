import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public void recurse(List<List<Integer>> ans, List<Integer> list, int []nums){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i]))      continue;
            list.add(nums[i]);
            recurse(ans,list,nums);
            list.remove(list.size()-1);
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
