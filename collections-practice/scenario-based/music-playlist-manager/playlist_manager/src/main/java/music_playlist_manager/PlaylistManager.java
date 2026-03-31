package music_playlist_manager;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

public class PlaylistManager {
    
    private static final Logger LOGGER = java.util.logging.Logger.getLogger(PlaylistManager.class.getName());
    private static final String PLAYLIST_NOT_FOUND = "No such playlist found.";
    private static final String INVALID_PLAYLIST_NAME = "Invalid playlist name";
    private final Set<Playlist> playlists;
    private final Deque<Song> recentlyPlayed;

    public PlaylistManager() {
        this.playlists = new LinkedHashSet<>();
        this.recentlyPlayed = new ArrayDeque<>();
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
            LOGGER.warning("Playlist with this name already exists");
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
            LOGGER.warning("No such playlist found");
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
            LOGGER.warning(e.getMessage());
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
            LOGGER.warning(e.getMessage());
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
            String songInfo = "Currently playing: "+song;
            LOGGER.info(songInfo);
            for(int i=0; i<=song.getDurationInSeconds(); i++);
            recentlyPlayed.push(song);

        }
    }
    
}
