package gui;

import java.util.Scanner;
import java.io.*;
import javax.swing.*;

import db.ConfirmCredentials;

import java.awt.*;


public class LoginScreen
{
	
	//---------------------------------LOGIN SCREEN----------------------------------------	
	public static void display()
	{
		
		int choice;		
	
		JPanel loginPanel = new JPanel();

		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
		
		final JTextField usernameField = new JTextField(5);
		JPasswordField passwordField = new JPasswordField(5);
		
		loginPanel.add(new JLabel("Please enter your login information:"));
		loginPanel.add(Box.createVerticalStrut(15));
		
		loginPanel.add(new JLabel("User ID:"));
		loginPanel.add(usernameField);
		loginPanel.add(Box.createVerticalStrut(15));
		
		loginPanel.add(new JLabel("Password:"));
		loginPanel.add(passwordField);
		loginPanel.add(Box.createVerticalStrut(15));
		
		
		UIManager.put("OptionPane.cancelButtonText", "Exit");
		UIManager.put("OptionPane.okButtonText", "Submit");
		
		choice = JOptionPane.showConfirmDialog(null, loginPanel, "Electronic Assignment and Attendance Guide", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		//User chooses to exit program.
		if(choice == JOptionPane.CANCEL_OPTION || choice == JOptionPane.CLOSED_OPTION)
		{
			System.exit(1);
		}
		
		else if(choice == JOptionPane.OK_OPTION)
		{
			String username = usernameField.getText();
			String userPassword = convertPasswordToString(passwordField.getPassword());
			
			//User has submitted their userID and password.
			ConfirmCredentials.credentials(username, userPassword);
		}
	
	}

	private static String convertPasswordToString(char[] password) {
		String pw = "";
		for(char a : password)
		{
			pw += a;
		}
		return pw;
	}
	
}