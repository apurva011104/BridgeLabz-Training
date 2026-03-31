public class Student {

    private final String rollNumber;
    private String name;
    private String grade;

    public Student(String rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString(){
        return "[Student Roll Number: "+rollNumber+", Name: "+name+", Grade: "+grade+"]";
    }
}
