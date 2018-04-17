package controllers;

import java.util.ArrayList;

import course.Course;
import db.*;
import user.*;

public class AdminController {

    private Administrator admin;
    private ArrayList<Teacher> teacherlist;
    private ArrayList<Student> studentlist;
    private ArrayList<Course> courselist;

    public AdminController(String username) {
        setAdmin(AdminQueries.getAdmin(username));
        updateTeacherList();
        updateStudentList();
        updateCourseList();
        
        studentSubList = new ArrayList<Student>();
        selectedCourseId = -1;

    }

    private void updateTeacherList() {
        setTeacherlist(TeacherQueries.getAllTeachers());
    }

    private void updateStudentList() {
        setStudentlist(StudentQueries.getAllStudents());
    }

    private void updateCourseList() {
        setCourselist(CourseQueries.getAllCourses());
    }

    /**
     * @return the admin
     */
    public Administrator getAdmin() {
        return admin;
    }

    /**
     * @return the classlist
     */
    public ArrayList<Course> getCourselist() {
        return courselist;
    }

    /**
     * @return the studentlist
     */
    public ArrayList<Student> getStudentlist() {
        return studentlist;
    }

    /**
     * @return the teacherlist
     */
    public ArrayList<Teacher> getTeacherlist() {
        return teacherlist;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }

    /**
     * @param classlist the classlist to set
     */
    public void setCourselist(ArrayList<Course> classlist) {
        this.courselist = classlist;
    }

    /**
     * @param studentlist the studentlist to set
     */
    public void setStudentlist(ArrayList<Student> studentlist) {
        this.studentlist = studentlist;
    }

    /**
     * @param teacherlist the teacherlist to set
     */
    public void setTeacherlist(ArrayList<Teacher> teacherlist) {
        this.teacherlist = teacherlist;
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String theString = "";
        theString += "Admin:\n" + admin.getFirstName() + " " + admin.getLastName() + "\n";
        //teacher student course
        theString += "\nTeachers:\n";
        for (Teacher t : teacherlist) {
            theString += t.getFirstName() + " " + t.getLastName() + "\n";
        }
        theString += "\nStudents:\n";
        for (Student s : studentlist) {
            theString += s.getFirstName() + " " + s.getLastName() + "\n";
        }
        theString += "\nCourses:\n";
        for (Course c : courselist) {
            theString += c.getCoursename() + " " + c.getTime() + "\n";
        }

        return theString;
    }

    public void createTeacher(String first, String last, String user, String pass) {
        AdminQueries.createTeacher(first, last, user, pass);
        updateTeacherList();
    }

    public void deleteTeacher(int teacherId) {
        AdminQueries.deleteTeacher(teacherId);
        updateTeacherList();
    }

    public void createStudent(String first, String last, String user, String pass) {
        AdminQueries.createStudent(first, last, user, pass);
        updateStudentList();
    }

    public void deleteStudent(int studentId) {
        AdminQueries.deleteStudent(studentId);
        updateStudentList();
    }

    public void createCourse(String name, String time) {
        AdminQueries.createCourse(name, time);
        updateCourseList();
    }

    public void deleteCourse(int courseId) {
        AdminQueries.deleteCourse(courseId);
        updateCourseList();
    }
    
    private int selectedCourseId;
    private ArrayList<Student> studentSubList;
    public ArrayList<Student> studentsNotInCourse(int courseId) {
        selectedCourseId = courseId;
        ArrayList<Student> studentsInCourse = CourseQueries.getStudentsForCourse(courseId);
        
        ArrayList<Student> studentsNotInCourse = new ArrayList<Student>(studentlist);
        
        for(Student s : studentsInCourse)
        {
            Student studentToRemove = new Student();
            for(Student s2 : studentsNotInCourse)
            {
                if(s.getUserName().equals(s2.getUserName()))
                {
                    studentToRemove = s2;
                    break;
                }
            }
            studentsNotInCourse.remove(studentToRemove);
        }
        studentSubList = studentsNotInCourse;
        return studentsNotInCourse;
    }
    
    public ArrayList<Student> getStudentSubList()
    {
        return studentSubList;
    }

    public void addStudentToCourse(int studentId) {
        AdminQueries.enrollStudentInCourse(studentId, selectedCourseId);
        updateCourseList();
    }

    public void setSelectedCourse(int courseId) {
        selectedCourseId = courseId;
    }

    public void addTeacherToCourse(int teacherId) {
        AdminQueries.addTeacherToCourse(teacherId, selectedCourseId);
        updateCourseList();
    }

    public ArrayList<Student> studentsInCourse(int courseId) {
        ArrayList<Student> studentsInCourse = CourseQueries.getStudentsForCourse(courseId);
        studentSubList = studentsInCourse;
        return studentsInCourse;
    }

    public void removeStudentFromCourse(int studentId) {
        AdminQueries.dropStudentFromCourse(studentId, selectedCourseId);
        updateCourseList();
    }

    public void removeTeacherFromCourse(int courseId) {
        AdminQueries.removeTeacherFromCourse(courseId);
        for(Course c : courselist)
        {
            if(c.getCourseID() == courseId)
            {
                c.setTeacher(new Teacher());
                break;
            }
        }
    }
}
