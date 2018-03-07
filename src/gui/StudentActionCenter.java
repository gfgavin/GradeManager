package gui;

import java.util.Scanner;
import java.io.*;
import javax.swing.*;

import controllers.DefaultController;
import user.Student;

import java.awt.*;

public class StudentActionCenter
{

	public static void display()
	{
		JFrame frame = new JFrame("Welcome, " + DefaultController.studentFirstName() + "!");
		
		JTextArea text = new JTextArea(DefaultController.studentToString());
	    text.setBounds(0, 0, 400, 400);
	    text.setEditable(false);

	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.add(text);
	    frame.setSize(400,400);  
	    frame.setLayout(null);  
	    frame.setVisible(true);
	}
	
}