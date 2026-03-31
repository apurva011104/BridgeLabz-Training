import java.util.ArrayList;
import java.util.List;

public class MovieScheduleManager{

    private final List<String> movieTitles;
    private final List<String> showTimes;

    public MovieScheduleManager() {
        this.movieTitles = new ArrayList<>();
        this.showTimes = new ArrayList<>();
    }

    private boolean validateTime(String showTime){
        if(!showTime.matches("\\d{2}:\\d{2}")){
            return false;
        }
        String[] time = showTime.split(":");
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        
        return (hours>=0 && hours<24) && (minutes>=0 && minutes<60);
    }

    public void addMovie(String title, String time) throws InvalidTimeFormatException{
        if(!validateTime(time)){
            throw new InvalidTimeFormatException("Invalid Time Format! Time must be of format 'hh:mm'");
        }

        movieTitles.add(title);
        showTimes.add(time);
    }

    public void searchMovie(String keyword){
        boolean foundMovie = false;

        try{
            for(int i=0; i<movieTitles.size();i++){
                String title = movieTitles.get(i).toLowerCase();
                if(title.contains(keyword.toLowerCase())){
                    System.out.println(String.format("[Movie Title: %s, Showtime: %s]%n",movieTitles.get(i), showTimes.get(i)));
                    foundMovie = true;
                }
            }
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Some error occurred while searching.");
        }
        if(!foundMovie){
            System.out.print("No movies found for \""+keyword+"\"");
        }
    }

    public void displayAllMovies(){
        if(movieTitles.isEmpty()){
            System.out.println("No movie to display.");
            return;
        }
        for(int i=0; i<movieTitles.size();i++){
            System.out.print(String.format("[Movie Title: %s, Showtime: %s]%n",movieTitles.get(i), showTimes.get(i)));
        }
    }
    
}