package user;
/**
 * 
 */

/**
 * @author owner
 *
 */
public class Teacher extends User {
	private int teacherID;
	private String specialty;
	
	
	
	/**
	 * @param teacherID
	 * @param specialty
	 */
	public Teacher() {
		super();
		setTeacherID(-1);
		setSpecialty("");
	}
	/**
	 * @param firstName
	 * @param lastName
	 * @param role
	 * @param username
	 * @param password
	 * @param email
	 * @param teacherID
	 * @param specialty
	 */
	public Teacher(String firstName, String lastName, String role, String username, String password, String email,
			int teacherID, String specialty) {
		super(firstName, lastName, role, username, password, email);
		setTeacherID(teacherID);
		setSpecialty(specialty);
	}
	/**
	 * @return the teacherID
	 */
	public int getTeacherID() {
		return teacherID;
	}
	/**
	 * @return the specialty
	 */
	public String getSpecialty() {
		return specialty;
	}
	/**
	 * @param teacherID the teacherID to set
	 */
	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}
	/**
	 * @param specialty the specialty to set
	 */
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	
}
