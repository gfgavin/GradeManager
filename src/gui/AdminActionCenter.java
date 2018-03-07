package gui;

import java.util.Scanner;
import java.io.*;
import javax.swing.*;

import controllers.DefaultController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminActionCenter
{

	public static void display()
	{		
		/*
		 * Administrator Action Center
			After clicking the ‘Login’ button, usernames associated with administrator
			accounts will be taken to this screen.
			This screen has the following elements:
			• Text at the top of the screen which welcomes the user to their action
			center by their first name.
			• An ‘Enroll Student in Class’ button, which will take the user to the Enroll
			Student screen.
			• A ‘Drop Student from Class’ button, which will take the user to the Drop
			Student screen.
			• A ‘Reset A User’s Password’ button, which will take the user to the
			Reset Password screen.
			• A ‘Create Class’ button, which will take the user to the Create Class
			screen.
			• A ‘Remove Class’ button, which will take the user to the Remove Class
			screen.
			• A ‘Create Teacher’ button, which will take the user to the Create
			Teacher screen.
			• A ‘Remove Teacher’ button, which will take the user to the Remove
			Teacher screen.
			• A ‘Create Student’ button, which will take the user to the Create Student
			screen.
			• A ‘Remove Student’ button, which will take the user to the Remove
			Student screen.
			• A ‘Secure Logout’ button, which will return the user to the login screen
			and prompt a ‘You have successfully logged out’ popup window..
			• A red ‘exit’ button in the top-right corner of the window, which will exit
			the program.

		 */	
	
		JFrame adminFrame = new JFrame("Welcome, " + DefaultController.adminFirstName() + "!");		
		
		JButton enrollButton= new JButton("Enroll Student in Class"); 
		enrollButton.setBounds(0,0,385,30);
	    enrollButton.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	            AdminScreens.enrollStudent();
	        }  
	    }); 
	    
	    JButton dropButton= new JButton("Drop Student from Class"); 
		dropButton.setBounds(0,30,385,30);
	    dropButton.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		AdminScreens.dropStudent();
	        }  
	    }); 
	    
	    JButton resetPWButton= new JButton("Reset a Password"); 
		resetPWButton.setBounds(0,60,385,30);
	    resetPWButton.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		AdminScreens.resetPassword();
	        }  
	    }); 
	    
	    JButton createClassButton= new JButton("Create a Class"); 
		createClassButton.setBounds(0,90,385,30);
	    createClassButton.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		AdminScreens.createClass();
	        }  
	    }); 
	    
	    JButton removeClassButton= new JButton("Remove a Class"); 
		removeClassButton.setBounds(0,120,385,30);
	    removeClassButton.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		AdminScreens.removeClass();
	        }  
	    }); 
	    
	    JButton createTeacherButton= new JButton("Create a Teacher"); 
		createTeacherButton.setBounds(0,150,385,30);
	    createTeacherButton.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		AdminScreens.createTeacher();
	        }  
	    }); 
	    
	    JButton removeTeacherButton= new JButton("Remove a Teacher"); 
		removeTeacherButton.setBounds(0,180,385,30);
	    removeTeacherButton.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		AdminScreens.removeTeacher();
	        }  
	    }); 
	    
	    JButton createStudentButton= new JButton("Create a Student"); 
		createStudentButton.setBounds(0,210,385,30);
	    createStudentButton.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		AdminScreens.createStudent();
	        }  
	    }); 
	    
	    JButton removeStudentButton= new JButton("Remove a Student"); 
		removeStudentButton.setBounds(0,240,385,30);
	    removeStudentButton.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		AdminScreens.removeStudent();
	        }  
	    }); 
	    
	    JButton logoutButton= new JButton("Logout"); 
		logoutButton.setBounds(0,270,385,30);
	    logoutButton.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		LoginScreen.display();
	        }  
	    }); 
	    
	    JTextArea bottomText = new JTextArea(DefaultController.adminToString());
	    bottomText.setBounds(0, 300, 385, 100);
	    bottomText.setEditable(false);

	    adminFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		adminFrame.add(enrollButton);
		adminFrame.add(dropButton);
		adminFrame.add(resetPWButton);
		adminFrame.add(createClassButton);
		adminFrame.add(removeClassButton);
		adminFrame.add(createTeacherButton);
		adminFrame.add(removeTeacherButton);
		adminFrame.add(createStudentButton);
		adminFrame.add(removeStudentButton);
		adminFrame.add(logoutButton);
		adminFrame.add(bottomText);
		adminFrame.setSize(400,400);  
		adminFrame.setLayout(null);  
		adminFrame.setVisible(true);
	}
	
}