import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupObjectsByProperty {

    public static Map<Department, List<Employee>> groupObjects(List<Employee> employees){
        Map<Department, List<Employee>> group = new HashMap<>();
        
        for(Employee e: employees){
            group.putIfAbsent(e.department, new ArrayList<>());
            group.get(e.department).add(e);
        }

        return group;
    }

    public static void displayGroup(Map<Department, List<Employee>> group){
        System.out.println("All employees grouped by their department");
        for(Map.Entry<Department, List<Employee>> entry: group.entrySet()){
            System.out.print(entry.getKey().name+": [");
            List<Employee> employees = entry.getValue();
            for(int i=0; i< employees.size()-1 ; i++){
                System.out.print(employees.get(i).name+", ");
            }
            System.out.println(employees.get(employees.size()-1).name+"]");
        }
    }

    public static void main(String[] args) {
        
        Department hr = new Department("HR");
        Department it = new Department("IT");

        Employee employee1 = new Employee("Alice", hr);
        Employee employee2 = new Employee("Bob", it);
        Employee employee3 = new Employee("Carol", hr);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        Map<Department, List<Employee>> grouped = groupObjects(employees);
        displayGroup(grouped);
    }
}

class Employee{
    String name;
    Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }
}

class Department{
    String name;

    public Department(String name) {
        this.name = name;
    }
    
}