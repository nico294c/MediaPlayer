package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.DB.purgeSelection;

public class ControllerMPNewPlaylist implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //listener for song selection in available songs
        listAvailableSongs.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("ListView selection changed from oldValue = "
                        + oldValue + " to newValue = " + newValue);
            }
        });
    }

    @FXML
    private Button loadAvailableSongsButton;

    public void loadAvailableSongsButtonClicked (ActionEvent event){

        Song animeThighs = new Song(1, "Songs/Anime Thighs (feat. Wonder).mp3");
        Song running90s = new Song(2, "Songs/Initial D - Running in The 90s.mp3");
        Song loveYourMove = new Song(3, "Songs/RASPUTIN - Vladimir Putin - Love The Way You Move (Funk Overload) @slocband.mp3");
        Song slavKing = new Song(4, "Songs/SLAV_KING_-_Boris_vs._DJ_Blyatman.mp3");
        Song blindingLights = new Song(5, "Songs/The Weeknd - Blinding Lights (Official Audio).mp3");

        listAvailableSongs.getItems().addAll(animeThighs.toString(), running90s.toString(), loveYourMove.toString(), slavKing.toString(), blindingLights.toString());
    }

    @FXML
    private Button savePlaylistButton;

    public void savePlaylistButtonClicked(ActionEvent event){
        //Changes the placeholder name to a useable playlist name
        String playlistName = playlistNameInput.getText();
        String insertQuery = "Insert into tblPlaylist(fldName) values('" + playlistName + "')";
        DB.insertSQL(insertQuery);
        //closes the stage
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button cancelButton;

    public void cancelButtonClicked(ActionEvent event){

        //deletes associated playlist content
        DB.selectSQL("Select fldPlaylistID from tblPlaylist where fldName = 'PlaceholderName'");
        int tempPlaylistID = Integer.parseInt(DB.getData());
        purgeSelection();

        //deletes the placeholder playlist entry
        DB.deleteSQL("Delete from tblPlaylistContent where fldPlaylistID = "+tempPlaylistID);
        DB.deleteSQL("Delete from tblPlaylist where fldName = 'PlaceholderName'");

        //closes the stage
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private TextField playlistNameInput;

    @FXML
    private ListView<String> listAvailableSongs;

    @FXML
    private ListView<String> listSelectedSongs;

    @FXML
    private Button addSelectedButton;

    public void addSelectedButtonClicked (ActionEvent event){

        ObservableList<String> selectedSonglist = FXCollections.<String>observableArrayList();
        ListView <String> selectedSongView = new ListView<>(selectedSonglist);
        listSelectedSongs.getItems().add(listAvailableSongs.getSelectionModel().getSelectedItem());

        //debug
        System.out.println(listAvailableSongs.getSelectionModel().getSelectedItem());

        //SQL query
        DB.selectSQL("Select fldSongID from tblSong where fldName = '"+listAvailableSongs.getSelectionModel().getSelectedItem()+"'");
        int tempSongID = Integer.parseInt(DB.getData());
        System.out.println(tempSongID);

        DB.selectSQL("Select fldPlaylistID from tblPlaylist where fldName = 'PlaceholderName'");
        int tempPlaylistID = Integer.parseInt(DB.getData());
        System.out.println(tempPlaylistID);
        purgeSelection();

        DB.insertSQL("Insert tblPlaylistContent(fldSongID, fldPlaylistID)"+ "values ("+tempSongID+","+tempPlaylistID+")");

    }

    @FXML
    private Button removeSelectedButton;

    //would remove an item from selected list and the associated database entry
    public void removeSelectedButtonClicked (ActionEvent event){

        //delete SQL
        //delete the item

    }

}
