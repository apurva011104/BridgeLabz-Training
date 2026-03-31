
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DynamicObjectCreator {
    
    public static Student createStudentObject(String id, String name){
        try {
            Class<?> studentClass = Class.forName("Student");
            Constructor<?> constructor = studentClass.getConstructor(String.class, String.class);

            Student student = (Student)constructor.newInstance(id, name);
            return student;

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println(e);
        }
        return null;
    } 

    public static void main(String[] args) {
        Student student = createStudentObject("STU123", "Ava");

        if(student==null){
            System.out.println("Object creation failed");
        }
        else{
            System.out.println(student);
        }
    }
}

class Student{
    
    private String id;
    private String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("Student ID: %s, Student Name: %s", id,name);
    }
    
    
}
