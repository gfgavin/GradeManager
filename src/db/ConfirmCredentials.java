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
			connect();
			pstmt = connection.prepareStatement("SELECT userpass FROM Student WHERE userlogin  = '" + username + "'");
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				if(rs.getString("userpass").equals(password))
				{
                                       userType = 1; 
                                       return userType;
				}
			}
			
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
                
                try {
			connect();
			pstmt = connection.prepareStatement("SELECT userpass FROM Teacher WHERE userlogin  = '" + username + "'");
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				if(rs.getString("userpass").equals(password))
				{
					userType = 2;
                                        return userType;
				}
			}
			
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
                
                try {
			connect();
			pstmt = connection.prepareStatement("SELECT userpass FROM Admin WHERE userlogin  = '" + username + "'");
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				if(rs.getString("userpass").equals(password))
				{
					userType = 3;
                                        return userType;
				}
			}
			
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
		return userType;
	}
        
        private static void connect() throws SQLException
        {
            //connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
            connection = DataSource.getInstance().getConnection();
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