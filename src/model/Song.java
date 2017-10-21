package model;
/*===============================================================
|Author:     Haotian Yuan  Jiaming Hao
|
|Class name:  Song
|
|Description: A class implements comparable interface represent 
|             a single song
*==============================================================*/

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.time.LocalDate;
import java.util.Map.Entry;

import javax.sound.sampled.AudioFileFormat;
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
	private String artist;
	private String title;
	private String time;
	private int played;
	private LocalDate localdate;
	public Song(String path) {
		this.path = path;
		if(path.compareTo("songfiles/Capture.mp3")==0) {
			title="Pokemon Capture";
			time="0:5";
			artist="Pikachu";
		}
		else if(path.compareTo("songfiles/DanseMacabreViolinHook.mp3")==0) {
			title="Danse Macabre";
			time="0:34";
			artist="Kevin MacLeod";
		}
		else if(path.compareTo("songfiles/DeterminedTumbao.mp3")==0) {
			title="Determined Tumbao";
			time="0:20";
			artist="FreePlay Music";
		}
		else if(path.compareTo("songfiles/LongingInTheirHearts.mp3")==0) {
			title="Longing In Their Hearts";
			time="4:48";
			artist="Bonnie Raitt";
		}
		else if(path.compareTo("songfiles/LopingSting.mp3")==0) {
			title="Loping Sting";
			time="0:5";
			artist="Kevin MacLeod";
		}
		else if(path.compareTo("songfiles/SwingCheese.mp3")==0) {
			title="Swing Cheese";
			time="0:15";
			artist="FreePlay Music";
		}
		else if(path.compareTo("songfiles/TheCurtainRises.mp3")==0) {
			title="The Curtain Rises";
			time="0:28";
			artist="Kevin MacLeod";
		}
		else if(path.compareTo("songfiles/UntameableFire.mp3")==0) {
			title="Untameable Fire";
			time="4:42";
			artist="Pierre Langer";
		}
		
		played = 0;
		localdate=LocalDate.now();
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

	public String getTime() {
		return time;
	}

	public int getPlayed() {
		LocalDate current = LocalDate.now();
		if(localdate.compareTo(current) < 0)
		{
			played=0;
		}
		return played;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setPlayed(int played) {
		this.played = played;
	}
}