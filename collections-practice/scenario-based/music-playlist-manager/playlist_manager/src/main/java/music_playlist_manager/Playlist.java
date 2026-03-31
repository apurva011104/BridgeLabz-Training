package music_playlist_manager;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Playlist {
    
    private String name;
    private final LinkedList<Song> songs;
    private final Set<Song> uniqueSongs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new LinkedList<>();
        this.uniqueSongs = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSong(Song song) throws SongAlreadyExistsException{
        if(uniqueSongs.contains(song)){
            throw new SongAlreadyExistsException("Song already exists in the playlist");
        }
        songs.add(song);
        uniqueSongs.add(song);
    }

    public void removeSong(Song song){
        if(!uniqueSongs.contains(song)){
            throw new IllegalArgumentException("No such song found in the playlist.");
        }
        songs.remove(song);
        uniqueSongs.remove(song);
    }

    public List<Song> getSongs() {
        return Collections.unmodifiableList(songs);
    }

}
