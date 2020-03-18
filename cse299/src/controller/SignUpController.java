package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RegexValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import database.DBQuerySingleton;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.io.File;
import java.math.BigInteger;
import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class SignUpController extends ControllerBase implements Initializable {

    @FXML
    private JFXTextField userName;
    @FXML
    private JFXTextField userNid;
    @FXML
    private JFXTextField userMobile;
    @FXML
    private JFXTextField userAddress;
    @FXML
    private JFXTextField userImage;
    @FXML
    private JFXTextField userEmail;
    @FXML
    private JFXPasswordField userPassword;
    @FXML
    private Label signupErrorMessage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bindJFXTextFiledValidator(userName,new RequiredFieldValidator(),"Please provide your name!");
        bindJFXTextFiledValidator(userNid,new NumberValidator(),"Please provide a valid NID number");
        bindJFXTextFiledValidator(userNid,new RequiredFieldValidator(), "Please provide a NID number");
        bindJFXTextFiledValidator(userMobile,new NumberValidator(),"Please provide valid mobile number");
        bindJFXTextFiledValidator(userMobile,new RequiredFieldValidator(), "Please provide your mobile number");
        bindJFXTextFiledValidator(userAddress,new RequiredFieldValidator(), "Please provide your address");
        bindJFXTextFiledValidator(userImage, new RequiredFieldValidator(), "please provide your image");
        bindJFXTextFiledValidator(userEmail, new RegexValidator(), emailRegex, "Please provide your email properly");
        bindJFXTextFiledValidator(userPassword, new RegexValidator(), passwordRegex, "At least 8 Character, At least 1 number");
    }



    @FXML
    private void onChooseImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose your profile picture");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("ImageFile", "*.png","*.jpeg");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(new Stage());
        if(file != null){
            userImage.setText(file.getAbsolutePath());
        }
    }

    @FXML
    private void onSingUp(ActionEvent event) {
        if(userName.validate() && userNid.validate() && userMobile.validate() && userAddress.validate() && userImage.validate() && userEmail.validate() && userPassword.validate()){
            DBQuerySingleton db = DBQuerySingleton.getInstance();
            String signupText = db.signUp(new BigInteger(userNid.getText()),userName.getText(),userMobile.getText(),userAddress.getText(),userImage.getText(),userEmail.getText(),userPassword.getText());
            if(signupText.equals("Insertion Successful")){
                //Todo
            }else{
                signupErrorMessage.setText(signupText);
            }
        }
    }

    @FXML
    void onBack(ActionEvent event) {
        mainClass.loadLoginPage();
    }
}
