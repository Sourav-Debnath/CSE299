package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;

public class NewsFeedController extends ControllerBase implements Initializable {

    @FXML
    private AnchorPane postParentPane;

    @FXML
    private ImageView userImage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userImage.setImage(new Image("http://localhost/profilepicture/ProfilePicture.png"));
        postParentPane.setPrefHeight(1000);
    }

    @FXML
    void onAccountSettings(ActionEvent event) {

    }

    @FXML
    void onPost(ActionEvent event) {

    }

    @FXML
    void onPressProfile(ActionEvent event) {

    }

    @FXML
    void onLoadMore(ActionEvent event) {

    }

    @FXML
    void onLogout(ActionEvent event) {
        mainClass.loadLoginPage();
    }
}
