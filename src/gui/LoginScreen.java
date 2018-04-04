package gui;

import java.util.Scanner;
import java.io.*;
import javax.swing.*;

import controllers.DefaultController;
import db.AssignmentQueries;
import db.ConfirmCredentials;
import user.Teacher;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginScreen
{
	private static JTextField usernameField;
	private static JTextField passwordField;

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void display()
	{
		JFrame frmLogin = new JFrame("Login");

	    frmLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frmLogin.setSize(811,627);  
	    frmLogin.getContentPane().setLayout(null);
	    
	    JLabel lblUsername = new JLabel("Username:");
	    lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    lblUsername.setBounds(322, 366, 119, 28);
	    frmLogin.getContentPane().add(lblUsername);
	    
	    usernameField = new JTextField();
	    usernameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    usernameField.setBounds(452, 366, 196, 28);
	    frmLogin.getContentPane().add(usernameField);
	    usernameField.setColumns(10);
	    
	    JLabel lblPassword = new JLabel("Password:");
	    lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    lblPassword.setBounds(322, 405, 119, 28);
	    frmLogin.getContentPane().add(lblPassword);
	    
	    passwordField = new JTextField();
	    passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    passwordField.setColumns(10);
	    passwordField.setBounds(452, 405, 196, 28);
	    frmLogin.getContentPane().add(passwordField);
	    
	    JButton btnSubmit = new JButton("Submit");
	    btnSubmit.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String username = usernameField.getText();
				String userPassword = passwordField.getText();
				
				//User has submitted their userID and password.
				ConfirmCredentials.credentials(username, userPassword);
	    	}
	    	
	    });
	    btnSubmit.setBounds(515, 454, 89, 23);
	    frmLogin.getContentPane().add(btnSubmit);
	    
	    JLabel label = new JLabel("");
	    label.setIcon(new ImageIcon(LoginScreen.class.getResource("/images/Login.png")));
	    label.setBounds(0, 0, 803, 588);
	    frmLogin.getContentPane().add(label);
	    frmLogin.setVisible(true);
	}
}
