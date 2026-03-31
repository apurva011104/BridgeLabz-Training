
import java.util.ArrayList;
import java.util.Scanner;

public class StudentScoreManager {

    double[][] studentsScore;

    public StudentScoreManager(int numberOfStudents) {
        studentsScore= new double[numberOfStudents][3];
    }

    //Method to validate double input
    public static boolean validateDoubleInput(String num){
        try {
            double n= Double.parseDouble(num);
            if(n<0){
                return false;
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    //Method to validate int input
    public static boolean validateIntegerInput(String num){
        try {
            int n= Integer.parseInt(num);
            if(n<0){
                return false;
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    //Methods to take input
    public static int takeIntegerInput(Scanner scan){
        String num=scan.next();
        while(!validateIntegerInput(num)){
            System.out.print("Invalid input. Enter again: ");
            num = scan.next();
        }
        return Integer.parseInt(num);
    }

    public static double takeDoubleInput(Scanner scan){
        String num=scan.next();
        while(!validateDoubleInput(num)){
            System.out.print("Invalid input. Enter again: ");
            num = scan.next();
        }
        return Double.parseDouble(num);
    }


    //Method to take marks input
    public void takeMarksInput(Scanner scan){
        for(int i=0 ; i<studentsScore.length ; i++){
            System.out.println("Student "+(i+1)+" marks:");
            System.out.print("In physics: ");
            studentsScore[i][0]=takeDoubleInput(scan);
            System.out.print("In chemistry: ");
            studentsScore[i][1]=takeDoubleInput(scan);
            System.out.print("In maths: ");
            studentsScore[i][2]=takeDoubleInput(scan);
        }
    }

    //Method to calculate marks for one student
    public double calculateAverageScoreOfStudent(double []studentScore){
        double total=0;
        for(double score: studentScore){
            total+=score;
        }
        return (Math.round((total/3)*100.0))/100.0;
    }
    
    //Method to store average marks of each student in an array
    public double[] averageScoreOfEachStudent(){

        double[] averageScoreOfEachStudent = new double[studentsScore.length];

        for(int i=0;i<studentsScore.length;i++){
            averageScoreOfEachStudent[i] = calculateAverageScoreOfStudent(studentsScore[i]);
        }

        return averageScoreOfEachStudent;
    }

    //Method to calculate average score of the class
    public double averageScoreOfStudents(){
        double[] averageScoreOfEachStudent = averageScoreOfEachStudent();

        double total=0;
        for(double average: averageScoreOfEachStudent){
            total+=average;
        }

        return (Math.round((total/=studentsScore.length)*100.0))/100.0;
    }

    //Method to display average marks of each student
    public void displayAverageScoreOfEachStudent(){

        double[] averageScoreOfEachStudent = averageScoreOfEachStudent();

        System.out.println("Average score of each student: ");
        for(int i=0 ; i<studentsScore.length ; i++){
            System.out.printf("Student %d: %.2f%n",(i+1),averageScoreOfEachStudent[i]);
        }

    }

    //Method to display average marks of all of the students
    public void displayAverageScoreOfStudents(){
        System.out.printf("Average score of the class: %.2f%n",averageScoreOfStudents());
    }

    //Method to find the highest score
    public double highestScore(){

        double[] averageScoreOfEachStudent = averageScoreOfEachStudent();

        double highestScore = averageScoreOfEachStudent[0];

        for(double score: averageScoreOfEachStudent){
            highestScore = Math.max(highestScore, score);
        }

        return highestScore;
    }

    //Method to display the highest score
    public void displayHighestScore(){
        System.out.println("Highest score: "+highestScore());
    }
    
    //Method to find the lowest score
    public double lowestScore(){

        double[] averageScoreOfEachStudent = averageScoreOfEachStudent();

        double lowestScore = averageScoreOfEachStudent[0];

        for(double score: averageScoreOfEachStudent){
            lowestScore = Math.min(lowestScore, score);
        }
        
        return lowestScore;
    }

    //Method to display the lowest score
    public void displayLowestScore(){
        System.out.println("Lowest score: "+lowestScore());
    }

    //Method to identify scores above the average
    public ArrayList<Double> scoresAboveAverage(){

        ArrayList<Double> scoresAboveAverage = new ArrayList<>();

        double[] averageScoreOfEachStudent = averageScoreOfEachStudent();

        double averageScore = averageScoreOfStudents();

        for(double score : averageScoreOfEachStudent){
            if(score>averageScore){
                scoresAboveAverage.add(score);
            }
        }

        return scoresAboveAverage;

    }

    //Method to display scores above the average
    public void displayScoresAboveAverage(){
        double averageScore = averageScoreOfStudents();
        ArrayList<Double> scoresAboveAverage = scoresAboveAverage();

        displayAverageScoreOfStudents();

        if(scoresAboveAverage.size()==0){
            System.out.println("No score above the average score were found.");
        }
        else{
            System.out.print("Scores above average:");
            for(double score: scoresAboveAverage){
                System.out.printf(" "+score);
            }
        }
    }

    //"main" method for testing
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numberOfStudents = takeIntegerInput(scan);
        StudentScoreManager scores = new StudentScoreManager(numberOfStudents);
        scores.takeMarksInput(scan);
        scores.displayAverageScoreOfEachStudent();
        scores.displayAverageScoreOfStudents();
        scores.displayHighestScore();
        scores.displayLowestScore();
        scores.displayScoresAboveAverage();
    }
}
