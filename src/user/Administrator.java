package user;
/**
 * 
 */

/**
 * @author owner
 *
 */
public class Administrator extends User {
	//this constructor is used just to create a mock administrator
	public Administrator(int a) 
	{
		super("Steve", "Jobs", "admin", "thebigguy@yahoo.com");
	}
	
	public Administrator()
	{
		super();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Administrator: " + getFirstName() + " " + getLastName() + "\n"
				+ "UserName: " + getUserName() + "\n"
				+ "Email: " + getEmail();
	}
	
	
}
