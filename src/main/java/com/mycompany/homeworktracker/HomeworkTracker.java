package com.mycompany.homeworktracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author hczek
 */

public class HomeworkTracker extends Application {

    // Stores course information and assignments.
    private Course course = new Course("", "", "");

    // Course information fields.
    private TextField courseNameField = new TextField();
    private TextField courseCodeField = new TextField();
    private TextField professorField = new TextField();

    // Assignment information fields.
    private TextField assignmentNameField = new TextField();
    private TextField descriptionField = new TextField();
    private TextField searchNameField = new TextField();

    private DatePicker dueDatePicker = new DatePicker();

    // Priority options.
    private RadioButton highPriority = new RadioButton("High");
    private RadioButton mediumPriority = new RadioButton("Medium");
    private RadioButton lowPriority = new RadioButton("Low");

    private ToggleGroup priorityGroup = new ToggleGroup();

    // Assignment type options.
    private RadioButton homeworkType = new RadioButton("Homework");
    private RadioButton projectType = new RadioButton("Project");
    private RadioButton examType = new RadioButton("Exam");
    private RadioButton essayType = new RadioButton("Essay");
    private RadioButton quizType = new RadioButton("Quiz");

    private ToggleGroup typeGroup = new ToggleGroup();

    // Filter by priority.
    private RadioButton allPriorities = new RadioButton("All");
    private RadioButton filterHigh = new RadioButton("High");
    private RadioButton filterMedium = new RadioButton("Medium");
    private RadioButton filterLow = new RadioButton("Low");

    private ToggleGroup filterPriorityGroup = new ToggleGroup();

    // Filter by assignment type.
    private RadioButton allTypes = new RadioButton("All");
    private RadioButton filterHomework = new RadioButton("Homework");
    private RadioButton filterProject = new RadioButton("Project");
    private RadioButton filterExam = new RadioButton("Exam");
    private RadioButton filterEssay = new RadioButton("Essay");
    private RadioButton filterQuiz = new RadioButton("Quiz");

    private ToggleGroup filterTypeGroup = new ToggleGroup();

    // Filter by completion status.
    private RadioButton allStatus = new RadioButton("All");
    private RadioButton completedStatus = new RadioButton("Completed");
    private RadioButton incompleteStatus = new RadioButton("Incomplete");

    private ToggleGroup statusGroup = new ToggleGroup();

    // Sorting options.
    private RadioButton sortName = new RadioButton("Name");
    private RadioButton sortDate = new RadioButton("Due Date");
    private RadioButton sortPriority = new RadioButton("Priority");

    private ToggleGroup sortGroup = new ToggleGroup();

    // Displays messages and assignments.
    private Label messageLabel = new Label("Welcome to the Homework Tracker!");

    private VBox assignmentDisplay = new VBox(5);

    @Override
    public void start(Stage stage) {

        // Create the main layout.
        GridPane grid = new GridPane();

        grid.setPadding(new Insets(15));
        grid.setHgap(10);
        grid.setVgap(10);

        int row = 0;

        // Course information section.
        grid.add(new Label("Course Information"), 0, row++);

        grid.add(new Label("Course Name:"), 0, row);
        grid.add(courseNameField, 1, row++);

        grid.add(new Label("Course Code:"), 0, row);
        grid.add(courseCodeField, 1, row++);

        grid.add(new Label("Professor:"), 0, row);
        grid.add(professorField, 1, row++);

        // Assignment information section.
        grid.add(new Label("Assignment Information"), 0, row++);

        grid.add(new Label("Assignment Name:"), 0, row);
        grid.add(assignmentNameField, 1, row++);

        grid.add(new Label("Description:"), 0, row);
        grid.add(descriptionField, 1, row++);

        grid.add(new Label("Due Date:"), 0, row);
        grid.add(dueDatePicker, 1, row++);

        // Priority selection.
        highPriority.setToggleGroup(priorityGroup);
        mediumPriority.setToggleGroup(priorityGroup);
        lowPriority.setToggleGroup(priorityGroup);

        mediumPriority.setSelected(true);

        HBox priorityOptions = new HBox(
                10, highPriority, mediumPriority, lowPriority
        );

        grid.add(new Label("Priority:"), 0, row);
        grid.add(priorityOptions, 1, row++);

        // Assignment type selection.
        homeworkType.setToggleGroup(typeGroup);
        projectType.setToggleGroup(typeGroup);
        examType.setToggleGroup(typeGroup);
        essayType.setToggleGroup(typeGroup);
        quizType.setToggleGroup(typeGroup);

        homeworkType.setSelected(true);

        HBox typeOptions = new HBox(
                10, homeworkType, projectType,
                examType, essayType, quizType
        );

        grid.add(new Label("Assignment Type:"), 0, row);
        grid.add(typeOptions, 1, row++);

        // Assignment buttons.
        Button addButton = new Button("Add Assignment");
        Button editButton = new Button("Edit Assignment");
        Button deleteButton = new Button("Delete Assignment");
        Button completeButton = new Button("Mark Complete");
        Button clearButton = new Button("Clear Form");

        HBox assignmentButtons = new HBox(
                10, addButton, editButton,
                deleteButton, completeButton, clearButton
        );

        grid.add(assignmentButtons, 0, row++, 2, 1);

        // Field for finding an existing assignment.
        grid.add(new Label("Existing Assignment Name:"), 0, row);
        grid.add(searchNameField, 1, row++);

        // Filter by priority.
        allPriorities.setToggleGroup(filterPriorityGroup);
        filterHigh.setToggleGroup(filterPriorityGroup);
        filterMedium.setToggleGroup(filterPriorityGroup);
        filterLow.setToggleGroup(filterPriorityGroup);

        allPriorities.setSelected(true);

        HBox priorityFilters = new HBox(
                10, allPriorities, filterHigh,
                filterMedium, filterLow
        );

        grid.add(new Label("Filter by Priority:"), 0, row);
        grid.add(priorityFilters, 1, row++);

        // Filter by assignment type.
        allTypes.setToggleGroup(filterTypeGroup);
        filterHomework.setToggleGroup(filterTypeGroup);
        filterProject.setToggleGroup(filterTypeGroup);
        filterExam.setToggleGroup(filterTypeGroup);
        filterEssay.setToggleGroup(filterTypeGroup);
        filterQuiz.setToggleGroup(filterTypeGroup);

        allTypes.setSelected(true);

        HBox typeFilters = new HBox(
                10, allTypes, filterHomework, filterProject,
                filterExam, filterEssay, filterQuiz
        );

        grid.add(new Label("Filter by Assignment Type:"), 0, row);
        grid.add(typeFilters, 1, row++);

        // Filter by completion status.
        allStatus.setToggleGroup(statusGroup);
        completedStatus.setToggleGroup(statusGroup);
        incompleteStatus.setToggleGroup(statusGroup);

        allStatus.setSelected(true);

        HBox statusFilters = new HBox(
                10, allStatus, completedStatus, incompleteStatus
        );

        grid.add(new Label("Filter by Status:"), 0, row);
        grid.add(statusFilters, 1, row++);

        // Sorting options.
        sortName.setToggleGroup(sortGroup);
        sortDate.setToggleGroup(sortGroup);
        sortPriority.setToggleGroup(sortGroup);

        sortName.setSelected(true);

        HBox sortOptions = new HBox(
                10, sortName, sortDate, sortPriority
        );

        grid.add(new Label("Sort By:"), 0, row);
        grid.add(sortOptions, 1, row++);

        // Filter and sort buttons.
        Button applyButton = new Button("Apply Filter and Sort");
        Button viewButton = new Button("View All Assignments");

        HBox filterButtons = new HBox(10, applyButton, viewButton);

        grid.add(filterButtons, 0, row++, 2, 1);

        // Message label.
        grid.add(messageLabel, 0, row++, 2, 1);

        // Connect buttons to their methods.
        addButton.setOnAction(e -> addAssignment());
        editButton.setOnAction(e -> editAssignment());
        deleteButton.setOnAction(e -> deleteAssignment());
        completeButton.setOnAction(e -> markAssignmentComplete());
        clearButton.setOnAction(e -> clearForm());

        applyButton.setOnAction(e -> applyFilterAndSort());
        viewButton.setOnAction(e -> displayAllAssignments());

        // Create the window layout.
        VBox layout = new VBox(
                10,
                grid,
                new Label("Assignments:"),
                assignmentDisplay
        );

        layout.setPadding(new Insets(10));

        Scene scene = new Scene(layout, 1050, 950);

        stage.setTitle("Homework Tracker");
        stage.setScene(scene);
        stage.show();
    }

    // Checks that the required information is entered.
    private boolean validInput() {

        if (courseNameField.getText().trim().isEmpty()
                || courseCodeField.getText().trim().isEmpty()
                || professorField.getText().trim().isEmpty()
                || assignmentNameField.getText().trim().isEmpty()
                || dueDatePicker.getValue() == null) {

            messageLabel.setText("Please complete all required fields.");
            return false;
        }

        return true;
    }

    // Updates course information.
    private void updateCourseInformation() {

        course.setCourseName(courseNameField.getText().trim());
        course.setCourseCode(courseCodeField.getText().trim());
        course.setProfessor(professorField.getText().trim());
    }

    // Gets the selected priority.
    private String getSelectedPriority() {

        if (highPriority.isSelected()) {
            return "High";
        } else if (mediumPriority.isSelected()) {
            return "Medium";
        } else {
            return "Low";
        }
    }

    // Creates the correct assignment subclass.
    private Assignment createAssignment() {

        String name = assignmentNameField.getText().trim();
        String description = descriptionField.getText().trim();
        LocalDate dueDate = dueDatePicker.getValue();
        String priority = getSelectedPriority();

        if (homeworkType.isSelected()) {
            return new Homework(name, description, dueDate, priority);

        } else if (projectType.isSelected()) {
            return new Project(name, description, dueDate, priority);

        } else if (examType.isSelected()) {
            return new Exam(name, description, dueDate, priority);

        } else if (essayType.isSelected()) {
            return new Essay(name, description, dueDate, priority);

        } else {
            return new Quiz(name, description, dueDate, priority);
        }
    }

    // Adds a new assignment.
    private void addAssignment() {

        if (!validInput()) {
            return;
        }

        updateCourseInformation();

        Assignment assignment = createAssignment();

        course.addAssignment(assignment);

        messageLabel.setText("Assignment added successfully.");

        clearAssignmentFields();
        displayAllAssignments();
    }

    // Finds an assignment by name.
    private Assignment findAssignment(String name) {

        for (Assignment assignment : course.getAssignments()) {

            if (assignment.getAssignmentName()
                    .equalsIgnoreCase(name.trim())) {

                return assignment;
            }
        }

        return null;
    }

    // Edits an existing assignment.
    private void editAssignment() {

        String oldName = searchNameField.getText().trim();

        if (oldName.isEmpty()) {
            messageLabel.setText("Enter the existing assignment name.");
            return;
        }

        Assignment oldAssignment = findAssignment(oldName);

        if (oldAssignment == null) {
            messageLabel.setText("Assignment not found.");
            return;
        }

        if (!validInput()) {
            return;
        }

        updateCourseInformation();

        // Remember whether the original assignment was completed.
        boolean wasCompleted = oldAssignment.isCompleted();

        // Create a replacement assignment.
        Assignment newAssignment = createAssignment();

        if (wasCompleted) {
            newAssignment.markComplete();
        }

        // Replace the old assignment with the new one.
        course.removeAssignment(oldAssignment);
        course.addAssignment(newAssignment);

        messageLabel.setText("Assignment updated successfully.");

        clearAssignmentFields();
        searchNameField.clear();

        displayAllAssignments();
    }

    // Deletes an assignment.
    private void deleteAssignment() {

        String name = searchNameField.getText().trim();

        if (name.isEmpty()) {
            messageLabel.setText("Enter an assignment name to delete.");
            return;
        }

        Assignment assignment = findAssignment(name);

        if (assignment == null) {
            messageLabel.setText("Assignment not found.");
            return;
        }

        course.removeAssignment(assignment);

        messageLabel.setText("Assignment deleted successfully.");

        searchNameField.clear();

        displayAllAssignments();
    }

    // Marks an assignment as complete.
    private void markAssignmentComplete() {

        String name = searchNameField.getText().trim();

        if (name.isEmpty()) {
            messageLabel.setText("Enter an assignment name.");
            return;
        }

        Assignment assignment = findAssignment(name);

        if (assignment == null) {
            messageLabel.setText("Assignment not found.");
            return;
        }

        assignment.markComplete();

        messageLabel.setText("Assignment marked as complete.");

        displayAllAssignments();
    }

    // Clears assignment input fields.
    private void clearAssignmentFields() {

        assignmentNameField.clear();
        descriptionField.clear();
        dueDatePicker.setValue(null);

        mediumPriority.setSelected(true);
        homeworkType.setSelected(true);
    }

    // Clears all fields and deletes every assignment.
    private void clearForm() {

        // Clear course information.
        courseNameField.clear();
        courseCodeField.clear();
        professorField.clear();

        // Clear assignment information.
        clearAssignmentFields();
        searchNameField.clear();

        // Reset filters and sorting options.
        allPriorities.setSelected(true);
        allTypes.setSelected(true);
        allStatus.setSelected(true);
        sortName.setSelected(true);

        // Delete all assignments from the course.
        course.getAssignments().clear();

        // Remove all displayed assignments.
        assignmentDisplay.getChildren().clear();

        messageLabel.setText("All fields and assignments have been cleared.");
    }

    // Filters assignments using the selected options.
    private List<Assignment> filterAssignments() {

        List<Assignment> filtered = new ArrayList<>();

        for (Assignment assignment : course.getAssignments()) {

            boolean matchesPriority = true;
            boolean matchesType = true;
            boolean matchesStatus = true;

            // Filter by priority.
            if (filterHigh.isSelected()) {
                matchesPriority = assignment.getPriority().equals("High");

            } else if (filterMedium.isSelected()) {
                matchesPriority = assignment.getPriority().equals("Medium");

            } else if (filterLow.isSelected()) {
                matchesPriority = assignment.getPriority().equals("Low");
            }

            // Filter by assignment type.
            if (filterHomework.isSelected()) {
                matchesType = assignment.getAssignmentType().equals("Homework");

            } else if (filterProject.isSelected()) {
                matchesType = assignment.getAssignmentType().equals("Project");

            } else if (filterExam.isSelected()) {
                matchesType = assignment.getAssignmentType().equals("Exam");

            } else if (filterEssay.isSelected()) {
                matchesType = assignment.getAssignmentType().equals("Essay");

            } else if (filterQuiz.isSelected()) {
                matchesType = assignment.getAssignmentType().equals("Quiz");
            }

            // Filter by completion status.
            if (completedStatus.isSelected()) {
                matchesStatus = assignment.isCompleted();

            } else if (incompleteStatus.isSelected()) {
                matchesStatus = !assignment.isCompleted();
            }

            // Add assignments that match every selected filter.
            if (matchesPriority && matchesType && matchesStatus) {

                filtered.add(assignment);
            }
        }

        return filtered;
    }

    // Sorts assignments using basic loops.
    private void sortAssignments(List<Assignment> assignments) {

        for (int i = 0; i < assignments.size() - 1; i++) {

            for (int j = 0; j < assignments.size() - i - 1; j++) {

                Assignment first = assignments.get(j);
                Assignment second = assignments.get(j + 1);

                boolean switchPlaces = false;

                // Sort alphabetically by assignment name.
                if (sortName.isSelected()) {

                    switchPlaces = first.getAssignmentName()
                            .compareToIgnoreCase(
                                    second.getAssignmentName()) > 0;

                // Sort by due date.
                } else if (sortDate.isSelected()) {

                    LocalDate firstDate = first.getDueDate();
                    LocalDate secondDate = second.getDueDate();

                    if (firstDate != null && secondDate != null) {
                        switchPlaces = firstDate.isAfter(secondDate);

                    } else if (firstDate == null && secondDate != null) {
                        switchPlaces = true;
                    }

                // Sort by priority.
                } else if (sortPriority.isSelected()) {

                    int firstPriority = getPriorityNumber(
                            first.getPriority());

                    int secondPriority = getPriorityNumber(
                            second.getPriority());

                    switchPlaces = firstPriority > secondPriority;
                }

                // Switch the assignments if necessary.
                if (switchPlaces) {

                    assignments.set(j, second);
                    assignments.set(j + 1, first);
                }
            }
        }
    }

    // Gives each priority a number for sorting.
    private int getPriorityNumber(String priority) {

        switch (priority) {
            case "High":
                return 1;
            case "Medium":
                return 2;
            default:
                return 3;
        }
    }

    // Applies filters and sorting.
    private void applyFilterAndSort() {

        List<Assignment> results = filterAssignments();

        sortAssignments(results);

        displayAssignments(results);

        messageLabel.setText(
                "Matching assignments: " + results.size()
        );
    }

    // Displays all assignments.
    private void displayAllAssignments() {

        List<Assignment> assignments =
                new ArrayList<>(course.getAssignments());

        sortAssignments(assignments);

        displayAssignments(assignments);
    }

    // Displays the assignments in the VBox.
    private void displayAssignments(List<Assignment> assignments) {

        assignmentDisplay.getChildren().clear();

        // Display course information.
        Label courseLabel = new Label(
                "Course: " + course.getCourseName()
                + " | Code: " + course.getCourseCode()
                + " | Professor: " + course.getProfessor()
        );

        assignmentDisplay.getChildren().add(courseLabel);

        // Display each assignment.
        for (Assignment assignment : assignments) {

            String status;

            if (assignment.isCompleted()) {
                status = "Completed";
            } else {
                status = "Incomplete";
            }

            Label assignmentLabel = new Label(
                    "Name: " + assignment.getAssignmentName()
                    + " | Description: " + assignment.getDescription()
                    + " | Due: " + assignment.getDueDate()
                    + " | Priority: " + assignment.getPriority()
                    + " | Assignment Type: " + assignment.getAssignmentType()
                    + " | Class Name: " + assignment.getClass().getSimpleName()
                    + " | Status: " + status
            );

            assignmentDisplay.getChildren().add(assignmentLabel);
        }

        if (assignments.isEmpty()) {
            assignmentDisplay.getChildren().add(
                    new Label("No assignments found.")
            );
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}