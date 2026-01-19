import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations {

    public static List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        int index=0;
        int i=1;
        while(i<=n && index<target.length){
            int count = 0;
            while(i!=target[index]){
                i++;
                operations.add("Push");
                count++;
            }
            while(count>0){
                operations.add("Pop");
                count--;
            }
            operations.add("Push");
            i++;
            index++;
        }
        
        return operations;
    }

    public static void main(String[] args) {
        
        int[] target = {1,2,5};
        int n = 8;
        List<String> operations = buildArray(target, n);
        System.out.println("Stack operations to build the target array: "+operations);
        
    }
}
