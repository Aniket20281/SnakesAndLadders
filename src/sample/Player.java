package sample;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class Player extends Game {
    private String name;
    private boolean game_started;
    private String colour;
    private int current;

    @FXML
    private ImageView photo;

    public void setCurrent(int current) {
        this.current = current;
    }
    public void setGame_started(boolean game_started) {
        this.game_started = game_started;
    }
    public boolean isGame_started() {
        return game_started;
    }
    public int getCurrent() {
        return current;
    }
    public void setPhoto(ImageView photo) {
        this.photo = photo;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }

}
