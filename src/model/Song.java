package model;
/*===============================================================
|Author:     Haotian Yuan  Jiaming Hao
|
|Class name:  Song
|
|Description: A class implements comparable interface represent 
|             a single song
*==============================================================*/


import java.io.File;


import java.net.URI;



import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.sun.javafx.collections.MappingChange.Map;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Song implements Comparable<Song> {
	private String path;
	private Media media;
	private String title;
	private double time;
	private int played;

	public Song(String path) {
		this.path = path;
		title = path.substring(10, path.length() - 4);
		File file = new File(path);
		URI uri = file.toURI();
		media = new Media(uri.toString());
		MusicPlayList list = new MusicPlayList();
		if (list.recordingTimes.get(path) == null) {
			played = 0;
		} else {
			played = list.recordingTimes.get(path);
		}
		// time=media.getDuration().toSeconds();

	}

	/*---------------------------------------------------------------------
	  |  Method: getPath
	  |
	  |  Purpose:   A method returns the path of the song
	  |  
	  |  Parameters: None
	  |
	  |  Returns:    String
	  *-------------------------------------------------------------------*/
	public String getPath() {
		return path;
	}

	/*---------------------------------------------------------------------
	  |  Method: toString
	  |
	  |  Purpose:   A method used to debug and show message in GUI
	  |  
	  |  Parameters: None
	  |
	  |  Returns:    String
	  *-------------------------------------------------------------------*/
	public String toString() {
		return path;
	}

	/*---------------------------------------------------------------------
	  |  Method: compareTo
	  |
	  |  Purpose:   A method used in MusicPlaylist
	  |  
	  |  Parameters: Song 
	  |
	  |  Returns:    Integer
	  *-------------------------------------------------------------------*/
	@Override
	public int compareTo(Song o) {
		return this.getPath().compareTo(o.getPath());
	}

	public String getTitle() {
		return title;
	}

	public double getTime() {
		return time;
	}

	public int getPlayed() {
		return played;
	}

	public void setPlayed(int played) {
		this.played = played;
	}
}