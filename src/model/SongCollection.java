package model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/*===============================================================
|Author:     Haotian Yuan
|
|Class name:  SongCollection
|
|Description: A collection contains all the songs needed for the  
|             JukeBox
*==============================================================*/

@SuppressWarnings("serial")
public class SongCollection implements Serializable{
	private List<Song> Songs;
	
	public SongCollection()  {
		Songs=new ArrayList<Song>();
		Songs.add(new Song("songfiles/Capture.mp3"));
		Songs.add(new Song("songfiles/DanseMacabreViolinHook.mp3"));
		Songs.add(new Song("songfiles/DeterminedTumbao.mp3"));
		Songs.add(new Song("songfiles/LongingInTheirHearts.mp3"));
		Songs.add(new Song("songfiles/LopingSting.mp3"));
		Songs.add(new Song("songfiles/SwingCheese.mp3"));
		Songs.add(new Song("songfiles/TheCurtainRises.mp3"));
		Songs.add(new Song("songfiles/UntameableFire.mp3"));		
	}
	/*---------------------------------------------------------------------
	  |  Method: size
	  |
	  |  Purpose:   A method returns the size of the collection
	  |  
	  |  Parameters: None
	  |
	  |  Returns:    int 
	  *-------------------------------------------------------------------*/
	public int size() {
	    return Songs.size();
	}
	/*---------------------------------------------------------------------
	  |  Method: add
	  |
	  |  Purpose:   A method adds new song to the collection
	  |  
	  |  Parameters: Song
	  |
	  |  Returns:    None
	  *-------------------------------------------------------------------*/
	 public void add(Song newSong) {
		    Songs.add(newSong);
	 }
	 /*---------------------------------------------------------------------
	  |  Method: get
	  |
	  |  Purpose:   A method returns a specific song in the collection according
	  |             to the index given as parameter
	  |  
	  |  Parameters: int
	  |
	  |  Returns:    Song
	  *-------------------------------------------------------------------*/
	 public Song get(int index) {
		    return Songs.get(index);
	 }
	 /*---------------------------------------------------------------------
	  |  Method: getList
	  |
	  |  Purpose:   A method returns the list instance variable 
	  |  
	  |  Parameters: None
	  |
	  |  Returns:    List<Song>
	  *-------------------------------------------------------------------*/
	 public List<Song> getSongList()
	 {
		 return Songs;
	 }
	 
}
