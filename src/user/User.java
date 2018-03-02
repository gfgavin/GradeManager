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
	private String userName;
	private String email;
	
	
	/**
	 * 
	 */
	public User() {
		setFirstName("");
		setLastName("");
		setUserName("");
		setEmail("");
	}
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 */
	public User(String firstName, String lastName, String userName, String email) {
		setFirstName(firstName);
		setLastName(lastName);
		setUserName(userName);
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
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
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
