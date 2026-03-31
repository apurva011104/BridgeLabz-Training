import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class ExamReviewSystem {
    
    private static final Scanner scanner = new Scanner(System.in);
    private final Student student;
    private final Exam exam;
    private final Map<String, String> studentAnswers;
    private final Stack<Question> navigationStackNext;
    private final Stack<Question> navigationStackPrevious;
    private Question currentQuestion = null;

    public ExamReviewSystem(Student student, Exam exam) {
        if(student==null || exam==null){
            throw new NullPointerException("Invalid student or exam.");
        }
        if(exam.getQuestions().isEmpty()){
            throw new IllegalArgumentException("No questions found in the exam");
        }
        this.student = student;
        this.exam = exam;
        this.studentAnswers = new HashMap<>();
        this.navigationStackNext = new Stack<>();
        this.navigationStackPrevious = new Stack<>();
        addQuestionsToStack();
    }

    public void startExam(){
        System.out.println("Exam started!");
        displayQuestion();
        takeUserInput();
    }

    private void addQuestionsToStack(){
        Map<String,Question> questions = exam.getQuestions();
        for(Map.Entry<String,Question> ques: questions.entrySet()){
            studentAnswers.put(ques.getKey(), null);
            navigationStackNext.add(ques.getValue());
        }
        currentQuestion = navigationStackNext.pop();
    }

    private void displayQuestion(){
        System.out.println("Question ID: "+currentQuestion.getQuestionID()+"\n Question: "+currentQuestion.getQuestionStatement());
    }

    private void goNext(){
        if(navigationStackNext.isEmpty()){
            System.out.println("No more questions to display.");
            return;
        }
        navigationStackPrevious.push(currentQuestion);
        currentQuestion = navigationStackNext.pop();
        displayQuestion();
    }

    private void goPrevious(){
        if(navigationStackPrevious.isEmpty()){
            System.out.println("No more questions to display.");
            return;
        }
        navigationStackNext.push(currentQuestion);
        currentQuestion = navigationStackPrevious.pop();
        displayQuestion();
    }

    private void answer(){
        System.out.print("Enter your answer: ");
        String answer = scanner.nextLine().trim();
        studentAnswers.replace(currentQuestion.getQuestionID(), answer);
        System.out.println("Answer stored successfully.");
    }

    private int calculateScore(){
        int count = 0;
        Map<String,Question> questions = exam.getQuestions();
        for(Map.Entry<String,String> entry: studentAnswers.entrySet()){
            Question question = questions.get(entry.getKey());
            if(entry.getValue()!=null && question.getAnswer().equalsIgnoreCase(entry.getValue())){
                count++;
            }
        }
        return count;
    }

    private void displayScore(){
        int score = calculateScore();
        System.out.println(student);
        System.out.println("Your Score: "+score+"/"+exam.getQuestions().size());
    }

    private void submitExam(){
        System.out.println("Exam submitted successfully.");
        System.out.println("Thank you for taking the exam.");
        displayScore();
    }

    private void takeUserInput(){
        boolean flag = true;
        while(flag){

            userMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            switch(choice){
                case "1":
                    answer();
                    break;
                case "2":
                    goNext();
                    break;
                case "3":
                    goPrevious();
                    break;
                case "4":
                    submitExam();
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid choice!.");
            }
        }
    }

    private void userMenu(){
        System.out.println("Enter '1' if you want to answer the current question.");
        System.out.println("Enter '2' if you want to go to next question.");
        System.out.println("Enter '3' if you want to go to previous question.");
        System.out.println("Enter '4' if you want to submit the exam.");
    }
}
