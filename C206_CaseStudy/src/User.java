
public class User {
	private String name;
	private String password;
	private String userID;
	private String email;
	private String role;
	
	public User(String name, String userID, String email, String role, String password) {
		this.name = name;
		this.userID = userID;
		this.email = email;
		this.role = role;
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
	public String getEmail() {
		return email;
	}
	public String getRole() {
		return role;
	}
}