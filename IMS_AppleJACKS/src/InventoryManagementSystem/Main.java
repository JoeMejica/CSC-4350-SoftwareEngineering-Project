package InventoryManagementSystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("I.M.S. | Login");
        primaryStage.setScene(new Scene(root, 800, 500));

        //kept stage dimensions static
        primaryStage.setWidth(800.0);
        primaryStage.setHeight(500.0);

        //disabled window resizing
        //primaryStage.setResizable(false);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

        //console output added for QA
        System.out.println("Inventory Management System Launched");


    }
}