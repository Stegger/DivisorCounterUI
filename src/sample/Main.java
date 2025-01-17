package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ui/sample.fxml"));
        primaryStage.setTitle("Divisor counter");
        int width = 500;
        primaryStage.setScene(new Scene(root, width, 200));
        primaryStage.show();
    }
}
