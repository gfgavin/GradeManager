package gui;

import java.util.Scanner;
import java.io.*;
import javax.swing.*;

import controllers.DefaultController;
import db.AssignmentQueries;
import db.ConfirmCredentials;
import user.Teacher;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeacherActionCenter
{

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void display()
	{
		
		//========================OBJECTS========================
		
		//Jframe
		JFrame frmTeacher = new JFrame("Welcome, " + DefaultController.teacherFirstName() + "!");
		frmTeacher.setResizable(false);
		JTextArea textBox = new JTextArea(DefaultController.teacherToString());
	    textBox.setBounds(280, 204, 436, 283);
	    textBox.setEditable(false);
	    frmTeacher.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frmTeacher.getContentPane().add(textBox);
	    frmTeacher.setSize(732,527);  
	    frmTeacher.getContentPane().setLayout(null);
	    
	    //'Take Attendance' Button
	    JButton btnTakeAttendance = new JButton("Take Attendance");
	    btnTakeAttendance.setFont(new Font("Arial", Font.PLAIN, 14));
	    btnTakeAttendance.setBounds(89, 204, 181, 41);
	    frmTeacher.getContentPane().add(btnTakeAttendance);
	    
	    //'Class Select' Button
	    JButton btnClassSelect = new JButton("Class Select");
	    btnClassSelect.setFont(new Font("Arial", Font.PLAIN, 14));
	    btnClassSelect.setBounds(10, 105, 181, 41);
	    frmTeacher.getContentPane().add(btnClassSelect);
	    
	    //'Create Assignment' Button
	    JButton btnCreateAssignment = new JButton("Create Assignment");
	    btnCreateAssignment.setFont(new Font("Arial", Font.PLAIN, 14));
	    btnCreateAssignment.setBounds(89, 256, 181, 41);
	    frmTeacher.getContentPane().add(btnCreateAssignment);
	    
	    //'Grade Assignment' Button
	    JButton btnGradeAssignment = new JButton("Grade Assignment");
	    btnGradeAssignment.setFont(new Font("Arial", Font.PLAIN, 14));
	    btnGradeAssignment.setBounds(89, 308, 181, 41);
	    frmTeacher.getContentPane().add(btnGradeAssignment);
	    
	    //Logout Button
	    JButton btnLogout = new JButton("Log Out");
	    btnLogout.setFont(new Font("Arial", Font.PLAIN, 14));
	    btnLogout.setBounds(10, 436, 181, 41);
	    frmTeacher.getContentPane().add(btnLogout);
	    
	    //'Current Class Selected:' Label
	    JLabel lblText = new JLabel("Current Class Selected:");
	    lblText.setFont(new Font("Arial", Font.PLAIN, 14));
	    lblText.setHorizontalAlignment(SwingConstants.CENTER);
	    lblText.setBounds(214, 92, 301, 28);
	    frmTeacher.getContentPane().add(lblText);
	    
	    //Current Class Display Label
	    JLabel lblCurrentClass = new JLabel("CIS 4595 (Monday at 5PM)");
	    lblCurrentClass.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    lblCurrentClass.setHorizontalAlignment(SwingConstants.CENTER);
	    lblCurrentClass.setOpaque(true);
	    lblCurrentClass.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	    lblCurrentClass.setForeground(Color.BLACK);
	    lblCurrentClass.setBackground(Color.WHITE);
	    lblCurrentClass.setBounds(214, 118, 301, 28);
	    frmTeacher.getContentPane().add(lblCurrentClass);
	    
	    //Background Image
	    JLabel lblBackgroundImage = new JLabel("");
	    lblBackgroundImage.setIcon(new ImageIcon(TeacherActionCenter.class.getResource("/images/teacher.png")));
	    lblBackgroundImage.setBounds(0, -15, 743, 526);
	    frmTeacher.getContentPane().add(lblBackgroundImage);
	    
		//========================ACTIONS========================
	    
	    //'Log Out' button has been clicked.
	    //Returns the user to the login screen.
	    btnLogout.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseReleased(MouseEvent arg0) {
	    		//Teacher action center is closed.
	    		frmTeacher.dispose();
	    		
	    		//Login screen is opened.
	    		LoginScreen.display();
	    	}
	    });
	    
	    //'Enter' key is pressed while the 'Log Out' button is tab-selected.
	    btnLogout.addKeyListener(new KeyAdapter() {
	    	@Override
	    	public void keyPressed(KeyEvent e) {
	    		if (e.getKeyCode()==KeyEvent.VK_ENTER){
		    		//Teacher action center is closed.
		    		frmTeacher.dispose();
		    		
		    		//Login screen is opened.
		    		LoginScreen.display();
	    	    }
	    	}
	    });
	    
		//========================OTHER========================
	    
		//IMPORTANT
	    //This code centers the Jframe in the center of the screen upon creation.
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frmTeacher.setLocation(dim.width/2-frmTeacher.getSize().width/2, dim.height/2-frmTeacher.getSize().height/2);
		frmTeacher.setLocationRelativeTo(null);
		frmTeacher.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnClassSelect, btnTakeAttendance, btnCreateAssignment, btnGradeAssignment, btnLogout}));
	    
		//Frame is displayed.
	    frmTeacher.setVisible(true);
	}
}