package application;

import controller.Controller;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Main extends Application {
    Font customFont = Font.loadFont(getClass().getResourceAsStream("/resources/pixelfont.ttf"), 12);
    private Controller controller;
    private MediaPlayer mediaPlayer;

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/ViewMultiplayer.fxml"));
            AnchorPane homeUtente = (AnchorPane) loader.load();
            Scene scene = new Scene(homeUtente);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setTitle("JavaFX-MultiplayerLobbySystem");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            this.controller = (Controller) loader.getController();

            // Load and play the music
            Media music = new Media(getClass().getResource("/resources/cyberpunk-street.mp3").toString());
            mediaPlayer = new MediaPlayer(music);
            mediaPlayer.play();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        this.controller.closeConnection();
        mediaPlayer.stop();
        mediaPlayer.dispose();
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
        System.out.println("ciao");
    }
}
