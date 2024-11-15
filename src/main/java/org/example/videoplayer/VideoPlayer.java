package org.example.videoplayer;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class VideoPlayer extends Application {

    private final File videoFile = new File("C:\\Users\\Sagarika\\Videos\\sample1.mp4");


    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Video Player");
        Group root = new Group();
        Scene scene = new Scene(root, 540, 210);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

        Media media = new Media(videoFile.toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setAutoPlay(true);
        MediaView mediaView = new MediaView(player);
        ((Group) scene.getRoot()).getChildren().add(mediaView);

    }

    public static void main(String[] args) {
        launch();
    }
}