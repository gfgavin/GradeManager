
//Imports
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

//________________________________________________________LOGINSCREEN________________________________________________________
public class LoginScreen
{
	//Variables
	private static JTextField usernameField;	//This variable retrieves the value from our username field entry.
	private static JTextField passwordField;	//This variable retrieves the value from our password field entry.

	//---------------------------------------------------------DISPLAY---------------------------------------------------------
	//This is the display method that is called from other methods to open the login screen.
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void display()
	{
		//Jframe
		JFrame frmLogin = new JFrame("Login");

	    frmLogin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frmLogin.setSize(811,627);  
	    frmLogin.getContentPane().setLayout(null);
	    
	    //Username Label
	    JLabel lblUsername = new JLabel("Username:");
	    lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    lblUsername.setBounds(322, 366, 119, 28);
	    frmLogin.getContentPane().add(lblUsername);
	    
	    //Username Textfield
	    usernameField = new JTextField();
	    usernameField.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    usernameField.setBounds(452, 366, 196, 28);
	    frmLogin.getContentPane().add(usernameField);
	    usernameField.setColumns(10);
	    
	    //Password Label
	    JLabel lblPassword = new JLabel("Password:");
	    lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    lblPassword.setBounds(322, 405, 119, 28);
	    frmLogin.getContentPane().add(lblPassword);
	    
	    //Password Textfield
	    passwordField = new JTextField();
	    passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    passwordField.setColumns(10);
	    passwordField.setBounds(452, 405, 196, 28);
	    frmLogin.getContentPane().add(passwordField);
	    
	    //Submit Button
	    JButton btnSubmit = new JButton("Submit");
	    btnSubmit.addActionListener(new ActionListener()
	    {
	    	//Button has been clicked.
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		//Get text from username and password fields.
	    		String username = usernameField.getText();
				String userPassword = passwordField.getText();
				
				//Send the username and password to the credentials method of the ConfirmCredentials class.
				ConfirmCredentials.credentials(username, userPassword);
	    	    frmLogin.setVisible(false);
	    	}
	    });
	    btnSubmit.setBounds(515, 454, 89, 23);
	    frmLogin.getContentPane().add(btnSubmit);
	    
	    //Background Image
	    JLabel backgroundImage = new JLabel("");
	    backgroundImage.setIcon(new ImageIcon(LoginScreen.class.getResource("/images/Login.png")));
	    backgroundImage.setBounds(0, 0, 803, 588);
	    frmLogin.getContentPane().add(backgroundImage);
	    frmLogin.setVisible(true);
	}
}
