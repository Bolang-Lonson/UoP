package Assignment6;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException, InterruptedException {
        WeatherAppGUI weatherAppGUI = new WeatherAppGUI();
        StackPane root = new StackPane();
        root.getChildren().add(weatherAppGUI.createContent()); // Assuming WeatherAppGUI has a createContent method to return the main GUI layout

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Weather Information App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}