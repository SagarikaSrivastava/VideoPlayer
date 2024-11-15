module org.example.videoplayer {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.videoplayer to javafx.fxml;
    exports org.example.videoplayer;
}