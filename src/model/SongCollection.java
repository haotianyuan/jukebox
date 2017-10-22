package model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


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
	
	public int size() {
	    return Songs.size();
	}
	
	 public void add(Song newSong) {
		    Songs.add(newSong);
	 }
	 
	 public Song get(int index) {
		    return Songs.get(index);
	 }
	 
	 public List<Song> getSongList()
	 {
		 return Songs;
	 }
	 
}
