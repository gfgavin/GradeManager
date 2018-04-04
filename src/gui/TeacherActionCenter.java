package gui;

import java.util.Scanner;
import java.io.*;
import javax.swing.*;

import controllers.DefaultController;
import user.Teacher;

import java.awt.*;

public class TeacherActionCenter
{

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void display()
	{
		JFrame frame = new JFrame("Welcome, " + DefaultController.teacherFirstName() + "!");
		
		JTextArea text = new JTextArea(DefaultController.teacherToString());
	    text.setBounds(201, 127, 505, 350);
	    text.setEditable(false);

	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.getContentPane().add(text);
	    frame.setSize(732,527);  
	    frame.getContentPane().setLayout(null);
	    
	    JButton btnNewButton = new JButton("Create Assignment");
	    btnNewButton.setBounds(10, 183, 181, 41);
	    frame.getContentPane().add(btnNewButton);
	    
	    JButton btnTakeAttendance = new JButton("Take Attendance");
	    btnTakeAttendance.setBounds(10, 131, 181, 41);
	    frame.getContentPane().add(btnTakeAttendance);
	    
	    JButton btnGradeAssignment = new JButton("Grade Assignment");
	    btnGradeAssignment.setBounds(10, 235, 181, 41);
	    frame.getContentPane().add(btnGradeAssignment);
	    
	    JLabel label = new JLabel("");
	    label.setIcon(new ImageIcon(TeacherActionCenter.class.getResource("/images/teacher.png")));
	    label.setBounds(0, 0, 743, 511);
	    frame.getContentPane().add(label);
	    frame.setVisible(true);
	}
}