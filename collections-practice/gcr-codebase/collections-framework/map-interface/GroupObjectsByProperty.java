import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupObjectsByProperty {
    
    class Employee{
        String name;
        String department;

        public Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

    }

    Map<String, List<Employee>> departments;

    public GroupObjectsByProperty() {
        this.departments = new HashMap<>();
    }

    public void addEmployee(String name, String department){
        department=department.toLowerCase();
        Employee employee = new Employee(name, department);
        departments.putIfAbsent(department, new ArrayList<>());
        departments.get(department).add(employee);
    }

    public void removeEmployee(Employee e){
        if(departments.containsKey(e.department)){
            if(departments.get(e.department).contains(e)){
                departments.get(e.department).remove(e);
            }
        }
    }

    public String toString(){
        if(departments.isEmpty()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, List<Employee>> entry: departments.entrySet()){
            sb.append(entry.getKey()+": [");
            List<Employee> employees = entry.getValue();
            for( int i =0; i<employees.size()-1 ;i++){
                sb.append(employees.get(i).name+", ");
            }
            sb.append(employees.get(employees.size()-1).name+"], ");
        }
        return sb.substring(0,sb.length()-2);
    }

    public static void main(String[] args) {
        GroupObjectsByProperty office = new GroupObjectsByProperty();

        office.addEmployee("Alice", "HR");
        office.addEmployee("Bob", "IT");
        office.addEmployee("Carol", "HR");

        System.out.println(office);
    }
}
