package user;
/**
 * 
 */

/**
 * @author owner
 *
 */
public class Administrator extends User {
	private int adminId = -1;
	
	//this constructor is used just to create a mock administrator
	public Administrator(int a) 
	{
		super("Steve", "Jobs", "admin");
	}
	
	public Administrator()
	{
		super();
	}
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param userName
	 */
	public Administrator(int adminId, String firstName, String lastName, String userName) {
		super(firstName, lastName, userName);
		setAdminId(adminId);
	}

	/**
	 * @return the adminId
	 */
	public int getAdminId() {
		return adminId;
	}

	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Administrator: " + getFirstName() + " " + getLastName() + "\n"
				+ "UserName: " + getUserName();
	}
	
	
}
