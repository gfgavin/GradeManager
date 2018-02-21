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
	private int year;
	
	
	
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
	 * @param role
	 * @param username
	 * @param password
	 * @param email
	 * @param studentID
	 * @param year
	 */
	public Student(String firstName, String lastName, String role, String username, String password, String email,
			int studentID, int year) {
		super(firstName, lastName, role, username, password, email);
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
	
	
}
