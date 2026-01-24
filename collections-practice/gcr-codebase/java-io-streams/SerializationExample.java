import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SerializationExample {

    public static void serializeList(List<Employee> employees , String fileName){

        try(
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ){

            objectOutputStream.writeObject(employees);
            System.out.println("Serealized list successfully to '"+fileName+"'");
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public static List<Employee> deserializeList(String fileName){

        try(
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ){
            List<Employee> employees = (List<Employee>)objectInputStream.readObject();
            System.out.println("List deserialized successfully.");
            return employees;
        }
        catch(IOException | ClassNotFoundException e){
            System.out.println(e);
        }
        return new ArrayList<>();

    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1,"Ava","IT",700000));
        employees.add(new Employee(2,"Jisoo","HR",750000));
        employees.add(new Employee(3,"Jennie","HR",750000));
        employees.add(new Employee(4,"Rosie","Management",750000));
        employees.add(new Employee(5,"Lisa","Management",750000));

        String fileName = "EmployeesData.txt";

        serializeList(employees, fileName);
        List<Employee> deserializedList = deserializeList(fileName);

        for(Employee employee: deserializedList){
            System.out.println(employee);
        }

    }

}


class Employee implements Serializable{

    int id;
    String name;
    String department;
    int salary;

    public Employee(int id, String name, String department, int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "[Employee ID: "+id+", Name: "+name+", Department: "+department+", Salary: "+salary+" INR]";
    }
}