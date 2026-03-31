public class MathematicalOperations {

    //Method to calculate factorial of a number
    public static int factorial(int n){
        if(n<=1){
            return 1;
        }
        return n*factorial(n-1);
    }

    //Method to check if a number is prime
    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    //Method to find the greatest common divisor of two numbers
    public static int gcd(int a , int b){
        a = Math.abs(a);
        b = Math.abs(b);
        
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }

    //Method to find nth fibonaaci number
    public static int nthFibonacciNumber(int n){
        if(n<=1)        return n;
        int prev2=0;
        int prev1=1;
        int nthFibonacciNumber=0;
        for(int i=2;i<=n;i++){
            nthFibonacciNumber=prev2+prev1;
            prev2=prev1;
            prev1=nthFibonacciNumber;

        }
        return nthFibonacciNumber;
    }

    //Main method for testing
    public static void main(String[] args) {
        int n=5;
        System.out.println("Factorial: "+factorial(n));
        System.out.println("Is prime: "+isPrime(n));
        System.out.println("GCD of 5 and 7: "+gcd(5,7));
        System.out.println("5th fibonacci number: "+nthFibonacciNumber(n));
    }
}
