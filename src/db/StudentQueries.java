package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import user.Student;

public class StudentQueries {
	private static Connection connection = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;
	

	public static ArrayList<Student> getAllStudents() {
		ArrayList<Student> studentlist = new ArrayList<Student>();
		try {
			connect();
			pstmt = connection.prepareStatement("SELECT * FROM Student");
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				Student student = new Student();
				student.setStudentID(rs.getInt("studentid"));
				student.setFirstName(rs.getString("firstname"));
				student.setLastName(rs.getString("lastname"));
				student.setUserName(rs.getString("userlogin"));
				studentlist.add(student);
			}
			
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
		return studentlist;
	}

	public static Student getStudent(String username) {
		Student student = new Student();
		try {
			connect();
			pstmt = connection.prepareStatement("SELECT * FROM Student WHERE userlogin  = '" + username + "'");
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				student.setStudentID(rs.getInt("studentid"));
            	student.setFirstName(rs.getString("firstname"));
            	student.setLastName(rs.getString("lastname"));
            	student.setUserName(rs.getString("userlogin"));
			}
			
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
		return student;
	}


	public static Student getStudent(int studentid) {
		Student student = new Student();
		try {
			connect();
			pstmt = connection.prepareStatement("SELECT * FROM Student WHERE studentid  = " + studentid);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				student.setStudentID(rs.getInt("studentid"));
            	student.setFirstName(rs.getString("firstname"));
            	student.setLastName(rs.getString("lastname"));
            	student.setUserName(rs.getString("userlogin"));
			}
			
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
		return student;
	}
	

        
        private static void connect() throws SQLException
        {
            //connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
            connection = DataSource.getInstance().getConnection();
        }	
	


	private static void closeConnection() {
		try {
			rs.close();
		} catch (Exception e) {
			/* ignored */ }
		try {
			pstmt.close();
		} catch (Exception e) {
			/* ignored */ }
		try {
			connection.close();
		} catch (Exception e) {
			/* ignored */ }
	}
}
