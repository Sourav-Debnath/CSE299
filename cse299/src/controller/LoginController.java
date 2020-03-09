package controller;

import database.DBQuery;
import javafx.scene.control.Label;
import main.MainClass;
import com.jfoenix.validation.RegexValidator;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;



public class LoginController extends ControllerBase implements Initializable {

    @FXML
    private Label errorMessageUser;
    @FXML
    private Label errorMessageAdmin;
    @FXML
    private JFXTextField userEmail;
    @FXML
    private JFXPasswordField userPassword;
    @FXML
    private JFXTextField adminEmail;
    @FXML
    private JFXPasswordField adminPassword;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bindJFXTextFiledValidator(userEmail, new RegexValidator(), emailRegex, "Please give a valid email");
        bindJFXTextFiledValidator(userPassword, new RegexValidator(), passwordRegex, "At least 8 Character, At least 1 number");
        bindJFXTextFiledValidator(adminEmail, new RegexValidator(), emailRegex, "Please give a valid email");
        bindJFXTextFiledValidator(adminPassword, new RegexValidator(), passwordRegex, "At least 8 Character, At least 1 number");
    }

    @FXML
    void onAdminGmailLogin(ActionEvent event) {

    }

    @FXML
    void onAdminLogin(ActionEvent event) {
        if(adminEmail.validate() && adminPassword.validate()){

        }
    }

    @FXML
    void onForgotPassword(ActionEvent event) {
        mainClass.loadForgotPasswordPage();
    }

    @FXML
    void onUserLogin(ActionEvent event) {
        if(userEmail.validate() && userPassword.validate()){
            DBQuery db = new DBQuery();
            String loginText = db.login(userEmail.getText(),userPassword.getText());
            if(loginText.equals("Logged In")){
                //Todo
            }else{
                errorMessageUser.setText(loginText);
            }
        }
    }

    @FXML
    void onSignup(ActionEvent event) {
        mainClass.loadSignUpPage();
    }

    @FXML
    void onUserGmailLogin(ActionEvent event) {

    }
}
