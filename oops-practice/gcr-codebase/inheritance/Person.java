public class Person {
    String name;
    int ageInYears;

    public Person(String name, int ageInYears){
        this.name = name;
        this.ageInYears = ageInYears;
    }

    public void displayInfo(){
        System.out.println("Name: "+name);
        System.out.println("age: "+ageInYears);
    }
}

class Teacher extends Person{

    private final String teacherId;
    String subject;

    public Teacher(String teacherId, String name, int ageInYears, String subject){
        super(name, ageInYears);
        this.teacherId=teacherId;
        this.subject=subject;
    }

    //Getter for teacherId
    public String getTeacherId(){
        return teacherId;
    }

    //Method to update subject
    public void updateSubject(String subjec){
        this.subject=subject;
    }

    //Method to display role
    public void displayRole(){
        System.out.println("Role: Teacher");
    }

    //Method to display information
    @Override
    public void displayInfo(){
        displayRole();
        System.out.println("Teacher Id: "+teacherId);
        super.displayInfo();
        System.out.println("Subject: "+subject);
    }
}

class Student extends Person{
    
    private final String studentId;
    String grade;

    public Student(String studentId, String name, int ageInYears, String grade){
        super(name, ageInYears);
        this.studentId=studentId;
        this.grade=grade;
    }

    //Getter for studentId
    public String getStudentId(){
        return studentId;
    }

    //Method to update grade
    public void updateGrade(String grade){
        this.grade=grade;
    }

    //Method to display role
    public void displayRole(){
        System.out.println("Role: Student");
    }
    
    //Method to display information
    @Override
    public void displayInfo(){
        displayRole();
        System.out.println("Student Id: "+studentId);
        super.displayInfo();
        System.out.println("Grade: "+grade);
    }

}

class Staff extends Person{
    
    private final String staffId;
    String department;

    public Staff(String staffId, String name, int ageInYears, String department){
        super(name, ageInYears);
        this.staffId = staffId;
        this.department = department;
    }

    //getter for staff id
    public String getStaffId(){
        return staffId;
    }

    //Method to display role
    public void displayRole(){
        System.out.println("Role: Staff");
    }

    //Method to display information
    @Override
    public void displayInfo(){
        displayRole();
        System.out.println("Staff Id: "+staffId);
        super.displayInfo();
        System.out.println("Department: "+department);
    }

}

//Main class for testing
class Main{
    public static void main(String[] args) {
        Person person1 = new Person("Bianca", 22);
        Teacher teacher1 = new Teacher("T2400158","Cindy", 27, "Java Programming");
        Student student1 = new Student("STU25000145", "Ava", 17, "11th");
        Staff staff1 = new Staff("STF2200123", "Ruby",32, "Administration");

        person1.displayInfo();

        System.out.println();

        teacher1.displayInfo();

        System.out.println();

        student1.displayInfo();

        System.out.println();
        
        staff1.displayInfo();

    }
}