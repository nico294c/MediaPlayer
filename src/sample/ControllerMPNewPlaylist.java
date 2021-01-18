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

    @FXML
    private Button cancelButton;

    public void cancelButtonClicked(ActionEvent event){
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
}
