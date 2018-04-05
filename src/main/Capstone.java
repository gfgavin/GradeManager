
//Package
package main;

//Imports
import gui.*;
import user.*;
import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.net.*;

//________________________________________________________CAPSTONE (MAIN PROGRAM)________________________________________________________
public class Capstone
{
	//---------------------------------------------------------MAIN---------------------------------------------------------
	public static void main(String[] args) throws IOException
	{
		//DEVELOPMENT AND TESTING PURPOSES:
		//(((Uncomment below to launch.)))
		//--------------------------------------------------------
		//TestFunctionsWithoutGUI program = new TestFunctionsWithoutGUI();
		//program.test();
		
		//Display Login Screen
		LoginScreen.display();
		
		//ACTION CENTER TESTING:
		//(((Uncomment action center below to launch it directly.)))
		//--------------------------------------------------------
		//AdminActionCenter.display(new Administrator(1));
		//StudentActionCenter.display(new Student(1));
		//TeacherActionCenter.display(new Teacher(1));
	}
			
}
