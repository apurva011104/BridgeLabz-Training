import java.util.List;

public class CourseUtils {

    public static void displayCourseDetails(Course<? extends CourseType> course){
        System.out.printf("Course ID: %s, Course Name: %s, Course Duration: %d weeks, Course Type: %s%n",course.getCourseID(), course.getCourseName(), course.getDurationInWeeks(), course.getCourseType().getCourseTypeName());
    }

    public static void displayAllCourses(List<Course<? extends CourseType>> courseRecord){
        for(Course<? extends CourseType> course: courseRecord){
            displayCourseDetails(course);
        }
    }
}

