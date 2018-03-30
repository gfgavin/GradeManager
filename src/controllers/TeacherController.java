package controllers;

import java.util.ArrayList;

import course.Course;
import db.CourseQueries;
import db.TeacherQueries;
import user.Teacher;

public class TeacherController {
	private Teacher teacher;
	private ArrayList<Course> courseList;


	public TeacherController(String username) {
		setTeacher(TeacherQueries.getTeacher(username));
		setCourseList(CourseQueries.getCoursesForTeacher(teacher.getTeacherID()));
	}


	/**
	 * @return the teacher
	 */
	public Teacher getTeacher() {
		return teacher;
	}


	/**
	 * @return the courseList
	 */
	public ArrayList<Course> getCourseList() {
		return courseList;
	}


	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
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
		theString += "Teacher:\n" + teacher.getFirstName() + " " + teacher.getLastName() + "\n";
		theString += "\nCourses:\n";
		for(Course c : courseList) {theString += c.getCoursename() + " " + c.getTime() + "\n";}
		
		return theString;
	}
}
