import java.util.Scanner;

class InvalidScoreException extends Exception{

    @Override
    public String getMessage(){
        return "Invalid score. Score must be in range of 0 to 100";
    }
}

public class StudentScoreAnalyzer {

    //Method to take valid inputs
    public static int takeIntegerInput(Scanner scan){
        while(true){
            try {
                int n= scan.nextInt();
                if(n<=0){
                    System.out.print("Invalid number of students. Enter again: ");
                    continue;
                }
                return n;
            } 
            catch (Exception e) {
                scan.next();
                System.out.print("Invalid number of students. Enter again: ");
            }
            
        }
    }

    public static double takeDoubleInput(Scanner scan){
        while(true){
            try {
                double n= scan.nextDouble();
                return n;
            } 
            catch (Exception e) {
                scan.next();
                System.out.print("Not a number. Enter again: ");
            }
            
        }
    }

    //Method to calculate average
    public static double calculateAverage(double []studentsScore) throws InvalidScoreException{
        double total=0.0;
        for(double score: studentsScore){
            if(score<0 || score>100){
                throw new InvalidScoreException();
            }
            total+=score;
        }
        return total/studentsScore.length;
    }

    //Method to calculate highest score
    public static double highestScore(double []studentsScore) throws InvalidScoreException{
        double highestScore = studentsScore[0];
        for(double score: studentsScore){
            if(score<0 || score>100){
                throw new InvalidScoreException();
            }
            highestScore=Math.max(highestScore,score);
        }
        return highestScore;
    }

    //Method to claculate lowest score
    public static double lowestScore(double []studentsScore) throws InvalidScoreException{
        double lowestScore = studentsScore[0];
        for(double score: studentsScore){
            if(score<0 || score>100){
                throw new InvalidScoreException();
            }
            lowestScore=Math.min(lowestScore,score);
        }
        return lowestScore;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n=takeIntegerInput(scan);
        double []studentsScore = new double[n];
        for(int i=0;i<n;i++){
            System.out.print("Enter marks of student "+(i+1)+": ");
            studentsScore[i]=takeDoubleInput(scan);
        }
        try {
            double averageScore = calculateAverage(studentsScore);
            double highestScore = highestScore(studentsScore);
            double lowestScore = lowestScore(studentsScore);

            System.out.printf("Average score of the class: %.2f%n",averageScore);
            System.out.printf("Highest score: %.2f%n",highestScore);
            System.out.printf("Lowest score: %.2f%n",lowestScore);
        } 
        catch (InvalidScoreException e) {
            System.out.println(e);
        }
        scan.close();
    }
}
