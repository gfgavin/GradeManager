package user;
/**
 * 
 */

/**
 * @author owner
 *
 */
public class Teacher extends User {
	private int teacherID = -1;
	
	//this constructor is used just to create a mock teacher
	public Teacher(int a) {
		super("John", "Smith", "jsmith2018");
	}
	
	/**
	 * @param teacherID
	 * @param specialty
	 */
	public Teacher() {
		super();
	}
	/**
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param email
	 * @param teacherID
	 * @param specialty
	 */
	public Teacher(int teacherID, String firstName, String lastName, String username) {
		super(firstName, lastName, username);
		setTeacherID(teacherID);
	}
	/**
	 * @return the teacherID
	 */
	public int getTeacherID() {
		return teacherID;
	}
	/**
	 * @param teacherID the teacherID to set
	 */
	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getFirstName() + " " + getLastName() 
                        + " (ID: " + getTeacherID() + " UserName: " + getUserName() + ")";
	}
}
