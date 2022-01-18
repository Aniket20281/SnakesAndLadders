package sample;

import com.sun.source.tree.UsesTree;
import javafx.scene.shape.Path;

import java.util.ArrayList;

public class Game extends Dice {
    boolean p1_chance = true;
    boolean p1_wins = false;
    boolean p2_wins = false;

    ArrayList<Snake> snakes = new ArrayList<>();
    ArrayList<ladder> ladders = new ArrayList<>();
    ArrayList<Player> players = new ArrayList<>();

    Path path1 = new Path();
    Path path2 = new Path();

    ArrayList<Path> paths = new ArrayList<>();

    int first_chance_p1 = 1;
    int first_chance_p2 = 1;

    public void setSnakes(ArrayList<Snake> snakes) {
        this.snakes = snakes;
    }

    public void setLadders(ArrayList<ladder> ladders) {
        this.ladders = ladders;
    }

    public void setFirst_chance_p1(int first_chance_p1) {
        this.first_chance_p1 = first_chance_p1;
    }

    public void setFirst_chance_p2(int first_chance_p2) {
        this.first_chance_p2 = first_chance_p2;
    }

    public void setP1_chance(boolean p1_chance) {
        this.p1_chance = p1_chance;
    }

    public void setP1_wins(boolean p1_wins) {
        this.p1_wins = p1_wins;
    }

    public void setP2_wins(boolean p2_wins) {
        this.p2_wins = p2_wins;
    }

    public void setPath1(Path path1) {
        this.path1 = path1;
    }

    public void setPath2(Path path2) {
        this.path2 = path2;
    }

    public void setPaths(ArrayList<Path> paths) {
        this.paths = paths;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Snake> getSnakes() {
        return snakes;
    }

    public ArrayList<ladder> getLadders() {
        return ladders;
    }

    public ArrayList<Path> getPaths() {
        return paths;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getFirst_chance_p1() {
        return first_chance_p1;
    }

    public int getFirst_chance_p2() {
        return first_chance_p2;
    }

    public Path getPath1() {
        return path1;
    }

    public Path getPath2() {
        return path2;
    }
}
