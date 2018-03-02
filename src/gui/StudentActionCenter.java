package gui;

import java.util.Scanner;
import java.io.*;
import javax.swing.*;

import user.Student;

import java.awt.*;

public class StudentActionCenter
{

	public static void display(Student theStudent)
	{
		JFrame frame = new JFrame("Welcome, " + theStudent.getFirstName() + "!");
		
		JTextArea text = new JTextArea(theStudent.toString());
	    text.setBounds(0, 0, 400, 400);
	    text.setEditable(false);

	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.add(text);
	    frame.setSize(400,400);  
	    frame.setLayout(null);  
	    frame.setVisible(true);
	}
	
}