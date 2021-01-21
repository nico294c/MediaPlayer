package sample;

import java.io.File;

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

        String artistQuery = "Select fldArtist from tblSong where fldSongID = " + songID;
        DB.selectSQL(artistQuery);
        setSongArtist(DB.getData());

        String path = new File(songLocation).getAbsolutePath();
        String insertLocation = "Update tblSong set fldLocation = '" + path + "'";
        DB.insertSQL(insertLocation);
        setSongLocation(path);

        setSongID(songID);
    }

    public String toString(){
        return "" + this.getSongArtist() + " - " + this.getSongName();
    }

    public void songsInit(){
        Song animeThighs = new Song(1, "Songs/Anime Thighs (feat. Wonder).mp3");
        Song running90s = new Song(2, "Songs/Initial D - Running in The 90s.mp3");
        Song loveYourMove = new Song(3, "Songs/RASPUTIN - Vladimir Putin - Love The Way You Move (Funk Overload) @slocband.mp3");
        Song slavKing = new Song(4, "Songs/SLAV_KING_-_Boris_vs._DJ_Blyatman.mp3");
        Song blindingLights = new Song(5, "Songs/The Weeknd - Blinding Lights (Official Audio).mp3");
    }
}
