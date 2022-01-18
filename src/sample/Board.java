package sample;

import java.util.ArrayList;

public class Board extends Game {

    private ArrayList<Snake> snakes = new ArrayList<>();
    private ArrayList<ladder> ladders = new ArrayList<>();
    private ArrayList<tile> tiles = new ArrayList<>();

    public ArrayList<ladder> getLadders() {
        return ladders;
    }
    public ArrayList<Snake> getSnakes() {
        return snakes;
    }

    public ArrayList<tile> getTiles() {
        return tiles;
    }

    public void setLadders(ArrayList<ladder> ladders) {
        this.ladders = ladders;
    }

    public void setSnakes(ArrayList<Snake> snakes) {
        this.snakes = snakes;
    }

    public void setTiles(ArrayList<tile> tiles) {
        this.tiles = tiles;
    }
}
