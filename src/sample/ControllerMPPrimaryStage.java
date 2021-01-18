package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.awt.*;

public class ControllerMPPrimaryStage extends MediaPlayerMain{

    @FXML
    private Slider progressBarSlider;

    @FXML
    private Button shuffleButton;

    @FXML
    private Button skipBackButton;

    @FXML
    private Button playButton;

    @FXML
    private Button pauseButton;

    @FXML
    private Button skipForwardButton;

    @FXML
    private Button repeatButton;

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
    private Slider volumeBarSlider;


}
