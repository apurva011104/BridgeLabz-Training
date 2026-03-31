package music_playlist_manager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlaylistManagerTest {

    @Test
    void testCreatePlaylist() {
        PlaylistManager manager = new PlaylistManager();
        assertTrue(manager.createPlaylist("My Playlist"));
        assertFalse(manager.createPlaylist("My Playlist"));
    }

    @Test
    void testCreatePlaylistInvalidName() {
        PlaylistManager manager = new PlaylistManager();

        assertThrows(IllegalArgumentException.class,
                () -> manager.createPlaylist(null));

        assertThrows(IllegalArgumentException.class,
                () -> manager.createPlaylist(""));
    }

    @Test
    void testPlaylistNameCaseInsensitive() {
        PlaylistManager manager = new PlaylistManager();

        manager.createPlaylist("My Playlist");
        assertFalse(manager.createPlaylist("my playlist"));
    }

    @Test
    void testDeletePlaylist() {
        PlaylistManager manager = new PlaylistManager();
        manager.createPlaylist("My Playlist");

        assertTrue(manager.deletePlaylist("My Playlist"));
        assertFalse(manager.deletePlaylist("My Playlist"));
    }

    @Test
    void testDeleteNonExistingPlaylist() {
        PlaylistManager manager = new PlaylistManager();
        assertFalse(manager.deletePlaylist("Unknown"));
    }

    @Test
    void testAddSong() {
        PlaylistManager manager = new PlaylistManager();
        manager.createPlaylist("My Playlist");

        Song song1 = new Song("Yes, and?", "Ariana Grande", 195);

        assertTrue(manager.addSong("My Playlist", song1));
        assertFalse(manager.addSong("My Playlist", song1));
    }

    @Test
    void testAddSongInvalidInputs() {
        PlaylistManager manager = new PlaylistManager();
        manager.createPlaylist("My Playlist");

        Song song1 = new Song("Song", "Artist", 100);

        assertThrows(IllegalArgumentException.class,
                () -> manager.addSong(null, song1));

        assertThrows(IllegalArgumentException.class,
                () -> manager.addSong("", song1));

        assertThrows(IllegalArgumentException.class,
                () -> manager.addSong("My Playlist", null));

        assertThrows(IllegalArgumentException.class,
                () -> manager.addSong("Unknown", song1));
    }

    @Test
    void testRemoveSong() {
        PlaylistManager manager = new PlaylistManager();
        manager.createPlaylist("My Playlist");

        Song song1 = new Song("Song1", "Artist1", 100);

        manager.addSong("My Playlist", song1);

        assertTrue(manager.removeSong("My Playlist", song1));
        assertFalse(manager.removeSong("My Playlist", song1));
    }

    @Test
    void testRemoveSongInvalidInputs() {
        PlaylistManager manager = new PlaylistManager();
        manager.createPlaylist("My Playlist");

        Song song1 = new Song("Song1", "Artist1", 100);

        assertThrows(IllegalArgumentException.class,
                () -> manager.removeSong(null, song1));

        assertThrows(IllegalArgumentException.class,
                () -> manager.removeSong("", song1));

        assertThrows(IllegalArgumentException.class,
                () -> manager.removeSong("My Playlist", null));

        assertThrows(IllegalArgumentException.class,
                () -> manager.removeSong("Unknown", song1));
    }

    @Test
    void testStartPlaylist() {
        PlaylistManager manager = new PlaylistManager();
        manager.createPlaylist("My Playlist");

        Song song1 = new Song("Yes, and?", "Ariana Grande", 1);
        manager.addSong("My Playlist", song1);

        assertDoesNotThrow(() -> manager.startPlaylist("My Playlist"));

        assertThrows(IllegalArgumentException.class,
                () -> manager.startPlaylist("Non Existent Playlist"));
    }

    @Test
    void testStartEmptyPlaylist() {
        PlaylistManager manager = new PlaylistManager();
        manager.createPlaylist("Empty");

        assertDoesNotThrow(() -> manager.startPlaylist("Empty"));
    }

    @Test
    void testStartPlaylistWithMultipleSongs() {
        PlaylistManager manager = new PlaylistManager();
        manager.createPlaylist("Hits");

        Song song1 = new Song("Song1", "Artist1", 1);
        Song song2 = new Song("Song2", "Artist2", 1);

        manager.addSong("Hits", song1);
        manager.addSong("Hits", song2);

        assertDoesNotThrow(() -> manager.startPlaylist("Hits"));
    }
}
