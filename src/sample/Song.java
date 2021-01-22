package sample;

import java.io.File;

import static sample.DB.purgeSelection;

/***
 * Song object class, constructs song objects for further use in the media player
 */

public class Song {

    private String songLocation;
    private String songName;
    private String songArtist;
    private int songID;

    public String getSongArtist() {
        return songArtist;
    }

    public String getSongLocation() {
        return songLocation;
    }

    public String getSongName() {
        return songName;
    }

    public int getSongID() {
        return songID;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public void setSongLocation(String songLocation) {
        this.songLocation = songLocation;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public Song(int songID, String songLocation){
        String nameQuery = "Select fldName from tblSong where fldSongID = " + songID;
        DB.selectSQL(nameQuery);
        setSongName(DB.getData());

        purgeSelection();

        String path = new File(songLocation).getAbsolutePath();
        String insertLocation = "Update tblSong set fldLocation = '" + path + "'";
        DB.insertSQL(insertLocation);
        setSongLocation(path);

        setSongID(songID);
    }

    public String toString(){
        return this.getSongName();
    }
}
