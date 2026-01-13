interface RegistrationService {
    void enrollCourse(Student student, Course course) throws CourseLimitExceededException;
    void dropCourse(Student student, Course course);
    void viewGrades(Student student);
    void updateGrades(Student student, String newGrade);
}