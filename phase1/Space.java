package phase1;

import java.util.ArrayList;

public class Space {
    private String path;
    private ArrayList<Player> players;

    public Space(String path, int noOfPlayers) {
        this.players = new ArrayList<>(noOfPlayers);
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

}
