package controllers;

import user.*;

public class DefaultController {
	private static Administrator theAdmin;
	private static Teacher theTeacher;
	private static Student theStudent;
	
	public static void init()
	{
		theAdmin = new Administrator(1);
		theTeacher = new Teacher(1);
		theStudent = new Student(1);
	}
	
	public static String adminFirstName()
	{
		return theAdmin.getFirstName();
	}
	
	public static String adminToString()
	{
		return theAdmin.toString();
	}
	
	public static String teacherFirstName()
	{
		return theTeacher.getFirstName();
	}
	
	public static String teacherToString()
	{
		return theTeacher.toString();
	}
	
	public static String studentFirstName()
	{
		return theStudent.getFirstName();
	}
	
	public static String studentToString()
	{
		return theStudent.toString();
	}
}
