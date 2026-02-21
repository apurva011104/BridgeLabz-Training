public class PrimeNumberOfSetBitsInBinaryRepresentation {

    public static boolean isPrimeNumber(int n){
        if(n==1){
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int countPrimeSetBits(int left, int right) {
        int count = 0;
        for(int i=left; i<=right ; i++){
            int setBits = Integer.bitCount(i);
            if(isPrimeNumber(setBits)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int left = 6;
        int right = 10;
        int count = countPrimeSetBits(left, right);
        System.out.println("Number of prime number of set bits in binary representation: "+count);
    }
}
