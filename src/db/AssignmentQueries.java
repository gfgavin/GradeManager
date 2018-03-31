package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import course.Assignment;

public class AssignmentQueries {
	private static Connection connection = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;

	public static ArrayList<Assignment> getCourseAssignmentsAndGrades(int courseid) {
		ArrayList<Assignment> courseAssignmentList = new ArrayList<Assignment>();

		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		try {
			connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
			pstmt = connection.prepareStatement("SELECT * FROM Assignment WHERE courseid = " + courseid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int assignmentID = rs.getInt("assignmentid");
				String title = rs.getString("title");

				pstmt2 = connection
						.prepareStatement("SELECT * FROM StudentAssignment WHERE assignmentid = " + assignmentID);
				rs2 = pstmt2.executeQuery();
				while (rs2.next()) {
					Assignment assignment = new Assignment();

					assignment.setAssignmentID(assignmentID);
					assignment.setTitle(title);
					assignment.setGrade(rs2.getInt("grade"));
					assignment.setStudent(StudentQueries.getStudent(rs2.getInt("studentid")));

					courseAssignmentList.add(assignment);
				}
			}

		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			try {
				rs2.close();
			} catch (Exception e) {
				/* ignored */ }
			try {
				pstmt2.close();
			} catch (Exception e) {
				/* ignored */ }
			closeConnection();
		}
		return courseAssignmentList;
	}
	
	
	public static ArrayList<Assignment> getStudentAssignmentsForACourse(int courseid, int studentid) {
		ArrayList<Assignment> courseAssignmentList = new ArrayList<Assignment>();

		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		try {
			connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
			pstmt = connection.prepareStatement("SELECT * FROM Assignment WHERE courseid = " + courseid);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int assignmentID = rs.getInt("assignmentid");
				String title = rs.getString("title");

				pstmt2 = connection
						.prepareStatement("SELECT * FROM StudentAssignment WHERE assignmentid = " + assignmentID
								+ " AND studentid = " + studentid);
				rs2 = pstmt2.executeQuery();
				while (rs2.next()) {
					Assignment assignment = new Assignment();

					assignment.setAssignmentID(assignmentID);
					assignment.setTitle(title);
					assignment.setGrade(rs2.getInt("grade"));

					courseAssignmentList.add(assignment);
				}
			}

		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			try {
				rs2.close();
			} catch (Exception e) {
				/* ignored */ }
			try {
				pstmt2.close();
			} catch (Exception e) {
				/* ignored */ }
			closeConnection();
		}
		return courseAssignmentList;
	}
	
	
	/**
	 * create an assignment with the given title for the given course in the "Assignment" table, 
	 * and create entries for each of the students in the course in the "StudentAssignment" table
	 * 
	 * @param courseid
	 * @param title
	 */
	public static void createAssignment(int courseid, String title) {
		try {
			connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
			pstmt = connection.prepareStatement(
					"INSERT INTO Assignment (courseid, title) VALUES (?, ?)");
			pstmt.setInt(1, courseid);
			pstmt.setString(2, title);
			pstmt.executeUpdate();
			pstmt.close();
			
			//get the assignmentid of the newly added assignment
			pstmt = connection.prepareStatement(
					"SELECT assignmentid FROM Assignment WHERE courseid = " + courseid + " AND title = '" + title + "'");
			rs = pstmt.executeQuery();
			int assignmentid = -1;
			while(rs.next())
			{
				assignmentid = rs.getInt("assignmentid");
			}
			pstmt.close();
			rs.close();
			
			//get list of students enrolled in the course
			pstmt = connection.prepareStatement(
					"SELECT * FROM StudentCourse WHERE courseid = " + courseid);
			rs = pstmt.executeQuery();
			ArrayList<Integer> studentidlist = new ArrayList<Integer>();
			while (rs.next()) {
				int studentid = rs.getInt("studentid");
				studentidlist.add(studentid);
			}
			pstmt.close();
			
			//add assignments to the studentassignment table for each student in the course
			for(int studentid : studentidlist)
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
	

	public static void deleteAssignment(int assignmentid)
	{
		try {
			connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
			pstmt = connection
					.prepareStatement("DELETE FROM Assignment WHERE assignmentid = " + assignmentid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
	}
	
	public static void gradeAssignment(int studentid, int assignmentid, int grade)
	{
		try {
			connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
			pstmt = connection
					.prepareStatement("UPDATE StudentAssignment SET grade = " + grade 
							+ " WHERE assignmentid = " + assignmentid + " AND studentid = " + studentid);
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
