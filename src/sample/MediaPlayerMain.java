package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class MediaPlayerMain extends Application {

    @Override
    public void init() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MediaPlayerPrimaryScene.fxml"));
        primaryStage.setTitle("An AWESOME Media Player");
        primaryStage.setScene(new Scene(root,500,600));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
