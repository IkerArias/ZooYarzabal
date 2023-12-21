package Ventanas;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class VideoPlayerInJFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	new JFXPanel();
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Reproductor de Video");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final JFXPanel fxPanel = new JFXPanel(); // JFXPanel para integrar JavaFX en Swing
        frame.add(fxPanel);

        frame.setSize(640, 480);
        frame.setVisible(true);

        Platform.runLater(() -> {
            initFX(fxPanel);
        });
    }

    private static void initFX(JFXPanel fxPanel) {
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    private static Scene createScene() {
    	String path = "C:/Users/unaio/Downloads/Go!azen 10_ _Zoriontasuna_.mp4"; // Actualiza con la ruta de tu video
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        mediaView.setFitWidth(640);
        mediaView.setFitHeight(480);

        // Crear un Group y agregar el MediaView a él
        Group root = new Group();
        root.getChildren().add(mediaView);

        // Devolver la escena que contiene el Group
        return new Scene(root, 640, 480);
    }
}
