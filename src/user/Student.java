package user;
/**
 * 
 */

/**
 * @author owner
 *
 */
public class Student extends User {
	private int studentID;
	private int year; //1 - freshman , 2 - sophomore...
	
	//this constructor is used just to create a mock student
	public Student(int a) {
		super("Billy", "Madison", "bmads123", "happygilmore@gmail.com");
		setStudentID(1001);
		setYear(2);
	}
	
	/**
	 * @param studentID
	 * @param year
	 */
	public Student() {
		super();
		setStudentID(-1);
		setYear(-1);
	}
	/**
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param email
	 * @param studentID
	 * @param year
	 */
	public Student(String firstName, String lastName, String username, String email,
			int studentID, int year) {
		super(firstName, lastName, username, email);
		setStudentID(studentID);
		setYear(year);
	}
	/**
	 * @return the studentID
	 */
	public int getStudentID() {
		return studentID;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student: " + getFirstName() + " " + getLastName() + "\n"
				+ "StudentID: " + getStudentID() + "\n"
				+ "Year: " + getYear() + "\n"
				+ "UserName: " + getUserName() + "\n"
				+ "Email: " + getEmail();
	}
	
	
}
