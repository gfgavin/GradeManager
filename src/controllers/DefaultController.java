package controllers;

import user.Administrator;

public class DefaultController {
	private static Administrator theAdmin;
	
	public static void init()
	{
		theAdmin = new Administrator(1);
	}
	
	public static String adminFirstName()
	{
		return theAdmin.getFirstName();
	}
	
	public static String adminToString()
	{
		return theAdmin.toString();
	}
}
