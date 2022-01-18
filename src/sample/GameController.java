package sample;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameController  extends Game implements Initializable {

    private Stage s;
    private Parent p;
    private Scene sc;


    @FXML
    private ImageView back_exit;

    @FXML
    private Label dice_value;

    @FXML
    private ImageView player1_faded;

    @FXML
    private ImageView player2;

    @FXML
    private ImageView dice_val_2;

    @FXML
    private ImageView exit_ok;

    @FXML
    private ImageView exit_menu;

    @FXML
    private ImageView dice_1;
    @FXML
    private ImageView dice_2;
    @FXML
    private ImageView dice_3;
    @FXML
    private ImageView dice_4;
    @FXML
    private ImageView dice_5;

    @FXML
    private ImageView blue;

    @FXML
    private ImageView green;

    @FXML
    private Button button;

    @FXML
    private ImageView back_button;

    @FXML
    private ImageView arrow;

    @FXML
    private ImageView board;

    @FXML
    private ImageView dice_6;

    @FXML
    private ImageView player1;
    @FXML
    private ImageView menu_1;

    @FXML
    private ImageView p2_win;
    @FXML
    private ImageView p1_win;

    @FXML
    private ImageView replay_1;

    @FXML
    private ImageView player2_faded;

    Path p_test = new Path();


    public void translateIT(ImageView img , double x , double y){
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(img);
        translate.setDuration(Duration.millis(1000));
        translate.setByX(x);
        translate.setByY(y);
        translate.play();
    }


    public void open_green_token(){
        double x = green.getX();
        double y = green.getY();
        translateIT(green , -6, -12);
        green.setY(y - 12);
        green.setX(x - 6);
    }

    public void open_blue_token(){
        double x = blue.getX();
        double y = blue.getY();
        translateIT(blue , 2 , -12);
        blue.setY(y - 12);
        blue.setX(x + 2);
    }

    public void move_Token_upwards(ImageView img , Path path){
        double x = img.getX();
        double y = img.getY();
        path.getElements().add(new MoveTo(x,y));
        path.getElements().add(new LineTo(x , y - 34));
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();

        if(img == blue){
            blue.setX(x);
            blue.setY(y - 34);
        }

        else{
            green.setX(x);
            green.setY(y - 34);
        }

    }

    public void move_Token_backwards(ImageView img , int x , Path path){
        double x_curr = 0;
        double y_curr = 0;
        x_curr = img.getX();
        y_curr = img.getY();
        for(int i = 0 ; i < x ; i++) {
            path.getElements().add(new MoveTo(x_curr, y_curr));
            ArcTo arc = new ArcTo();
            arc.setX(x_curr - 24);
            arc.setY(y_curr);
            arc.setRadiusX(10);
            arc.setRadiusY(-10);
            path.getElements().add(arc);
            x_curr -= 24;
        }
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();
        if(img == blue){
            blue.setX(x_curr);
            blue.setY(y_curr);
        }
        else{
            green.setX(x_curr);
            green.setY(y_curr);
        }
    }

    public void move_Token_forward(ImageView img , int x , Path path){
        double x_curr = 0;
        double y_curr = 0;

        x_curr = img.getX();
        y_curr = img.getY();
        for(int i = 0 ; i < x ; i++) {
            path.getElements().add(new MoveTo(x_curr, y_curr));
            ArcTo arc = new ArcTo();
            if (img == blue && first_chance_p1 == 1){
                arc.setX(x_curr + 35);
            }
            else if (img == green && first_chance_p2 == 1){
                arc.setX(x_curr+28);
            }
            else{
                arc.setX(x_curr + 24);
            }
            arc.setY(y_curr);
            arc.setRadiusX(10);
            arc.setRadiusY(-10);
            path.getElements().add(arc);
            if (img == blue && first_chance_p1 == 1){
                x_curr += 35;
            }
            else if (img == green && first_chance_p2 == 1){
                x_curr += 28;
            }
            else{
                x_curr += 24;
            }
        }
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();

        if(img == blue){
            blue.setX(x_curr);
            blue.setY(y_curr);
        }
        else{
            green.setX(x_curr);
            green.setY(y_curr);
        }
    }

    public void ladder_1(ImageView img , Path path){

        path.getElements().add(new MoveTo(img.getX(), img.getY()));
        if(img == blue){
            path.getElements().add(new LineTo(13,-80));
        }
        else{
            path.getElements().add(new LineTo(-2,-80));
        }
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();
        if(img == blue){
            blue.setX(13);
            blue.setY(-80);
        }
        else{
            green.setX(-2);
            green.setY(-80);
        }
    }

    public void ladder_2(ImageView img , Path path){

        path.getElements().add(new MoveTo(img.getX(), img.getY()));
        if(img == blue){
            path.getElements().add(new LineTo(157,-80));
        }
        else{
            path.getElements().add(new LineTo(142,-80));
        }

        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();

        if(img == blue){
            blue.setX(157);
            blue.setY(-80);
        }
        else{
            green.setX(142);
            green.setY(-80);
        }

    }

    public void ladder_3(ImageView img , Path path){

        path.getElements().add(new MoveTo(img.getX(), img.getY()));

        if(img == blue){
            path.getElements().add(new LineTo(181,-114));
        }
        else{
            path.getElements().add(new LineTo(166,-114));
        }
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();

        if (img == blue){
            blue.setX(181);
            blue.setY(-114);
        }
        else{
            green.setX(166);
            green.setY(-114);
        }
    }

    public void ladder_4(ImageView img , Path path){

        path.getElements().add(new MoveTo(img.getX(), img.getY()));

        if(img == blue){
            path.getElements().add(new LineTo(157,-114));
        }
        else{
            path.getElements().add(new LineTo(142,-114));
        }

        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();

        if (img == blue){
            blue.setX(157);
            blue.setY(-114);
        }
        else{
            green.setX(142);
            green.setY(-114);
        }
    }

    public void ladder_5(ImageView img , Path path){

        path.getElements().add(new MoveTo(img.getX(), img.getY()));

        if(img == blue){
            path.getElements().add(new LineTo(85,-216));
        }
        else{
            path.getElements().add(new LineTo(70,-216));
        }
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();

        if (img == blue){
            blue.setX(85);
            blue.setY(-216);
        }
        else{
            green.setX(70);
            green.setY(-216);
        }
    }

    public void ladder_6(ImageView img , Path path){

        path.getElements().add(new MoveTo(img.getX(), img.getY()));

        if(img == blue){
            path.getElements().add(new LineTo(61,-182));
        }
        else{
            path.getElements().add(new LineTo(46,-182));
        }
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();

        if (img == blue){
            blue.setX(61);
            blue.setY(-182);
        }
        else{
            green.setX(46);
            green.setY(-182);
        }
    }

    public void ladder_7(ImageView img , Path path){

        path.getElements().add(new MoveTo(img.getX(), img.getY()));

        if(img == blue){
            path.getElements().add(new LineTo(37,-284));
        }
        else{
            path.getElements().add(new LineTo(22,-284));
        }
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();

        if (img == blue){
            blue.setX(37);
            blue.setY(-284);
        }
        else{
            green.setX(22);
            green.setY(-284);
        }
    }
    public void ladder_8(ImageView img , Path path){

        path.getElements().add(new MoveTo(img.getX(), img.getY()));

        if(img == blue){
            path.getElements().add(new LineTo(229,-318));
        }
        else{
            path.getElements().add(new LineTo(214,-318));
        }
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();

        if (img == blue){
            blue.setX(229);
            blue.setY(-318);
        }
        else{
            green.setX(214);
            green.setY(-318);
        }
    }

    public void ladder_9(ImageView img , Path path){

        path.getElements().add(new MoveTo(img.getX(), img.getY()));

        if(img == blue){
            path.getElements().add(new LineTo(157,-318));
        }
        else{
            path.getElements().add(new LineTo(142,-318));
        }
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();

        if (img == blue){
            blue.setX(157);
            blue.setY(-318);
        }
        else{
            green.setX(142);
            green.setY(-318);
        }
    }

    public void ladder_10(ImageView img , Path path){

        path.getElements().add(new MoveTo(img.getX(), img.getY()));

        if(img == blue){
            path.getElements().add(new LineTo(85,-318));
        }
        else{
            path.getElements().add(new LineTo(70,-318));
        }
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();

        if (img == blue){
            blue.setX(85);
            blue.setY(-318);
        }
        else{
            green.setX(70);
            green.setY(-318);
        }
    }

    public void snake_1(ImageView img , Path path){

        path.getElements().add(new MoveTo(img.getX(), img.getY()));

        if(img == blue){
            path.getElements().add(new LineTo(109,-12));
        }
        else{
            path.getElements().add(new LineTo(94,-12));
        }
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();
        if(img == blue){
            blue.setX(109);
            blue.setY(-12);
        }
        else{
            green.setX(94);
            green.setY(-12);
        }
    }
    public void snake_2(ImageView img , Path path){

        path.getElements().add(new MoveTo(img.getX(), img.getY()));

        if(img == blue){
            path.getElements().add(new LineTo(205 , -12));
        }
        else{
            path.getElements().add(new LineTo(190,-12));
        }
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();
        if(img == blue){
            blue.setX(205);
            blue.setY(-12);
        }
        else{
            green.setX(190);
            green.setY(-12);
        }
    }

    public void snake_3(ImageView img , Path path){
        path.getElements().add(new MoveTo(img.getX(), img.getY()));

        if(img == blue){
            path.getElements().add(new LineTo(109,-80));
        }
        else{
            path.getElements().add(new LineTo(94,-80));
        }
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();
        if(img == blue){
            blue.setX(109);
            blue.setY(-80);
        }
        else{
            green.setX(94);
            green.setY(-80);
        }
    }

    public void snake_4(ImageView img , Path path){
        path.getElements().add(new MoveTo(img.getX(), img.getY()));

        if(img == blue){
            path.getElements().add(new LineTo(13,-114));
        }
        else{
            path.getElements().add(new LineTo(-2,-114));
        }
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();
        if(img == blue){
            blue.setX(13);
            blue.setY(-114);
        }
        else{
            green.setX(-2);
            green.setY(-114);
        }
    }

    public void snake_5(ImageView img , Path path){
        path.getElements().add(new MoveTo(img.getX(), img.getY()));

        if(img == blue){
            path.getElements().add(new LineTo(109,-182));
        }
        else{
            path.getElements().add(new LineTo(94,-182));
        }
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();
        if(img == blue){
            blue.setX(109);
            blue.setY(-182);
        }
        else{
            green.setX(94);
            green.setY(-182);
        }
    }

    public void snake_6(ImageView img , Path path){
        path.getElements().add(new MoveTo(img.getX(), img.getY()));

        if(img == blue){
            path.getElements().add(new LineTo(229,-46));
        }
        else{
            path.getElements().add(new LineTo(214,-46));
        }
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();
        if(img == blue){
            blue.setX(229);
            blue.setY(-46);
        }
        else{
            green.setX(214);
            green.setY(-46);
        }
    }

    public void snake_7(ImageView img , Path path){
        path.getElements().add(new MoveTo(img.getX(), img.getY()));

        if(img == blue){
            path.getElements().add(new LineTo(37,-216));
        }
        else{
            path.getElements().add(new LineTo(22,-216));
        }
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();
        if(img == blue){
            blue.setX(37);
            blue.setY(-216);
        }
        else{
            green.setX(22);
            green.setY(-216);
        }
    }

    public void snake_8(ImageView img , Path path){
        path.getElements().add(new MoveTo(img.getX(), img.getY()));

        if(img == blue){
            path.getElements().add(new LineTo(109,-216));
        }
        else{
            path.getElements().add(new LineTo(94,-216));
        }
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();
        if(img == blue){
            blue.setX(109);
            blue.setY(-216);
        }
        else{
            green.setX(94);
            green.setY(-216);
        }
    }

    public void snake_9(ImageView img , Path path){
        path.getElements().add(new MoveTo(img.getX(), img.getY()));

        if(img == blue){
            path.getElements().add(new LineTo(157,-182));
        }
        else{
            path.getElements().add(new LineTo(142,-182));
        }
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();
        if(img == blue){
            blue.setX(157);
            blue.setY(-182);
        }
        else{
            green.setX(142);
            green.setY(-182);
        }
    }

    public void snake_10(ImageView img , Path path){
        path.getElements().add(new MoveTo(img.getX(), img.getY()));

        if(img == blue){
            path.getElements().add(new LineTo(181,-148));
        }
        else{
            path.getElements().add(new LineTo(166,-148));
        }
        PathTransition transition = new PathTransition();
        transition.setNode(img);
        transition.setDuration((Duration.millis(1000)));
        transition.setPath(path);
        transition.play();
        if(img == blue){
            blue.setX(181);
            blue.setY(-148);
        }
        else{
            green.setX(166);
            green.setY(-148);
        }
    }

    public void backToMenu(MouseEvent mouseEvent){
        translateIT(exit_menu , 0 , 300);
        translateIT(exit_ok , 0 , 300);
        translateIT(back_exit , 0 , 300);
    }

    public FadeTransition fadeIT(ImageView img){
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(2000));
        fade.setToValue(1200);
        fade.setNode(img);
        return fade;
    }

    public FadeTransition fadeOut(ImageView img){
        FadeTransition fader = new FadeTransition(Duration.millis(1) , img);
        fader.setFromValue(1);
        fader.setToValue(0);
        return fader;
    }
    public FadeTransition fadeIn(ImageView img){
        FadeTransition fader = new FadeTransition(Duration.millis(1) , img);
        fader.setFromValue(0);
        fader.setToValue(1);
        return fader;
    }


    public void exitOK(MouseEvent mouseEvent) throws IOException {
        s = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        s.setTitle("Main game");
        s.setScene(new Scene(root, 275, 532));
        s.show();
    }

    public void exitBack(MouseEvent mouseEvent){
        translateIT(exit_menu , 0 , -300);
        translateIT(exit_ok , 0 , -300);
        translateIT(back_exit , 0 , -300);
    }

    public void setBoard(ArrayList<Snake> snakes , ArrayList<ladder> ladders){

        Board new_board = new Board();

        // Setting Snakes
        Snake s1 = new Snake(23);
        s1.setHead(23);
        s1.setTail(5);
        Snake s2 = new Snake(32);
        s2.setHead(32);
        s2.setTail(9);
        Snake s3 = new Snake(46);
        s3.setHead(46);
        s3.setTail(25);
        Snake s4 = new Snake(51);
        s4.setHead(51);
        s4.setTail(11);
        Snake s5 = new Snake(59);
        s5.setHead(59);
        s5.setTail(40);
        Snake s6 = new Snake(66);
        s6.setHead(66);
        s6.setTail(56);
        Snake s7 = new Snake(81);
        s7.setHead(81);
        s7.setTail(62);
        Snake s8 = new Snake(92);
        s8.setHead(92);
        s8.setTail(48);
        Snake s9 = new Snake(95);
        s9.setHead(95);
        s9.setTail(54);
        Snake s10 = new Snake(98);
        s10.setHead(98);
        s10.setTail(65);
        snakes.add(s1);
        snakes.add(s2);
        snakes.add(s3);
        snakes.add(s4);
        snakes.add(s5);
        snakes.add(s6);
        snakes.add(s7);
        snakes.add(s8);
        snakes.add(s9);
        snakes.add(s10);


        // Setting Ladders
        ladder l1 = new ladder(2,21);
        ladder l2 = new ladder(6,27);
        ladder l3 = new ladder(8,33);
        ladder l4 = new ladder(16,34);
        ladder l5 = new ladder(24,64);
        ladder l6 = new ladder(38 , 58);
        ladder l7 = new ladder(63,82);
        ladder l8 = new ladder(70,91);
        ladder l9 = new ladder(73 , 94);
        ladder l10 = new ladder(85,97);
        ladders.add(l1);
        ladders.add(l2);
        ladders.add(l3);
        ladders.add(l4);
        ladders.add(l5);
        ladders.add(l6);
        ladders.add(l7);
        ladders.add(l8);
        ladders.add(l9);
        ladders.add(l10);

        ArrayList<tile> tiles = new ArrayList<>();

        for(int i = 1 ; i <= 100 ; i++){
            tile new_tile = new tile();
            for(int p = 0 ; p < ladders.size() ; p++){
                if (ladders.get(p).getStart() == i){
                    new_tile.setLadder(true);
                }
            }
            for(int p = 0 ; p < snakes.size() ; p++){
                if (snakes.get(p).getHead() == i){
                    new_tile.setSnake(true);
                }
            }
            tiles.add(new_tile);
        }

        new_board.setTiles(tiles);
    }



    public void Chance(Player p1 , Player p2 , ArrayList<Snake> snakes , ArrayList<ladder> ladders , int value){
        Path p_test = new Path();
        Path p_tester = new Path();
        if (p1_chance == true){
            int new_value = 0;
            if (!p1.isGame_started()){
                if (value == 1) {
                    // player 1 threw a 1
                    open_blue_token();
                    p1.setGame_started(true);
                    // TODO
                    new_value = 1;
                }
                else{
                    p1_chance = false;
                    return;
                }
            }
            else if (p1.getCurrent() >= 95 && value > 100 - p1.getCurrent()){
                // now we have to consider wrong input
                // don't do anything in such cases
                p1_chance = false;
                return ;
            }
            else{
                // first we will find out in which lane is the pawn standing
                int pos = p1.getCurrent();
                if (pos == 1 || pos == 2 || pos == 3 || pos == 4 || pos == 5 || pos == 6 || pos == 7 || pos == 8 || pos == 9 || pos == 10
                    || pos == 21 || pos == 22 || pos == 23 || pos == 24 || pos == 25 || pos == 26 || pos == 27 || pos == 28 || pos == 29 || pos == 30
                || pos == 41 || pos == 42 || pos == 43 || pos == 44 || pos == 45 || pos == 46 || pos == 47 || pos == 48 || pos == 49 || pos == 50
                || pos == 61 || pos == 62 || pos == 63 || pos == 64 || pos == 65 || pos == 66 || pos == 67 || pos == 68 || pos == 69 || pos == 70
                || pos == 81 || pos == 82 || pos == 83 || pos == 84 || pos == 85 || pos == 86 || pos == 87 || pos == 88 || pos == 89 || pos == 90) {
                    // this means that we are in the lane where we need to go up or right
                    int space_ahead = 10 - (p1.getCurrent() % 10);

                    if (space_ahead >= value && space_ahead != 10){
                        // working fine
                        // the player has enough space to just move forward
                        Path path_temp = new Path();

                        move_Token_forward(blue , 1 , p_test);
                        first_chance_p1 --;

                        move_Token_forward(blue , value-1 , p_test);
                        new_value = p1.getCurrent() + value;
                    }
                    else if(space_ahead == 10){
                        // there is no space ahead, so we will move up by one
                        System.out.println("here");
                        Path path_temp = new Path();

                        move_Token_upwards(blue , p_test);
                        System.out.println("here");
                        // now we will move backwards
                        int moves_left = value - 1;

                        if(moves_left != 0){
                            Path pp = new Path();
                            // change it to p_test if required
                            move_Token_backwards(blue , moves_left , pp);
                        }

                        new_value = p1.getCurrent() + value;

                    }
                    else{
                        // first we need to move right as much as possible
                        Path p = new Path();

                        move_Token_forward(blue , space_ahead ,p_test);
                        int temp = value - space_ahead;

                        // now we will move upwards
                        Path path_temp = new Path();

                        move_Token_upwards(blue , p_test);

                        // now we will move backwards
                        int moves_left = temp - 1;
                        Path pp = new Path();

                        move_Token_backwards(blue , moves_left , p_test );

                        new_value = p1.getCurrent() + value;
                    }
                }

                else{
//                    Path p_tester = new Path();

                    // we are in a tray where we need to move backwards
                    int space_ahead = 10 - (p1.getCurrent() % 10);
                    if (space_ahead >= value && space_ahead != 10){
                        // the player has enough space to just move backwards
                        Path path_temp = new Path();

                        move_Token_backwards(blue , value , p_test);
                        new_value = p1.getCurrent() + value;
                    }

                    else if(space_ahead == 10){
                        // there is no space ahead, so we will move up by one
                        Path path_temp = new Path();

                        move_Token_upwards(blue , p_test);

                        // now we will move forward
                        int moves_left = value - 1;
                        Path pp = new Path();

                        move_Token_forward(blue , moves_left , p_test );
                        new_value = p1.getCurrent() + value;
                    }
                    else{

                        // first we need to move left as much as possible
                        Path p = new Path();

                        move_Token_backwards(blue , space_ahead ,p_test);
                        int temp = value - space_ahead;

                        // now we will move upwards
                        Path path_temp = new Path();

                        move_Token_upwards(blue , p_test);

                        // now we will move forward
                        int moves_left = temp - 1;
                        Path pp = new Path();

                        move_Token_forward(blue , moves_left , p_test);

                        new_value = p1.getCurrent() + value;
                    }
                }
            }

            // here -> player 1 has reached it's new position so now we will decide that does the new position has any ladder/snake

            // checking for snakes
            for(int i = 0 ; i < snakes.size() ; i++){
                Snake target = snakes.get(i);
                if(target.getHead() == new_value){
                    // we have a ladder at the new position of player 1
                    if (new_value == 23){
                        Path y = new Path();
                        snake_1(blue , p_test);
                        new_value = 5;
                    }
                    if(new_value == 32){
                        Path y = new Path();
                        snake_2(blue , p_test);
                        new_value = 9;
                    }
                    if(new_value == 46){
                        Path y = new Path();
                        snake_3(blue , p_test);
                        new_value = 25;
                    }
                    if(new_value == 59){
                        Path y = new Path();
                        snake_4(blue , p_test);
                        new_value = 40;
                    }
                    if(new_value == 66 ){
                        Path y = new Path();
                        snake_5(blue , p_test);
                        new_value = 56;
                    }
                    if(new_value == 51 ){
                        Path y = new Path();
                        snake_6(blue , p_test);
                        new_value = 11;
                    }
                    if(new_value == 81 ){
                        Path y = new Path();
                        snake_7(blue , p_test);
                        new_value = 62;
                    }
                    if(new_value == 98 ){
                        Path y = new Path();
                        snake_8(blue , p_test);
                        new_value = 65;
                    }
                    if(new_value == 95){
                        Path y = new Path();
                        snake_9(blue , p_test);
                        new_value = 54;
                    }
                    if(new_value == 92){
                        Path y = new Path();
                        snake_10(blue , p_test);
                        new_value = 48;
                    }
                    break;
                }
            }

            // checking for ladders
            for(int i = 0 ; i < ladders.size() ; i++){
                ladder target = ladders.get(i);
                if(target.getStart() == new_value){
                    // we have a ladder at the new position of player 1
                    if (new_value == 2){
                        Path y = new Path();
                        ladder_1(blue , p_test);
                        new_value = 21;
                    }
                    if(new_value == 6){
                        Path y = new Path();
                        ladder_2(blue , p_test);
                        new_value = 27;
                    }
                    if(new_value == 8){
                        Path y = new Path();
                        ladder_3(blue , p_test);
                        new_value = 33;
                    }
                    if(new_value == 16){
                        Path y = new Path();
                        ladder_4(blue , p_test);
                        new_value = 34;
                    }
                    if(new_value == 24 ){
                        Path y = new Path();
                        ladder_5(blue , p_test);
                        new_value = 64;
                    }
                    if(new_value == 38 ){
                        Path y = new Path();
                        ladder_6(blue , p_test);
                        new_value = 58;
                    }
                    if(new_value == 63 ){
                        Path y = new Path();
                        ladder_7(blue , p_test);
                        new_value = 82;
                    }
                    if(new_value == 70 ){
                        Path y = new Path();
                        ladder_8(blue , p_test);
                        new_value = 91;
                    }
                    if(new_value == 73){
                        Path y = new Path();
                        ladder_9(blue , p_test);
                        new_value = 94;
                    }
                    if(new_value == 85){
                        Path y = new Path();
                        ladder_10(blue , p_test);
                        new_value = 97;
                    }
                    break;
                }
            }

            // now we have the final position of player 1 so we'll update the value
            p1.setCurrent(new_value);
            System.out.println(p1.getCurrent());
            // and also we'll set p1_chance to false
            p1_chance = false;
        }

        else{
            int new_value = 0;
            if (!p2.isGame_started()){
                if (value == 1) {
                    // player 1 threw a 1
                    open_green_token();
                    p2.setGame_started(true);
                    new_value = 1;
                }
                else{
                    p1_chance = true;
                    return;
                }
            }
            else if (p2.getCurrent() >= 95 && value > 100 - p2.getCurrent()){
                // now we have to consider wrong input
                // don't do anything in such cases
                p1_chance = true;
                return ;
            }
            else{
                // first we will find out in which lane is the pawn standing
                int pos = p2.getCurrent();
                if (pos == 1 || pos == 2 || pos == 3 || pos == 4 || pos == 5 || pos == 6 || pos == 7 || pos == 8 || pos == 9 || pos == 10
                        || pos == 21 || pos == 22 || pos == 23 || pos == 24 || pos == 25 || pos == 26 || pos == 27 || pos == 28 || pos == 29 || pos == 30
                        || pos == 41 || pos == 42 || pos == 43 || pos == 44 || pos == 45 || pos == 46 || pos == 47 || pos == 48 || pos == 49 || pos == 50
                        || pos == 61 || pos == 62 || pos == 63 || pos == 64 || pos == 65 || pos == 66 || pos == 67 || pos == 68 || pos == 69 || pos == 70
                        || pos == 81 || pos == 82 || pos == 83 || pos == 84 || pos == 85 || pos == 86 || pos == 87 || pos == 88 || pos == 89 || pos == 90) {
                    // this means that we are in the lane where we need to go up or right
                    int space_ahead = 10 - (p2.getCurrent() % 10);
                    if (space_ahead >= value && space_ahead != 10){
                        // working fine
                        // the player has enough space to just move forward
                        Path path_temp = new Path();

                        move_Token_forward(green , 1 , p_test);
                        first_chance_p2 --;

                        move_Token_forward(green , value-1 , p_test);
                        new_value = p2.getCurrent() + value;
                    }
                    else if(space_ahead == 10){
                        // there is no space ahead, so we will move up by one
                        Path path_temp = new Path();

                        move_Token_upwards(green , p_test);
                        // now we will move backwards
                        int moves_left = value - 1;

                        if(moves_left != 0){
                            Path pp = new Path();
                            move_Token_backwards(green , moves_left , pp);
                        }

                        new_value = p2.getCurrent() + value;

                    }
                    else{
                        // first we need to move right as much as possible
                        Path p = new Path();

                        move_Token_forward(green , space_ahead ,p_test);
                        int temp = value - space_ahead;

                        // now we will move upwards
                        Path path_temp = new Path();

                        move_Token_upwards(green , p_test);

                        // now we will move backwards
                        int moves_left = temp - 1;
                        Path pp = new Path();

                        move_Token_backwards(green , moves_left , p_test );

                        new_value = p2.getCurrent() + value;
                    }
                }

                else{
                    // we are in a tray where we need to move backwards
                    int space_ahead = 10 - (p2.getCurrent() % 10);
                    if (space_ahead >= value && space_ahead != 10){
                        // the player has enough space to just move backwards
                        Path path_temp = new Path();

                        move_Token_backwards(green , value , p_test);
                        new_value = p2.getCurrent() + value;
                    }
                    else if(space_ahead == 10){
                        // there is no space ahead, so we will move up by one
                        Path path_temp = new Path();

                        move_Token_upwards(green , p_test);

                        // now we will move forward
                        int moves_left = value - 1;
                        Path pp = new Path();

                        move_Token_forward(green , moves_left , p_test );
                        new_value = p2.getCurrent() + value;
                    }
                    else{
                        // first we need to move left as much as possible
                        Path p = new Path();

                        move_Token_backwards(green , space_ahead ,p_test);
                        int temp = value - space_ahead;

                        // now we will move upwards
                        Path path_temp = new Path();

                        move_Token_upwards(green , p_test);

                        // now we will move forward
                        int moves_left = temp - 1;
                        Path pp = new Path();

                        move_Token_forward(green , moves_left , p_test);
                        new_value = p2.getCurrent() + value;
                    }
                }
            }

            // here -> player 1 has reached it's new position so now we will decide that does the new position has any ladder/snake

            // checking snakes
            for(int i = 0 ; i < snakes.size() ; i++){
                Snake target = snakes.get(i);
                if(target.getHead() == new_value){
                    // we have a ladder at the new position of player 1
                    if (new_value == 23){
                        Path y = new Path();
                        snake_1(green , p_test);
                        new_value = 5;
                    }
                    if(new_value == 32){
                        Path y = new Path();
                        snake_2(green , p_test);
                        new_value = 9;
                    }
                    if(new_value == 46){
                        Path y = new Path();
                        snake_3(green , p_test);
                        new_value = 25;
                    }
                    if(new_value == 59){
                        Path y = new Path();
                        snake_4(green , p_test);
                        new_value = 40;
                    }
                    if(new_value == 66 ){
                        Path y = new Path();
                        snake_5(green , p_test);
                        new_value = 56;
                    }
                    if(new_value == 51 ){
                        Path y = new Path();
                        snake_6(green , p_test);
                        new_value = 11;
                    }
                    if(new_value == 81 ){
                        Path y = new Path();
                        snake_7(green , p_test);
                        new_value = 62;
                    }
                    if(new_value == 98 ){
                        Path y = new Path();
                        snake_8(green , p_test);
                        new_value = 65;
                    }
                    if(new_value == 95){
                        Path y = new Path();
                        snake_9(green , p_test);
                        new_value = 54;
                    }
                    if(new_value == 92){
                        Path y = new Path();
                        snake_10(green , p_test);
                        new_value = 48;
                    }
                    break;
                }
            }

            // checking for ladders
            for(int i = 0 ; i < ladders.size() ; i++){
                ladder target = ladders.get(i);
                if(target.getStart() == new_value){
                    // we have a ladder at the new position of player 1
                    if (new_value == 2){
                        Path y = new Path();
                        ladder_1(green , p_test);
                        new_value = 21;
                    }
                    if(new_value == 6){
                        Path y = new Path();
                        ladder_2(green , p_test);
                        new_value = 27;
                    }
                    if(new_value == 8){
                        Path y = new Path();
                        ladder_3(green , p_test);
                        new_value = 33;
                    }
                    if(new_value == 16){
                        Path y = new Path();
                        ladder_4(green , p_test);
                        new_value = 34;
                    }
                    if(new_value == 24 ){
                        Path y = new Path();
                        ladder_5(green , p_test);
                        new_value = 64;
                    }
                    if(new_value == 38 ){
                        Path y = new Path();
                        ladder_6(green , p_test);
                        new_value = 58;
                    }
                    if(new_value == 63 ){
                        Path y = new Path();
                        ladder_7(green , p_test);
                        new_value = 82;
                    }
                    if(new_value == 70 ){
                        Path y = new Path();
                        ladder_8(green , p_test);
                        new_value = 91;
                    }
                    if(new_value == 73){
                        Path y = new Path();
                        ladder_9(green , p_test);
                        new_value = 94;
                    }
                    if(new_value == 85){
                        Path y = new Path();
                        ladder_10(green , p_test);
                        new_value = 97;
                    }
                    break;
                }
            }

            // now we have the final position of player 1 so we'll update the value
            p2.setCurrent(new_value);

            // and also we'll set p1_chance to false
            p1_chance = true;
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(arrow);
        translate.setDuration(Duration.millis(650));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByY(10);
        translate.setAutoReverse(true);
        translate.play();

        // First we will adjust our board and prepare
        setBoard(snakes , ladders);

        Boolean[] isSnake = new Boolean[100];
        Boolean[] isLadder = new Boolean[100];

        for(int i = 0 ; i < 100 ; i++){
            isSnake[i] = false;
            isLadder[i] = false;
        }
        for(int i = 0 ; i < snakes.size() ; i++){
            isSnake[snakes.get(i).getHead()] = true;
        }
        for(int i = 0; i < ladders.size() ; i++){
            isLadder[ladders.get(i).getStart()] = true;
        }

        // Now we have made the board and the data required
        // Now we will start the main game

        Player player_1 = new Player();
        // first player has blue token
        player_1.setPhoto(blue);
        player_1.setColour("blue");
        player_1.setCurrent(0);
        players.add(player_1);
        paths.add(path1);

        Player player_2 = new Player();
        // second player has green token
        player_1.setPhoto(green);
        player_1.setColour("green");
        player_1.setCurrent(0);
        players.add(player_2);
        paths.add(path2);

        Game new_game = new Game();
    }


    public void show_menu(MouseEvent mouseEvent) throws IOException {
        s = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        s.setTitle("Main game");
        s.setScene(new Scene(root, 275, 532));
        s.show();
    }

    public void clickDice(MouseEvent mouseEvent){
        // Dice is rolled
        Dice new_dice = new Dice();
        Thread t = new Thread(new_dice);
        int roll = 0;
        t.start();
        roll = roll();

        if(roll == 1){
            FadeTransition f2 = fadeOut(dice_2);
            f2.play();
            FadeTransition f3 = fadeOut(dice_3);
            f3.play();
            FadeTransition f4 = fadeOut(dice_4);
            f4.play();
            FadeTransition f5 = fadeOut(dice_5);
            f5.play();
            FadeTransition f6 = fadeOut(dice_6);
            f6.play();
            FadeTransition f1 = fadeIn(dice_1);
            f1.play();
        }
        else if(roll == 2){
            FadeTransition f1 = fadeOut(dice_1);
            f1.play();
            FadeTransition f2 = fadeIn(dice_2);
            f2.play();
            FadeTransition f3 = fadeOut(dice_3);
            f3.play();
            FadeTransition f4 = fadeOut(dice_4);
            f4.play();
            FadeTransition f5 = fadeOut(dice_5);
            f5.play();
            FadeTransition f6 = fadeOut(dice_6);
            f6.play();
        }
        else if(roll == 3){
            FadeTransition f1 = fadeOut(dice_1);
            f1.play();
            FadeTransition f2 = fadeOut(dice_2);
            f2.play();
            FadeTransition f3 = fadeIn(dice_3);
            f3.play();
            FadeTransition f4 = fadeOut(dice_4);
            f4.play();
            FadeTransition f5 = fadeOut(dice_5);
            f5.play();
            FadeTransition f6 = fadeOut(dice_6);
            f6.play();
        }
        else if(roll == 4){
            FadeTransition f1 = fadeOut(dice_1);
            f1.play();
            FadeTransition f2 = fadeOut(dice_2);
            f2.play();
            FadeTransition f3 = fadeOut(dice_3);
            f3.play();
            FadeTransition f4 = fadeIn(dice_4);
            f4.play();
            FadeTransition f5 = fadeOut(dice_5);
            f5.play();
            FadeTransition f6 = fadeOut(dice_6);
            f6.play();
        }
        else if(roll == 5){
            FadeTransition f1 = fadeOut(dice_1);
            f1.play();
            FadeTransition f2 = fadeOut(dice_2);
            f2.play();
            FadeTransition f3 = fadeOut(dice_3);
            f3.play();
            FadeTransition f4 = fadeOut(dice_4);
            f4.play();
            FadeTransition f5 = fadeIn(dice_5);
            f5.play();
            FadeTransition f6 = fadeOut(dice_6);
            f6.play();
        }
        else if(roll == 6){
            FadeTransition f1 = fadeOut(dice_1);
            f1.play();
            FadeTransition f2 = fadeOut(dice_2);
            f2.play();
            FadeTransition f3 = fadeOut(dice_3);
            f3.play();
            FadeTransition f4 = fadeOut(dice_4);
            f4.play();
            FadeTransition f5 = fadeOut(dice_5);
            f5.play();
            FadeTransition f6 = fadeIn(dice_6);
            f6.play();
        }

        Chance(players.get(0) , players.get(1) , snakes , ladders , roll);

        if(players.get(1).getCurrent() == 100){
            translateIT(menu_1 , 245 , 0);
            translateIT(p2_win , 245 , 0);
            translateIT(replay_1 , 245 , 0);
        }
        if(players.get(0).getCurrent() == 100){
            translateIT(menu_1 , 245 , 0);
            translateIT(p1_win , 245 , 0);
            translateIT(replay_1 , 245 , 0);
        }

        if(p1_chance == true){
            FadeTransition f11 = fadeIn(player1);
            f11.play();
            FadeTransition f21 = fadeOut(player1_faded);
            f21.play();
            FadeTransition f31 = fadeIn(player2_faded);
            f31.play();
            FadeTransition f41 = fadeOut(player2);
            f41.play();
        }
        else{
            FadeTransition f11 = fadeOut(player1);
            f11.play();
            FadeTransition f21 = fadeIn(player1_faded);
            f21.play();
            FadeTransition f31 = fadeOut(player2_faded);
            f31.play();
            FadeTransition f41 = fadeIn(player2);
            f41.play();
        }


    }

    public void replay(MouseEvent mouseEvent) throws IOException {
        s = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        s.setTitle("Main game");
        s.setScene(new Scene(root, 275, 532));
        s.show();
    }
}