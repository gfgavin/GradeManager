package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import user.Administrator;

public class AdminQueries {
	private static Connection connection = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;

	public static Administrator getAdmin(String username) {
		Administrator admin = new Administrator();
		try {
			connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
			pstmt = connection.prepareStatement("SELECT * FROM Admin WHERE userlogin  = '" + username + "'");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				admin.setAdminId(rs.getInt("adminid"));
				admin.setFirstName(rs.getString("firstname"));
				admin.setLastName(rs.getString("lastname"));
				admin.setUserName(rs.getString("userlogin"));
			}

		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
		return admin;
	}

	public static void createTeacher(String firstname, String lastname, String userlogin, String userpass) {
		try {
			connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
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
			connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
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

	public static void createCourse(String coursename, String time) {
		try {
			connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
			pstmt = connection.prepareStatement("INSERT INTO Course (coursename, time, teacherid) VALUES (?,?,?)");
			pstmt.setString(1, coursename);
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
			connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
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
			connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
			pstmt = connection.prepareStatement("DELETE FROM Student WHERE studentid = " + studentid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
	}

	public static void removeCourse(int courseid) {
		try {
			connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
			pstmt = connection.prepareStatement("DELETE FROM Course WHERE courseid = " + courseid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
	}

	public static void addTeacherToCourse(int courseid, int teacherid) {
		try {
			connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
			pstmt = connection
					.prepareStatement("UPDATE Course SET teacherid = " + teacherid + " WHERE courseid = " + courseid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
	}

	public static void removeTeacherFromCourse(int courseid) {
		try {
			connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
			pstmt = connection
					.prepareStatement("UPDATE Course SET teacherid = " + null + " WHERE courseid = " + courseid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
	}

	public static void enrollStudentInCourse(int studentid, int courseid) {
		try {
			connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
			pstmt = connection.prepareStatement("INSERT INTO StudentCourse VALUES (" + studentid + ", " + courseid + ")");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
	}

	public static void dropStudentFromCourse(int studentid, int courseid) {
		try {
			connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
			pstmt = connection.prepareStatement(
					"DELETE FROM StudentCourse WHERE studentid = " + studentid + " AND courseid = " + courseid);
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
