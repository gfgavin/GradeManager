package user;
/**
 * 
 */

/**
 * @author owner
 *
 */
public class User {
	/*
	 * firstName	VARCHAR(35)
lastName	VARCHAR(35)
role		VARCHAR(35)
username	VARCHAR(20)
password	VARCHAR(20)
email		VARCHAR(35)
	 * 
	 */
	
	private String firstName;
	private String lastName;
	private String role;
	private String username;
	private String password;
	private String email;
	
	
	/**
	 * 
	 */
	public User() {
		setFirstName("");
		setLastName("");
		setRole("");
		setUsername("");
		setPassword("");
		setEmail("");
	}
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param role
	 * @param username
	 * @param password
	 * @param email
	 */
	public User(String firstName, String lastName, String role, String username, String password, String email) {
		setFirstName(firstName);
		setLastName(lastName);
		setRole(role);
		setUsername(username);
		setPassword(password);
		setEmail(email);
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
