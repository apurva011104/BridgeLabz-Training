public class Student extends Person {
    
    private String grade;

    public Student(String ID, String name, int age, String gender, String grade){
        super(ID, name, age, gender);
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void updateGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public void displayInformation(){
        System.out.printf("Student ID: %s, Name: %s, Age: %s, Gender: %s, Grade: %s%n",getID(), getName(), getAge(), getGender(), grade);
    }


}
