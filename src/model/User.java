package model;

import java.io.Serializable;
import java.time.LocalDate;




/*===============================================================
|Author:     Haotian Yuan  Jiaming Hao
|
|Class name:  Song
|
|Description: A class represents users
*==============================================================*/

@SuppressWarnings("serial")
public class User implements Serializable{
	
	private String accountName;
	private String password;
	private boolean admin;
	private int chance;// three times for each day
	private LocalDate localDate;
	
	
	public User(String name,String password,boolean admin) 
	{
		accountName=name;
		this.password=password;
		this.admin=admin;
		chance=3;
		localDate=LocalDate.now();
		
	}
	/*---------------------------------------------------------------------
	  |  Method: selectSong
	  |
	  |  Purpose:   Whenever a user select a song on GUI, this method will
	  |             be called, returns true indicating song selected, otherwise
	  |             returns false
	  |  
	  |  Parameters: None
	  |
	  |  Returns:    Boolean
	  *-------------------------------------------------------------------*/
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
	
	/*---------------------------------------------------------------------
	  |  Method: getAccountName
	  |
	  |  Purpose:   return account name
	  |  
	  |  Parameters: None
	  |
	  |  Returns:    String
	  *-------------------------------------------------------------------*/
	public String getAccountName() {
		return accountName;
	}
	/*---------------------------------------------------------------------
	  |  Method: getPassword
	  |
	  |  Purpose:   return password
	  |  
	  |  Parameters: None
	  |
	  |  Returns:    String
	  *-------------------------------------------------------------------*/
	public String getPassword() {
		return password;
	}
	/*---------------------------------------------------------------------
	  |  Method: getAdmin
	  |
	  |  Purpose:   return account property
	  |  
	  |  Parameters: None
	  |
	  |  Returns:    Boolean
	  *-------------------------------------------------------------------*/
	public boolean getAdmin() {
		return admin;
	}
	/*---------------------------------------------------------------------
	  |  Method: getchance
	  |
	  |  Purpose:   return account times
	  |  
	  |  Parameters: None
	  |
	  |  Returns:    Integer
	  *-------------------------------------------------------------------*/
	public int getchance() {
		return chance;
	}
	/*---------------------------------------------------------------------
	  |  Method: recovChance
	  |
	  |  Purpose:   increment the chance by 1 
	  |  
	  |  Parameters: None
	  |
	  |  Returns:    None
	  *-------------------------------------------------------------------*/
	public void recovChance()
	{
		chance++;
	}
	/*---------------------------------------------------------------------
	  |  Method: toString
	  |
	  |  Purpose:   Method used to debug and show message on GUI
	  |  
	  |  Parameters: None
	  |
	  |  Returns:    String
	  *-------------------------------------------------------------------*/
	public String toString()
	{
		String type = "Normal";
		if(admin)
			type = "Admin";
		return "Account name: " + accountName + "    Account Type: " + type;
	}
	/*---------------------------------------------------------------------
	  |  Method: resetChan
	  |
	  |  Purpose:   Method used to reset every user's chance in a new day
	  |  
	  |  Parameters: None
	  |
	  |  Returns:    None
	  *-------------------------------------------------------------------*/
	public void resetChan()
	{
		chance = 3;
	}
	
	
}
