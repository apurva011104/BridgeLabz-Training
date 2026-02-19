public class ReverseBits {

    public static int reverseBits(int n) {
        int reversed = 0;
        for(int i=31; i>=0 ; i--){
            if((n&1)==1){
                reversed += (int)Math.pow(2,i);
            }
            n>>=1;
        }
        return reversed;
    }

    public static void main(String[] args) {
        int n = 43261596;
        int reversed = reverseBits(n);
        System.out.println(reversed);
    }
}
