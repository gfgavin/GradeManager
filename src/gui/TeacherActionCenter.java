package gui;

import java.util.Scanner;
import java.io.*;
import javax.swing.*;

import controllers.DefaultController;
import user.Teacher;

import java.awt.*;

public class TeacherActionCenter
{

	public static void display()
	{
		JFrame frame = new JFrame("Welcome, " + DefaultController.teacherFirstName() + "!");
		
		JTextArea text = new JTextArea(DefaultController.teacherToString());
	    text.setBounds(0, 0, 400, 400);
	    text.setEditable(false);

	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.add(text);
	    frame.setSize(400,400);  
	    frame.setLayout(null);  
	    frame.setVisible(true);
	}
	
}