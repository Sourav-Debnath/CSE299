package main;

import controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass extends Application {
    private Stage stage;
    @Override
    public void start(Stage primaryStage){
        this.stage = primaryStage;
        loadLoginPage();
    }
    private void loadLoginPage(){

        try {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("../fxml/login.fxml"));
            Parent root = loader.load();
            LoginController controller=loader.getController();
            controller.setMainClass(this);
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
