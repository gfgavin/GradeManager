package gui;

import java.util.Scanner;
import java.io.*;
import javax.swing.*;

import controllers.DefaultController;
import db.AssignmentQueries;
import user.Teacher;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherActionCenter
{

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void display()
	{
		JFrame frame = new JFrame("Welcome, " + DefaultController.teacherFirstName() + "!");
		
		JTextArea textBox = new JTextArea(DefaultController.teacherToString());
	    textBox.setBounds(201, 131, 505, 346);
	    textBox.setEditable(false);

	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.getContentPane().add(textBox);
	    frame.setSize(732,527);  
	    frame.getContentPane().setLayout(null);
	    
	    JButton btnNewButton = new JButton("Create Assignment");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		textBox.setText("YO");
	    		JOptionPane.showMessageDialog(null , "yeah");
	    	}
	    });
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
	    label.setBounds(0, -15, 743, 526);
	    frame.getContentPane().add(label);
	    frame.setVisible(true);
	}
}