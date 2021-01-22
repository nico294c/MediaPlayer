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

/***
 * This scene loads and displays available saved playlists
 * the selected playlist should be loaded into the corresponding listview in the primary scene.
 * this class implements intitializable interface, in order to load the exisitng playlists from the getgo.
 * Primary scene controller is extended to inherit a method that would prompt loading and display of the playlist selected here.
 */

public class ControllerMPLoadPlaylist extends ControllerMPPrimaryStage implements Initializable {

    /***
     * loads created playlists
     * creates a listener for the selected item
     * @param location
     * @param resources
     */

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

    /***
     * Selects the associated database entry, to hold the information for the primary scene loader
     * Closes the scene
     * @param event
     */
    public void loadSelectedPlaylistButtonClicked (ActionEvent event){
    DB.selectSQL("Select fldName from tblPlaylist where fldName = '"+loadPlaylistAvailablePlaylists.getSelectionModel().getSelectedItem()+"'");
    initializeSelectedPlaylist();
    //close stage
        Stage stage = (Stage) loadPlaylistCancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button loadPlaylistCancelButton;

    /***
     * closes the scene without any changes
     * @param event
     */
    public void loadPlaylistCancelButtonClicked (ActionEvent event) {
        Stage stage = (Stage) loadPlaylistCancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private ListView<String> loadPlaylistAvailablePlaylists;


}
