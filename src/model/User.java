package model;

public class User {
	private String accountName;
	private String password;
	private boolean admin;
	public User(String name,String password,boolean admin) {
		accountName=name;
		this.password=password;
		this.admin=admin;
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
	
	public boolean vertifyAccount(String name,String pass) {
		if(name.compareTo(accountName)==0 && pass.compareTo(password)==0) {
			return true;
		}
		return false;
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
