package model;
/*===============================================================
|Author:     Haotian Yuan  Jiaming Hao
|
|Class name:  Song
|
|Description: A class implements comparable interface represent 
|             a single song
*==============================================================*/

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class Song implements Comparable<Song>,Serializable {
	private String path;
	private String artist;
	private String title;
	private String time;// the duration of the song
	private int played; // record how many times played in a day
	private LocalDate localdate; 

	public Song(String path) {
		this.path = path;
		if (path.compareTo("songfiles/Capture.mp3") == 0) {
			title = "Pokemon Capture";
			time = "0:05";
			artist = "Pikachu";
		} else if (path.compareTo("songfiles/DanseMacabreViolinHook.mp3") == 0) {
			title = "Danse Macabre";
			time = "0:34";
			artist = "Kevin MacLeod";
		} else if (path.compareTo("songfiles/DeterminedTumbao.mp3") == 0) {
			title = "Determined Tumbao";
			time = "0:20";
			artist = "FreePlay Music";
		} else if (path.compareTo("songfiles/LongingInTheirHearts.mp3") == 0) {
			title = "Longing In Their Hearts";
			time = "4:48";
			artist = "Bonnie Raitt";
		} else if (path.compareTo("songfiles/LopingSting.mp3") == 0) {
			title = "Loping Sting";
			time = "0:05";
			artist = "Kevin MacLeod";
		} else if (path.compareTo("songfiles/SwingCheese.mp3") == 0) {
			title = "Swing Cheese";
			time = "0:15";
			artist = "FreePlay Music";
		} else if (path.compareTo("songfiles/TheCurtainRises.mp3") == 0) {
			title = "The Curtain Rises";
			time = "0:28";
			artist = "Kevin MacLeod";
		} else if (path.compareTo("songfiles/UntameableFire.mp3") == 0) {
			title = "Untameable Fire";
			time = "4:42";
			artist = "Pierre Langer";
		}

		played = 0;
		localdate = LocalDate.now();
		

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
	/*---------------------------------------------------------------------
	  |  Method:   getTitle
	  |
	  |  Purpose:   A method returns the title of the song
	  |  
	  |  Parameters: None 
	  |
	  |  Returns:    String
	  *-------------------------------------------------------------------*/
	public String getTitle() {
		return title;
	}
	/*---------------------------------------------------------------------
	  |  Method:   getTime
	  |
	  |  Purpose:   A method returns the duration of the song
	  |  
	  |  Parameters: None
	  |
	  |  Returns:    String
	  *-------------------------------------------------------------------*/
	public String getTime() {
		return time;
	}
	/*---------------------------------------------------------------------
	  |  Method:   getPlayed
	  |
	  |  Purpose:   A method returns the play times of the song in one day
	  |  
	  |  Parameters: None
	  |
	  |  Returns:    int
	  *-------------------------------------------------------------------*/
	public int getPlayed() {
		LocalDate current = LocalDate.now();
		if (localdate.compareTo(current) < 0) {
			played = 0;
		}
		return played;
	}
	/*---------------------------------------------------------------------
	  |  Method:   getArtist
	  |
	  |  Purpose:   A method returns the Artist of the song
	  |  
	  |  Parameters: None
	  |
	  |  Returns:    String
	  *-------------------------------------------------------------------*/
	public String getArtist() {
		return artist;
	}
	/*---------------------------------------------------------------------
	  |  Method:   setPlayed
	  |
	  |  Purpose:   A method sets the play time of the song
	  |  
	  |  Parameters: int
	  |
	  |  Returns:    None
	  *-------------------------------------------------------------------*/
	public void setPlayed(int played) {
		this.played = played;
	}
	/*---------------------------------------------------------------------
	  |  Method:   setLocal
	  |
	  |  Purpose:   A method sets the LocalDate instance variable 
	  |  
	  |  Parameters: LocalDate
	  |
	  |  Returns:    None
	  *-------------------------------------------------------------------*/
	public void setLocal(LocalDate now)
	{
		localdate = now;
	}
}