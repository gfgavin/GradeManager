package controllers;

import course.Assignment;
import java.util.ArrayList;

import course.Course;
import db.AssignmentQueries;
import db.CourseQueries;
import db.TeacherQueries;
import user.Teacher;

public class TeacherController {

    private Teacher teacher;
    private ArrayList<Course> courseList;

    private Course selectedCourse;
    private ArrayList<Assignment> selectedAssignmentGrades;

    public TeacherController(String username) {
        setTeacher(TeacherQueries.getTeacher(username));
        setCourseList(CourseQueries.getCoursesForTeacher(teacher.getTeacherID()));
        
        for(Course c : getCourseList())
        {
            c.setTeacher(getTeacher());
        }

        setSelectedCourse(new Course());
        setSelectedAssignmentGrades(new ArrayList<Assignment>());
    }

    /**
     * @return the teacher
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * @return the courseList
     */
    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    /**
     * @param teacher the teacher to set
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * @param courseList the courseList to set
     */
    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    public Course getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(Course selectedCourse) {
        this.selectedCourse = selectedCourse;
    }

    public ArrayList<Assignment> getSelectedAssignmentGrades() {
        return selectedAssignmentGrades;
    }

    public void setSelectedAssignmentGrades(ArrayList<Assignment> selectedAssignmentGrades) {
        this.selectedAssignmentGrades = selectedAssignmentGrades;
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        String theString = "";
        theString += "Teacher:\n" + teacher.getFirstName() + " " + teacher.getLastName() + "\n";
        theString += "\nCourses:\n";
        for (Course c : courseList) {
            theString += c.getCoursename() + " " + c.getTime() + "\n"
                    + c.assignmentListToString() + "\n";
        }

        return theString;
    }

    public ArrayList<Assignment> getAssignmentsForCourse(int courseId) {
        for(Course c : courseList)
        {
            if(c.getCourseID() == courseId)
            {
                setSelectedCourse(c);
                break;
            }
        }
        return getSelectedCourse().distinctAssignments();
    }

    public void getGradesForAssignment(int assignmentId) {
        selectedAssignmentGrades.clear();
        for(Assignment a : selectedCourse.getAssignmentList())
        {
            if(a.getAssignmentID() == assignmentId)
            {
                selectedAssignmentGrades.add(a);
            }
        }
        
    }

    public void createAssignment(String newAssignmentTitle) {
        AssignmentQueries.createAssignment(getSelectedCourse().getCourseID(), newAssignmentTitle);
        setCourseList(CourseQueries.getCoursesForTeacher(teacher.getTeacherID()));
        
    }
}
