package phase1;

import java.util.ArrayList;

public class Space {
    private String color;
    private String path;
    private ArrayList<Player> players;
    private boolean isJunction;
    private boolean isSpaceRetire;

    public Space(String color, String path, int noOfPlayers) {
        this.players = new ArrayList<>(noOfPlayers);
        this.color = color;
        this.path = path;
    }

    public String getColor() {
        return color;
    }

    public String getPath() {
        return path;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public boolean isJunction() {
        return isJunction;
    }

    public boolean isSpaceRetire() {
        return isSpaceRetire;
    }

}
