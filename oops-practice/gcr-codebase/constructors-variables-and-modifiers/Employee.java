public class Employee {

    public String employeeID;      //public variable
    protected String department;      //protected variable
    private double salary;          //private variable

    public Employee(String employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    //Public method to access salary
    public double getSalary(){
        return salary;
    }

    //Public method to modify salary
    public void updateSalary(double newSalary){
        salary = newSalary;
    }

    //Method to display employee details
    public void displayEmployeeDetails(){
        System.out.println("----------------------------------");
        System.out.println("Employee details: ");
        System.out.println("Employee Id: "+employeeID);
        System.out.println("Department: "+department);
        System.out.printf("Salary per annum: INR %.2f%n",salary);
        System.out.println("----------------------------------");

    }
}

class Manager extends Employee{

    private String managerID;

    public Manager(String employeeId, String department, double salary, String managerID) {
        super(employeeId, department, salary);
        this.managerID = managerID;
    }

    public void displayManagerDetails(){
        System.out.println("---------------------------------------------");
        System.out.println("Manager details: ");
        System.out.println("Employee Id: "+employeeID);         // public variables are accessible everywhere
        System.out.println("Manager Id: "+managerID);
        System.out.println("Department: "+department);          // protected variables are accessible in subclasses
        System.out.printf("Salary per annum: INR %.2f%n",getSalary());        // private variable accessible via public getter
        System.out.println("--------------------------------------------");

    }
    
}

class Main{

    public static void main(String[] args) {

        Employee employee = new Employee("EMP131","HR",650000.00);
        employee.displayEmployeeDetails();

        Manager manager = new Manager("EMP104","HR",1000000.00,"MG21");
        manager.displayManagerDetails();
    }

}
