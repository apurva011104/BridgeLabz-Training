public class NumberOfStepsToReduceANumberToZero {
    
    public static int countingSteps(int num, int count){
        if(num==0){
            return count;
        }
        count++;
        if(num%2==0){
            return countingSteps(num/2, count);
        }
        return countingSteps(num-1, count);
    }

    public static int numberOfSteps(int num){
        return countingSteps(num, 0);
    }

    public static void main(String[] args) {
        int n = 20;
        int numberOfSteps = numberOfSteps(n);
        System.out.println("Number of steps to reduce "+n+" to zero: "+numberOfSteps);
    }
}
