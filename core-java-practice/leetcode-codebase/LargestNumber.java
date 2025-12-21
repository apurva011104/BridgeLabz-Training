import java.util.Arrays;

public class LargestNumber {

    public String largestNumber(int[] nums){
        
        StringBuilder largestNumber=new StringBuilder();
        
        Integer[] numsObject = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        
        Arrays.sort(numsObject , (a,b) -> (Integer.toString(b)+Integer.toString(a)).compareTo(Integer.toString(a)+Integer.toString(b)));

        for(Integer n: numsObject){
            largestNumber.append(n);
        }

        return largestNumber.toString();

    }
    public static void main(String[] args) {
        LargestNumber ln=new LargestNumber();
        int nums[]= {3,30,34,5,9};
        String largestNumber=ln.largestNumber(nums);
        System.out.println("Array of numbers: "+Arrays.toString(nums));
        System.out.println("Largest Number: "+largestNumber);
    }    
}
