package main;

import controllers.*;
import db.ConfirmCredentials;
import utilities.Input;

public class TestFunctionsWithoutGUI {
	private AdminController adminController;
	private TeacherController teacherController;
	private StudentController studentController;

	public void test() {
		System.out.println("Are you a teacher, student, or administrator?\n"
				+ "1 - administrator\n"
				+ "2 - teacher\n"
				+ "3 - student");
		int selection = Input.validInt(1, 3);
		
		String userType = "";
		if(selection == 1) {userType = "Admin";}
		else if(selection == 2) {userType = "Teacher";}
		else if(selection == 3) {userType = "Student";}
		
		System.out.println("Please enter your username:");
		String username = Input.validString(30);

		System.out.println("Please enter your password:");
		String password = Input.validString(30);
		
		
		boolean userNameAndPasswordMatch = ConfirmCredentials.confirmUser(userType, username, password);
		if(userNameAndPasswordMatch)
		{
			System.out.println("LOG IN SUCCESSFUL!!\n");
			if(userType.equals("Admin"))
			{
				adminController = new AdminController(username);
				doAdminStuff();
			}
			else if(userType.equals("Teacher"))
			{
				teacherController = new TeacherController(username);
				doTeacherStuff();
			}
			else if(userType.equals("Student"))
			{
				studentController = new StudentController(username);
				doStudentStuff();
			}
		}
		else
		{
			System.out.println("unsuccessful login");
			
		}
	}

	private void doAdminStuff() {
		System.out.println(adminController.toString());
	}

	private void doTeacherStuff() {
		System.out.println(teacherController.toString());
	}

	private void doStudentStuff() {
		System.out.println(studentController.toString());
	}
}
