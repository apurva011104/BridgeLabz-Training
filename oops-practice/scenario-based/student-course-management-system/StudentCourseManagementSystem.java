
public class StudentCourseManagementSystem {

    public static void enrollCourse(CourseManager manager, Student student, Course course){
        try {
            manager.enrollCourse(student, course);
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        
        CourseManager manager = new CourseManager(5, "Manager");

        Student student1 = manager.addStudent("Ava", 21, "Female", "A");
        Student student2 = manager.addStudent("Lisa",22,"Female","A");
        Student student3 = manager.addStudent("Rose",22,"Female","A");
        Student student4 = manager.addStudent("Jennie",23,"Female","A");
        Student student5 = manager.addStudent("Jisoo",24,"Female","A");

        Course course1 = manager.addCourse("Java Programming",56);
        Course course2 = manager.addCourse("Product management",44);
        Course course3 = manager.addCourse("Software Development",84);
        Course course4 = manager.addCourse("Web Development",72);
        Course course5 = manager.addCourse("Database Management System",47);
        Course course6 = manager.addCourse("Cybersecurity",54);
        Course course7 = manager.addCourse("Inorganic chemistry",48);
        Course course8 = manager.addCourse("Discrete mathematics",60);

        Professor professor1 = manager.addProfessor("Bianca",32,"Female","CEA");
        Professor professor2 = manager.addProfessor("Alice",29,"Female","IT");
        Professor professor3 = manager.addProfessor("Jessica",54,"Female","Management");
        Professor professor4 = manager.addProfessor("Ruby",47,"Female","Management");
        Professor professor5 = manager.addProfessor("Violet",45,"Female","CEA");
        Professor professor6 = manager.addProfessor("Jia",28,"Female","Mathematics");
        Professor professor7 = manager.addProfessor("Lily",34,"Female","IT");
        Professor professor8 = manager.addProfessor("Jennifer",65,"Female","CEA");
        Professor professor9 = manager.addProfessor("Daisy",38,"Female","CEA");

        manager.displayStudentRecord();
        System.out.println();
        manager.displayProfessorRecord();
        System.out.println();
        manager.displayCourseRecord();
        System.out.println();

        enrollCourse(manager, student1, course1);
        enrollCourse(manager, student1, course3);
        enrollCourse(manager, student1, course4);
        enrollCourse(manager, student1, course5);
        enrollCourse(manager, student1, course6);
        enrollCourse(manager, student1, course8);

        enrollCourse(manager, student5, course2);
        enrollCourse(manager, student5, course2);
        enrollCourse(manager, student5, course7);

        enrollCourse(manager, student4, course2);
        enrollCourse(manager, student4, course3);
        enrollCourse(manager, student4, course5);

        enrollCourse(manager, student3, course1);

        enrollCourse(manager, student2, course2);
        enrollCourse(manager, student2, course6);
        enrollCourse(manager, student2, course4);

        manager.assignProfessor(course2, professor4);
        manager.assignProfessor(course2, professor3);
        manager.assignProfessor(course1, professor1);
        manager.assignProfessor(course5, professor9);
        manager.assignProfessor(course8, professor1);
        manager.assignProfessor(course7, professor8);
        manager.assignProfessor(course7, professor2);
        manager.assignProfessor(course4, professor7);
        manager.assignProfessor(course8, professor5);

        manager.displayStudentRecord();
        System.out.println();
        manager.displayProfessorRecord();
        System.out.println();
        manager.displayCourseRecord();
        System.out.println();

        manager.displayCoursesEnrolledByStudent(student1);
        manager.displayCourseTutors(course1);

        manager.removeCourse(course7);

        manager.removeProfessor(professor6);

        manager.displayStudentRecord();
        System.out.println();
        manager.displayProfessorRecord();
        System.out.println();
        manager.displayCourseRecord();
        System.out.println();

    }
}
