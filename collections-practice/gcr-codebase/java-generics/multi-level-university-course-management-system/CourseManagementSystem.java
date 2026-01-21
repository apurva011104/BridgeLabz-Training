public class CourseManagementSystem {
    public static void main(String[] args) {

        CourseType courseType = new ExamCourse();
        ExamCourse examCourse = new ExamCourse();
        ResearchCourse researchCourse = new ResearchCourse();
        AssignmentCourse assignmentCourse = new AssignmentCourse();

        Course<CourseType> course1 = new Course<>("CRSE1235","Java Programming",20,courseType);
        Course<ExamCourse> course2 = new Course<>("SDES7690","Software development",24,examCourse);
        Course<ResearchCourse> course3 = new Course<>("RSRF6785","Organic chemistry",16,researchCourse);
        Course<AssignmentCourse> course4 = new Course<>("SGHE5452","SQL",12,assignmentCourse);

        CourseManager courseManager = new CourseManager();

        courseManager.addCourse(course1);
        courseManager.addCourse(course2);
        courseManager.addCourse(course3);
        courseManager.addCourse(course4);

        courseManager.displayAllCourses();

        courseManager.displayFinalScore(course2,19,89);
        
        courseManager.displayCourseDetails(course4);

        courseManager.removeCourse(course4);

        courseManager.displayAllCourses();;
    }
}
