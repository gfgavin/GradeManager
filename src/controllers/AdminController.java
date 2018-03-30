package controllers;

import java.util.ArrayList;

import course.Course;
import db.*;
import user.*;

public class AdminController {
	private Administrator admin;
	private ArrayList<Teacher> teacherlist;
	private ArrayList<Student> studentlist;
	private ArrayList<Course> courselist;
	
	public AdminController(String username)
	{
		setAdmin(AdminQueries.getAdmin(username));
		setTeacherlist(TeacherQueries.getAllTeachers());
		setStudentlist(StudentQueries.getAllStudents());
		setClasslist(CourseQueries.getAllCourses());
		
	}
	/**
	 * @return the admin
	 */
	public Administrator getAdmin() {
		return admin;
	}

	/**
	 * @return the classlist
	 */
	public ArrayList<Course> getClasslist() {
		return courselist;
	}

	/**
	 * @return the studentlist
	 */
	public ArrayList<Student> getStudentlist() {
		return studentlist;
	}

	/**
	 * @return the teacherlist
	 */
	public ArrayList<Teacher> getTeacherlist() {
		return teacherlist;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}

	/**
	 * @param classlist the classlist to set
	 */
	public void setClasslist(ArrayList<Course> classlist) {
		this.courselist = classlist;
	}

	/**
	 * @param studentlist the studentlist to set
	 */
	public void setStudentlist(ArrayList<Student> studentlist) {
		this.studentlist = studentlist;
	}

	/**
	 * @param teacherlist the teacherlist to set
	 */
	public void setTeacherlist(ArrayList<Teacher> teacherlist) {
		this.teacherlist = teacherlist;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String theString = "";
		theString += "Admin:\n" + admin.getFirstName() + " " + admin.getLastName() + "\n";
		//teacher student course
		theString += "\nTeachers:\n";
		for(Teacher t : teacherlist) {theString += t.getFirstName() + " " + t.getLastName() + "\n";}
		theString += "\nStudents:\n";
		for(Student s : studentlist) {theString += s.getFirstName() + " " + s.getLastName() + "\n";}
		theString += "\nCourses:\n";
		for(Course c : courselist) {theString += c.getCoursename() + " " + c.getTime() + "\n";}
		
		return theString;
	}
}
