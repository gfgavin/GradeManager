package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminQueries {
	private static Connection connection = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;

	public static void createTeacher(String firstname, String lastname, String userlogin, String userpass) {
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://capstone.clsnwlfmobom.us-east-2.rds.amazonaws.com:3306/CapstoneDB", "team1capstone",
					"team1pass");
			pstmt = connection.prepareStatement(
					"INSERT INTO Teacher (firstname, lastname, userlogin, userpass) VALUES (?,?,?,?)");
			pstmt.setString(1, firstname);
			pstmt.setString(2, lastname);
			pstmt.setString(3, userlogin);
			pstmt.setString(4, userpass);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
	}

	public static void createStudent(String firstname, String lastname, String userlogin, String userpass) {
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://capstone.clsnwlfmobom.us-east-2.rds.amazonaws.com:3306/CapstoneDB", "team1capstone",
					"team1pass");
			pstmt = connection.prepareStatement(
					"INSERT INTO Student (firstname, lastname, userlogin, userpass) VALUES (?,?,?,?)");
			pstmt.setString(1, firstname);
			pstmt.setString(2, lastname);
			pstmt.setString(3, userlogin);
			pstmt.setString(4, userpass);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
	}

	public static void createClass(String classname, String time) {
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://capstone.clsnwlfmobom.us-east-2.rds.amazonaws.com:3306/CapstoneDB", "team1capstone",
					"team1pass");
			pstmt = connection.prepareStatement("INSERT INTO Class (classname, time, teacherid) VALUES (?,?,?)");
			pstmt.setString(1, classname);
			pstmt.setString(2, time);
			pstmt.setString(3, null);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
	}

	public static void removeTeacher(int teacherid) {
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://capstone.clsnwlfmobom.us-east-2.rds.amazonaws.com:3306/CapstoneDB", "team1capstone",
					"team1pass");
			pstmt = connection.prepareStatement("DELETE FROM Teacher WHERE teacherid = " + teacherid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
	}

	public static void removeStudent(int studentid) {
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://capstone.clsnwlfmobom.us-east-2.rds.amazonaws.com:3306/CapstoneDB", "team1capstone",
					"team1pass");
			pstmt = connection.prepareStatement("DELETE FROM Student WHERE studentid = " + studentid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
	}

	public static void removeClass(int classid) {
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://capstone.clsnwlfmobom.us-east-2.rds.amazonaws.com:3306/CapstoneDB", "team1capstone",
					"team1pass");
			pstmt = connection.prepareStatement("DELETE FROM Class WHERE classid = " + classid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
	}

	public static void addTeacherToClass(int classid, int teacherid) {
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://capstone.clsnwlfmobom.us-east-2.rds.amazonaws.com:3306/CapstoneDB", "team1capstone",
					"team1pass");
			pstmt = connection
					.prepareStatement("UPDATE Class SET teacherid = " + teacherid + " WHERE classid = " + classid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
	}

	public static void removeTeacherFromClass(int classid) {
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://capstone.clsnwlfmobom.us-east-2.rds.amazonaws.com:3306/CapstoneDB", "team1capstone",
					"team1pass");
			pstmt = connection.prepareStatement("UPDATE Class SET teacherid = " + null + " WHERE classid = " + classid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
	}

	public static void enrollStudentInClass(int studentid, int classid) {
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://capstone.clsnwlfmobom.us-east-2.rds.amazonaws.com:3306/CapstoneDB", "team1capstone",
					"team1pass");
			pstmt = connection.prepareStatement("INSERT INTO StudentClass VALUES (" + studentid + ", " + classid + ")");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
	}

	public static void dropStudentFromClass(int studentid, int classid) {
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://capstone.clsnwlfmobom.us-east-2.rds.amazonaws.com:3306/CapstoneDB", "team1capstone",
					"team1pass");
			pstmt = connection.prepareStatement(
					"DELETE FROM StudentClass WHERE studentid = " + studentid + " AND classid = " + classid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
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
