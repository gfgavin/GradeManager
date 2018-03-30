package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import course.Course;

public class CourseQueries {
	private static Connection connection = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;

	public static ArrayList<Course> getAllCourses() {
		ArrayList<Course> courselist = new ArrayList<Course>();
		try {
			connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
			pstmt = connection.prepareStatement("SELECT * FROM Course");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Course course = new Course();
				course.setCourseID(rs.getInt("courseid"));
				course.setCoursename(rs.getString("coursename"));
				course.setTime(rs.getString("time"));
				course.setTeacher(TeacherQueries.getTeacher(rs.getInt("teacherid")));
				
				//to also get all of the assignments, including grades:
				//course.setAssignmentList(AssignmentQueries.getCourseAssignmentsAndGrades(rs.getInt("courseid")));
				
				courselist.add(course);
			}

		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
		return courselist;
	}

	public static ArrayList<Course> getCoursesForTeacher(int teacherID) {
		ArrayList<Course> courselist = new ArrayList<Course>();
		try {
			connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
			pstmt = connection.prepareStatement("SELECT * FROM Course WHERE teacherid = " + teacherID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Course course = new Course();
				course.setCourseID(rs.getInt("courseid"));
				course.setCoursename(rs.getString("coursename"));
				course.setTime(rs.getString("time"));
				//course.setTeacher(TeacherQueries.getTeacher(rs.getInt("teacherid")));
				
				//to also get all of the assignments, including grades:
				course.setAssignmentList(AssignmentQueries.getCourseAssignmentsAndGrades(rs.getInt("courseid")));
				
				courselist.add(course);
			}

		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
		return courselist;
	}

	public static ArrayList<Course> getCoursesForStudent(int studentid) {
		ArrayList<Course> courselist = new ArrayList<Course>();

		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		try {
			connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
			pstmt = connection.prepareStatement("SELECT * FROM StudentCourse WHERE studentid = " + studentid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int courseid = rs.getInt("courseid");
				
				pstmt2 = connection
						.prepareStatement("SELECT * FROM Course WHERE courseid = " + courseid);
				rs2 = pstmt2.executeQuery();
				while (rs2.next()) {
					//ArrayList<Assignment> assignmentList = new ArrayList<Assignment>();
					Course course = new Course();
					
					course.setCoursename(rs2.getString("coursename"));
					course.setTime(rs2.getString("time"));
					course.setAssignmentList(AssignmentQueries.getStudentAssignmentsForACourse(courseid, studentid));

					courselist.add(course);
				}
			}

		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
		return courselist;
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
