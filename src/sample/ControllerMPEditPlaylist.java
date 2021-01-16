package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ControllerMPEditPlaylist {

    @FXML
    private Button editLoadAvailableSongs;

    @FXML
    private Button editSavePlaylist;

    @FXML
    private Button editCancelButton;

    @FXML
    private TextField editPlaylistNameInput;

    @FXML
    private ListView<?> editListAvailableSongs;

    @FXML
    private ListView<?> editListSelectedSongs;

    @FXML
    private Button editAddSelected;

    @FXML
    private Button editRemoveSelected;

}
