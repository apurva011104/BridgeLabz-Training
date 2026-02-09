package music_playlist_manager;

public class MusicApplication {
    
    public static void main(String[] args) {
        Song song1 = new Song("Yes, and?","Ariana Grande",195);
        Song song2 = new Song("Pretty Savage", "Blackpink", 212);
        Song song3 = new Song("Jump","Blackpink",180);
        Song song4 = new Song("Filter","Jennie",100);
        Song song5 = new Song("Tears","Jisoo",195);
        Song song6 = new Song("Drinks and Coffee","Rosie",135);
        Song song7 = new Song("Dream","Lisa",228);
        Song song8 = new Song("Right Now","New Jeans",168);
        Song song9 = new Song("Bloodline","Ariana Grande",217);
        Song song10 = new Song("Cool with you","New Jeans",192);

        PlaylistManager manager = new PlaylistManager();

        manager.createPlaylist("Blackpink songs");
        manager.addSong("Blackpink songs",song1);
        manager.addSong("Blackpink songs",song2);
        manager.addSong("Blackpink songs",song3);
        manager.addSong("Blackpink songs",song4);
        manager.addSong("Blackpink songs",song5);
        manager.addSong("Blackpink songs",song6);
        manager.addSong("Blackpink songs",song7);
        manager.addSong("Blackpink songs",song8);
        manager.addSong("Blackpink songs",song9);
        manager.addSong("Blackpink songs",song10);

        manager.startPlaylist("Blackpink songs");
        
    }
}
