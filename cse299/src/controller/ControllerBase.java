package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RegexValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import main.MainClass;

public class ControllerBase {
    protected MainClass mainClass;
    protected String emailRegex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    protected String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
    public void setMainClass(MainClass mainClass) {
        this.mainClass = mainClass;
    }
    protected void bindJFXTextFiledValidator(JFXTextField textField, RequiredFieldValidator validator, String message){
        validator.setMessage(message);
        textField.setValidators(validator);
        textField.focusedProperty().addListener((o,oldVal,newVal)->{
            if(!newVal) textField.validate();
        });
    }
    protected void bindJFXTextFiledValidator(JFXTextField textField, RegexValidator validator, String regex, String message){
        validator.setRegexPattern(regex);
        validator.setMessage(message);
        textField.setValidators(validator);
        textField.focusedProperty().addListener((o,oldVal,newVal)->{
            if(!newVal) textField.validate();
        });
    }
    protected void bindJFXTextFiledValidator(JFXTextField textField, NumberValidator validator, String message){
        validator.setMessage(message);
        textField.setValidators(validator);
        textField.focusedProperty().addListener((o,oldVal,newVal)->{
            if(!newVal) textField.validate();
        });
    }
    protected void bindJFXTextFiledValidator(JFXPasswordField textField, RegexValidator validator, String regex, String message){
        validator.setRegexPattern(regex);
        validator.setMessage(message);
        textField.setValidators(validator);
        textField.focusedProperty().addListener((o,oldVal,newVal)->{
            if(!newVal) textField.validate();
        });
    }
    protected void bindJFXTextFiledValidator(JFXPasswordField textField, RegexValidator validator, String message){
        validator.setMessage(message);
        textField.setValidators(validator);
        textField.focusedProperty().addListener((o,oldVal,newVal)->{
            if(!newVal) textField.validate();
        });
    }
}
