public class Course {
    
    private final String courseID;
    private String courseName;
    private int courseDurationInHours;

    public Course(String courseID, String courseName, int courseDurationInHours) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseDurationInHours = courseDurationInHours;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseDurationInHours() {
        return courseDurationInHours;
    }

    public void displayCourseDetails(){
        System.out.printf("Course ID: %s, Course Name: %s, Course Duration: %d hours%n", courseID, courseName, courseDurationInHours);
    }

}
