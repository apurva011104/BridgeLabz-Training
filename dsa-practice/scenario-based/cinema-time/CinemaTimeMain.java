import java.util.Scanner;

public class CinemaTimeMain{

    public static void userMenu(){
        System.out.println("Enter '1' to add movie");
        System.out.println("Enter '2' to search movie");
        System.out.println("Enter '3' to display all movies.");
        System.out.println("Enter '4' to exit the program.");
    }

    
    public static void main(String[] args){

        MovieScheduleManager manager = new MovieScheduleManager();
        final Scanner scan = new Scanner(System.in);
        
        boolean flag = true;
        while(flag){
            userMenu();
            System.out.print("Enter your choice: ");
            String choice = scan.nextLine().trim();

            switch(choice){
                case "1":
                    System.out.print("Enter movie title: ");
                    String title = scan.nextLine().trim();
                    System.out.print("Enter showtime (in format 'hh:mm'): ");
                    String showTime = scan.nextLine().trim();
                    try{
                        manager.addMovie(title, showTime);
                    }
                    catch(InvalidTimeFormatException e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case "2":
                    System.out.print("Enter keyword to search: ");
                    String keyword = scan.nextLine().trim();
                    manager.searchMovie(keyword);
                    break;

                case "3":
                    manager.displayAllMovies();
                    break;

                case "4":
                    flag = false;
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice!");

            }
            
        }
    }
}