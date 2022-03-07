import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;

public class Inicio extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception {


        String path = "src/images/VideoEntrada3.mp4";


        Media media = new Media(new File(path).toURI().toString());


        MediaPlayer mediaPlayer = new MediaPlayer(media);


        MediaView mediaView = new MediaView(mediaPlayer);


        mediaPlayer.setAutoPlay(true);

        Group root = new Group();
        root.getChildren().add(mediaView);
        Scene scene = new Scene(root,850,450);
        primaryStage.setScene(scene);

        primaryStage.show();
        primaryStage.setResizable(false);

    }
    public static void main(String[] args)  {


        JFrame janela = new Menu();
        janela.setUndecorated(true);
        janela.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);

        launch(args);

    }

}
