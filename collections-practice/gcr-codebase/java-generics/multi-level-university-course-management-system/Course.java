public class Course<T extends CourseType> {
    
    private final String courseID;
    private final String courseName;
    private final T courseType;
    private final int durationInWeeks;

    public Course(String courseID, String courseName,  int durationInWeeks,  T courseType) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.durationInWeeks = durationInWeeks;
        this.courseType = courseType;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getCourseType() {
        return courseType;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }
}
