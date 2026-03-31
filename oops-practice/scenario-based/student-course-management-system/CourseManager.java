import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseManager implements RegistrationService{
    
    private final int MAXIMUM_NUMBER_OF_ENROLLED_COURSES;
    private String managerName;
    private final List<Course> coursesRecord;
    private final List<Professor> professorsRecord;
    private final List<Student> studentsRecord;
    private final Map<Student,List<Course>> enrolledCoursesByStudents;
    private final Map<Course, List<Professor>> courseTutors;
    private final Map<Professor, Course> courseAssignedToProfessor;

    public CourseManager(int maximumNumberOfEnrolledCourses, String managerName) {
        this.MAXIMUM_NUMBER_OF_ENROLLED_COURSES = maximumNumberOfEnrolledCourses;
        this.managerName = managerName;
        this.coursesRecord = new ArrayList<>();
        this.professorsRecord = new ArrayList<>();
        this.studentsRecord = new ArrayList<>();
        this.enrolledCoursesByStudents = new HashMap<>();
        this.courseTutors = new HashMap<>();
        this.courseAssignedToProfessor = new HashMap<>();
    }

    public String getManagerName() {
        return managerName;
    }

    public int getMAXIMUM_NUMBER_OF_ENROLLED_COURSES() {
        return MAXIMUM_NUMBER_OF_ENROLLED_COURSES;
    }

    /*----------------------------VALIDATOR METHODS---------------------------------*/
    private boolean isCourseIDPresent(String id){
        for(Course course: coursesRecord){
            if(course.getCourseID().equals(id)){
                return true;
            }
        }
        return false;
    }

    private boolean isProfessorIDPresent(String id){
        for(Professor professor: professorsRecord){
            if(professor.getID().equals(id)){
                return true;
            }
        }
        return false;
    }

    private boolean isStudentIDPresent(String id){
        for(Student student: studentsRecord){
            if(student.getID().equals(id)){
                return true;
            }
        }
        return false;
    }

    /*----------------------------ID GENERATORS-------------------------------*/
    private String generateCourseID(){
        StringBuilder id;
        do { 
            id= new StringBuilder();
            for(int i=0;i<8;i++){
                if(i<4){
                    id.append((char)((int)(Math.random()*26)+'A'));
                }
                else{
                    id.append((int)(Math.random()*10));
                }
            }
        } 
        while (isCourseIDPresent(id.toString()));
        return id.toString();
    }

    private String generatePersonID(String prefix){
        String id;
        do { 
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<12;i++){
                sb.append((int)(Math.random()*10));
            }
            id = prefix+sb.toString();
        } 
        while (prefix.equals("STU")?isStudentIDPresent(id):isProfessorIDPresent(id));
        return id;
    }

    /*-------------------------------CREATE OPERATIONS----------------------------------*/
    public Course addCourse(String courseName, int courseDurationInHours){
        Course course = new Course(generateCourseID(), courseName, courseDurationInHours);
        courseTutors.put(course, new ArrayList<>());
        coursesRecord.add(course);
        return course;
    }

    public Professor addProfessor(String name, int age, String gender, String department){
        Professor professor = new Professor(generatePersonID("PROF"), name, age, gender, department);
        courseAssignedToProfessor.put(professor, null);
        professorsRecord.add(professor);
        return professor;
    }

    public Student addStudent(String name, int age, String gender, String grade){
        Student student = new Student(generatePersonID("STU"), name, age, gender, grade);
        studentsRecord.add(student);
        enrolledCoursesByStudents.put(student, new ArrayList<>());
        return student;
    }

    /*-------------------------------READ OPERATIONS----------------------------------*/
    public void displayCourseRecord(){
        int index=1;
        System.out.println("Course Record: ");
        for(Course course: coursesRecord){
            System.out.print((index)+". ");
            course.displayCourseDetails();
            if(courseTutors.get(course).isEmpty()){
                System.out.println("No professor assigned");
                continue;
            }
            char professorIndex='a';
            System.out.println("Professors assigned: ");
            for(Professor professor: courseTutors.get(course)){
                System.out.printf("%c. Professor ID: %s, Professor Name: %s%n", professorIndex, professor.getID(), professor.getName());
                professorIndex++;
            }
            index++;
        }
    }

    public void displayProfessorRecord(){
        int index=1;
        System.out.println("Professor Record: ");
        for(Professor professor: professorsRecord){
            System.out.print((index)+". ");
            professor.displayInformation();
            if(courseAssignedToProfessor.get(professor)!=null){
                System.out.println("Course: ("+courseAssignedToProfessor.get(professor).getCourseID()+", "+courseAssignedToProfessor.get(professor).getCourseName()+")");
            }
            else{
                System.out.println("Not teaching any course");
            }
            index++;

        }
    }

    public void displayStudentRecord(){
        int index=1;
        System.out.println("Student Record: ");
        for(Student student: studentsRecord){
            System.out.print((index)+". ");
            student.displayInformation();
            if(enrolledCoursesByStudents.get(student).isEmpty()){
                System.out.println("No courses enrolled");
                continue;
            }
            char courseIndex = 'a';
            System.out.println("Courses enrolled: ");
            for(Course course: enrolledCoursesByStudents.get(student)){
                System.out.printf("%c. Course ID: %s, Course Name: %s%n", courseIndex, course.getCourseID(), course.getCourseName());
                courseIndex++;
            }
            index++;
        }
    }

    public void displayCoursesEnrolledByStudent(Student student){
        if(!studentsRecord.contains(student)){
            System.out.println("Student not found in the record");
            return;
        }
        char courseIndex = 'a';
        System.out.println("Courses enrolled: ");
        for(Course course: enrolledCoursesByStudents.get(student)){
            System.out.printf("%c. Course ID: %s, Course Name: %s%n", courseIndex, course.getCourseID(), course.getCourseName());
            courseIndex++;
        }
    }

    public void displayCourseTutors(Course course){
        if(!coursesRecord.contains(course)){
            System.out.println("Course not found in the record");
            return;
        }
        if(courseTutors.get(course).isEmpty()){
            System.out.println("No professors assigned");
            return;
        }
        char professorIndex='a';
        System.out.println("Professors assigned: ");
        for(Professor professor: courseTutors.get(course)){
            System.out.printf("%c. Professor ID: %s, Professor Name: %s%n", professorIndex, professor.getID(), professor.getName());
            professorIndex++;
        }
        
    }

    /*-------------------------------UPDATE OPERATIONS----------------------------------*/
    @Override
    public void enrollCourse(Student student, Course course) throws CourseLimitExceededException{
        if(!studentsRecord.contains(student)){
            System.out.println("Student not found in the record");
            return;
        }
        if(!coursesRecord.contains(course)){
            System.out.println("Course not found in the record");
            return;
        }
        if(enrolledCoursesByStudents.get(student).contains(course)){
            System.out.println("Student is already enrolled in the course");
            return;
        }
        if(enrolledCoursesByStudents.get(student).size()>=MAXIMUM_NUMBER_OF_ENROLLED_COURSES){
            throw new CourseLimitExceededException("Student have already enrolled in maximum number of courses");
        }
        enrolledCoursesByStudents.get(student).add(course);
        System.out.println("Student "+student.getID()+" enrolled in course "+course.getCourseName()+" successfully");
    }

    @Override
    public void dropCourse(Student student, Course course){
        if(!studentsRecord.contains(student)){
            System.out.println("Student not found in the record");
            return;
        }
        if(!enrolledCoursesByStudents.get(student).contains(course)){
            System.out.println("No such course found to drop.");
            return;
        }
        enrolledCoursesByStudents.get(student).remove(course);
        System.out.println("Course dropped by student successfully");
    }

    @Override
    public void viewGrades(Student student){
        if(!studentsRecord.contains(student)){
            System.out.println("Student not found in the record");
            return;
        }
        System.out.println("Student "+student.getID()+" grade: "+student.getGrade());
    }

    @Override
    public void updateGrades(Student student, String newGrade){
        if(!studentsRecord.contains(student)){
            System.out.println("Student not found in the record");
            return;
        }
        student.updateGrade(newGrade);
        System.out.println("Student "+student.getID()+" grade updated to grade '"+newGrade+"' successfully");
    }

    public void assignProfessor(Course course, Professor professor){
        if(!professorsRecord.contains(professor)){
            System.out.println("Professor not found in the record");
            return;
        }
        if(!coursesRecord.contains(course)){
            System.out.println("Course not found in the record");
            return;
        }
        if(courseAssignedToProfessor.get(professor)!=null){
            System.out.println("A course has already been assigned to professor");
            return;
        }
        courseTutors.get(course).add(professor);
        courseAssignedToProfessor.put(professor,course);
        System.out.println("Professor "+professor.getName()+" to course "+course.getCourseID()+" successfully");
    }

    public void unassignProfessor(Professor professor){
        if(!professorsRecord.contains(professor)){
            System.out.println("Professor not found in the record");
            return;
        }
        if(courseAssignedToProfessor.get(professor)==null){
            System.out.println("Professor is not teaching any course");
            return;
        }
        Course course = courseAssignedToProfessor.get(professor);
        courseTutors.get(course).remove(professor);
        courseAssignedToProfessor.replace(professor, null);
        System.out.println("Professor unassigned successfully");
    }

    /*-------------------------------DELETE OPERATIONS----------------------------------*/
    public void removeStudent(Student student){
        if(!studentsRecord.contains(student)){
            System.out.println("Student not found in the record");
            return;
        }

        studentsRecord.remove(student);
        enrolledCoursesByStudents.remove(student);
        System.out.println("Student removed successfully");
    }

    public void removeCourse(Course course){
        if(!coursesRecord.contains(course)){
            System.out.println("Course not found in the record");
            return;
        }
        for(Map.Entry<Student,List<Course>> entry: enrolledCoursesByStudents.entrySet()){
            if(entry.getValue().contains(course)){
                enrolledCoursesByStudents.get(entry.getKey()).remove(course);
            }
        }
        for(Professor professor : courseTutors.get(course)){
            courseAssignedToProfessor.replace(professor, null);
        }
        courseTutors.remove(course);
        coursesRecord.remove(course);
        System.out.println("Course removed successfully");
    }

    public void removeProfessor(Professor professor){
        if(!professorsRecord.contains(professor)){
            System.out.println("Professor not found in the record");
            return;
        }
        for(Map.Entry<Course, List<Professor>> entry: courseTutors.entrySet()){
            if(entry.getValue().contains(professor)){
                courseTutors.get(entry.getKey()).remove(professor);
            }
        }
        professorsRecord.remove(professor);
        courseAssignedToProfessor.remove(professor);
        System.out.println("Professor removed successfully");
    }
    
}
