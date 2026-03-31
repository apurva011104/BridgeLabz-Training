public class AssignmentCourse extends CourseType{

    private static final String COURSE_TYPE = "Assignment";

    public AssignmentCourse() {
        super(4,20);
    }

    @Override
    public String getCourseTypeName(){
        return COURSE_TYPE;
    }

    @Override
    public double calculateFinalScore(double internalMarks, double externalMarks){
        return internalMarks;
    }
}
