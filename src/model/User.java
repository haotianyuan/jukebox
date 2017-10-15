package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class User {
	private String accountName;
	private String password;
	private boolean admin;
	private int chance;
	private LocalDate localDate;
	private MusicPlayList playlist;
	public User(String name,String password,boolean admin) {
		accountName=name;
		this.password=password;
		this.admin=admin;
		chance=3;
		localDate=LocalDate.now();
		playlist=new MusicPlayList();
	}
	
	public boolean add(Song song) {
		if(LocalDate.now().compareTo(localDate)!=0) {//update the time and chance 
			localDate=LocalDate.now();
			chance=3;
		}
		if(playlist.add(song)==true && chance>0) {
			chance--;
			return true;
		}
		return false;
	}
	
	public ArrayList<Song> getlist(){
		return playlist.getList();
	}
	public String getAccountName() {
		return accountName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean getAdmin() {
		return admin;
	}
	
	public int getchance() {
		return chance;
	}
	//这个方法是我加的， 因为要应用ObservableList
	public String toString()
	{
		String type = "Normal";
		if(admin)
			type = "Admin";
		return "Account name: " + accountName + "    Account Type: " + type;
	}
	
}
