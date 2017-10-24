/*===============================================================
|Author:     Jiaming Hao
|
|Class name:  MusicPlayList
|
|Description: A class implemented as queue to be used in Jukebox
|             to play songs
*==============================================================*/

package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("serial")
public class MusicPlayList implements Serializable {

	private ArrayList<Song> list;
	private int index;// indicates which song to play next time
	private LocalDate localDate;
	public Map<Song, Integer> recordingTimes;// keep track of how many times each song has been added
	// to the list one single day, if the times larger than three, the song can not
	// be added today

	public MusicPlayList() {
		index = -1;// -1 means there are currently no songs in the list
		list = new ArrayList<Song>();
		localDate = LocalDate.now();// update the date to current date when the list is created
		recordingTimes = new TreeMap<Song, Integer>();
	}

	/*---------------------------------------------------------------------
	  |  Method: add
	  |
	  |  Purpose:    A method used to add songs, return true to indicate 
	  |              a song has been added, otherwise return false
	  |  
	  |  Parameters: Song 
	  |
	  |  Returns:    boolean
	  *-------------------------------------------------------------------*/
	public boolean add(Song newSong) {
		// first check whether it is a new day
		LocalDate current = LocalDate.now();

		// if current date is newer than the date when this list created, update the
		// date info, and reset both lists
		// to empty
		if (localDate.compareTo(current) < 0) {
			localDate = current;

			recordingTimes = new TreeMap<Song, Integer>();
		}

		if (list.size() == 0)
			index = 0;

		// record the times of this added song
		if (recordingTimes.get(newSong) == null)// if the song has not been chosen today
		{
			recordingTimes.put(newSong, 1);
			list.add(newSong);
			System.out.println(recordingTimes);// debug
			return true;
		} else {
			if (recordingTimes.get(newSong) >= 3) { // if the song today has already been chosen 3 times
				System.out.println("Song: " + newSong.getPath() + " already been selected 3 times today");// debug
				System.out.println(recordingTimes);// debug
				return false;// the song can not be added any more today
			} else {
				recordingTimes.put(newSong, recordingTimes.get(newSong) + 1);
				list.add(newSong);
				System.out.println(recordingTimes);
				return true;
			}
		}
	}

	/*---------------------------------------------------------------------
	  |  Method: nextSong
	  |
	  |  Purpose:  A method used to give next song in the list
	  |  
	  |  Parameters: None 
	  |
	  |  Returns:    Song
	  *-------------------------------------------------------------------*/
	public Song nextSong() {
		if (index >= list.size() || index == -1) {
			System.out.println("All songs in the list have been played!");// debug
			return null;// when there are no songs left in the list
		} else {
			int i = index;
			index++;
			return list.get(i);
		}
	}

	/*---------------------------------------------------------------------
	  |  Method: getList
	  |
	  |  Purpose:  A method return the instance variable list
	  |  
	  |  Parameters: None 
	  |
	  |  Returns:    ArrayList<Song> 
	  *-------------------------------------------------------------------*/
	public ArrayList<Song> getList() {
		return list;
	}
	/*---------------------------------------------------------------------
	  |  Method: getRecording
	  |
	  |  Purpose:  A method return the Map inside the play list
	  |  
	  |  Parameters: None 
	  |
	  |  Returns:    Map<Song, Integer>
	  *-------------------------------------------------------------------*/
	public Map<Song, Integer> getRecording() {
		return recordingTimes;
	}

}
