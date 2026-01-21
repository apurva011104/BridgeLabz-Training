public abstract class CourseType {

    private final int credits;
    private final int totalMarks;

    public CourseType(int credits, int totalMarks) {
        this.credits = credits;
        this.totalMarks = totalMarks;
    }

    public int getCredits() {
        return credits;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public abstract String getCourseTypeName();

    public abstract double  calculateFinalScore(double internalMarks, double externalMarks);

}
