public class Employee {

    //Static variables 
    private static String companyName = "Tech Solutions Inc.";
    private static int totalEmployees = 0;

    //Instance variables
    private String name;
    private final String id;        //Final variable
    private String designation;

    //Constructor to create Employee object
    public Employee(String name, String id, String designation) {
        //Use of this keyword inside constructor
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    //Getters and setters
    public void setName(String name){
        this.name = name;
    }
    public void setDesignation(String designation){
        this.designation = designation;
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public String getDesignation(){
        return designation;
    }
    public static int getTotalEmployees(){
        return totalEmployees;
    }

    //Static method to display total number of employees
    public static void displayTotalEmployees(){
        System.out.println("Total Employees: "+totalEmployees);
    }

    //Instance method to display employee details
    public void displayEmployeeDetails(){
        if(this instanceof Employee){
            System.out.println("Company Name: "+companyName);
            System.out.println("Employee ID: "+id);
            System.out.println("Name: "+name);
            System.out.println("Designation: "+designation);
        }
        else{
            System.out.println("Invalid employee instance");
        }
    }

    public static void main(String[] args) {
        
        Employee employee1 = new Employee("Thamarai", "101", "Software Engineer");
        Employee employee2 = new Employee("Rohan", "102", "Project Manager");

        displayTotalEmployees();

        employee1.displayEmployeeDetails();
        employee2.displayEmployeeDetails();
    }
}
