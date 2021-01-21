package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;


import java.awt.*;
import java.io.File;

public class ControllerMPPrimaryStage extends MediaPlayerMain{

    private String songPath;
    private MediaPlayer awesomeMediaPlayer;

    @FXML
    private MediaView mediaPlayerMediaView;

    @FXML
    private Slider progressBarSlider;

    @FXML
    private Button shuffleButton;

    @FXML
    private Button skipBackButton;

    @FXML
    private Button playButton;

    public void playButtonClicked(ActionEvent event) {
        awesomeMediaPlayer.play();
    }

    @FXML
    private Button pauseButton;

    public void pauseButtonClicked (ActionEvent event){
        awesomeMediaPlayer.pause();
    }

    @FXML
    private Button skipForwardButton;

    @FXML
    private Button repeatButton;

    //to do later
    public void repeatButtonClicked (ActionEvent event){
        awesomeMediaPlayer.getOnRepeat();
        awesomeMediaPlayer.setOnRepeat(null);

    }

    @FXML
    private Button newPlaylistButton;

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

        DB.insertSQL("Insert into tblPlaylist(fldName) values('PlaceholderName')");

    }

    @FXML
    private Button loadPlaylistButton;

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

    public void openFileButtonClicked (ActionEvent event){

        FileChooser songFileChooser = new FileChooser();
        File songFile = songFileChooser.showOpenDialog(null);
        songPath = songFile.toURI().toString();
        int maxVolume = 100;

        if (songFile != null){

            //media creation
            Media songMedia = new Media(songPath);
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


}
