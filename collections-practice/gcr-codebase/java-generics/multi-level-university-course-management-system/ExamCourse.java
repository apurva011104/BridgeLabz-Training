public class ExamCourse extends CourseType {
    
    private static final String COURSE_TYPE = "Exam";

    public ExamCourse() {
        super(5,100);

    }

    @Override
    public String getCourseTypeName(){
        return COURSE_TYPE;
    }

    @Override
    public double calculateFinalScore(double internalMarks, double externalMarks){
        return internalMarks*0.2+externalMarks*0.8;
    }

}
