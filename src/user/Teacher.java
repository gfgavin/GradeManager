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
	
	//this constructor is used just to create a mock teacher
	public Teacher(int a) {
		super("John", "Smith", "jsmith2018", "jsm@students.uwf.edu");
		setTeacherID(101);
		setSpecialty("Science");
	}
	
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
	 * @param username
	 * @param email
	 * @param teacherID
	 * @param specialty
	 */
	public Teacher(String firstName, String lastName, String username, String email,
			int teacherID, String specialty) {
		super(firstName, lastName, username, email);
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Teacher: " + getFirstName() + " " + getLastName() + "\n"
				+ "TeacherID: " + getTeacherID() + "\n"
				+ "Specialty: " + getSpecialty() + "\n"
				+ "UserName: " + getUserName() + "\n"
				+ "Email: " + getEmail();
	}
}
