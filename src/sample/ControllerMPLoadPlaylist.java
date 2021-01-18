package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMPLoadPlaylist implements Initializable {

    @FXML
    private Button loadSelectedPlaylistButton;

    @FXML
    private Button loadPlaylistCancelButton;

    public void loadPlaylistCancelButtonClicked (ActionEvent event) {
        Stage stage = (Stage) loadPlaylistCancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private ListView<?> loadPlaylistAvailablePlaylists;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
