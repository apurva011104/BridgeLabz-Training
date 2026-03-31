import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public int square(int n){
        int sum=0;
        while(n!=0){
            sum+=Math.pow(n%10 , 2);
            n/=10;
        }
        return sum;
    }
    public boolean isHappy(int n){
        Set<Integer> unique=new HashSet<>();
        while(n!=1){
            n=square(n);
            if(unique.contains(n)){
                return false;
            }
            unique.add(n);
        }
        return true;
    }
    public static void main(String[] args) {
        HappyNumber hn= new HappyNumber();
        int n=2;
        boolean isHappy = hn.isHappy(n);
        System.out.println("Is "+n+" happy?: "+isHappy);
    }
}
