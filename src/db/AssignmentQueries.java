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
