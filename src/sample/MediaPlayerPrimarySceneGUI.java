package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;

public class MediaPlayerPrimarySceneGUI extends Application {

    @Override
    public void start(Stage primarystage)
    {
        Parent root = FXMLLoader.load(getClass().getResource("MediaPlayerPrimaryScene.fxml"));
        primarystage.setTitle("A fucking awesome Media Player");
        primarystage.setScene(new Scene(root));
        primarystage.show();
        launch();




    }
}
