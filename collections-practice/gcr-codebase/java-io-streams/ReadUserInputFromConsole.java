import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadUserInputFromConsole {
    
    public static String takeAgeInput(BufferedReader bufferedReader){
        while(true){
            try {
                String age = bufferedReader.readLine();
                int a = Integer.parseInt(age);
                if(a>0 && a<=100){
                    return age; 
                }
                System.out.print("Invalid age. Enter again: ");
            } catch (IOException | NumberFormatException e) {
                System.out.print("Invalid age. Enter again: ");
            }
        }
    }

    public static void main(String[] args) {

        try(
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            FileWriter fileWriter = new FileWriter("UserData.txt");
        ) {
            System.out.print("Enter your name: ");
            String name = bufferedReader.readLine();
            System.out.print("Enter your age: ");
            String age = takeAgeInput(bufferedReader);
            System.out.print("Enter your favorite programming language: ");
            String language = bufferedReader.readLine();

            String userData = "Name: " + name + "\nAge: " + age + "\nFavorite Programming Langugage: " + language + "\n";
            fileWriter.write(userData);
            System.out.println("User data saved successfully to 'UserData.txt'");

        } catch (IOException e) {
            System.out.println(e);
        }
        
    }
}
