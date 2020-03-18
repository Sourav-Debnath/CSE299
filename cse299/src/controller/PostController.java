package controller;

import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class PostController extends ControllerBase implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    private ImageView postUserImage;

    @FXML
    private Label postUserName;

    @FXML
    private Label postDate;

    @FXML
    private JFXTextArea postText;

    @FXML
    private WebView postWebView;
}
