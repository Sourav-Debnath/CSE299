package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebView;
import java.net.URL;
import java.util.ResourceBundle;


public class PostController extends ControllerBase implements Initializable {

    @FXML
    private ImageView postUserImage;

    @FXML
    private Label postUserName;

    @FXML
    private Label postDate;

    @FXML
    private JFXTextField postflatNo;

    @FXML
    private JFXTextField postHouseNo;

    @FXML
    private JFXTextField postRoadNo;

    @FXML
    private JFXTextField postSectorNo;

    @FXML
    private JFXTextField postAreaName;

    @FXML
    private WebView postWebView;

    @FXML
    void onPost(ActionEvent event) {
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        postWebView.getEngine().load("http://localhost/map/setaddress.php?key=cse299&lng=90.4125&lat=23.8103");
    }

}
