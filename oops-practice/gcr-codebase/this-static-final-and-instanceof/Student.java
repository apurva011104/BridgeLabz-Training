public class Student {
    
    //Static variable
    private static String universityName = "Global University";
    private static int totalStudents = 0;

    //Instance variables
    private final String rollNumber;        //final variable 
    private String name;
    private String grade;

    //Constructor to create Student object
    public Student(String rollNumber, String name, String grade) {
        //Use of this keyword in constructor
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    //Getters and setters
    public void setName(String name){
        this.name = name;
    }
    public String getRollNumber(){
        return rollNumber;
    }
    public String getName(){
        return name;
    }
    public String getGrade(){
        return grade;
    }
    public static String getUniversityName(){
        return universityName;
    } 
    public static int getTotalStudents(){
        return totalStudents;
    }

    //Instance method to update grade
    public void updateGrade(String grade){
        if(this instanceof Student){        //Checking if the object is instance of the Student class
            this.grade = grade;
            System.out.println("Grade updated to: "+grade);
        }
        else{
            System.out.println("Invalid student instance");
        }
    }

    //Static method to display total students
    public static void displayTotalStudents(){
        System.out.println("Total Students Enrolled: "+totalStudents);
    }

    //Instance method to display Student details
    public void displayStudentDetails(){
        if(this instanceof Student){        //Checking if the object is instance of the Student class
            System.out.println("University Name: "+universityName);
            System.out.println("Roll Number: "+rollNumber);
            System.out.println("Name: "+name);
            System.out.println("Grade: "+grade);
        }
        else{
            System.out.println("Invalid student instance");
        }
    }

    public static void main(String[] args) {
        
        Student student1 = new Student("101","Hemashree","A");
        Student student2 = new Student("102","Sharmila","B");

        displayTotalStudents();

        student1.displayStudentDetails();
        student2.displayStudentDetails();

        student2.updateGrade("A");

        student2.displayStudentDetails();
    }

}
