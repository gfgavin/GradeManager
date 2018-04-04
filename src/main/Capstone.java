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
		
		//TestFunctionsWithoutGUI program = new TestFunctionsWithoutGUI();
		//program.test();
		
		
		//Allowing keyboard input.
		//Scanner keyboard = new Scanner(System.in);
		
		//Welcome Screen
		LoginScreen.display();
		
		/*
		 * to launch an action center directly, comment out welcomeScreen() above,
		 * and uncomment the action center you want the program to launch
		 */
		//AdminActionCenter.display(new Administrator(1));
		//StudentActionCenter.display(new Student(1));
		//TeacherActionCenter.display(new Teacher(1));
	}
			
}