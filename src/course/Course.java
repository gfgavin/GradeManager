/**
 * 
 */
package course;

import java.util.ArrayList;

import user.Teacher;

/**
 * @author owner
 *
 */
public class Course {
	private int courseID = -1;
	private String coursename;
	private String time;
	private Teacher teacher;
	private ArrayList<Assignment> assignmentList;
	
	
	/**
	 * 
	 */
	public Course() {
		setCoursename("");
		setTime("");
		setTeacher(new Teacher());
		setAssignmentList(new ArrayList<Assignment>());
	}


	/**
	 * @param courseID
	 * @param coursename
	 * @param time
	 * @param announcement
	 * @param assignmentList
	 */
	public Course(int courseID, String coursename, String time, Teacher teacher, ArrayList<Assignment> assignmentList) {
		setCourseID(courseID);
		setCoursename(coursename);
		setTime(time);
		setAssignmentList(assignmentList);
	}


	/**
	 * @return the courseID
	 */
	public int getCourseID() {
		return courseID;
	}


	/**
	 * @return the title
	 */
	public String getCoursename() {
		return coursename;
	}


	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}


	/**
	 * @return the assignmentList
	 */
	public ArrayList<Assignment> getAssignmentList() {
		return assignmentList;
	}


	/**
	 * @return the teacher
	 */
	public Teacher getTeacher() {
		return teacher;
	}


	/**
	 * @param courseID the courseID to set
	 */
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}


	/**
	 * @param title the title to set
	 */
	public void setCoursename(String title) {
		this.coursename = title;
	}


	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}


	/**
	 * @param assignmentList the assignmentList to set
	 */
	public void setAssignmentList(ArrayList<Assignment> assignmentList) {
		this.assignmentList = assignmentList;
	}


	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public String assignmentListToString()
	{
		String assignListString = "";
		for(Assignment a : getAssignmentList())
		{
			assignListString += a + "\n";
		}
		return assignListString;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Course: " + getCoursename() + "\n"
				+ "CourseID: " + getCourseID() + "\n"
				+ "Time: " + getTime() + "\n"
				+ "Teacher: " + getTeacher().getFirstName() + " " + getTeacher().getLastName() + "\n"
				+ "Assignments: " + assignmentListToString();
	}
	
	
}
