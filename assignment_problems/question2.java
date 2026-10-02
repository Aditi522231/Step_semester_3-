package assignment_problems;

import java.util.Arrays;

// Class encapsulating playlist state with defensive copying
class Playlist {
    private final String[] songs;
    private int count;

    // Constructor initializing array with fixed capacity
    public Playlist(int capacity) {
        this.songs = new String[capacity];
        this.count = 0;
    }

    // Adds a song if capacity permits
    public void addSong(String song) {
        if (this.count < this.songs.length) {
            this.songs[this.count] = song;
            this.count++;
        } else {
            System.out.println("Playlist is full. Cannot add: " + song);
        }
    }

    // Returns a defensive copy containing only added songs so far
    public String[] getSongs() {
        return Arrays.copyOf(this.songs, this.count);
    }

    // Read-only getter for actual song count
    public int getSongCount() {
        return this.count;
    }
}

public class question2 {

    public static void main(String[] args) {
        // Sample Test Case
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        // Retrieve copy of songs
        String[] copy = p.getSongs();

        // Mutate returned array to test defensive copying
        copy[0] = "Hacked";

        // Verify internal array state is unaffected
        System.out.println("copy[0] = " + copy[0]);
        System.out.println("p.getSongs()[0] = " + p.getSongs()[0]); // Still "Song A"
        System.out.println("Song Count: " + p.getSongCount());
    }
}
