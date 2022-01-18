package sample;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class Controller extends Main_page_animations implements Initializable {

    private Stage s;
    private Parent p;
    private Scene sc;

    @FXML
    private ImageView heading;

    @FXML
    private ImageView profilePic;
    @FXML
    private ImageView watchvideo;
    @FXML
    private ImageView mainButton;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(heading);
        translate.setDuration(Duration.millis(1000));
        translate.setByY(175);
        translate.play();
        FadeTransition fade = fadeIT(img1);
        fade.play();
        FadeTransition fade2 = fadeIT(img2);
        fade2.play();
        FadeTransition fade3 = fadeIT(profilePic);
        fade3.play();
        FadeTransition fade4 = fadeIT(mainButton);
        fade4.play();
        translate = new TranslateTransition();
        translate.setNode(mainButton);
        translate.setDuration(Duration.millis(650));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByY(5);
        translate.setAutoReverse(true);
        translate.play();
        TranslateTransition translate2 = new TranslateTransition();
        translate2.setNode(watchvideo);
        translate2.setDuration(Duration.millis(1000));
        translate2.setByY(-50);
        translate2.play();
    }


    public void switchToGame(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        s = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        s.setTitle("Main game");
        s.setScene(new Scene(root, 275, 532));
        s.show();
    }
}
