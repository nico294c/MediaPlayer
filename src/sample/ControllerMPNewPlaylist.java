package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ControllerMPNewPlaylist {

    @FXML
    private Button loadAvailableSongsButton;

    @FXML
    private Button savePlaylistButton;

    @FXML
    private Button cancelButton;

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

}
