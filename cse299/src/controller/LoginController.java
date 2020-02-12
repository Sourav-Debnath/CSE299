package controller;

import main.MainClass;
import com.jfoenix.validation.RegexValidator;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;



public class LoginController implements Initializable {

    private MainClass mainClass;
    @FXML
    private JFXTextField userEmail;
    @FXML
    private JFXPasswordField userPassword;
    @FXML
    private JFXTextField adminEmail;
    @FXML
    private JFXPasswordField adminPassword;

    public void setMainClass(MainClass mainClass) {
        this.mainClass = mainClass;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RegexValidator emailRegexValidator = new RegexValidator();
        emailRegexValidator.setRegexPattern("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        emailRegexValidator.setMessage("Please give a valid email");
        userEmail.setValidators(emailRegexValidator);
        userEmail.focusedProperty().addListener((o,oldVal,newVal)->{
            if(!newVal) userEmail.validate();
        });
        RegexValidator passwordRegexValidator = new RegexValidator();
        passwordRegexValidator.setRegexPattern("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
        passwordRegexValidator.setMessage("At least 8 Character, At least 1 number");
        userPassword.setValidators(passwordRegexValidator);
        userPassword.focusedProperty().addListener((o,oldVal,newVal)->{
            if(!newVal) userPassword.validate();
        });

        adminEmail.setValidators(emailRegexValidator);
        adminEmail.focusedProperty().addListener((o,oldVal,newVal)->{
            if(!newVal) adminEmail.validate();
        });
        adminPassword.setValidators(passwordRegexValidator);
        adminPassword.focusedProperty().addListener((o,oldVal,newVal)->{
            if(!newVal) adminPassword.validate();
        });

    }

    @FXML
    public void onAdminGmailLogin(ActionEvent event) {

    }

    @FXML
    public void onAdminLogin(ActionEvent event) {
        if(adminEmail.validate() && adminPassword.validate()){
            //start query
        }else{
            //dont start query
        }

    }

    @FXML
    public void onForgotPassword(ActionEvent event) {

    }

    @FXML
    public void onUserLogin(ActionEvent event) {
        if(userEmail.validate() && userPassword.validate()){
            //start query
        }else{
            //dont start query
        }
    }

    @FXML
    public void onSignup(ActionEvent event) {

    }

    @FXML
    public void onUserGmailLogin(ActionEvent event) {

    }


}
