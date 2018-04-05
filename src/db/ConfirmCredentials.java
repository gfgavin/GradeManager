package db;
import java.util.Scanner;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import controllers.DefaultController;
import gui.*;
import user.*;

import java.awt.*;

public class ConfirmCredentials
{
	private static Connection connection = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	
public static int confirmUser(String username, String password) {
int userType = 0;
try {
connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER,
DBInfo.PASSWORD);
pstmt = connection.prepareStatement("SELECT userpass FROM Student WHERE userlogin  = '" + username + "'");
rs = pstmt.executeQuery();
if(rs.next())
{
if(rs.getString("userpass").equals(password))
{
userType = 1;
}
}
} catch (SQLException e) {
System.out.println("nope - query was not successful. reason:");
System.out.println(e.getMessage());
}
                try {
connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER,
DBInfo.PASSWORD);
pstmt = connection.prepareStatement("SELECT userpass FROM Teacher WHERE userlogin  = '" + username + "'");
rs = pstmt.executeQuery();
if(rs.next())
{
if(rs.getString("userpass").equals(password))
{
userType = 2;
}
}
} catch (SQLException e) {
System.out.println("nope - query was not successful. reason:");
System.out.println(e.getMessage());
}
                try {
connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER,
DBInfo.PASSWORD);
pstmt = connection.prepareStatement("SELECT userpass FROM Admin WHERE userlogin  = '" + username + "'");
rs = pstmt.executeQuery();
if(rs.next())
{
if(rs.getString("userpass").equals(password))
{
userType = 3;
}
}
} catch (SQLException e) {
System.out.println("nope - query was not successful. reason:");
System.out.println(e.getMessage());
}
return userType;


}
/*
	public static boolean confirmUser(String userType, String username, String password) {
		boolean userIsConfirmed = false;
		try {
			connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
			pstmt = connection.prepareStatement("SELECT userpass FROM " + userType + " WHERE userlogin  = '" + username + "'");
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				if(rs.getString("userpass").equals(password))
				{
					userIsConfirmed = true;
				}
			}
			
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
		return userIsConfirmed;
	}
*/
	
	public static void credentials(String username, String password)
	{
		
		

		DefaultController.init();
		AdminActionCenter.display();
		/*
		if(userIsTeacher())
		{
			
		}
		*/
		//THIS IS WHERE WE WILL CHECK WITH THE DATABASE TO CONFIRM THE USER'S CREDENTIALS.
		//If the credentials match up, the user is taken to their respective action center.
		//For now, we will use these placeholder logins.
		if (username.equals("admin"))
		{
			AdminActionCenter.display();
		}
		//need to refactor teacher and student so that gui code does not have user objects
		else if (username.equals("teacher"))
		{
			TeacherActionCenter.display();
		}
		else if (username.equals("student"))
		{
			StudentActionCenter.display();
		}
		else
		{
			LoginScreen.display();
		}
		
	}
	


	private static void closeConnection() {
		try {
			rs.close();
		} catch (Exception e) {
			/* ignored */ }
		try {
			pstmt.close();
		} catch (Exception e) {
			/* ignored */ }
		try {
			connection.close();
		} catch (Exception e) {
			/* ignored */ }
	}
}