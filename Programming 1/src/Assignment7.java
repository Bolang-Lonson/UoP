import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

class Student {
    private StringProperty id;
    private StringProperty name;
    private IntegerProperty age;
    private StringProperty major;

    public Student(String id, String name, int age, String major) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleIntegerProperty(age);
        this.major = new SimpleStringProperty(major);
    }

    // Getters and setters
    public String getId() {
        return id.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public StringProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public int getAge() {
        return age.get();
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public String getMajor() {
        return major.get();
    }

    public void setMajor(String major) {
        this.major.set(major);
    }

    public StringProperty majorProperty() {
        return major;
    }
}

class StudentManagementTab extends Tab {

    private TableView<Student> studentTable;
    private ObservableList<Student> studentData;

    public StudentManagementTab() {
        setText("Student Management");

        // Initialize the student data list
        studentData = FXCollections.observableArrayList();

        // Create the table view and its columns
        studentTable = new TableView<>();
        TableColumn<Student, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Student, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        TableColumn<Student, String> majorColumn = new TableColumn<>("Major");
        majorColumn.setCellValueFactory(new PropertyValueFactory<>("major"));

        studentTable.getColumns().addAll(idColumn, nameColumn, ageColumn, majorColumn);
        studentTable.setItems(studentData);

        // Create buttons and their event handlers
        Button addButton = new Button("Add Student");
        addButton.setOnAction(e -> showAddStudentDialog());

        Button updateButton = new Button("Update Student");
        updateButton.setOnAction(e -> showUpdateStudentDialog());

        Button viewButton = new Button("View Student Details");
        viewButton.setOnAction(e -> showStudentDetails());

        // Layout setup
        HBox buttonBox = new HBox(10, addButton, updateButton, viewButton);
        buttonBox.setPadding(new Insets(10));

        VBox layout = new VBox(10, buttonBox, studentTable);
        layout.setPadding(new Insets(10));

        setContent(layout);
    }

    private void showAddStudentDialog() {
        Dialog<Student> dialog = new Dialog<>();
        dialog.setTitle("Add Student");

        // Set the button types
        ButtonType addButtonType = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButtonType, ButtonType.CANCEL);

        // Create the form fields
        TextField nameField = new TextField();
        nameField.setPromptText("Name");
        TextField ageField = new TextField();
        ageField.setPromptText("Age");
        TextField majorField = new TextField();
        majorField.setPromptText("Major");

        VBox form = new VBox(10, new Label("Name:"), nameField, new Label("Age:"), ageField, new Label("Major:"), majorField);
        form.setPadding(new Insets(20, 150, 10, 10));
        dialog.getDialogPane().setContent(form);

        // Convert the result to a Student object when the Add button is clicked
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButtonType) {
                try {
                    String name = nameField.getText();
                    int age = Integer.parseInt(ageField.getText());
                    String major = majorField.getText();
                    if (name.isEmpty() || major.isEmpty()) {
                        showAlert("Invalid Input", "Name and Major cannot be empty.");
                        return null;
                    }
                    return new Student(studentData.size() + 1, name, age, major);
                } catch (NumberFormatException e) {
                    showAlert("Invalid Input", "Please enter a valid age.");
                    return null;
                }
            }
            return null;
        });

        dialog.showAndWait().ifPresent(student -> studentData.add(student));
    }

    private void showUpdateStudentDialog() {
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        if (selectedStudent == null) {
            showAlert("No Student Selected", "Please select a student to update.");
            return;
        }
    
        Dialog<Student> dialog = new Dialog<>();
        dialog.setTitle("Update Student");
    
        // Set the button types
        ButtonType updateButtonType = new ButtonType("Update", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(updateButtonType, ButtonType.CANCEL);
    
        // Create the form fields
        TextField nameField = new TextField(selectedStudent.getName());
        TextField ageField = new TextField(String.valueOf(selectedStudent.getAge()));
        TextField majorField = new TextField(selectedStudent.getMajor());
    
        VBox form = new VBox(10, new Label("Name:"), nameField, new Label("Age:"), ageField, new Label("Major:"), majorField);
        form.setPadding(new Insets(20, 150, 10, 10));
        dialog.getDialogPane().setContent(form);
    
        // Convert the result to a Student object when the Update button is clicked
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == updateButtonType) {
                try {
                    String name = nameField.getText();
                    int age = Integer.parseInt(ageField.getText());
                    String major = majorField.getText();
                    if (name.isEmpty() || major.isEmpty()) {
                        showAlert("Invalid Input", "Name and Major cannot be empty.");
                        return null;
                    }
                    selectedStudent.setName(name);
                    selectedStudent.setAge(age);
                    selectedStudent.setMajor(major);
                    return selectedStudent;
                } catch (NumberFormatException e) {
                    showAlert("Invalid Input", "Please enter a valid age.");
                    return null;
                }
            }
            return null;
        });
    
        dialog.showAndWait().ifPresent(student -> studentTable.refresh());
    }
    
    private void showStudentDetails() {
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        if (selectedStudent == null) {
            showAlert("No Student Selected", "Please select a student to view details.");
            return;
        }
    
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Student Details");
        alert.setHeaderText(null);
        alert.setContentText("ID: " + selectedStudent.getId() +
                             "\nName: " + selectedStudent.getName() +
                             "\nAge: " + selectedStudent.getAge() +
                             "\nMajor: " + selectedStudent.getMajor());
        alert.showAndWait();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
}

public class DashboardTab extends Tab {

    public DashboardTab() {
        setText("Dashboard");

        // Create a layout for the dashboard
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(10));

        // Create labels for summary statistics
        Label totalStudentsLabel = new Label("Total Students: 0");
        Label totalCoursesLabel = new Label("Total Courses: 0");
        Label totalEnrollmentsLabel = new Label("Total Enrollments: 0");

        // Create buttons to navigate to different sections
        Button manageStudentsButton = new Button("Manage Students");
        Button manageCoursesButton = new Button("Manage Courses");
        Button manageGradesButton = new Button("Manage Grades");

        // Event handlers for buttons (assuming you have methods to handle these actions)
        manageStudentsButton.setOnAction(e -> openManageStudentsTab());
        manageCoursesButton.setOnAction(e -> openManageCoursesTab());
        manageGradesButton.setOnAction(e -> openManageGradesTab());

        // Add elements to the layout
        layout.getChildren().addAll(
                new Label("Dashboard Overview"),
                totalStudentsLabel,
                totalCoursesLabel,
                totalEnrollmentsLabel,
                manageStudentsButton,
                manageCoursesButton,
                manageGradesButton
        );

        setContent(layout);
    }

    // Placeholder methods for opening tabs
    private void openManageStudentsTab() {
        // Logic to switch to the Manage Students tab
    }

    private void openManageCoursesTab() {
        // Logic to switch to the Manage Courses tab
    }

    private void openManageGradesTab() {
        // Logic to switch to the Manage Grades tab
    }

    // Method to update dashboard statistics (to be called from main app)
    public void updateStatistics(int totalStudents, int totalCourses, int totalEnrollments) {
        // Updating the labels with the latest statistics
        ((Label)((VBox) getContent()).getChildren().get(1)).setText("Total Students: " + totalStudents);
        ((Label)((VBox) getContent()).getChildren().get(2)).setText("Total Courses: " + totalCourses);
        ((Label)((VBox) getContent()).getChildren().get(3)).setText("Total Enrollments: " + totalEnrollments);
    }
}


public class Assignment7 extends Application {
    @Override
    public void start(Stage stage) {
        // Setting window title of application
        stage.setTitle("Student Managemment System");
        
        TabPane tabPane = new TabPane();
        tabPane.getTabs().addAll(
            new DashboardTab(),
            new StudentManagementTab(),
            new CourseEnrollmentTab(),
            new GradeManagementTab()
        );

        Scene scene = new Scene(tabPane, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();   // Runs this application
    }
}