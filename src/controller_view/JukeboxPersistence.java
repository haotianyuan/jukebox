package controller_view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.MusicPlayList;
import model.SongCollection;
import model.User;
/*===============================================================
|Author:      Jiaming Hao
|
|Class name:  JukeboxPersistence
|
|Description: A class only contains static methods to implement
|             the persistence of JukeBox
*==============================================================*/

public class JukeboxPersistence {

	/*---------------------------------------------------------------------
	  |  Method:     writeUserList
	  |
	  |  Purpose:    Write the current userList to the file named "listOfUsers"
	  |  
	  |  Parameters: ObservableList<User> userList
	  |
	  |  Returns:    None
	  *-------------------------------------------------------------------*/
	public static void writeUserList(ObservableList<User> userList) {
		try {
			List<User> serialList = new ArrayList<User>(userList);
			FileOutputStream bytesToDisk = new FileOutputStream("listOfUsers");
			ObjectOutputStream outFile = new ObjectOutputStream(bytesToDisk);
			outFile.writeObject(serialList);
			outFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found when writing userList");
		} catch (IOException io) {
			System.out.println("IoException error when writing userList");
		}
	}
	/*---------------------------------------------------------------------
	  |  Method:     writeMusicPlayList
	  |
	  |  Purpose:    Write the current playlist to the file named "listOfMusic"
	  |  
	  |  Parameters: MusicPlayList playlist
	  |
	  |  Returns:    None
	  *-------------------------------------------------------------------*/
	public static void writeMusicPlayList(MusicPlayList playlist) {
		try {
			FileOutputStream bytesToDisk = new FileOutputStream("listOfMusic");
			ObjectOutputStream outFile = new ObjectOutputStream(bytesToDisk);
			outFile.writeObject(playlist);
			outFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found when writing playList");
		} catch (IOException io) {
			System.out.println("IoException error when writing playList");
		}
	}
	/*---------------------------------------------------------------------
	  |  Method:     readUserList
	  |
	  |  Purpose:    Read the former userList from file "listOfUsers"
	  |  
	  |  Parameters: None
	  |
	  |  Returns:    ObservableList<User>
	  *-------------------------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public static ObservableList<User> readUserList() {
		List<User> list = null;
		try {
			FileInputStream rawBytes = new FileInputStream("listOfUsers");
			ObjectInputStream inFile = new ObjectInputStream(rawBytes);
			// Need to cast Objects to the class they are known to be
			list = (List<User>) inFile.readObject();
			inFile.close();
		} catch (Exception e) {
			System.out.println("Something went wrong while reading UserList");
		}
		return FXCollections.observableArrayList(list);
	}
	/*---------------------------------------------------------------------
	  |  Method:     readMusicPlayList
	  |
	  |  Purpose:    Read the former PlayList from file "listOfMusic"
	  |  
	  |  Parameters: None
	  |
	  |  Returns:    MusicPlayList
	  *-------------------------------------------------------------------*/
	public static MusicPlayList readMusicPlayList() {
		MusicPlayList playList = null;
		try {
			FileInputStream rawBytes = new FileInputStream("listOfMusic");
			ObjectInputStream inFile = new ObjectInputStream(rawBytes);
			// Need to cast Objects to the class they are known to be
			playList = (MusicPlayList) inFile.readObject();
			inFile.close();
		} catch (Exception e) {
			System.out.println("Something went wrong while reading MusicPlayList");
		}
		return playList;
	}
	/*---------------------------------------------------------------------
	  |  Method:     writeSongCollection
	  |
	  |  Purpose:    Write the current songCollection to the file named "songCollection"
	  |  
	  |  Parameters:  songCollection songCollection
	  |
	  |  Returns:     None
	  *-------------------------------------------------------------------*/
	public static void writeSongCollection(SongCollection songCollection)
	{
		try {
			
			FileOutputStream bytesToDisk = new FileOutputStream("songCollection");
			ObjectOutputStream outFile = new ObjectOutputStream(bytesToDisk);
			outFile.writeObject(songCollection);
			outFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found when writing songCollection");
		} catch (IOException io) {
			System.out.println("IoException error when writing songCollection");
		}
	}
	/*---------------------------------------------------------------------
	  |  Method:     readSongCollection
	  |
	  |  Purpose:    Read the former songCollection object from file "songCollection"
	  |  
	  |  Parameters: None
	  |
	  |  Returns:    SongCollection
	  *-------------------------------------------------------------------*/
	public static SongCollection readSongCollection()
	{
		SongCollection collection = null;
		try {
			FileInputStream rawBytes = new FileInputStream("songCollection");
			ObjectInputStream inFile = new ObjectInputStream(rawBytes);
			// Need to cast Objects to the class they are known to be
			collection = (SongCollection) inFile.readObject();
			inFile.close();
		} catch (Exception e) {
			System.out.println("Something went wrong while reading SongCollection");
		}
		return collection;
	}
	/*---------------------------------------------------------------------
	  |  Method:     saveDate
	  |
	  |  Purpose:    Write the current LocalDate object to file named "formerDate"
	  |  
	  |  Parameters:  LocalDate local
	  |
	  |  Returns:    None
	  *-------------------------------------------------------------------*/
	public static void saveDate(LocalDate local)
	{
		try {
			FileOutputStream bytesToDisk = new FileOutputStream("formerDate");
			ObjectOutputStream outFile = new ObjectOutputStream(bytesToDisk);
			outFile.writeObject(local);
			outFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found when writing local date");
		} catch (IOException io) {
			System.out.println("IoException error when writing local date");
		}
	}
	/*---------------------------------------------------------------------
	  |  Method:     readDate
	  |
	  |  Purpose:    Read the former LocalDate object from the file "formerDate"
	  |  
	  |  Parameters: None
	  |
	  |  Returns:    LocalDate
	  *-------------------------------------------------------------------*/
	public static LocalDate readDate()
	{
		LocalDate former = null;
		try {
			FileInputStream rawBytes = new FileInputStream("formerDate");
			ObjectInputStream inFile = new ObjectInputStream(rawBytes);
			// Need to cast Objects to the class they are known to be
			former = (LocalDate) inFile.readObject();
			inFile.close();
		} catch (Exception e) {
			System.out.println("Something went wrong while reading former date");
		}
		return former;
	}
}
