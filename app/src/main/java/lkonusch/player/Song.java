package lkonusch.player;

/*
Class that models the information for single audio file
 */

public class Song {
    private long id;
    private String title;
    private String artist;

    public Song(long songID, String songTitle, String songArtist) {
        // initiate instance variables
        id      = songID;
        title   = songTitle;
        artist  = songArtist;
    }

    // get methods for the instance variables
    public long getId(){return id;}
    public String getTitle(){return title;}
    public String getArtist(){return artist;}
}
