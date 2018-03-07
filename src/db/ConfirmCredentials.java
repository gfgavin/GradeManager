package db;
import java.util.Scanner;
import java.io.*;
import javax.swing.*;

import controllers.DefaultController;
import gui.*;
import user.*;

import java.awt.*;

public class ConfirmCredentials
{
	public static void credentials(String username, String password)
	{
		//THIS IS WHERE WE WILL CHECK WITH THE DATABASE TO CONFIRM THE USER'S CREDENTIALS.
		//If the credentials match up, the user is taken to their respective action center.
		//For now, we will use these placeholder logins.
		if (username.equals("admin"))
		{
			DefaultController.init();
			AdminActionCenter.display();
		}
		//need to refactor teacher and student so that gui code does not have user objects
		else if (username.equals("teacher"))
		{
			TeacherActionCenter.display(new Teacher(1));
		}
		else if (username.equals("student"))
		{
			StudentActionCenter.display(new Student(1));
		}
		else
		{
			LoginScreen.display();
		}
	}
}