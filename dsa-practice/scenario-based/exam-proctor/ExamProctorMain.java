public class ExamProctorMain {
    
    public static void main(String[] args) {
        Student student = new Student("STU123","Ava","A");

        Exam exam = new Exam();
        exam.addQuestion(new Question("Q1","Which planet is the largest?","Jupiter"));
        exam.addQuestion(new Question("Q2","Which planet is known as 'Red planet'?","Mars"));
        exam.addQuestion(new Question("Q3","Calculate '24 * 5 + 8 / 4 * 3'?","126"));
        exam.addQuestion(new Question("Q4","How many seconds are there in an hour? (Numerical value only)","3600"));
        exam.addQuestion(new Question("Q5","Who is the author of 'Romeo & Juliet'?","William Shakespeare"));
        exam.addQuestion(new Question("Q6","How many colours are there in a rainbow? (Numerical value only)","7"));
        exam.addQuestion(new Question("Q7","Which is the largest continent on Earth?","Asia"));
        exam.addQuestion(new Question("Q8","How many oceans are there on Earth? (Numerical value only)","5"));
        exam.addQuestion(new Question("Q9","What is the full form of 'RAM'?","Random Access Memory"));
        exam.addQuestion(new Question("Q10","Which country is known as the 'Land of the Rising Sun'?","Japan"));

        ExamReviewSystem examReviewSystem = new ExamReviewSystem(student, exam);
        examReviewSystem.startExam();
    }

}
