import java.time.Year;
import java.util.ArrayList;

class Movie{

    private String movieTitle;
    private String director;
    private Year yearOfRelease;
    private int rating;

    public Movie(String movieTitle, String director, Year yearOfRelease, int rating) {
        this.movieTitle = movieTitle;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Year getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(Year yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void displayInfo(){
        System.out.print("Movie Title: "+movieTitle);
        System.out.print(", Director: "+director);
        System.out.print(", Year of Release: "+yearOfRelease);
        System.out.printf(", Ratings: %d%n",rating);
    }

}

class MovieNode{

    private Movie movie;
    private MovieNode previous;
    private MovieNode next;

    public MovieNode(Movie movie) {
        this.movie = movie;
        this.previous = null;
        this.next = null;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public MovieNode getPrevious() {
        return previous;
    }

    public void setPrevious(MovieNode previous) {
        this.previous = previous;
    }

    public MovieNode getNext() {
        return next;
    }

    public void setNext(MovieNode next) {
        this.next = next;
    }
    
}

public class MovieManagementSystem {

    private MovieNode movieHead;
    private MovieNode movieTail;

    public MovieNode getMovieHead() {
        return movieHead;
    }

    public void setMovieHead(MovieNode movieHead) {
        this.movieHead = movieHead;
    }

    public MovieNode getMovieTail() {
        return movieTail;
    }

    public void setMovieTail(MovieNode movieTail) {
        this.movieTail = movieTail;
    }

    //Method to find size
    public int size(){
        int size=0;
        MovieNode current = movieHead;
        while(current!=null){
            size++;
            current=current.getNext();
        }
        return size;
    }

    //Method to check if movie already exists or not
    public boolean movieAlreadyExists(String movieTitle, String director){

        MovieNode current = movieHead;
        while(current!=null){
            if(movieTitle.equalsIgnoreCase(current.getMovie().getMovieTitle()) && director.equalsIgnoreCase(current.getMovie().getDirector()) ){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    
    /*--------------------------Create operations--------------------------*/
    //Method to add movie at the beginning
    public void addMovieAtTheBeginning(String movieTitle, String director, int yearOfRelease, int rating){

        if(movieAlreadyExists(movieTitle, director)){
            System.out.println("Movie already exist.");
            return;
        }

        try {
            Movie newMovie = new Movie(movieTitle, director, Year.of(yearOfRelease), rating);
            MovieNode newMovieNode = new MovieNode(newMovie);
            if(movieHead==null){
                movieHead=newMovieNode;
                movieTail=newMovieNode;
            }
            else{
                movieHead.setPrevious(newMovieNode);
                newMovieNode.setNext(movieHead);
                movieHead=newMovieNode;
            }   
        }
        catch (Exception e) {
            System.out.println("Invalid year of release");
        }

    }

    //Method to add movie at the end
    public void addMovieAtTheEnd(String movieTitle, String director, int yearOfRelease, int rating){

        if(movieAlreadyExists(movieTitle, director)){
            System.out.println("Movie already exist.");
            return;
        }

        try {
            Movie newMovie = new Movie(movieTitle, director, Year.of(yearOfRelease), rating);
            MovieNode newMovieNode = new MovieNode(newMovie);
            if(movieHead==null){
                movieHead=newMovieNode;
                movieTail=newMovieNode;
            }
            else{
                newMovieNode.setPrevious(movieTail);
                movieTail.setNext(newMovieNode);
                movieTail=newMovieNode;
            }   
        }
        catch (Exception e) {
            System.out.println("Invalid year of release");
        }

    }

    //Method to add movie at a specific position
    public void addMovie(String movieTitle, String director, int yearOfRelease, int rating, int positionToAddAt){

        if(movieAlreadyExists(movieTitle, director)){
            System.out.println("Movie already exist.");
            return;
        }

        int currentSize = size();

        if(positionToAddAt<0 || positionToAddAt>currentSize){
            System.out.println("Invalid position");
            return;
        }

        if(positionToAddAt == 0){
            addMovieAtTheBeginning(movieTitle, director, yearOfRelease, rating);;
        }
        else if(positionToAddAt == currentSize){
            addMovieAtTheEnd(movieTitle, director, yearOfRelease, rating);;
        }
        else{
            try {
                Movie newMovie = new Movie(movieTitle, director, Year.of(yearOfRelease), rating);
                MovieNode newMovieNode = new MovieNode(newMovie);
                int currentPosition = 0;
                MovieNode current = movieHead;
                while(currentPosition<positionToAddAt-1){
                    current=current.getNext();
                    currentPosition++;
                }
                newMovieNode.setPrevious(current);
                current.getNext().setPrevious(newMovieNode);
                newMovieNode.setNext(current.getNext());
                current.setNext(newMovieNode);
            } 
            catch (Exception e) {
                System.out.println("Invalid movie year");
            }
        }
    }


    /*--------------------------Read operations--------------------------*/

    //Method to search movie name by director
    private ArrayList<MovieNode> searchMovieNodeByDirector(String director){
        ArrayList<MovieNode> foundMovies = new ArrayList<>();

        MovieNode current = movieHead;

        while(current!=null){
            if(current.getMovie().getDirector().equalsIgnoreCase(director)){
                foundMovies.add(current);
            }
            current = current.getNext();
        }

        return foundMovies;
    }

    public void searchMovieByDirector(String director){
        ArrayList<MovieNode> foundMovies = searchMovieNodeByDirector(director);
        if(foundMovies.size()==0){
            System.out.println("No movies found");
            return;
        }
        displayFoundMovies(foundMovies);
    }

    //Method to search movie name by rating
    private ArrayList<MovieNode> searchMovieNodeByRating(int rating){
        ArrayList<MovieNode> foundMovies = new ArrayList<>();

        MovieNode current = movieHead;

        while(current!=null){
            if(current.getMovie().getRating() == rating){
                foundMovies.add(current);
            }
            current = current.getNext();
        }

        return foundMovies;
    }
    public void searchMovieByRating(int rating){
        ArrayList<MovieNode> foundMovies = searchMovieNodeByRating(rating);
        if(foundMovies.size()==0){
            System.out.println("No movies found");
            return;
        }
        displayFoundMovies(foundMovies);
    }

    public void displayFoundMovies(ArrayList<MovieNode> foundMovies){
        System.out.println("Movies found: ");
        for(MovieNode movie: foundMovies){
            movie.getMovie().displayInfo();
        }
    }

    //Method to display movies
    public void displayAllMoviesForward(){
        if(movieHead == null){
            System.out.println("No movie to display.");
            return;
        }
        MovieNode current = movieHead;

        System.out.println("Forward display of all movies: ");
        while(current!=null){
            current.getMovie().displayInfo();
            current = current.getNext();
        }
    }

    public void displayAllMoviesReverse(){
        if(movieHead == null){
            System.out.println("No movie to display.");
            return;
        }
        MovieNode current = movieTail;
        System.out.println("Reverse display of all movies: ");
        while(current!=null){
            current.getMovie().displayInfo();
            current = current.getPrevious();
        }
    }

    /*--------------------------Update operations--------------------------*/

    //Method to update movie ratings
    public void updateMovieRatings(String movieTitle, String director, int newRating){

        if(!movieAlreadyExists(movieTitle, director)){
            System.out.println("Movie does not exist");
            return;
        }

        MovieNode current = movieHead;

        while(current != null){
            if(current.getMovie().getMovieTitle().equalsIgnoreCase(movieTitle) &&
               current.getMovie().getDirector().equalsIgnoreCase(director)){
                current.getMovie().setRating(newRating);
                System.out.println("Rating updated successfully");
                return;
            }
            current = current.getNext();
        }
    }

    /*--------------------------Delete operations--------------------------*/

    //Remove a movie record
    public void deleteMovie(String movieTitle){

        if(movieHead == null){
            System.out.println("No such movie to delete");
            return;
        }

        int deletedCount = 0;
        MovieNode current = movieHead;

        while(current != null){
            if(current.getMovie().getMovieTitle().equalsIgnoreCase(movieTitle)){

                MovieNode next = current.getNext();
                MovieNode prev = current.getPrevious();

                if(current == movieHead){
                    movieHead = next;
                    if(movieHead != null)
                        movieHead.setPrevious(null);
                }
                else if(current == movieTail){
                    movieTail = prev;
                    movieTail.setNext(null);
                }
                else{
                    prev.setNext(next);
                    next.setPrevious(prev);
                }

                current.setNext(null);
                current.setPrevious(null);
                deletedCount++;
                current = next;
            }
            else{
                current = current.getNext();
            }
        }

        if(deletedCount == 0){
            System.out.println("No such movie to delete");
        }
        else{
            System.out.println(deletedCount + " movie(s) deleted");
        }
    }


     
    //Main method for testing
    public static void main(String[] args) {
        MovieManagementSystem management = new MovieManagementSystem();

        management.addMovieAtTheBeginning("Notebook", "Kristy", 2015, 5);
        management.addMovieAtTheBeginning("Wonderland", "Julie",2016, 4);
        management.addMovieAtTheEnd("Rings", "Anastasia", 2009, 3);
        management.addMovie("Arcane", "Violet", 2019, 5, 4);
        management.addMovieAtTheEnd("Arcane 2", "Violet", 2022, 4);
        management.addMovie("Carol", "Ruby", 2007, 5, 0);
        management.addMovieAtTheEnd("Coffee", "Justin", 2012, 1);
        management.addMovieAtTheBeginning("Notebook", "kristy", 2015, 5);
        management.addMovie("Notebook", "Juliana", 2020, 4, 2);

        management.displayAllMoviesForward();
        System.out.println();
        management.updateMovieRatings("Coffee", "Justin", 2);
        System.out.println();
        management.searchMovieByDirector("Violet");
        System.out.println();
        management.searchMovieByRating(4);
        System.out.println();
        management.deleteMovie("Coffee");
        System.out.println();
        management.deleteMovie("Destiny");
        System.out.println();
        management.displayAllMoviesReverse();

    }
}
