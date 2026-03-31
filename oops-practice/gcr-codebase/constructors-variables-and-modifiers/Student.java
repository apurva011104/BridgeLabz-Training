public class Student {
    
    public int rollNumber;      // public variable
    protected String name;      // protected variable
    private double cgpa;        // private variable

    public Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        setCgpa(cgpa);
    }

    // Public method to modify CGPA
    public void setCgpa(double cgpa){
        this.cgpa = cgpa ;
    }

    // Public method to access CGPA
    public double getCgpa(){
        return cgpa;
    }

    //Public method to display student details
    public void displayStudent() {
        System.out.println("Student details: ");
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.printf("CGPA: %.2f%n",getCgpa());
        System.out.println("-------------------------------------------");
    }
}

class PostgraduateStudent  extends Student{

    private int graduationYear;

    public PostgraduateStudent(int rollNumber, String name, double cgpa, int graduationYear) {
        super(rollNumber, name, cgpa);
        this.graduationYear = graduationYear;
    }
    
    public void displayPGStudent() {
        System.out.println("Post gradatee details: ");
        System.out.println("Roll Number: " + rollNumber);   // public variables are accessible everywhere
        System.out.println("Name: " + name);               // protected variable are accessible within sub classes inside same package
        System.out.println("Graduation year: " + graduationYear);
        System.out.printf("CGPA: %.2f%n",getCgpa());           // private variable being accessed by public method
    }
}

class Main{
    public static void main(String[] args) {
        Student student = new Student(14,"Ava",8.62);
        PostgraduateStudent pgStudent = new PostgraduateStudent(12, "Avery", 8.4,2016);
        student.displayStudent();
        pgStudent.displayPGStudent();
    }
}