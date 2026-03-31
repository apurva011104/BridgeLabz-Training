import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}

class StudentRecord {

    private final String rollNumber;
    private final double[] marks;

    public StudentRecord(String rollNumber, int subjectCount) {
        this.rollNumber = rollNumber;
        this.marks = new double[subjectCount];
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public double[] getMarks() {
        return marks;
    }
}


public class StudentReportGenerator {
    
private static final String[] subjects = {"Physics", "Chemistry", "Maths"};
    private final List<StudentRecord> students = new ArrayList<>();

    // Validation Methods

    public static boolean validateMark(double mark) {
        return mark >= 0 && mark <= 100;
    }

    public static double takeValidMark(Scanner scan) throws InvalidMarkException {
        String input = scan.next();
        try {
            double mark = Double.parseDouble(input);
            if (!validateMark(mark)) {
                throw new InvalidMarkException("Marks must be between 0 and 100.");
            }
            return mark;
        } catch (NumberFormatException e) {
            throw new InvalidMarkException("Marks must be numeric.");
        }
    }

    //Input Methods

    public void addStudent(Scanner scan) throws InvalidMarkException {

        System.out.print("Enter roll number: ");
        String roll = scan.next();

        StudentRecord student = new StudentRecord(roll, subjects.length);

        System.out.println("Enter marks:");
        for (int i = 0; i < subjects.length; i++) {
            System.out.print(subjects[i] + ": ");
            student.getMarks()[i] = takeValidMark(scan);
        }

        students.add(student);
    }

    //Calculation Methods

    public double calculateAverage(double[] marks) {
        double total = 0;
        for (double m : marks) {
            total += m;
        }
        return Math.round((total / marks.length) * 100.0) / 100.0;
    }

    public String assignGrade(double average) {
        if (average >= 85) return "A";
        if (average >= 70) return "B";
        if (average >= 50) return "C";
        return "Fail";
    }

    //display method

    public void displayReportCard(StudentRecord student) {

        double average = calculateAverage(student.getMarks());
        String grade = assignGrade(average);

        System.out.println("\n---------------- REPORT CARD ----------------");
        System.out.println("Roll Number: " + student.getRollNumber());
        System.out.println("--------------------------------------------");

        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%-10s : %.2f%n", subjects[i], student.getMarks()[i]);
        }

        System.out.println("--------------------------------------------");
        System.out.printf("Average Marks : %.2f%n", average);
        System.out.println("Grade         : " + grade);
        System.out.println("--------------------------------------------");
    }

    public void displayAllReports() {
        for (StudentRecord student : students) {
            displayReportCard(student);
        }
    }

    //Main method for testing

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        StudentReportGenerator generator = new StudentReportGenerator();

        System.out.print("Enter number of students: ");
        int n = scan.nextInt();

        try {
            for (int i = 0; i < n; i++) {
                System.out.println("\nStudent " + (i + 1));
                generator.addStudent(scan);
            }

            generator.displayAllReports();

        } catch (InvalidMarkException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
