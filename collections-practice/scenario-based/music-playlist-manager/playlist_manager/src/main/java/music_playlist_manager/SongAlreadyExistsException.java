package music_playlist_manager;

public class SongAlreadyExistsException extends Exception{

    public SongAlreadyExistsException(String message) {
        super(message);
    }
        
}
