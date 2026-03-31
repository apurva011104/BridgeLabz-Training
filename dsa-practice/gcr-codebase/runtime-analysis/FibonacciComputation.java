public class FibonacciComputation {

    public static int recursiveFibonacciComputation(int n){
        if(n<=1){
            return n;
        }
        return recursiveFibonacciComputation(n-1) + recursiveFibonacciComputation(n-2);
    }

    public static int iterativeFibonacciComputation(int n){
        if(n<=1){
            return n;
        }
        int prev1=0, prev2=1;
        int nthFibonacciNumber = 0;
        for(int i =2; i<=n ; i++){
            nthFibonacciNumber = prev2 + prev1;
            prev1 = prev2;
            prev2 = nthFibonacciNumber;
        }
        return nthFibonacciNumber;
    }

    public static void analyze(int n){

        long iterativeStartTime = System.nanoTime();
        iterativeFibonacciComputation(n);
        long iterativeEndTime = System.nanoTime();
        long iterativeTimeTaken = iterativeEndTime - iterativeStartTime;
        System.out.println("Time taken by iterative fibonnaci computation: "+iterativeTimeTaken+" nanoseconds");

        long recursiveStartTime = System.nanoTime();
        recursiveFibonacciComputation(n);
        long recursiveEndTime = System.nanoTime();
        long recursiveTimeTaken = recursiveEndTime - recursiveStartTime;
        System.out.println("Time taken by recursive fibonnaci computation: "+recursiveTimeTaken+" nanoseconds");
    }

    public static void main(String[] args) {
        System.out.println("Analysis when n=10: ");
        analyze(10);
        System.out.println();

        System.out.println("Analysis when n=30: ");
        analyze(30);
        System.out.println();

        System.out.println("Analysis when n=50: ");
        analyze(50);
    }
}
