/**
 * 
 */
package course;

import java.util.ArrayList;
import user.Student;

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
        private ArrayList<Student> studentList;
	
	
	/**
	 * 
	 */
	public Course() {
		setCoursename("");
		setTime("");
		setTeacher(new Teacher());
		setAssignmentList(new ArrayList<Assignment>());
                setStudentList(new ArrayList<Student>());
	}


	/**
	 * @param courseID
	 * @param coursename
	 * @param time
	 * @param teacher
	 * @param assignmentList
	 */
	public Course(int courseID, String coursename, String time, Teacher teacher, ArrayList<Assignment> assignmentList) {
		setCourseID(courseID);
		setCoursename(coursename);
		setTime(time);
		setAssignmentList(assignmentList);
                setStudentList(new ArrayList<Student>());
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
                /*
                //ArrayList<Assignment> listForOneAssignment = new ArrayList<Assignment>();
                if(this.assignmentList.size() > 0)
                {
                    int id = assignmentList.get(0).getAssignmentID();
                    for(Assignment a : this.assignmentList)
                    {
                        if(a.getAssignmentID() == id)
                        {
                            studentList.add(a.getStudent());
                        }
                    }
                }
                */
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
		return getCoursename() + " (ID: " + getCourseID() + " Time: " + getTime()
                        + " Teacher: " + getTeacher().getFirstName() + " " + getTeacher().getLastName() +")";
	}

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
	
	
}
