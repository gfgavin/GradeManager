package user;
/**
 * 
 */

/**
 * @author owner
 *
 */
public class User {
	
	private String firstName;
	private String lastName;
	private String userName;
		
	/**
	 * 
	 */
	public User() {
		setFirstName("");
		setLastName("");
		setUserName("");
	}
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param userName
	 */
	public User(String firstName, String lastName, String userName) {
		setFirstName(firstName);
		setLastName(lastName);
		setUserName(userName);
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
}
