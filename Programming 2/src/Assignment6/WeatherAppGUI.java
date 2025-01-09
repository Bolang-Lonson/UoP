package Assignment6;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class WeatherAppGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Weather Information App");

        VBox root = createContent();
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public VBox createContent() {
        VBox root = new VBox(10);
        root.setPadding(new javafx.geometry.Insets(10));

        TextField locationInput = new TextField();
        locationInput.setPromptText("Enter location");
        Button fetchWeatherButton = new Button("Get Weather");

        Label weatherInfoLabel = new Label("Weather information will appear here.");

        root.getChildren().addAll(new Label("Weather Information App"), locationInput, fetchWeatherButton, weatherInfoLabel);

        fetchWeatherButton.setOnAction(e -> {
            String location = locationInput.getText();
            if (location.isEmpty()) {
                weatherInfoLabel.setText("Please enter a location.");
            } else {
                try {
                    String weatherData = WeatherAPI.getWeather(location);
                    weatherInfoLabel.setText("Weather data: " + weatherData);
                } catch (IOException | InterruptedException ex) {
                    weatherInfoLabel.setText("Failed to fetch weather data. Please try again.");
                }
            }
        });

        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }
}