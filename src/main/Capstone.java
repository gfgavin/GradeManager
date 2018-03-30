package main;

//_________________________MAIN PROGRAM_____________________________
import gui.*;
import user.*;

import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.awt.*;

//This utility allows the program to connect to the internet.
//This is used for displaying the welcome-screen image.
import java.net.*;

//PROGRAM
public class Capstone
{
	//---------------------------------MAIN----------------------------------------
	public static void main(String[] args) throws IOException
	{
		/*
		 * uncomment 'welcomescreen();' to run program normally.
		 * For development and testing purposes, I'm running another method
		 */
		TestFunctionsWithoutGUI program = new TestFunctionsWithoutGUI();
		program.test();
		
		
		//Allowing keyboard input.
		//Scanner keyboard = new Scanner(System.in);
		
		//Welcome Screen
		//welcomeScreen();
		
		/*
		 * to launch an action center directly, comment out welcomeScreen() above,
		 * and uncomment the action center you want the program to launch
		 */
		//AdminActionCenter.display(new Administrator(1));
		//StudentActionCenter.display(new Student(1));
		//TeacherActionCenter.display(new Teacher(1));
	}
	
	//---------------------------------WELCOME SCREEN----------------------------------------	
	public static void welcomeScreen() throws IOException
	{

		int choice;
		
		//Welcome message image 'picture'.
		final ImageIcon picture = new ImageIcon(new URL("https://i.imgur.com/NWMD6Si.jpg"));
		
		//Setting text for buttons.
		UIManager.put("OptionPane.cancelButtonText", "Exit");
		UIManager.put("OptionPane.okButtonText", "Start");
		
		//Displaying image.
		choice = JOptionPane.showConfirmDialog(null, "", "Electronic Assignment and Attendance Guide", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, picture);
	
	
		//User chooses to exit program.
		if(choice == JOptionPane.CANCEL_OPTION || choice == JOptionPane.CLOSED_OPTION)
		{
			System.exit(1);
		}
		
		else if(choice == JOptionPane.OK_OPTION)
		{
			LoginScreen.display();
		}
		
	}

			
}