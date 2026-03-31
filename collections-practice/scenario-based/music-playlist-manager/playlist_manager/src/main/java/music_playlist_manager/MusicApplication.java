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

        String playlistName  = "Liked Songs";
        manager.createPlaylist(playlistName);
        manager.addSong(playlistName  , song1);
        manager.addSong(playlistName  , song2);
        manager.addSong(playlistName  , song3);
        manager.addSong(playlistName  , song4);
        manager.addSong(playlistName  , song5);
        manager.addSong(playlistName  , song6);
        manager.addSong(playlistName  , song7);
        manager.addSong(playlistName  , song8);
        manager.addSong(playlistName  , song9);
        manager.addSong(playlistName  , song10);

        manager.startPlaylist(playlistName  );
        
    }
}
