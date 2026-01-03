public class Employee {

    String name;
    String id;
    double salary;

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails(){
        System.out.println("Employee ID: "+id);
        System.out.println("Employee Name: "+name);
        System.out.printf("Employee Salary: $%.2f%n",salary);
    }

}

class Manager extends Employee{

    int teamSize;

    public Manager(String name, String id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void displayDetails(){
        System.out.println("Manager ID: "+id);
        System.out.println("Manager Name: "+name);
        System.out.printf("Manager Salary: $%.2f%n",salary);
        System.out.println("Manager Team Size: "+teamSize);
    }

}

class Developer extends Employee{

    String programmingLanguage;

    public Developer(String name, String id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails(){
        System.out.println("Developer ID: "+id);
        System.out.println("Developer Name: "+name);
        System.out.printf("Developer Salary: $%.2f%n",salary);
        System.out.println("Developer programming language: "+programmingLanguage);
    }

}

class Intern extends Employee{

    public Intern(String name, String id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void displayDetails(){
        System.out.println("Intern ID: "+id);
        System.out.println("Intern Name: "+name);
        System.out.printf("Intern Salary: $%.2f%n",salary);
    }

}

//Main class for testing
class Main{
    public static void main(String[] args) {
        Employee employee1 = new Employee("Lily", "EMP101", 1000.00);
        Manager manager1 = new Manager("Avery", "MG005", 1250.00, 6);
        Developer developer1 = new Developer("Ava","DEV051",1170.00,"Java");
        Intern intern1 = new Intern("Mia","IN024",400.00);

        employee1.displayDetails();
        System.out.println();
        manager1.displayDetails();
        System.out.println();
        developer1.displayDetails();
        System.out.println();
        intern1.displayDetails();
    }
}