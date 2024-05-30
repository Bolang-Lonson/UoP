import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class Assignment7 extends Application {
    @Override
    public void start(Stage stage) {
        // Setting window title of application
        stage.setTitle("Student Managemment System");
        TabPane tabPane = new TabPane();
        // tabPane.getTabs().addAll(
        //     new DashboardTab(),
        //     new StudentManagementTab(),
        //     new CourseEnrollmentTab(),
        //     new GradeManagementTab()
        // );

        Scene scene = new Scene(tabPane, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();   // Runs this application
    }
}

// class StudentManagementTab