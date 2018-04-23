package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import user.Teacher;

public class TeacherQueries {
	private static Connection connection = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;

	public static ArrayList<Teacher> getAllTeachers() {
		ArrayList<Teacher> teacherlist = new ArrayList<Teacher>();
		try {
			connect();
			pstmt = connection.prepareStatement("SELECT * FROM Teacher");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setTeacherID(rs.getInt("teacherid"));
				teacher.setFirstName(rs.getString("firstname"));
				teacher.setLastName(rs.getString("lastname"));
				teacher.setUserName(rs.getString("userlogin"));
				teacherlist.add(teacher);
			}

		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
		return teacherlist;
	}

	public static Teacher getTeacher(String username) {
		Teacher teacher = new Teacher();
		try {
			connect();
			pstmt = connection.prepareStatement("SELECT * FROM Teacher WHERE userlogin  = '" + username + "'");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				teacher.setTeacherID(rs.getInt("teacherid"));
				teacher.setFirstName(rs.getString("firstname"));
				teacher.setLastName(rs.getString("lastname"));
				teacher.setUserName(rs.getString("userlogin"));
			}

		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
		return teacher;
	}

	public static Teacher getTeacher(int teacherid) {
		Teacher teacher = new Teacher();
		try {
			connect();
			pstmt = connection.prepareStatement("SELECT * FROM Teacher WHERE teacherid  = " + teacherid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				teacher.setTeacherID(rs.getInt("teacherid"));
				teacher.setFirstName(rs.getString("firstname"));
				teacher.setLastName(rs.getString("lastname"));
				teacher.setUserName(rs.getString("userlogin"));
			}

		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
		return teacher;
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
