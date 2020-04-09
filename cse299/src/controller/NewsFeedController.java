package controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class NewsFeedController extends ControllerBase implements Initializable {

    @FXML
    private AnchorPane postParentPane;

    @FXML
    private AnchorPane sideBar;

    @FXML
    private AnchorPane body;

    @FXML
    private ImageView userImage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //userImage.setImage(new Image("http://localhost/profilepicture/ProfilePicture.png"));
        postParentPane.setPrefHeight(1000);
        //Sidebar minus the button width is 258
        sideBar.setTranslateX(-258);
        body.setTranslateX(-258);
        AnchorPane.setRightAnchor(body, -258.0);
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

    @FXML
    void onPressMenu(ActionEvent actionEvent) {
        TranslateTransition openNav = new TranslateTransition(new Duration(350), sideBar);
        TranslateTransition closeNav = new TranslateTransition(new Duration(350), sideBar);
        TranslateTransition expendBody = new TranslateTransition(new Duration(350), body);
        TranslateTransition closeBody = new TranslateTransition(new Duration(350), body);

        if (sideBar.getTranslateX() != 0) {
            openNav.setToX(0);
            openNav.play();
            expendBody.setToX(0);
            expendBody.play();
            expendBody.setOnFinished(e -> {
                AnchorPane.setRightAnchor(body, 0.0);
            });


        } else {
            closeNav.setToX(-((sideBar.getWidth()) - 48));
            closeNav.play();
            closeBody.setToX(-(sideBar.getWidth() - 48));
            closeBody.play();
            AnchorPane.setRightAnchor(body, -(sideBar.getWidth() - 48));
        }
    }

}
