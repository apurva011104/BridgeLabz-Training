import java.util.ArrayList;
import java.util.List;

public class CourseManager {
    
    private final List<Course<? extends CourseType>> courseRecord;

    public CourseManager() {
        this.courseRecord = new ArrayList<>();
    }

    private  boolean isCourseExists(Course course){
        for(Course<? extends CourseType> c: courseRecord){
            if(course.equals(c) || course.getCourseID().equals(c.getCourseID()) || course.getCourseName().equalsIgnoreCase(c.getCourseName())){
                return true;
            }
        }
        return false;
    }

    private  boolean isCourseIDExists(String id){
        for(Course<? extends CourseType> c: courseRecord){
            if(id.equals(c.getCourseID())){
                return true;
            }
        }
        return false;
    }

    private  boolean isCourseNameExists(String name){
        for(Course<? extends CourseType> c: courseRecord){
            if(name.equalsIgnoreCase(c.getCourseName())){
                return true;
            }
        }
        return false;
    }

    public void addCourse(Course course){
        if(isCourseExists(course)){
            System.out.println("Course is present in record");
            return;
        }
        if (isCourseIDExists(course.getCourseID())) {
            System.out.println("Another course with ID same is present in record");
            return;
        }
        if(isCourseNameExists(course.getCourseName())){
            System.out.println("Another course with same name is present in record");
            return;
        }

        courseRecord.add(course);
        System.out.println("Course added successfully");
    }

    public void displayAllCourses(){
        CourseUtils.displayAllCourses(courseRecord);
    }

    public void displayCourseDetails(Course course){
        if(!isCourseExists(course)){
            System.out.println("No such course found in record");
            return;
        }
        CourseUtils.displayCourseDetails(course);
    }

    private double evaluateFinalScore(Course course, double internalMarks, double externalMarks){
        return course.getCourseType().calculateFinalScore(internalMarks, externalMarks);
    }

    public void displayFinalScore(Course course, double internalMarks, double externalMarks){
        if(!isCourseExists(course)){
            System.out.println("No such course found in record");
            return;
        }
        double finalScore = evaluateFinalScore(course, internalMarks, externalMarks);
        System.out.printf("Final score: %.2f%n",finalScore);
    }

    public void removeCourse(Course course){
        if(!isCourseExists(course)){
            System.out.println("No such course found in record");
            return;
        }
        courseRecord.remove(course);
        System.out.println("Course removed successfully");
    }

}
