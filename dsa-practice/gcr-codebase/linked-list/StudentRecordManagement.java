class Student{

    protected final String rollNumber;
    private String name;
    private int age;
    private String grade;

    public Student(String rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    //Method to display information of student
    public void displayInfo(){
        System.out.println("Roll Number: "+rollNumber);
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Grade: "+grade);
    }
}

class StudentNode{
        
    private Student student;
    private StudentNode next;       //Points to next student node

    public StudentNode(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentNode getNext() {
        return next;
    }

    public void setNext(StudentNode next) {
        this.next = next;
    }
        
}


public class StudentRecordManagement {

    private StudentNode studentHead;
    private StudentNode studentTail;

    public StudentRecordManagement(){
        this.studentHead = null;
        this.studentTail = null;
    }

    public StudentRecordManagement(StudentNode studentNode){
        this.studentHead = studentNode;
        this.studentTail = studentNode;
    }

    private boolean studentAlreadyExists(String rollNumber){
        return searchStudent(rollNumber)!=null;
    }

    //Method to find size
    public int size(){
        int size=0;
        StudentNode current = studentHead;
        while(current!=null){
            size++;
            current=current.getNext();
        }
        return size;
    }

    //Method to add student at the beginning
    public void addStudentAtTheBeginning(String rollNumber, String name, int age, String grade){

        if(studentAlreadyExists(rollNumber)){
            System.out.println("Roll number is already assigned to some other student.");
            return;
        }

        Student newStudent = new Student(rollNumber, name, age, grade);
        StudentNode newStudentNode = new StudentNode(newStudent);

        if(studentHead==null){
            studentHead=newStudentNode;
            studentTail=newStudentNode;
        }
        else{
            newStudentNode.setNext(studentHead);
            studentHead=newStudentNode;
        }

    }

    //Method to add student at the end
    public void addStudentAtTheEnd(String rollNumber, String name, int age, String grade){

        if(studentAlreadyExists(rollNumber)){
            System.out.println("Roll number is already assigned to some other student.");
            return;
        }

        Student newStudent = new Student(rollNumber, name, age, grade);
        StudentNode newStudentNode = new StudentNode(newStudent);
        if(studentHead==null){
            studentHead=newStudentNode;
            studentTail=newStudentNode;
        }
        else{
            studentTail.setNext(newStudentNode);
            studentTail=newStudentNode;
        }


    }
    
    //Method to add student at a specific position
    public void addStudent(String rollNumber, String name, int age, String grade, int positionToAddAt){

        if(studentAlreadyExists(rollNumber)){
            System.out.println("Roll number is already assigned to some other student.");
            return;
        }

        if(positionToAddAt<0 || positionToAddAt>size()){
            System.out.println("Invalid position");
            return;
        }

        if(positionToAddAt == 0){
            addStudentAtTheBeginning(rollNumber, name, age, grade);
        }
        else if(positionToAddAt == size()){
            addStudentAtTheEnd(rollNumber, name, age, grade);
        }
        else{
            Student newStudent = new Student(rollNumber, name, age, grade);
            StudentNode newStudentNode = new StudentNode(newStudent);
            int currentPosition = 0;
            StudentNode current = studentHead;
            while(currentPosition<positionToAddAt-1){
                current=current.getNext();
                currentPosition++;
            }
            newStudentNode.setNext(current.getNext());
            current.setNext(newStudentNode);
        }
    }


    //Method to delete student
    public void deleteStudent(String rollNumber){
        if(!studentAlreadyExists(rollNumber)){
            System.out.println("No such student's roll number found in the record.");
            return;
        }
        StudentNode studentNode = searchStudent(rollNumber);
        if(rollNumber.equals(studentHead.getStudent().rollNumber)){
            if(studentHead.getNext()==null){
                studentTail=null;
            }
            studentHead=studentHead.getNext();

        }
        else{
            StudentNode current = studentHead;
            while(current.getNext()!=null){
                if(current.getNext().equals(studentNode)){
                    current.setNext(current.getNext().getNext());
                    if(studentNode==studentTail){
                        studentTail=current;
                    }
                    break;
                }
                current=current.getNext();
            }
        }
        studentNode.setNext(null);
        studentNode = null;     //eligile for garbage collection
        System.out.println("Student deleted successfully");
    }

    //Method to search a student
    public StudentNode searchStudent(String rollNumber){
        
        StudentNode current = studentHead;

        while(current!=null){
            if(current.getStudent().rollNumber.equals(rollNumber)){
                return current;
            }
            current = current.getNext();
        }

        return null;
    }
    

    //Method to update student grade
    public void updateStudent(String rollNumber, String newGrade){
        StudentNode studentNode = searchStudent(rollNumber);
        if(studentNode==null){
            System.out.println("No such student's roll number found in the record.");
            return;
        }

        studentNode.getStudent().setGrade(newGrade);
        System.out.println("Grade updated successfully");

    }

    //Method to display all student
    public void displayAllStudents(){

        if(studentHead == null){
            System.out.println("No student records available.");
            return;
        }
        
        StudentNode current = studentHead;
        int index=0;
        while(current!=null){
            System.out.println("Student "+(index+1)+" details: ");
            current.getStudent().displayInfo();
            System.out.println();
            current=current.getNext();
            index++;
        }
    }

    public static void main(String[] args) {
        StudentRecordManagement record1 = new StudentRecordManagement();

        record1.addStudent("STU1245", "Ava", 22, "A", 0);
        record1.addStudentAtTheBeginning("STU1247", "Amelia", 21, "A");
        record1.addStudentAtTheEnd("STU1245", "Candice", 23, "B");
        record1.addStudentAtTheEnd("STU1345", "Candice", 23, "B");
        record1.addStudent("STU1758", "Rose", 23, "B",-1);
        record1.addStudent("STU1758", "Rose", 23, "B",3);
        record1.addStudent("STU1308", "Bella", 23, "D",2);

        try {
            record1.searchStudent("STU1758").getStudent().displayInfo();
        } 
        catch (Exception e) {
            System.out.println("No such roll number exists");
        }
        

        record1.updateStudent("STU1308", "C");

        record1.displayAllStudents();
        
        record1.deleteStudent("STU13450");
        record1.deleteStudent("STU1345");

        record1.displayAllStudents();
    }
}
