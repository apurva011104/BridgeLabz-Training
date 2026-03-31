public class Question {
    
    private final String questionID;
    private String questionStatement;
    private String answer;

    public Question(String questionID, String questionStatement, String answer) {
        if(questionID==null || questionStatement==null || answer==null){
            throw new NullPointerException("Invalid question ID, statement or answer.");
        }
        questionID = questionID.trim();
        questionStatement = questionStatement.trim();
        answer = answer.trim();
        if(questionID.isEmpty() || questionStatement.isEmpty() || answer.isEmpty()){
            throw new IllegalArgumentException("Question ID, statement and answer cannot be empty");
        }
        this.questionID = questionID;
        this.questionStatement = questionStatement;
        this.answer = answer;
    }

    public String getQuestionID() {
        return questionID;
    }

    public String getQuestionStatement() {
        return questionStatement;
    }

    public String getAnswer() {
        return answer;
    }


}
