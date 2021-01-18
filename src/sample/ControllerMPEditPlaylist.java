package sample;

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

public class ControllerMPEditPlaylist implements Initializable {

    @FXML
    private Button editLoadAvailableSongs;

    @FXML
    private Button editSavePlaylist;

    @FXML
    private Button editCancelButton;

    public void editCancelButtonClicked (ActionEvent event){
        Stage stage = (Stage) editCancelButton.getScene().getWindow();
        stage.close();
    }

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
