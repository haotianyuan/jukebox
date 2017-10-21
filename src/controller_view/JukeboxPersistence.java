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

public class JukeboxPersistence {

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
