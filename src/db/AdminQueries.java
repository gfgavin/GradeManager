package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import user.Administrator;

public class AdminQueries {
	private static Connection connection = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;

	public static Administrator getAdmin(String username) {
		Administrator admin = new Administrator();
		try {
			connect();
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
			connect();
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
			connect();
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
			connect();
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

	public static void deleteTeacher(int teacherid) {
		try {
			connect();
			pstmt = connection.prepareStatement("DELETE FROM Teacher WHERE teacherid = " + teacherid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
	}

	public static void deleteStudent(int studentid) {
		try {
			connect();
			pstmt = connection.prepareStatement("DELETE FROM Student WHERE studentid = " + studentid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
	}

	public static void deleteCourse(int courseid) {
		try {
			connect();
			pstmt = connection.prepareStatement("DELETE FROM Course WHERE courseid = " + courseid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
	}

	public static void addTeacherToCourse(int teacherid, int courseid) {
		try {
			connect();
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
			connect();
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
			connect();
			pstmt = connection.prepareStatement("INSERT INTO StudentCourse VALUES (" + studentid + ", " + courseid + ")");
			pstmt.executeUpdate();
			
			//get the assignments from the course
			pstmt = connection.prepareStatement("SELECT assignmentid FROM Assignment WHERE courseid = " + courseid);
			rs = pstmt.executeQuery();
			ArrayList<Integer> assignmentidlist = new ArrayList<Integer>();
			while(rs.next())
			{
				assignmentidlist.add(rs.getInt("assignmentid"));
			}
			
			//add entries for each of the assignments for the student
			for(int assignmentid : assignmentidlist)
			{
				pstmt = connection.prepareStatement(
						"INSERT INTO StudentAssignment (studentid, assignmentid) VALUES (?, ?)");
				pstmt.setInt(1, studentid);
				pstmt.setInt(2, assignmentid);
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
	}

	public static void dropStudentFromCourse(int studentid, int courseid) {
		try {
			connect();
			pstmt = connection.prepareStatement(
					"DELETE FROM StudentCourse WHERE studentid = " + studentid + " AND courseid = " + courseid);
			pstmt.executeUpdate();
			
			//get the assignments from the course
			pstmt = connection.prepareStatement("SELECT assignmentid FROM Assignment WHERE courseid = " + courseid);
			rs = pstmt.executeQuery();
			ArrayList<Integer> assignmentidlist = new ArrayList<Integer>();
			while(rs.next())
			{
				assignmentidlist.add(rs.getInt("assignmentid"));
			}
			
			//remove entries for each of the assignments for the student
			for(int assignmentid : assignmentidlist)
			{
				pstmt = connection.prepareStatement(
						"DELETE FROM StudentAssignment WHERE studentid = ? AND assignmentid = ?");
				pstmt.setInt(1, studentid);
				pstmt.setInt(2, assignmentid);
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
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
