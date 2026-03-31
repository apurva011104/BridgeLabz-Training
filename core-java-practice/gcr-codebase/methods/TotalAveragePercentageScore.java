import java.util.Scanner;

public class TotalAveragePercentageScore {

    //Rounding a number to two decimal points
    public static double roundToTwoDecimalPoints(double num){
        return Math.round(num*100.0)/100.0;
    }

    //Generating marks of subjects
    public static double generateMarks(){
        double marks=0.0;
        while(true){
            marks=0.0;
            for( int i=0 ; i<2 ; i++){
                marks = (marks * 10) + (Math.random()*9);
            }
            marks = roundToTwoDecimalPoints(marks);
            if(marks<=100){
                break;
            }
        }
        return marks;
    }

    //Storing marks in an array
    public static double[][] studentsMarks(int numberOfStudents){
        double [][]studentsMarks = new double[numberOfStudents][3];
        for(int i=0 ; i<numberOfStudents ; i++){
            for(int j=0 ; j<3 ; j++){
                studentsMarks[i][j]=generateMarks();
            }
        }
        return studentsMarks;
    }

    //Calculating total
    public static double total( double[] marks){
        double total=0.0;
        for(double m: marks){
            total+=m;
        }
        return total;
    }

    //Calculating average
    public static double average( double[] marks){
        double total=total(marks);
        double average = total / 3;
        average = roundToTwoDecimalPoints(average);
        return average;
    }

    //Calculating percentage
    public static double percentage(double[] marks){
        return average(marks);
    }

    //Storing total, average and percentage in an array
    public static double[][] totalAverageAndPercentageOfStudents(double[][] marks){
        double [][]totalAverageAndPercentageOfStudents = new double[marks.length][3];
        for(int i=0; i<marks.length;i++){
            totalAverageAndPercentageOfStudents[i][0]=total(marks[i]);
            totalAverageAndPercentageOfStudents[i][1]=average(marks[i]);
            totalAverageAndPercentageOfStudents[i][2]=percentage(marks[i]);
        }
        return totalAverageAndPercentageOfStudents;
    }

    //Calculating grades and remarks according to percentage
    public static String[][] calculateGradesAndRemarks(double[][] marks){
        String[][] gradesAndRemarks = new String[marks.length][2];

        for(int i=0;i<marks.length;i++){
            double percentage = percentage(marks[i]);
            if(percentage>=80){
                gradesAndRemarks[i][0]="A";
                gradesAndRemarks[i][1]= "Level 4, above agency-normalized standards";
            }
            else if(percentage>=70){
                gradesAndRemarks[i][0]="B";
                gradesAndRemarks[i][1]= "Level 3, at agency-normalized standards";
            }
            else if(percentage>=60){
                gradesAndRemarks[i][0]="C";
                gradesAndRemarks[i][1]= " Level 2, below but approaching agency-normalized standards";

            }
            else if(percentage>=50){
                gradesAndRemarks[i][0]="D";
                gradesAndRemarks[i][1]= "Level 1, well below agency-normalized standards";

            }
            else if(percentage>=40){
                gradesAndRemarks[i][0]="E";
                gradesAndRemarks[i][1]= "Level 1-, too below agency-normalized standards";
            }
            else{
                gradesAndRemarks[i][0]="R";
                gradesAndRemarks[i][1]= " Remedial standards";
            }
        }

        return gradesAndRemarks;
    }

    //Displaying scores
    public static void displayScoreCard(double [][]studentsMarks){
        double [][]totalAverageAndPercentageOfStudents = totalAverageAndPercentageOfStudents(studentsMarks);
        String [][]gradesAndRemarks = calculateGradesAndRemarks(studentsMarks);

        System.out.println("Student    |    Physics    |    Chemistry    |    Maths    |    Total    |    Average    |    Percentage    |    Grade    |    Remarks");
        for(int i=0 ; i<studentsMarks.length;i++){
            System.out.printf("%d    |    %.2f    |    %.2f    |    %.2f    |    %.2f    |    %.2f    |    %.2f%%   |    %s    |    %s    ",(i+1),studentsMarks[i][0],studentsMarks[i][1],studentsMarks[i][2],totalAverageAndPercentageOfStudents[i][0],totalAverageAndPercentageOfStudents[i][1],totalAverageAndPercentageOfStudents[i][2],gradesAndRemarks[i][0],gradesAndRemarks[i][1]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numberOfStudents = scan.nextInt();
        while(numberOfStudents<=0){
            System.out.print("Number of students cannot be less than one. Enter again: ");
            numberOfStudents=scan.nextInt();
        }
        double [][]studentsMarks = studentsMarks(numberOfStudents);

        displayScoreCard(studentsMarks);
        
        scan.close();
    }
}
