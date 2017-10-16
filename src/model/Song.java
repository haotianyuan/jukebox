package model;
/*===============================================================
|Author:     Haotian Yuan  Jiaming Hao
|
|Class name:  Song
|
|Description: A class implements comparable interface represent 
|             a single song
*==============================================================*/

public class Song implements Comparable<Song>{
	private String path;
	public Song(String path) {
		this.path=path;
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
	public String toString()
	{
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
		if(this.getPath().equals(o.getPath()))
			return 0;
		return 1;
	}
}