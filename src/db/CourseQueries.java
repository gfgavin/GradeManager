package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import user.Student;

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
				Course course = new Course();
				int courseid = rs.getInt("courseid");
				course.setCourseID(courseid);
                                
				pstmt2 = connection
						.prepareStatement("SELECT * FROM Course WHERE courseid = " + courseid);
				rs2 = pstmt2.executeQuery();
				while (rs2.next()) {
					//ArrayList<Assignment> assignmentList = new ArrayList<Assignment>();
					
					course.setCoursename(rs2.getString("coursename"));
					course.setTime(rs2.getString("time"));
                                        course.setTeacher(TeacherQueries.getTeacher(rs2.getInt("teacherid")));
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
        public static ArrayList<Student> getStudentsForCourse(int courseid) {
		ArrayList<Student> studentlist = new ArrayList<Student>();
                PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;   
		try {
			connection = DriverManager.getConnection(DBInfo.URL, DBInfo.USER, DBInfo.PASSWORD);
			pstmt = connection.prepareStatement("SELECT * FROM StudentCourse WHERE courseid = " + courseid);
			rs = pstmt.executeQuery();

			while (rs.next()) {	
				Student student = new Student();			
				int studentid = rs.getInt("studentid");
                                student.setStudentID(studentid);
				
				pstmt2 = connection
						.prepareStatement("SELECT * FROM Student WHERE studentid = " + studentid);
				rs2 = pstmt2.executeQuery();
				while (rs2.next()) {
					//ArrayList<Assignment> assignmentList = new ArrayList<Assignment>();
					
					student.setFirstName(rs2.getString("firstname"));
					student.setLastName(rs2.getString("lastname"));
					student.setUserName(rs2.getString("userlogin"));
					

					studentlist.add(student);
				}
			}

		} catch (SQLException e) {
			System.out.println("nope - query was not successful. reason:");
			System.out.println(e.getMessage());
		} finally {
			closeConnection();
		}
		return studentlist;
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
