public class Professor extends Person {
    
    private String department;

    public Professor(String ID, String name, int age, String gender, String department){
        super(ID, name, age, gender);
        this.department = department;
    }

    @Override
    public void displayInformation(){
        System.out.printf("Student ID: %s, Name: %s, Age: %s, Gender: %s, Department: %s%n",getID(), getName(), getAge(), getGender(), department);
    }

    public String getDepartment() {
        return department;
    }

    public void updateDepartment(String department) {
        this.department = department;
    }
    
}
