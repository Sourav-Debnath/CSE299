package controller;

import com.jfoenix.validation.RegexValidator;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

public class ForgotPasswordController extends ControllerBase implements Initializable {
    @FXML
    private JFXTextField email;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RegexValidator emailRegexValidator = new RegexValidator();
        emailRegexValidator.setRegexPattern("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        emailRegexValidator.setMessage("Please give a valid email");
        email.setValidators(emailRegexValidator);
        email.focusedProperty().addListener((o,oldVal,newVal)->{
            if(!newVal) email.validate();
        });
    }

    @FXML
    void onBack(ActionEvent event) {
        mainClass.loadLoginPage();
    }

    @FXML
    void onResetPassword(ActionEvent event) {
        if(email.validate()){
            //todo
        }else {
            //not todo
        }
    }
}
