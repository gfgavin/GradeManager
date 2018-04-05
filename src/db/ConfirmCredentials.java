
//Package
package db;

//Imports
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

//________________________________________________________CONFIRM CREDENTIALS________________________________________________________
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
=======
	//---------------------------------------------------------CONFIRM USER---------------------------------------------------------
	//This method checks our database to confirm that a user exists for the given username and password combination.
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
					//Username and password match!
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

	//---------------------------------------------------------CREDENTIALS---------------------------------------------------------
	//This method is called from the login screen (LoginScreen.java) upon submittion of user-entered login data.
	public static void credentials(String username, String password)
	{
		DefaultController.init();

		//THIS IS WHERE WE WILL CHECK WITH THE DATABASE TO CONFIRM THE USER TYPE
		//The user is then taken to their respective action center, based on their user type.
		//For now, we will use these placeholder logins.

		//User is of 'Admin' type.
		if (username.equals("admin"))
		{
			//Admin action center is displayed for the user.
			AdminActionCenter.display();
		}

		//User is of 'Teacher' type.
		else if (username.equals("teacher"))
		{
			String currentClass = "No Class Selected";

			//Teacher action center is displayed for the user.
			TeacherActionCenter.display(currentClass);
		}

		//User is of 'Student' type.
		else if (username.equals("student"))
		{
			//Student action center is displayed for the user.
			StudentActionCenter.display();
		}

		//PLACEHOLDER
		//User does not match one of the three user types. Must try login again.
		else
		{
			LoginScreen.display();
		}
	}

	//---------------------------------------------------------CLOSE CONNECTION---------------------------------------------------------
	//Closes connection with the database.
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
