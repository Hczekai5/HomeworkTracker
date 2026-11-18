# Homework Tracker

## Project Description

Homework Tracker is a JavaFX application designed to help students organize and manage their school assignments. The application allows users to add, edit, delete, and complete assignments while keeping track of important information such as assignment names, descriptions, due dates, priorities, and assignment types.

The purpose of this project is to provide students with a simple tool to stay organized, manage their workload, and keep track of upcoming assignments.

## Features

- **Add Assignments:** Create assignments with a name, description, due date, priority, and assignment type.
- **Edit Assignments:** Update information for an existing assignment.
- **Delete Assignments:** Remove assignments from the tracker.
- **Mark Complete:** Change an assignment's status to completed.
- **Filter Assignments:** Filter assignments by priority, type, and completion status, including overdue assignments.
- **Sort Assignments:** Organize assignments by name, due date, or priority.
- **View All Assignments:** Display all assignments in the tracker.
- **Clear Assignments:** Remove all assignments and reset the application fields.

## Assignment Types

The application supports five assignment types:
- Homework
- Project
- Exam
- Essay
- Quiz

## Technologies Used
- Java
- JavaFX


## Program Structure

The application uses inheritance to organize different assignment types.
- `Assignment` – Parent class containing the general assignment information and methods.
- `Homework` – Represents homework assignments.
- `Project` – Represents project assignments.
- `Exam` – Represents exams.
- `Essay` – Represents essay assignments.
- `Quiz` – Represents quizzes.
- `HomeworkTracker` – Main JavaFX application that creates the graphical user interface and manages assignments.

## How to Run the Application

1. Download or clone this GitHub repository.
2. Open the project in an IDE that supports Java and Maven, such as NetBeans or IntelliJ IDEA.
3. Make sure a compatible JDK and JavaFX configuration are installed.
4. Allow Maven to load the project dependencies.
5. Run the `HomeworkTracker.java` file.
6. The Homework Tracker window should open.

## How to Use the Application

1. Enter an assignment name and description.
2. Select the assignment's due date.
3. Choose a priority level: High, Medium, or Low.
4. Choose an assignment type.
5. Click **Add Assignment**.
6. Use the Select an Assignment field to identify an existing assignment when editing, deleting, or marking it complete.
7. Select filtering and sorting options, then click **Apply Filter and Sort**.
8. Click **View All Assignments** to display all assignments.
9. Click **Clear Assignments** to remove all assignments.
10. Click **Exit** to close the application.

## Data Storage

Assignments are stored in an ArrayList while the application is running. Assignments are not permanently saved, so they will not remain after the application is closed.

## Project Documentation

This repository includes:

- User Manual
- Implementation Manual
- Java source code
