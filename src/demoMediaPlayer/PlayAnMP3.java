package demoMediaPlayer;

/**
 * This code will play "LopingSting.mp3" assuming that file is in
 * a folder named songfiles. You were asked to import this folder 
 * containing mp3 files when accepting the team assignment.
 */
import java.io.File;
import java.net.URI;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class PlayAnMP3 extends Application {

  public static void main(String[] args) {
    launch(args);
  }
  
  private int songsPlayed = 1;

  @Override
  public void start(Stage primaryStage) throws Exception {

    String path = "songfiles/LopingSting.mp3";    
    System.out.println( System.getenv().entrySet());  
    File file = new File(path);
    URI uri = file.toURI();
    System.out.println(uri);
    Media media = new Media(uri.toString());
    MediaPlayer mediaPlayer = new MediaPlayer(media);
    mediaPlayer.setAutoPlay(true);
    mediaPlayer.play();
    
    mediaPlayer.setOnEndOfMedia(new EndOfSongHandler());
  }
 
  private class EndOfSongHandler implements Runnable {
    @Override
    public void run() {
      songsPlayed++;
      System.out.println("Song ended, play song #" + songsPlayed);
    }
  }
}