package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.DB.purgeSelection;

public class ControllerMPLoadPlaylist implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //load existing playlists into the listview
        DB.selectSQL("Select fldName from tblPlaylist");
        loadPlaylistAvailablePlaylists.getItems().add(DB.getData());
        purgeSelection();

        //create a selection listener
        loadPlaylistAvailablePlaylists.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("ListView selection changed from oldValue = "
                        + oldValue + " to newValue = " + newValue);
            }
        });
    }

    @FXML
    private Button loadSelectedPlaylistButton;

    public void loadSelectedPlaylistButtonClicked (ActionEvent event){

    }
    //send the selected playlist to the primary stage
    @FXML
    private void sendloadPlaylistData (MouseEvent event){

    }

    @FXML
    private Button loadPlaylistCancelButton;

    public void loadPlaylistCancelButtonClicked (ActionEvent event) {
        Stage stage = (Stage) loadPlaylistCancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private ListView<String> loadPlaylistAvailablePlaylists;


}
