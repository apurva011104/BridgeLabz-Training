package music_playlist_manager;

import java.util.Objects;

public class Song {
    private final String title;
    private final String artist;
    private final int durationInSeconds;

    public Song(String title, String artist, int durationInSeconds){
        if(title==null || artist==null || title.isEmpty() || artist.isEmpty() || durationInSeconds<=5){
            throw new IllegalArgumentException("Invalid song");
        }
        this.title = title;
        this.artist = artist;
        this.durationInSeconds = durationInSeconds;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    @Override
    public String toString() {
        return String.format("[Song title: %s, Artist: %s, Duration: %d seconds]", title, artist, durationInSeconds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title.toLowerCase(), artist.toLowerCase() , durationInSeconds);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(this == obj){
            return true;
        }
        if(getClass() != obj.getClass()){
            return false;
        }

        Song otherSong = (Song) obj;

        return Integer.compare(durationInSeconds, otherSong.durationInSeconds) == 0
                && Objects.equals(title.toLowerCase(), otherSong.title.toLowerCase())
                && Objects.equals(artist.toLowerCase(), otherSong.artist.toLowerCase());

    }
    
}
