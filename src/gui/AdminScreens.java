package gui;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class AdminScreens {

	public static void enrollStudent() {
		tempDisplay();
	}

	public static void dropStudent() {
		tempDisplay();
	}

	public static void resetPassword() {
		tempDisplay();
	}

	public static void createClass() {
		tempDisplay();
	}

	public static void removeClass() {
		tempDisplay();
	}

	public static void createTeacher() {
		tempDisplay();
	}

	public static void removeTeacher() {
		tempDisplay();
	}

	public static void createStudent() {
		tempDisplay();
	}

	public static void removeStudent() {
		tempDisplay();
	}
	
	private static void tempDisplay()
	{
		JFrame frame = new JFrame("this is just a placeholder");
		
		JTextArea text = new JTextArea("I'm just writing things");
	    text.setBounds(0, 0, 400, 400);
	    text.setEditable(false);

	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.add(text);
	    frame.setSize(400,400);  
	    frame.setLayout(null);  
	    frame.setVisible(true);
	}
}
