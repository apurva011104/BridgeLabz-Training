package junit;

public class ExceptionHandling {
    
    public static int divide(int a, int b){
        if(b==0){
            throw new ArithmeticException("Cannot be divided by 0!");
        }
        return a / b;
    }

}
