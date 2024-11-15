package org.example.videoplayer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javafx.util.Duration;

import java.security.PrivilegedAction;

public class VideoPlayerController extends BorderPane {
    private MediaPlayer player;
    private MediaView mediaView;
    private final boolean repeat = false;
    private boolean pauseRequested = false;
    private boolean atEndOfVideo = false;
    private Duration duration;
    private Slider timeSlider;
    private Label playTime;
    private Slider volumeSlider;
    private HBox mediaBar;

    public VideoPlayerController(final MediaPlayer mp) {
        player = mp;
        setStyle("-fx-background-color: #bfc2c7;");
        mediaView = new MediaView(player);
        Pane vwPane = new Pane() {
        };
        vwPane.getChildren().add(mediaView);
        vwPane.setStyle("-fx-background-color: black;");
        setCenter(vwPane);

        mediaBar = new HBox();
        mediaBar.setAlignment(Pos.CENTER);
        mediaBar.setPadding(new Insets(5, 10, 5, 10));
        BorderPane.setAlignment(mediaBar, Pos.CENTER);

        final Button playButton = new Button(">");
        mediaBar.getChildren().add(playButton);

        Label spacer = new Label("    ");
        mediaBar.getChildren().add(spacer);

        Label timeLabel = new Label("Time:  ");
        mediaBar.getChildren().add(timeLabel);

        timeSlider = new Slider();
        HBox.setHgrow(timeSlider, Priority.ALWAYS);
        timeSlider.setMinWidth(50);
        timeSlider.setMaxWidth(Double.MAX_VALUE);
        mediaBar.getChildren().add(timeSlider);

        playTime = new Label();
        playTime.setPrefWidth(130);
        playTime.setMinWidth(50);
        mediaBar.getChildren().add(playTime);

        Label volumeLabel = new Label("Vol:  ");
        mediaBar.getChildren().add(volumeLabel);

        volumeSlider = new Slider();
        volumeSlider.setPrefWidth(70);
        volumeSlider.setMaxWidth(Region.USE_PREF_SIZE); //--
        volumeSlider.setMinWidth(30);
        mediaBar.getChildren().add(volumeSlider);


        setBottom(mediaBar);

    }


}