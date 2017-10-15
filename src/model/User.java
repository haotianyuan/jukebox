package model;

import java.time.LocalDate;


public class User {
	private String accountName;
	private String password;
	private boolean admin;
	private int chance;
	private LocalDate localDate;
	
	public User(String name,String password,boolean admin) 
	{
		accountName=name;
		this.password=password;
		this.admin=admin;
		chance=3;
		localDate=LocalDate.now();
	}
	
	public boolean selectSong() {
		if (LocalDate.now().compareTo(localDate) > 0) 
		{// if it is a new day
			localDate = LocalDate.now();
			chance = 3;
		}
		if(chance!=0)
		{
			chance--;
			return true;
		}
		else
			return false;
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
	public void recovChance()
	{
		chance++;
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
