package com.mycompany.homeworktracker;

import java.time.LocalDate;

/**
 *
 * @author hczek
 */

public class Assignment {

    private String assignmentName;
    private String description;
    private LocalDate dueDate;
    private String priority;
    private String assignmentType;
    private boolean completed;

    // Constructor
    public Assignment(String assignmentName, String description,
                      LocalDate dueDate, String priority, String assignmentType) {

        this.assignmentName = assignmentName;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.assignmentType = assignmentType;
        this.completed = false;
    }

    // Gets the assignment due date
    public LocalDate getDueDate() {
        return dueDate;
    }

    // Changes the assignment due date
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    // Marks the assignment as completed.
    public void markComplete() {
        completed = true;
    }

    // Checks whether the assignment is past its due date.
    public boolean isOverdue() {
        return dueDate != null
                && dueDate.isBefore(LocalDate.now())
                && !completed;
    }

    // Returns the assignment name.
    public String getAssignmentName() {
        return assignmentName;
    }

    // Returns the assignment description.
    public String getDescription() {
        return description;
    }

    // Returns the assignment priority.
    public String getPriority() {
        return priority;
    }

    // Returns the assignment type.
    public String getAssignmentType() {
        return assignmentType;
    }

    // Checks whether the assignment is completed.
    public boolean isCompleted() {
        return completed;
    }

    // Updates the assignment name.
    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    // Updates the assignment description.
    public void setDescription(String description) {
        this.description = description;
    }

    // Updates the assignment priority.
    public void setPriority(String priority) {
        this.priority = priority;
    }

    // Updates the assignment type.
    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }
}
