/**
 * 
 */
package course;

import java.util.ArrayList;

/**
 * @author owner
 *
 */
public class Course {
	/*
	 * classID	INT(5)
title		VARCHAR(35)
time		VARCHAR(20)
announcement	VARCHAR(50)
teacherID	INT(5)
	 */
	private int courseID;
	private String title;
	private String time;
	private String announcement;
	private ArrayList<Assignment> assignmentList;
	
	
	/**
	 * 
	 */
	public Course() {
		setCourseID(-1);
		setTitle("");
		setTime("");
		setAnnouncement("");
		setAssignmentList(new ArrayList<Assignment>());
	}


	/**
	 * @param courseID
	 * @param title
	 * @param time
	 * @param announcement
	 * @param assignmentList
	 */
	public Course(int courseID, String title, String time, String announcement, ArrayList<Assignment> assignmentList) {
		setCourseID(courseID);
		setTitle(title);
		setTime(time);
		setAnnouncement(announcement);
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
	public String getTitle() {
		return title;
	}


	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}


	/**
	 * @return the announcement
	 */
	public String getAnnouncement() {
		return announcement;
	}


	/**
	 * @return the assignmentList
	 */
	public ArrayList<Assignment> getAssignmentList() {
		return assignmentList;
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
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}


	/**
	 * @param announcement the announcement to set
	 */
	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}


	/**
	 * @param assignmentList the assignmentList to set
	 */
	public void setAssignmentList(ArrayList<Assignment> assignmentList) {
		this.assignmentList = assignmentList;
	}
	
	
}
