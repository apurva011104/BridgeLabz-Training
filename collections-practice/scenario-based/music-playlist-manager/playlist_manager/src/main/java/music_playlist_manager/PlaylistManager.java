package music_playlist_manager;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class PlaylistManager {
    
    private static final String PLAYLIST_NOT_FOUND = "No such playlist found.";
    private static final String INVALID_PLAYLIST_NAME = "Invalid playlist name";
    private final Set<Playlist> playlists;
    private final Stack<Song> recentlyPlayed;

    public PlaylistManager() {
        this.playlists = new LinkedHashSet<>();
        this.recentlyPlayed = new Stack<>();
    }

    private Playlist playlistNameExists(String name){
        for(Playlist playlist: playlists){
            if(name.equalsIgnoreCase(playlist.getName())){
                return playlist;
            }
        }
        return null;
    }

    public boolean createPlaylist(String name){
        if(name==null || name.isEmpty()){
            throw new IllegalArgumentException(INVALID_PLAYLIST_NAME);
        }
        if(playlistNameExists(name) != null){
            System.err.println("Playlist with this name already exists");
            return false;
        }
        Playlist playlist = new Playlist(name);
        playlists.add(playlist);
        return true;
    }

    public boolean deletePlaylist(String name){
        if(name==null || name.isEmpty()){
            throw new IllegalArgumentException(INVALID_PLAYLIST_NAME);
        }
        Playlist playlist = playlistNameExists(name);
        if(playlist == null){
            System.err.println("No such playlist found");
            return false; 
        }

        playlists.remove(playlist);
        return true;
    }

    public boolean addSong(String playlistName, Song song){
        if(playlistName==null || playlistName.isEmpty()){
            throw new IllegalArgumentException(INVALID_PLAYLIST_NAME);
        }
        if(song==null){
            throw new IllegalArgumentException("Invalid song");
        }
        Playlist playlist = playlistNameExists(playlistName);
        if(playlist == null){
            throw new IllegalArgumentException(PLAYLIST_NOT_FOUND);
        }
        try {
            playlist.addSong(song);
            return true;
        } 
        catch (SongAlreadyExistsException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean removeSong(String playlistName, Song song){
        if(playlistName==null || playlistName.isEmpty()){
            throw new IllegalArgumentException(INVALID_PLAYLIST_NAME);
        }
        if(song==null){
            throw new IllegalArgumentException("Invalid song");
        }
        Playlist playlist = playlistNameExists(playlistName);
        if(playlist == null){
            throw new IllegalArgumentException(PLAYLIST_NOT_FOUND);
        }
        try {
            playlist.removeSong(song);
            return true;
        } 
        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public void startPlaylist(String playlistName){
        if(playlistName==null || playlistName.isEmpty()){
            throw new IllegalArgumentException(INVALID_PLAYLIST_NAME);
        }
        Playlist playlist = playlistNameExists(playlistName);
        if(playlist == null){
            throw new IllegalArgumentException(PLAYLIST_NOT_FOUND);
        }
        for(Song song: playlist.getSongs()){
            System.err.println("Currently playing: "+song);
            for(int i=0; i<=song.getDurationInSeconds(); i++);
            recentlyPlayed.push(song);
            try {
                Thread.sleep(100);
            } 
            catch (InterruptedException e) {
                System.err.println("Playback interrupted");
            }

        }
    }
    
}
