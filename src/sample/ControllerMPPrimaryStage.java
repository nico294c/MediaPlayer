package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;


import javax.swing.*;
import java.awt.*;
import java.io.File;

import static sample.DB.pendingData;
import static sample.DB.purgeSelection;

/***
 * Controller for the main stage of the player
 */

public class ControllerMPPrimaryStage extends MediaPlayerMain{

    private String songPath;
    private MediaPlayer awesomeMediaPlayer;
    private Media songMedia;


    /***
     * Is supposed to carry over the selected playlist between "load playlist" and "primary" scenes
     */
    public void initializeSelectedPlaylist (){
        if (pendingData!=false){
            String tempPlaylistHolder = DB.getData();
            System.out.println(tempPlaylistHolder);

            ObservableList<String> loadedPlaylist = FXCollections.<String>observableArrayList();
            loadedPlaylist.add(tempPlaylistHolder);
            loadedPlaylistView.getItems();

        }

    }
    @FXML
    private MediaView mediaPlayerMediaView;

    @FXML
    private Slider progressBarSlider;

    @FXML
    private Button shuffleButton; //would be used to randomly rearrange the order of songs in the playlist. The idea was to create a 2d arraylist for the songs and randomly pick indexes.

    @FXML
    private Button skipBackButton;

    /***
     * Skips to the start of the song
     * @param event
     */

    public void skipBackButtonClicked (ActionEvent event){
        awesomeMediaPlayer.seek(javafx.util.Duration.seconds(0));
    }

    @FXML
    private Button playButton;

    /***
     * plays the media
     * @param event
     */

    public void playButtonClicked(ActionEvent event) {
        awesomeMediaPlayer.play();
    }

    @FXML
    private Button pauseButton;

    /***
     * pauses the media
     * @param event
     */

    public void pauseButtonClicked (ActionEvent event){
        awesomeMediaPlayer.pause();
    }

    @FXML
    private Button skipForwardButton;

    /***
     * Skips to the end of the song
     * @param event
     */

    public void skipForwardButtonClicked (ActionEvent event){

    awesomeMediaPlayer.seek(songMedia.getDuration());

    }

    @FXML
    private Button repeatButton;


    /***
     * is supposed to loop the media when toggled
     * @param event
     */
    //to do later
    public void repeatButtonClicked (ActionEvent event){
        awesomeMediaPlayer.getOnRepeat();
        awesomeMediaPlayer.setOnRepeat(null);

    }

    @FXML
    private Button newPlaylistButton;

    /***
     * opens the "new playlist" scene and creates a placeholder playlist entry in the DB
     * @param event
     * @throws Exception
     */

    @FXML
    public void newPlaylistButtonClicked(ActionEvent event) throws Exception{
       FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MediaPlayerNewPlaylistScene.fxml"));
       Parent rootNewPlaylist = (Parent) fxmlLoader.load();
       Stage stageNewPlaylist = new Stage();
       stageNewPlaylist.setTitle("New Playlist");
       stageNewPlaylist.setScene(new Scene(rootNewPlaylist,300,400));
       stageNewPlaylist.show();

       //debug
        System.out.println("New Playlist button clicked");

        DB.updateSQL("Insert into tblPlaylist(fldName) values('PlaceholderName')");

    }

    @FXML
    private Button loadPlaylistButton;

    /***
     * opens the "Load playlist" scene
     * @param event
     * @throws Exception
     */
    public void loadPlaylistButtonClicked(ActionEvent event) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MediaPlayerLoadPlaylistScene.fxml"));
        Parent rootLoadPlaylist = (Parent) fxmlLoader.load();
        Stage stageLoadPlaylist = new Stage();
        stageLoadPlaylist.setTitle("Load Playlist");
        stageLoadPlaylist.setScene(new Scene(rootLoadPlaylist,300,400));
        stageLoadPlaylist.show();

        //debug
        System.out.println("Load Playlist button clicked");
    }

    @FXML
    private Button editPlaylistButton;

    /***
     * Opens the "Edit playlist" scene
     * @param event
     * @throws Exception
     */

    public void editPlaylistButtonClicked(ActionEvent event) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MediaPlayerEditPlaylist.fxml"));
        Parent rootEditPlaylist = (Parent) fxmlLoader.load();
        Stage stageEditPlaylist = new Stage();
        stageEditPlaylist.setTitle("Edit Current Playlist");
        stageEditPlaylist.setScene(new Scene(rootEditPlaylist, 300, 400));
        stageEditPlaylist.show();

        //debug
        System.out.println("Edit Playlist button clicked");
    }

    @FXML
    private Button openFileButton;

    /***
     * Opens a single media through a file breowser
     * @param event
     */

    public void openFileButtonClicked (ActionEvent event){

        FileChooser songFileChooser = new FileChooser();
        File songFile = songFileChooser.showOpenDialog(null);
        songPath = songFile.toURI().toString();
        int maxVolume = 100;

        if (songFile != null){

            //media creation
            songMedia = new Media(songPath);
            awesomeMediaPlayer = new MediaPlayer(songMedia);
            mediaPlayerMediaView.setMediaPlayer(awesomeMediaPlayer);
            awesomeMediaPlayer.play();

            //progress bar functionality

            awesomeMediaPlayer.currentTimeProperty().addListener(new ChangeListener<javafx.util.Duration>() {
                @Override
                public void changed(ObservableValue<? extends javafx.util.Duration> observable,
                                                        javafx.util.Duration oldValue,
                                                        javafx.util.Duration newValue) {
                progressBarSlider.setValue(newValue.toSeconds());

                }
            });

            progressBarSlider.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    awesomeMediaPlayer.seek(javafx.util.Duration.seconds(progressBarSlider.getValue()));
                }
            });

            progressBarSlider.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    awesomeMediaPlayer.seek(javafx.util.Duration.seconds(progressBarSlider.getValue()));
                }
            });

            awesomeMediaPlayer.setOnReady(new Runnable() {
                @Override
                public void run() {
                    javafx.util.Duration total = songMedia.getDuration();
                    progressBarSlider.setMax(total.toSeconds());
                }
            });

            //Volume bar functionality

            volumeBarSlider.setValue(awesomeMediaPlayer.getVolume()*maxVolume);
            volumeBarSlider.valueProperty().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    awesomeMediaPlayer.setVolume(volumeBarSlider.getValue()/maxVolume);
                }
            });
        }
    }
    @FXML
    private Slider volumeBarSlider;
    @FXML
    public ListView <String> loadedPlaylistView;
}
