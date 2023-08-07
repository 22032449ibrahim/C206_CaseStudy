
public class User {
	private String name;
	private String password;
	private String userID;
	
	public User(String name, String userID, String password) {
		this.name = name;
		this.userID = userID;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}	
	public String getUserID() {
		return userID;
	}
}
