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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeworkTracker extends Application {
    
// Stores all assignments.
private List<Assignment> assignments = new ArrayList<>();

    //Assignment input fields.
    private TextField assignmentNameField = new TextField();
    private TextField descriptionField = new TextField();
    private TextField selectNameField = new TextField();
    private DatePicker dueDatePicker = new DatePicker();

    // Assignment priority options.
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

    // Priority filter options.
    private RadioButton allPriorities = new RadioButton("All");
    private RadioButton filterHigh = new RadioButton("High");
    private RadioButton filterMedium = new RadioButton("Medium");
    private RadioButton filterLow = new RadioButton("Low");
    private ToggleGroup filterPriorityGroup = new ToggleGroup();

    // Assignment type filter options.
    private RadioButton allTypes = new RadioButton("All");
    private RadioButton filterHomework = new RadioButton("Homework");
    private RadioButton filterProject = new RadioButton("Project");
    private RadioButton filterExam = new RadioButton("Exam");
    private RadioButton filterEssay = new RadioButton("Essay");
    private RadioButton filterQuiz = new RadioButton("Quiz");
    private ToggleGroup filterTypeGroup = new ToggleGroup();

    // Assignment completion status filters.
    private RadioButton allStatus = new RadioButton("All");
    private RadioButton completedStatus = new RadioButton("Completed");
    private RadioButton incompleteStatus = new RadioButton("Incomplete");
    private RadioButton overdueStatus = new RadioButton("Overdue");
    private ToggleGroup statusGroup = new ToggleGroup();

    // Assignment sorting options.
    private RadioButton sortName = new RadioButton("Name");
    private RadioButton sortDate = new RadioButton("Due Date");
    private RadioButton sortPriority = new RadioButton("Priority");
    private ToggleGroup sortGroup = new ToggleGroup();

    // Displays messages and assignment information.
    private Label messageLabel = new Label("Welcome to Homework Tracker!");
   // Displays assignment cards horizontally and wraps to new rows.
   private FlowPane assignmentDisplay = new FlowPane();

    @Override
    public void start(Stage stage) {

        // Creates the main layout.
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setHgap(10);
        grid.setVgap(10);

        int row = 0;

        // Assignment information.
        grid.add(new Label("Assignment Information:"), 0, row++);
        grid.add(new Label("Assignment Name:"), 0, row);
        grid.add(assignmentNameField, 1, row++);
        grid.add(new Label("Description:"), 0, row);
        grid.add(descriptionField, 1, row++);
        grid.add(new Label("Due Date:"), 0, row);
        grid.add(dueDatePicker, 1, row++);

        // Select assignment priority.
        highPriority.setToggleGroup(priorityGroup);
        mediumPriority.setToggleGroup(priorityGroup);
        lowPriority.setToggleGroup(priorityGroup);
        mediumPriority.setSelected(true);

        HBox priorityOptions = new HBox(
                10, highPriority, mediumPriority, lowPriority);
        grid.add(new Label("Priority:"), 0, row);
        grid.add(priorityOptions, 1, row++);

        // Select assignment type.
        homeworkType.setToggleGroup(typeGroup);
        projectType.setToggleGroup(typeGroup);
        examType.setToggleGroup(typeGroup);
        essayType.setToggleGroup(typeGroup);
        quizType.setToggleGroup(typeGroup);
        homeworkType.setSelected(true);

        HBox typeOptions = new HBox(
                10, homeworkType, projectType,
                examType, essayType, quizType);
        grid.add(new Label("Assignment Type:"), 0, row);
        grid.add(typeOptions, 1, row++);

        // Creates assignment action buttons.
        Button addButton = new Button("Add Assignment");
        Button editButton = new Button("Edit Assignment");
        Button deleteButton = new Button("Delete Assignment");
        Button completeButton = new Button("Mark Complete");
        Button clearButton = new Button("Clear Assignments");
        Button exitButton = new Button("Exit");
        HBox assignmentButtons = new HBox(
                10, addButton, editButton, deleteButton,
                completeButton);
        grid.add(assignmentButtons, 0, row++, 2, 1);

        // Search for an assignment by name.
        grid.add(new Label("Select an Assignment:"), 0, row);
        grid.add(selectNameField, 1, row++);

        // Priority filters.
        grid.add(new Label("Filter by Priority:"), 0, row++);
        allPriorities.setToggleGroup(filterPriorityGroup);
        filterHigh.setToggleGroup(filterPriorityGroup);
        filterMedium.setToggleGroup(filterPriorityGroup);
        filterLow.setToggleGroup(filterPriorityGroup);
        allPriorities.setSelected(true);

        HBox priorityFilters = new HBox(
                10, allPriorities, filterHigh,
                filterMedium, filterLow);
        grid.add(priorityFilters, 0, row++, 2, 1);

        // Assignment type filters.
        grid.add(new Label("Filter by Type:"), 0, row++);
        allTypes.setToggleGroup(filterTypeGroup);
        filterHomework.setToggleGroup(filterTypeGroup);
        filterProject.setToggleGroup(filterTypeGroup);
        filterExam.setToggleGroup(filterTypeGroup);
        filterEssay.setToggleGroup(filterTypeGroup);
        filterQuiz.setToggleGroup(filterTypeGroup);
        allTypes.setSelected(true);

        HBox typeFilters = new HBox(
                10, allTypes, filterHomework, filterProject,
                filterExam, filterEssay, filterQuiz);
        grid.add(typeFilters, 0, row++, 2, 1);

        // Completion status filters.
        grid.add(new Label("Filter by Status:"), 0, row++);
        allStatus.setToggleGroup(statusGroup);
        completedStatus.setToggleGroup(statusGroup);
        incompleteStatus.setToggleGroup(statusGroup);
        overdueStatus.setToggleGroup(statusGroup);
        allStatus.setSelected(true);

        HBox statusFilters = new HBox(
                10, allStatus, completedStatus,
                incompleteStatus, overdueStatus);
        grid.add(statusFilters, 0, row++, 2, 1);

        // Sorting options.
        grid.add(new Label("Sort By:"), 0, row++);
        sortName.setToggleGroup(sortGroup);
        sortDate.setToggleGroup(sortGroup);
        sortPriority.setToggleGroup(sortGroup);
        sortName.setSelected(true);

        HBox sortOptions = new HBox(
                10, sortName, sortDate, sortPriority);
        grid.add(sortOptions, 0, row++, 2, 1);

        // Filter, sort, and display buttons.
        Button applyButton = new Button("Apply Filter and Sort");
        Button viewButton = new Button("View All Assignments");
       // Places all four buttons next to each other.
       HBox filterButtons = new HBox(10, applyButton, viewButton, clearButton, exitButton);
       grid.add(filterButtons, 0, row++, 2, 1);
        
        // Sets spacing between assignment cards.
        assignmentDisplay.setHgap(15);
        assignmentDisplay.setVgap(15);
        assignmentDisplay.setPrefWrapLength(850);
        assignmentDisplay.setMaxWidth(900);

        // Displays messages and assignment information.
        grid.add(messageLabel, 0, row++, 2, 1);
        grid.add(new Label("Assignments:"), 0, row++, 2, 1);
        grid.add(assignmentDisplay, 0, row++, 2, 1);
       

        // Connects buttons to their methods.
        addButton.setOnAction(e -> addAssignment());
        editButton.setOnAction(e -> editAssignment());
        deleteButton.setOnAction(e -> deleteAssignment());
        completeButton.setOnAction(e -> markAssignmentComplete());
        clearButton.setOnAction(e -> clearForm());
        applyButton.setOnAction(e -> { messageLabel.setText(""); 
        applyFilterAndSort(); });
        viewButton.setOnAction(e -> displayAllAssignments());
        exitButton.setOnAction(e -> stage.close());

        // Displays the application window.
        VBox layout = new VBox(10, grid);
        layout.setPadding(new Insets(10));

        Scene scene = new Scene(layout, 1050, 950);
        stage.setTitle("Homework Tracker");
        stage.setScene(scene);
        stage.show();
    }

    // Creates an assignment using the selected options.
    private Assignment createAssignment() {

        String name = assignmentNameField.getText();
        String description = descriptionField.getText();
        LocalDate dueDate = dueDatePicker.getValue();

        if (name.isEmpty() || dueDate == null) {
            messageLabel.setText("Enter an assignment name and due date.");
            return null;
        }

        String priority = "Medium";
        if (highPriority.isSelected()) {
            priority = "High";
        } else if (lowPriority.isSelected()) {
            priority = "Low";
        }

        // Creates the correct assignment subclass.
        if (projectType.isSelected()) {
            return new Project(name, description, dueDate, priority);
        } else if (examType.isSelected()) {
            return new Exam(name, description, dueDate, priority);
        } else if (essayType.isSelected()) {
            return new Essay(name, description, dueDate, priority);
        } else if (quizType.isSelected()) {
            return new Quiz(name, description, dueDate, priority);
        }

        return new Homework(name, description, dueDate, priority);
    }

    // Adds a new assignment to the list.
// Adds a new assignment to the list.
private void addAssignment() {
    Assignment assignment = createAssignment();
    if (assignment == null) {
        return;
    }
    assignments.add(assignment);

    messageLabel.setText("Assignment added successfully!");
    // Refreshes the display using the selected filters.
    applyFilterAndSort();
    clearAssignmentFields();
}

    // Finds an assignment using its name.
private Assignment findAssignment(String name) {

    for (Assignment assignment : assignments) {
        if (assignment.getAssignmentName().equalsIgnoreCase(name)) {
            return assignment;
        }
    }

    return null;
}

    // Updates an existing assignment.
private void editAssignment() {

    String name = selectNameField.getText();
    Assignment oldAssignment = findAssignment(name);

    if (oldAssignment == null) {
        messageLabel.setText("Assignment not found.");
        return;
    }

    Assignment updatedAssignment = createAssignment();

    if (updatedAssignment == null) {
        return;
    }

    // Replaces the old assignment.
    int index = assignments.indexOf(oldAssignment);
    assignments.set(index, updatedAssignment);

    messageLabel.setText("Assignment updated successfully!");
    applyFilterAndSort();
    clearAssignmentFields();
    selectNameField.clear();
}

    // Deletes the selected assignment.
private void deleteAssignment() {
    Assignment assignment = findAssignment(selectNameField.getText());
    if (assignment == null) {
        messageLabel.setText("Assignment not found.");
        return;
    }
    assignments.remove(assignment);
    messageLabel.setText("Assignment deleted successfully!");
    applyFilterAndSort();
    selectNameField.clear();
}

    // Marks an assignment as completed.
    private void markAssignmentComplete() {
        Assignment assignment = findAssignment(selectNameField.getText());
        if (assignment == null) {
            messageLabel.setText("Assignment not found.");
            return;
        }
        assignment.markComplete();
        messageLabel.setText("Assignment marked as completed!");
        applyFilterAndSort();
        selectNameField.clear();
    }

    // Checks whether an assignment is overdue.
    private boolean isOverdue(Assignment assignment) {
        return assignment.isOverdue();
    }

    // Applies filters and sorting to assignments.
private void applyFilterAndSort() {
    List<Assignment> filteredAssignments =
            new ArrayList<>(assignments);

    // Filters assignments by priority, type, and status.
    filteredAssignments.removeIf(assignment -> {

        if (filterHigh.isSelected()
                && !assignment.getPriority().equals("High")) {
            return true;
        }

        if (filterMedium.isSelected()
                && !assignment.getPriority().equals("Medium")) {
            return true;
        }

        if (filterLow.isSelected()
                && !assignment.getPriority().equals("Low")) {
            return true;
        }

        String type = assignment.getAssignmentType();

        if (filterHomework.isSelected() && !type.equals("Homework")) {
            return true;
        }

        if (filterProject.isSelected() && !type.equals("Project")) {
            return true;
        }

        if (filterExam.isSelected() && !type.equals("Exam")) {
            return true;
        }

        if (filterEssay.isSelected() && !type.equals("Essay")) {
            return true;
        }

        if (filterQuiz.isSelected() && !type.equals("Quiz")) {
            return true;
        }

        if (completedStatus.isSelected()
                && !assignment.isCompleted()) {
            return true;
        }

        if (incompleteStatus.isSelected()
                && (assignment.isCompleted() || isOverdue(assignment))) {
            return true;
        }

        return overdueStatus.isSelected() && !isOverdue(assignment);
    });

    // Sorts assignments by the selected option.
    if (sortName.isSelected()) {
        filteredAssignments.sort((a, b) ->
                a.getAssignmentName().compareToIgnoreCase(
                        b.getAssignmentName()));
    } else if (sortDate.isSelected()) {
        filteredAssignments.sort((a, b) ->
                a.getDueDate().compareTo(b.getDueDate()));
    } else if (sortPriority.isSelected()) {
        filteredAssignments.sort((a, b) ->
                priorityRank(a.getPriority())
                        - priorityRank(b.getPriority()));
    }

    displayAssignments(filteredAssignments);
}


    // Gives each priority a sorting number.
    private int priorityRank(String priority) {
        if (priority.equals("High")) {
            return 1;
        } else if (priority.equals("Medium")) {
            return 2;
        }
        return 3;
    }

    // Displays all assignments.
private void displayAllAssignments() {
    displayAssignments(assignments);
}

   // Displays assignments and their information using FlowPane.
private void displayAssignments(List<Assignment> filteredAssignments) {

    assignmentDisplay.getChildren().clear();

    // Displays a message when no assignments match.
    if (filteredAssignments.isEmpty()) {
        assignmentDisplay.getChildren().add(
                new Label("No assignments match this filter.")
        );
        return;
    }

    // Creates a card for each assignment.
    for (Assignment assignment : filteredAssignments) {

        String status;

        if (assignment.isCompleted()) {
            status = "Completed";
        } else if (isOverdue(assignment)) {
            status = "Overdue";
        } else {
            status = "Incomplete";
        }

        Label assignmentLabel = new Label(
                "Name: " + assignment.getAssignmentName()
                + "\nDescription: " + assignment.getDescription()
                + "\nDue Date: " + assignment.getDueDate()
                + "\nPriority: " + assignment.getPriority()
                + "\nType: " + assignment.getAssignmentType()
                + "\nStatus: " + status
        );

        // Formats each assignment card.
        assignmentLabel.setPrefWidth(200);
        assignmentLabel.setMinHeight(130);
        assignmentLabel.setPadding(new Insets(10));
        assignmentLabel.setWrapText(true);
        assignmentLabel.setStyle(
                "-fx-border-color: gray;"
                + "-fx-border-radius: 5;"
                + "-fx-background-radius: 5;"
        );

        assignmentDisplay.getChildren().add(assignmentLabel);
    }
}

    // Clears only the assignment input fields.
    private void clearAssignmentFields() {
        assignmentNameField.clear();
        descriptionField.clear();
        dueDatePicker.setValue(null);
        mediumPriority.setSelected(true);
        homeworkType.setSelected(true);
    }

   // Clears all information and removes all assignments.
private void clearForm() {
    assignmentNameField.clear();
    descriptionField.clear();
    selectNameField.clear();
    dueDatePicker.setValue(null);
    mediumPriority.setSelected(true);
    homeworkType.setSelected(true);
    allPriorities.setSelected(true);
    allTypes.setSelected(true);
    allStatus.setSelected(true);
    sortName.setSelected(true);
    assignments.clear();
    assignmentDisplay.getChildren().clear();
    messageLabel.setText("Assignments cleared!");
}

    public static void main(String[] args) {
        launch(args);
    }
}
