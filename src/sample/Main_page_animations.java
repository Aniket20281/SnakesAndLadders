package sample;

import javafx.animation.FadeTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Main_page_animations {
    public static FadeTransition fadeIT(ImageView img){
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(2000));
        fade.setToValue(1200);
        fade.setNode(img);
        return fade;
    }
}
