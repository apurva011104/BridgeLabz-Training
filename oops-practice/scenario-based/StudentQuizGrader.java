import java.util.Scanner;

class Student{

    protected final String rollNumber;
    private String name;
    private String []studentAnswers;

    public Student(String rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.studentAnswers = new String[10];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getStudentAnswers() {
        return studentAnswers;
    }

    public void setStudentAnswers(String[] studentAnswers) {
        this.studentAnswers = studentAnswers;
    }

    public String getRollNumber() {
        return rollNumber;
    }
}

public class StudentQuizGrader {
    
    private static final Scanner scan = new Scanner(System.in);
    private static final String[] quizQuestions = {"Which planet is closest to the sun?","What gas do human exhales that plants absorb?","How many degrees are in a circle?","Which continent is the biggest continent in the world?","How many colors are there in rainbow?","Calculate: 54+71*4/2-7","Who painted the Mona Lisa?","What is the largest country in the world by land area?","Which planet is known as the Red Planet?","Which ocean is the largest in the world?"};
    private static final String[][] options = {{"Mercury","Saturn","Pluto","Earth"},{"Oxygen","Carbon Dioxide","Nitrogen","Helium"},{"180","270","360","400"},{"Africa","Asia","Antartica","Europe"},{"5","7","6","8"},{"198","243","189","-100"},{"Leonardo da Vinci","Michelangelo","Vincent van Gogh","Pablo Picasso"},{"India","China","USA","Russia"},{"Mercury","Jupiter","Neptune","Mars"},{"Arctic","Indian","Pacific","Atlantic"}};
    private static final String[] correctAnswers = {"Mercury","Carbon Dioxide","360","Asia","7","189","Vincent van Gogh","Russia","Mars","Pacific"};
    private static final double passingGrade = 30.0;

    public static void displaySampleQuestion(){
        System.out.println("Instructions for answer format: ");
        System.out.println("How many bones are there in out body?");
        System.out.println("A. 204\nB.207\nC.206\nD.205");
        System.out.println("Your answer: 206");
    }

    public static void displayQuiz(Student student){
        String[] studentAnswers = student.getStudentAnswers();
        
        System.out.println("Quiz: ");
        for(int i=0;i<quizQuestions.length;i++){
            System.out.println((i+1)+". "+quizQuestions[i]);
            displayOptions(i);
            System.out.print("Your answer: ");
            String answer = scan.nextLine().trim();
            studentAnswers[i]=answer;
        }
    }

    public static void displayOptions(int questionNumber){
        for(char ch='A';ch<='D';ch++){
            System.out.println(ch+". "+options[questionNumber][ch-'A']);
        }
    }

    private static boolean checkAnswer(int questionNumber, String studentAnswer){
        return correctAnswers[questionNumber].equalsIgnoreCase(studentAnswer);
    }

    protected static int calculateScore(String[] studentAnswers){
        int correctAnswersCount = 0;
        for(int i=0; i<quizQuestions.length ;i++){
            if(checkAnswer(i, studentAnswers[i])){
                correctAnswersCount++;
            }
        }
        return correctAnswersCount;
    }

    public static double calculatePercentageScore(String[] studentAnswers){
        return (calculateScore(studentAnswers)*100.0)/quizQuestions.length;
    }
    public static void provideFeedback(String[] studentAnswers){
        for(int i=0; i<quizQuestions.length ;i++){
            System.out.println("Question "+(i+1)+".: "+(checkAnswer(i, studentAnswers[i])?"Correct":"Incorrect"));
        }
    }

    public static String status(String[] studentAnswers){
        return calculatePercentageScore(studentAnswers)>=passingGrade?"Pass":"Fail";
    }

    public static void displayResults(Student student){
        System.out.println("Student roll number: "+student.getRollNumber());
        System.out.println("Name: "+student.getName());
        System.out.println("Score (out of 10): "+calculateScore(student.getStudentAnswers()));
        System.out.printf("Percentage score: %.1f%n",calculatePercentageScore(student.getStudentAnswers()));
        System.out.println("Result: "+status(student.getStudentAnswers()));
    }

    public static void main(String[] args) {
        Student student1 = new Student("STU14755", "Ava");
        displaySampleQuestion();
        displayQuiz(student1);
        provideFeedback(student1.getStudentAnswers());
        displayResults(student1);
    }
}
