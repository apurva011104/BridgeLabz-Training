//Demonstrating encapsulation by restricting the acccess of methods and variables

//Demonstrates abstraction
interface Department{
    public void assignDepartment(String department);
    public void getDepartmentDetails();
}

//Demonstrates abstraction
abstract class Employee implements Department{

    protected final String employeeId;
    private String name;
    private double baseSalary;
    private String department;

    public Employee(String employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
        this.department = "Not assigned yet";
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public void assignDepartment(String department){
        this.department=department;
    }

    @Override
    public void getDepartmentDetails(){
        System.out.println("Department: "+department);
    }

    protected abstract double calculateSalary();

    public void displayDetails(){
        System.out.println("Employee id: "+employeeId);
        System.out.println("Name: "+name);
        System.out.printf("Annual salary: %.2f INR%n", calculateSalary());
        getDepartmentDetails();
    }

}

class FullTimeEmployee extends Employee{

    private String role;
    public FullTimeEmployee(String employeeId, String name, double baseSalary, String role) {
        super(employeeId, name, baseSalary);
        this.role = role;
    }

    @Override
    protected double calculateSalary(){
        return getBaseSalary();
    }

    @Override
    public void displayDetails(){
        System.out.println("Status: Full Time Employee");
        super.displayDetails();
        System.out.println("Role: "+role);
    }
    
}

class PartTimeEmployee extends Employee{

    private int hoursPerDay;
    private double salaryPerHour;
    private int numberOfWorkDaysInAYear;

    public PartTimeEmployee(String employeeId, String name, int hoursPerDay, double salaryPerHour, int numberOfWorkDaysInAYear) {
        super(employeeId, name,0);
        this.hoursPerDay=hoursPerDay;
        this.salaryPerHour = salaryPerHour;
        this.numberOfWorkDaysInAYear=numberOfWorkDaysInAYear;
    }

    @Override
    protected double calculateSalary(){
        return salaryPerHour * hoursPerDay * numberOfWorkDaysInAYear;
    }

    @Override
    public void displayDetails(){
        System.out.println("Status: Part Time Employee");
        super.displayDetails();
    }
    
}


//Main class for testing
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        
        Employee employee1 = new FullTimeEmployee("EMPFT1001","Ava",550000.0,"Web Developer");
        Employee employee2 = new FullTimeEmployee("EMPFT0628","Ruby",750000.0,"Project Manager");
        Employee employee3 = new PartTimeEmployee("EMPPT2410", "Valerie", 5,500.0 , 274);

        employee1.assignDepartment("IT");
        employee2.assignDepartment("IT");
        employee3.assignDepartment("HR");

        //Demonstrates polymorphism
        Employee[] employees = {employee1,employee2,employee3};

        for(int i=0; i<3 ; i++){
            employees[i].displayDetails();
        }

        
    }
}
