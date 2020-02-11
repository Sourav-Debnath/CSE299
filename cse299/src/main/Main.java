package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    Stage stage;
    @Override
    public void start(Stage primaryStage){
        this.stage = primaryStage;
        loadLoginPage();
    }
    private void loadLoginPage(){

        try {
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
            Scene scene  = new Scene(root);
            stage.setTitle("Tenant Portal");
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.setResizable(false);
            stage.show();
        }catch (Exception e){
            System.out.println(e);
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
