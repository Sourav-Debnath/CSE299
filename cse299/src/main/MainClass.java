package main;

import controller.ControllerBase;
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
    public  void loadSignUpPage(){ loadFxml("signup.fxml"); }

    public void loadLoginPage(){
        loadFxml("login.fxml");
    }

    public void loadForgotPasswordPage(){
        loadFxml("forgotpassword.fxml");
    }

    //This function will load the fxml as well as initialize the controller class
    private void loadFxml(String fxmlName){
        try {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("../fxml/"+fxmlName));
            Parent root = loader.load();
            ControllerBase controller = loader.getController();
            controller.setMainClass(this);
            if(stage.getScene() == null){
                Scene scene  = new Scene(root);
                stage.setScene(scene);
                stage.setMaximized(true);
            }else{
                stage.getScene().setRoot(root);
            }
            stage.setTitle("Tenant Portal");
            stage.setResizable(false);
            stage.show();
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
