import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class DataStreamsExample {
    public static void main(String[] args) {
        
        String fileName = "Student.bin";

        try (
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        ){
            
            dataOutputStream.writeInt(1);
            dataOutputStream.writeUTF("Ava");
            dataOutputStream.writeDouble(8.62);

            System.out.println("Data saved to 'Student.bin' file successfully.");
        } 
        catch (IOException e) {
            System.out.println("Error occured while saving student data in bin file");
        }

        try (
            FileInputStream fileInputStream = new FileInputStream(fileName);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        ){
            int rollNumber = dataInputStream.readInt();
            String name = dataInputStream.readUTF();
            double gpa = dataInputStream.readDouble();

            System.out.println("Data read from file successfully.");
            System.out.println("Student details: ");
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);

        } 
        catch (IOException e) {
            System.out.println("Error occurred while reading student details.");
        }
    }
}