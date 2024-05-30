import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

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