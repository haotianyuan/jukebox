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
	private String time;
	private int played;
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

	public String getTitle() {
		return title;
	}

	public String getTime() {
		return time;
	}

	public int getPlayed() {
		LocalDate current = LocalDate.now();
		if (localdate.compareTo(current) < 0) {
			played = 0;
		}
		return played;
	}

	public String getArtist() {
		return artist;
	}

	public void setPlayed(int played) {
		this.played = played;
	}
	
	public void setLocal(LocalDate now)
	{
		localdate = now;
	}
}