/**
 * 
 */
package course;

import user.Student;

/**
 * @author owner
 *
 */
public class Assignment {
	
	private int assignmentID = -1;
	private String title;
	private Student student;
	private int grade = -1;
	
	/**
	 * 
	 */
	public Assignment() {
		setTitle("");
		setStudent(new Student());
	}

	/**
	 * @param assignmentID
	 * @param title
	 * @param description
	 * @param weight
	 * @param dueDate
	 */
	public Assignment(int assignmentID, String title, Student student) {
		setAssignmentID(assignmentID);
		setTitle(title);
		setStudent(student);
	}
	
	/**
	 * @return the assignmentID
	 */
	public int getAssignmentID() {
		return assignmentID;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}
	/**
	 * @param assignmentID the assignmentID to set
	 */
	public void setAssignmentID(int assignmentID) {
		this.assignmentID = assignmentID;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Assignment: " + getTitle() + "\n"
				+ "AssignmentID: " + getAssignmentID() + "\n"
				+ "Student: " + getStudent() + "\n"
				+ "Grade: " + getGrade();
	}
	
	
}
