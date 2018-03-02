package gui;

import java.util.Scanner;
import java.io.*;
import javax.swing.*;

import user.Teacher;

import java.awt.*;

public class TeacherActionCenter
{

	public static void display(Teacher theTeacher)
	{
		JFrame frame = new JFrame("Welcome, " + theTeacher.getFirstName() + "!");
		
		JTextArea text = new JTextArea(theTeacher.toString());
	    text.setBounds(0, 0, 400, 400);
	    text.setEditable(false);

	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.add(text);
	    frame.setSize(400,400);  
	    frame.setLayout(null);  
	    frame.setVisible(true);
	}
	
}