/**
 * 
 */
package classes;

import java.sql.Date;

/**
 * @author owner
 *
 */
public class Assignment {
	/*
	 * assignmentID	INT(10)	
title		VARCHAR(20)
description	VARCHAR(50)
weight		INT(2)
dueDate	DATE
	 */
	
	private int assignmentID;
	private String title;
	private String description;
	private int weight;
	private Date dueDate;
	
	
	
	/**
	 * 
	 */
	public Assignment() {
		setAssignmentID(0);
		setTitle("");
		setDescription("");
		setWeight(0);
		setDueDate(new Date(1, 1, 2011));
	}

	/**
	 * @param assignmentID
	 * @param title
	 * @param description
	 * @param weight
	 * @param dueDate
	 */
	public Assignment(int assignmentID, String title, String description, int weight, Date dueDate) {
		setAssignmentID(assignmentID);
		setTitle(title);
		setDescription(description);
		setWeight(weight);
		setDueDate(dueDate);
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
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
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	
}
