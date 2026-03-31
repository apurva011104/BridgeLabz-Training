public class NoDriverAvailableException extends Exception{
    
    @Override
    public String getMessage(){
        return "No driver available at the moment";
    }
}
