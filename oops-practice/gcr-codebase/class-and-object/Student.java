public class Student {
    
    String name;
    String rollNumber;
    int []marks;

    //Constructor to create student
    public Student(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = new int[3];
    }

    //Method to calculate total marks
    private int calculateTotalMarks(){
        int total=0;
        for(int m: marks){
            total+=m;
        }
        return total;
    }

    //Method to calculate grade
    public String calculateGrade(){
        double average = calculateTotalMarks()/marks.length;

        if (average>=90){
            return "A+";
        }
        if (average>=80) {
            return "A";
        }
        if(average>=70){
            return "B";
        }
        if( average>=50){
            return "C";
        }
        if(average>=35){
            return "D";
        }
        return "F";
    }

    //Method to display student marks
    private void displayMarks(){
        for(int i=0;i<marks.length;i++){
            System.out.println("Marks"+(i+1)+": "+marks[i]);
        }
    }

    //Method to display details
    public void displayDetails(){
        String grade = calculateGrade();
        System.out.println("Student Name: "+name);
        System.out.println("Student RollNumber: "+rollNumber);
        System.out.println("Student marks: ");
        displayMarks();
        System.out.println("Grade: "+grade);
        System.err.println("-----------------------------------------------");
    }

    public static void main(String []args){
        
        Student student1 = new Student("Thamaral", "ECE001");
        student1.marks = new int[]{80,70,75};

        Student student2 = new Student("Kannan", "CSC002");
        student2.marks =  new int[]{60,65,50};

        student1.displayDetails();
        student2.displayDetails();
    }

}
