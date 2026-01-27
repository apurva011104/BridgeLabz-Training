import java.util.LinkedHashMap;
import java.util.Map;

public class Exam {
    
    private final Map<String,Question> questions;

    public Exam() {
        this.questions = new LinkedHashMap<>();
    }

    public Map<String,Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question){
        if(question == null){
            throw new NullPointerException("Add a valid question");
        }
        if(questions.containsKey(question.getQuestionID())){
            System.out.println("Question already added to the exam");
            return;
        }
        this.questions.put(question.getQuestionID(), question);
    }

    public void removeQuestion(Question question){
        if(question == null){
            throw new NullPointerException("Remove a valid question");
        }
        if(!questions.containsKey(question.getQuestionID())){
            System.out.println("No such question found in the exam");
            return;
        }
        this.questions.remove(question.getQuestionID());
    }
    
}
