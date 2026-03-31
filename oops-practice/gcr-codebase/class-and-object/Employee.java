public class Employee {
	String name;
	int id;
	double salary;
	
	//Employee constructor
	Employee(String name, int id, double salary){
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	
	//Method to display details
	public void displayDetails() {
		System.out.println("Employee name: "+name);
		System.out.println("Employee id: "+id);
		System.out.printf("Employee salary: %.2f%n",salary);
	}
	
	public static void main(String []args) {
		Employee employee1 = new Employee("Rohan",1,500000);
		employee1.displayDetails();
	}
}
