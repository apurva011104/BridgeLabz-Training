package music_playlist_manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SongTest {

    @Test
    void testValidSongCreation() {
        Song song = new Song("Yes, and?", "Ariana Grande", 195);

        assertEquals("Yes, and?", song.getTitle());
        assertEquals("Ariana Grande", song.getArtist());
        assertEquals(195, song.getDurationInSeconds());
    }

    @Test
    void testInvalidSongCreation() {
        assertThrows(IllegalArgumentException.class,
                () -> new Song(null, "Artist", 100));

        assertThrows(IllegalArgumentException.class,
                () -> new Song("Title", null, 100));

        assertThrows(IllegalArgumentException.class,
                () -> new Song("", "Artist", 100));

        assertThrows(IllegalArgumentException.class,
                () -> new Song("Title", "", 100));

        assertThrows(IllegalArgumentException.class,
                () -> new Song("Title", "Artist", 5));
    }

    @Test
    void testToString() {
        Song song = new Song("Hello", "Adele", 200);
        String result = song.toString();

        assertTrue(result.contains("Hello"));
        assertTrue(result.contains("Adele"));
        assertTrue(result.contains("200"));
    }

    @Test
    void testEqualsSameObject() {
        Song song = new Song("Hello", "Adele", 200);
        assertTrue(song.equals(song));
    }

    @Test
    void testEqualsNull() {
        Song song = new Song("Hello", "Adele", 200);
        assertFalse(song.equals(null));
    }

    @Test
    void testEqualsDifferentClass() {
        Song song = new Song("Hello", "Adele", 200);
        assertFalse(song.equals("Not a Song"));
    }

    @Test
    void testEqualsSameValuesCaseInsensitive() {
        Song song1 = new Song("Hello", "Adele", 200);
        Song song2 = new Song("hello", "adele", 200);

        assertEquals(song1, song2);
        assertEquals(song1.hashCode(), song2.hashCode());
    }

    @Test
    void testEqualsDifferentValues() {
        Song song1 = new Song("Hello", "Adele", 200);
        Song song2 = new Song("Skyfall", "Adele", 200);

        assertNotEquals(song1, song2);
    }
}
