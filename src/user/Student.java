package user;
/**
 * 
 */

/**
 * @author owner
 *
 */
public class Student extends User {
	private int studentID = -1;
	
	//this constructor is used just to create a mock student
	public Student(int a) {
		super("Billy", "Madison", "bmads123");
	}
	
	/**
	 * @param studentID
	 * @param year
	 */
	public Student() {
		super();
	}
	/**
	 * @param firstName
	 * @param lastName
	 * @param userName
	 */
	public Student(int studentId, String firstName, String lastName, String userName) {
		super(firstName, lastName, userName);
		setStudentID(studentId);
	}
	/**
	 * @return the studentID
	 */
	public int getStudentID() {
		return studentID;
	}
	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
            return getFirstName() + " " + getLastName() 
                        + " (ID: " + getStudentID() + " UserName: " + getUserName() + ")";
	}
	
	
}
