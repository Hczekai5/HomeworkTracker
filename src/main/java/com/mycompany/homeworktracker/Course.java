/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.homeworktracker;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hczek
 */

// Represents a course in the Homework Tracker.
public class Course {

    // Variables that store course information.
    private String courseName;
    private String courseCode;
    private String professor;

    // List that stores assignments belonging to the course.
    private List<Assignment> assignments;

    // Constructor that initializes a course.
    public Course(String courseName, String courseCode,
                  String professor) {

        this.courseName = courseName;
        this.courseCode = courseCode;
        this.professor = professor;

        // Creates an empty ArrayList for assignments.
        assignments = new ArrayList<>();
    }

    // Adds an assignment to the course.
    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    // Removes an assignment from the course.
    public void removeAssignment(Assignment assignment) {
        assignments.remove(assignment);
    }

    // Returns the list of assignments.
    public List<Assignment> getAssignments() {
        return assignments;
    }

    // Returns the course name.
    public String getCourseName() {
        return courseName;
    }

    // Returns the course code.
    public String getCourseCode() {
        return courseCode;
    }

    // Returns the professor's name.
    public String getProfessor() {
        return professor;
    }

    // Updates the course name.
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    // Updates the course code.
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    // Updates the professor's name.
    public void setProfessor(String professor) {
        this.professor = professor;
    }
}
