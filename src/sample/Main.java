package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Parent root = FXMLLoader.load(getClass().getResource("MediaPlayerPrimaryScene.fxml"));
        launch(args);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
