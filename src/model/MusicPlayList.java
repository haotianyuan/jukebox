

package model;

	import java.time.LocalDate;
	import java.util.ArrayList;
	import java.util.Map;
	import java.util.TreeMap;

	public class MusicPlayList {
		
		private ArrayList<Song> list;
		private int index;//indicates which song to play next time
		private LocalDate localDate;
		public Map<Song,Integer> recordingTimes;//keep track of how many times each song has been added
		// to the list one single day, if the times lager than three, the song can not be added today 
		
		public MusicPlayList()
		{
			index = -1;// -1 means there are currently no songs in the list
			list = new ArrayList<Song>();
			localDate = LocalDate.now();//update the date to current date when the list is created
			recordingTimes = new TreeMap<Song, Integer>();
		}
		
		public boolean add(Song newSong)
		{
			//first check whether it is a new day
			LocalDate current = LocalDate.now();
			
			//if current date is newer than the date when this list created, update the date info, and reset both lists 
			// to empty
			if(localDate.compareTo(current) < 0)
			{
				localDate = current;
				//list = new ArrayList<Song>();
				//index = -1;//reset the index
				recordingTimes = new TreeMap<Song, Integer>();
			}
			
			if(list.size()==0)
				index = 0;
			
			//record the times of this added song
			if(recordingTimes.get(newSong)==null)// if the song has not been chosen today
			{
				recordingTimes.put(newSong, 1);
				list.add(newSong);
				System.out.println(recordingTimes);//debug
				return true;
			}
			else
			{
				if(recordingTimes.get(newSong) >= 3) { // if the song today has already been chosen 3 times
					System.out.println("Song: " + newSong.getPath() + " already been selected 3 times today");//debug
					return false;// the song can not be chosen any more today
				}
				else
				{
					recordingTimes.put(newSong,recordingTimes.get(newSong)+1);
					list.add(newSong);
					
					return true;
				}
			}
		}
		
		public Song nextSong()
		{
			if(index >= list.size()||index == -1)
			{
				System.out.println("All songs in the list have been played!");//debug
				return null;// when there are no songs left in the list
			}
			else
			{
				int i = index;
				index++;
				return list.get(i);
			}
		}
		
		public ArrayList<Song> getList(){
			return list;
		}
		

	
}
