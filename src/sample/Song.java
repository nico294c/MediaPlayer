package sample;

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

    public Song(String songLocation, String songName, String songArtist){
        setSongArtist(songArtist);
        setSongLocation(songLocation);
        setSongName(songName);
        String tempQuery = "Insert into tblSong(fldName,fldArtist,fldLocation) values('" + this.getSongName() + "','" + this.getSongArtist() + "','" + this.getSongLocation() + "')";
        DB.insertSQL(tempQuery);
        String tempRetrieveID = "Select fldSongID from tblSong where fldLocation ='" + this.getSongLocation() + "'";
        DB.selectSQL(tempRetrieveID);
        tempRetrieveID = DB.getData();
        setSongID(Integer.parseInt(tempRetrieveID));
    }
}
