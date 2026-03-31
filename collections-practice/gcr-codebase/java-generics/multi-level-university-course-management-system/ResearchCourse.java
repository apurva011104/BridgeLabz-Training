public class ResearchCourse extends CourseType{

    private static final String COURSE_TYPE = "Research";

    public ResearchCourse() {
        super(3,50);
    }

    @Override
    public String getCourseTypeName(){
        return COURSE_TYPE;
    }

    @Override
    public double calculateFinalScore(double internalMarks, double externalMarks){
        return (internalMarks+externalMarks)/2;
    }

}
