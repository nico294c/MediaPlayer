package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/***
 * Media Player
 * @date 22.01.2021
 * @authors Vanda Bovina, Daniela Petkova, Nicolai Barasinski
 */

public class MediaPlayerMain extends Application {

    @Override
    public void init() {

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MediaPlayerPrimaryScene.fxml"));
        primaryStage.setTitle("a Dumpsterfire Media Player");
        primaryStage.setScene(new Scene(root,500,600));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}

