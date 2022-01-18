package sample;

public class tile{
    private boolean isSnake;
    private boolean isLadder;

    public void setLadder(boolean ladder) {
        isLadder = ladder;
    }

    public void setSnake(boolean snake) {
        isSnake = snake;
    }

    public boolean getisLadder() {
        return isLadder;
    }

    public boolean getisSnake() {
        return isSnake;
    }
}
