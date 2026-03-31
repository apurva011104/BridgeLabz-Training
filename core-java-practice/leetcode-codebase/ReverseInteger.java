
public class ReverseInteger {

    public int reverseInteger(int x){
        long reverse=0;
        int absolute=Math.abs(x);

        while(absolute!=0){
            reverse= reverse*10 + (absolute%10);
            absolute/=10;
        }

        if(x<0){
            reverse*=-1;
        }

        if(reverse<Integer.MIN_VALUE || reverse>Integer.MAX_VALUE){
            return 0;
        }
        return (int)reverse;
    }

    public static void main(String[] args) {
        ReverseInteger rev=new ReverseInteger();
        int x=-321;
        int reverse=rev.reverseInteger(x);
        System.out.println("Original: "+x);
        System.out.println("Reverse: "+reverse);

    }
}
