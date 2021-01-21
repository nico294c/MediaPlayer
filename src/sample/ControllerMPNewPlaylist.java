package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMPNewPlaylist implements Initializable {

    @FXML
    private Button loadAvailableSongsButton;

    @FXML
    private Button savePlaylistButton;

    public void savePlaylistButtonClicked(ActionEvent event){
        String playlistName = playlistNameInput.toString();
        String insertQuery = "Insert into tblPlaylist(fldName) values('" + playlistName + "')";
        DB.insertSQL(insertQuery);
    }

    @FXML
    private Button cancelButton;

    public void cancelButtonClicked(ActionEvent event){
        DB.deleteSQL("Delete from tblPlaylist where fldName = 'PlaceholderName'");
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private TextField playlistNameInput;

    @FXML
    private ListView<?> listAvailableSongs;

    @FXML
    private ListView<?> listSelectedSongs;

    @FXML
    private Button addSelectedButton;

    @FXML
    private Button removeSelectedButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void songsInit(){
        Song animeThighs = new Song(1, "Songs/Anime Thighs (feat. Wonder).mp3");
        System.out.println(animeThighs.toString());

        Song running90s = new Song(2, "Songs/Initial D - Running in The 90s.mp3");
        System.out.println(running90s.toString());

        Song loveYourMove = new Song(3, "Songs/RASPUTIN - Vladimir Putin - Love The Way You Move (Funk Overload) @slocband.mp3");
        System.out.println(loveYourMove.toString());

        Song slavKing = new Song(4, "Songs/SLAV_KING_-_Boris_vs._DJ_Blyatman.mp3");
        System.out.println(slavKing.toString());

        Song blindingLights = new Song(5, "Songs/The Weeknd - Blinding Lights (Official Audio).mp3");
        System.out.println(blindingLights.toString());
    }
}
