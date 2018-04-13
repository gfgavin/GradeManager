package controllers;

import java.util.ArrayList;

import course.Assignment;
import course.Course;
import db.CourseQueries;
import db.StudentQueries;
import user.Student;

public class StudentController {
	private Student student;
	private ArrayList<Course> courseList;

	public StudentController(String username) {
		setStudent(StudentQueries.getStudent(username));
		setCourseList(CourseQueries.getCoursesForStudent(student.getStudentID()));
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @return the courseList
	 */
	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * @param courseList the courseList to set
	 */
	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String theString = "";

		theString += "Student:\n" + student.getFirstName() + " " + student.getLastName() + "\n";
		theString += "\nCourses:\n";
		for(Course c : courseList) 
		{
			theString += c.getCoursename() + " " + c.getTime() + "\n";
			theString += "\nAssignments:\n";
			for(Assignment a : c.getAssignmentList()) {theString += a.getTitle() + " " + a.getGrade() + "\n";}
		}
		
		return theString;
	}

    public String viewGradesForCourse(int courseId) {
        String grades = "";
        Course course = new Course();
        for(Course c : courseList)
        {
            if(c.getCourseID() == courseId)
            {
                course = c;
                break;
            }
        }
        grades += "Course: " + course.getCoursename() + "\n"
                + "Teacher: " + course.getTeacher().getFirstName() + " " + course.getTeacher().getLastName() + "\n\n";
        
        for(Assignment a : course.getAssignmentList())
        {
            grades += a.getTitle() + " - " + a.getGrade() + "\n";
        }
        
        return grades;
    }

}
