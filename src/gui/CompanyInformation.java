
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

//________________________________________________________Comapny Information________________________________________________________
public class CompanyInformation {
	/**
	 * @wbp.parser.entryPoint
	 */	
	
	//---------------------------------------------------------DISPLAY---------------------------------------------------------
	public static void display()
	{
		//========================OBJECTS========================

		//Jframe
		JFrame frmDetails = new JFrame("Company Information");
		frmDetails.setResizable(false);
	    frmDetails.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	    frmDetails.setSize(392,306);
	    
	    
	    //========================ACTIONS========================
        
	    
	    //========================OTHER========================
	    
	  	//IMPORTANT
	  	//This code centers the Jframe in the center of the screen upon creation.
	  	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	  	frmDetails.setLocation(dim.width/2-frmDetails.getSize().width/2, dim.height/2-frmDetails.getSize().height/2);
	  	frmDetails.setLocationRelativeTo(null);
	  	frmDetails.getContentPane().setLayout(null);
	  	
	  	JLabel lblABunchOf = new JLabel("A BUNCH OF COMPANY INFORMATION WILL GO HERE");
	  	lblABunchOf.setBounds(26, 11, 333, 242);
	  	frmDetails.getContentPane().add(lblABunchOf);
	  	
	  	//Frame is displayed.
	  	frmDetails.setVisible(true);
	}
}
