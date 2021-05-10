package Controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../Views/ingreso.fxml"));
        primaryStage.setTitle("Bienvenido a Turbo Message");
        primaryStage.setScene(new Scene(root, 400, 450));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}