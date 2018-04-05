
//Package
package gui;

//Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import db.ConfirmCredentials;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;

//________________________________________________________CLASS SELECT________________________________________________________
public class ClassSelect {
	/**
	 * @wbp.parser.entryPoint
	 */	
	
	//---------------------------------------------------------DISPLAY---------------------------------------------------------
	public static void display()
	{
		//========================OBJECTS========================

		//Jframe
		JFrame frmClass = new JFrame("Class Select");
		frmClass.setResizable(false);
	    frmClass.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	    frmClass.setSize(392,306);
	    
	    //This is the list which contains all of the classes the teacher has access to.
	    DefaultListModel listOfClasses = new DefaultListModel();
	    
	    //TEMPORARY TEMPORARY TEMPORARY TEMPORARY TEMPORARY TEMPORARY TEMPORARY TEMPORARY TEMPORARY TEMPORARY 
	    //Pre-filled class list values.
	    //This is where a query will eventually retrieve a teacher's classes.
	    listOfClasses.addElement("Geography\t(10:30AM - 11:30AM)");
	    listOfClasses.addElement("History III \t(9:45PM - 10:15PM)");
	    listOfClasses.addElement("Advanced Math\t(1:00PM - 1:30PM)");
	    listOfClasses.addElement("Science\t(7:45AM - 10:00AM)");
	    listOfClasses.addElement("Science\t(10:30AM - 11:30AM)");
	    listOfClasses.addElement("Science \t(12:00PM - 1:00PM)");
	    listOfClasses.addElement("Reading\t(12:00PM - 1:00PM)");
	    listOfClasses.addElement("Reading\t(1:00PM - 2:00PM)");
	    listOfClasses.addElement("Drawing\t(10:00AM - 11:00AM)");
	    listOfClasses.addElement("Drawing II \t(10:00AM - 11:00AM)");
	    listOfClasses.addElement("Calculus\t(9:00AM - 10:00AM)");
	    listOfClasses.addElement("Calculus\t(10:30AM - 11:30AM)");
	    listOfClasses.addElement("Art II \t(1:00PM - 1:30PM)");
	    listOfClasses.addElement("Wood Shop\t(2:00PM - 3:00PM)");
	    listOfClasses.addElement("Lunch\t(8:00AM - 10:00AM)");
	    frmClass.getContentPane().setLayout(null);
	    
	    //Scroll Pane
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(10, 11, 366, 209);
	    frmClass.getContentPane().add(scrollPane);
	
	    //Jlist
	    JList classList = new JList(listOfClasses);
	    classList.setFont(new Font("Arial", Font.PLAIN, 16));
	    classList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	    scrollPane.setViewportView(classList);
	    classList.setBackground(Color.WHITE);
        classList.setSelectedIndex(0);
        classList.setVisibleRowCount(3);
        
        //'Select' Button
        JButton btnSelect = new JButton("Select");
        btnSelect.setFont(new Font("Arial", Font.PLAIN, 16));
        btnSelect.setBounds(10, 231, 366, 35);
        btnSelect.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        frmClass.getContentPane().add(btnSelect);
	    
	    //========================ACTIONS========================
        
	    //'Select' button has been clicked.
        btnSelect.addMouseListener(new MouseAdapter()
        {
        	@Override
        	public void mouseReleased(MouseEvent arg0)
        	{
        		//Convert selected class to a string and send it back to the teacher action center.
        		String index = classList.getSelectedValue().toString();
        		TeacherActionCenter.display(index);
				
				//Close class-selection screen.
	    	    frmClass.dispose();
        	}
        });
        
	    //'Enter' key is pressed while a class is selected.
	    classList.addKeyListener(new KeyAdapter()
	    {
	    	@Override
	    	public void keyPressed(KeyEvent e)
	    	{
	    		if (e.getKeyCode()==KeyEvent.VK_ENTER)
	    		{
	        		//Convert selected class to a string and send it back to the teacher action center.
	        		String index = classList.getSelectedValue().toString();
	        		TeacherActionCenter.display(index);
					
					//Close class-selection screen.
		    	    frmClass.dispose();
	    	    }
	    	}
	    });
	    
	    
	    //========================OTHER========================
	    
	  	//IMPORTANT
	  	//This code centers the Jframe in the center of the screen upon creation.
	  	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	  	frmClass.setLocation(dim.width/2-frmClass.getSize().width/2, dim.height/2-frmClass.getSize().height/2);
	  	frmClass.setLocationRelativeTo(null);
	  	
	  	//Frame is displayed.
	  	frmClass.setVisible(true);
	}
}
