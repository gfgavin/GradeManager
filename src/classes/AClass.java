/**
 * 
 */
package classes;

import user.Teacher;

/**
 * @author owner
 *
 */
public class AClass {
	/*
	 * classID	INT(5)
title		VARCHAR(35)
time		VARCHAR(20)
announcement	VARCHAR(50)
teacherID	INT(5)
	 */
	private int classID;
	private String title;
	private String time;
	private String announcement;
	private Teacher theTeacher;
	
	
	/**
	 * @param classID
	 * @param title
	 * @param time
	 * @param announcement
	 * @param theTeacher
	 */
	public AClass(int classID, String title, String time, String announcement, Teacher theTeacher) {
		setClassID(classID);
		setTitle(title);
		setTime(time);
		setAnnouncement(announcement);
		setTheTeacher(theTeacher);
	}
	/**
	 * @return the classID
	 */
	public int getClassID() {
		return classID;
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
	 * @return the theTeacher
	 */
	public Teacher getTheTeacher() {
		return theTeacher;
	}
	/**
	 * @param classID the classID to set
	 */
	public void setClassID(int classID) {
		this.classID = classID;
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
	 * @param theTeacher the theTeacher to set
	 */
	public void setTheTeacher(Teacher theTeacher) {
		this.theTeacher = theTeacher;
	}
	
	
}
